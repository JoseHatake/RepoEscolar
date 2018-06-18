package mx.ipn.escom.repoescolar.accesoDB.dao;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Administrador;

@Service("administradorDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AdministradorDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private String QUERY1 = "select a from Administrador a where UsuarioFK = ?1";
	
	public Administrador save(Administrador administrador) {
		sessionFactory.getCurrentSession().save(administrador);
		return administrador;
	}
	
	public Administrador update(Administrador administrador) {
		sessionFactory.getCurrentSession().merge(administrador);
		sessionFactory.getCurrentSession().update(administrador);
		return administrador;
	}
	
	public void delete(Administrador administrador) {
		sessionFactory.getCurrentSession().delete(administrador);
	}
	
	public Administrador searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(Administrador.class, id);
	}
	
	public Administrador searchByIdUsuario(Integer idUsuario) {
		Query<Administrador> result = sessionFactory.getCurrentSession().createQuery(QUERY1,Administrador.class);
		result.setParameter(1, idUsuario);
		List<Administrador> res = result.getResultList();
		return res.isEmpty()?new Administrador():res.get(0);
	}
}
