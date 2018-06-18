package mx.ipn.escom.repoescolar.accesoDB.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Administrativo;

@Service("administrativoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AdministrativoDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private String QUERY1 = "select a from Administrativo a where UsuarioFK = ?1";
	
	public Administrativo save(Administrativo administrativo) {
		sessionFactory.getCurrentSession().save(administrativo);
		return administrativo;
	}
	
	public Administrativo update(Administrativo administrativo) {
		sessionFactory.getCurrentSession().merge(administrativo);
		sessionFactory.getCurrentSession().update(administrativo);
		return administrativo;
	}
	
	public void delete(Administrativo administrativo) {
		sessionFactory.getCurrentSession().delete(administrativo);
	}
	
	public Administrativo searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(Administrativo.class, id);
	}
	
	public Administrativo searchByIdUsuario(Integer idUsuario) {
		Query<Administrativo> result = sessionFactory.getCurrentSession().createQuery(QUERY1,Administrativo.class);
		result.setParameter(1, idUsuario);
		List<Administrativo> res = result.getResultList();
		return res.isEmpty()?new Administrativo():res.get(0);
	}
}
