package mx.ipn.escom.repoescolar.accesoDB.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Academia;

@Service("academiaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AcademiaDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private String QUERY1 = "select a from Academia a where EscuelaFK = ?1";
	
	public Academia save(Academia academia) {
		sessionFactory.getCurrentSession().save(academia);
		return academia;
	}
	
	public Academia update(Academia academia) {
		sessionFactory.getCurrentSession().merge(academia);
		sessionFactory.getCurrentSession().update(academia);
		return academia;
	}
	
	public void delete(Academia academia) {
		sessionFactory.getCurrentSession().delete(academia);
	}
	
	public Academia searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(Academia.class, id);
	}
	
	public List<Academia> academysByIdSchool(Integer idSchool) {
		Query<Academia> result = sessionFactory.getCurrentSession().createQuery(QUERY1,Academia.class);
		result.setParameter(1, idSchool);
		List<Academia> res = result.getResultList();
		return res.isEmpty()?new ArrayList<Academia>():res;
	}
}
