package mx.ipn.escom.repoescolar.accesoDB.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.JefeAcademia;

@Service("jefeAcademiaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class JefeAcademiaDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private String QUERY1 = "select a from JefeAcademia a where UsuarioFK = ?1";
	
	public JefeAcademia save(JefeAcademia jefeAcademia) {
		sessionFactory.getCurrentSession().save(jefeAcademia);
		return jefeAcademia;
	}
	
	public JefeAcademia update(JefeAcademia jefeAcademia) {
		sessionFactory.getCurrentSession().merge(jefeAcademia);
		sessionFactory.getCurrentSession().update(jefeAcademia);
		return jefeAcademia;
	}
	
	public void delete(JefeAcademia jefeAcademia) {
		sessionFactory.getCurrentSession().delete(jefeAcademia);
	}
	
	public JefeAcademia searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(JefeAcademia.class, id);
	}
	
	public JefeAcademia searchByIdUsuario(Integer idUsuario) {
		Query<JefeAcademia> result = sessionFactory.getCurrentSession().createQuery(QUERY1,JefeAcademia.class);
		result.setParameter(1, idUsuario);
		List<JefeAcademia> res = result.getResultList();
		return res.isEmpty()?new JefeAcademia():res.get(0);
	}
}
