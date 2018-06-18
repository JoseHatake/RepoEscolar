package mx.ipn.escom.repoescolar.accesoDB.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela;

@Service("escuelaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class EscuelaDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private String QUERY1 = "select a from Escuela a";
	
	public Escuela save(Escuela escuela) {
		sessionFactory.getCurrentSession().save(escuela);
		return escuela;
	}
	
	public Escuela update(Escuela escuela) {
		sessionFactory.getCurrentSession().merge(escuela);
		sessionFactory.getCurrentSession().update(escuela);
		return escuela;
	}
	
	public void delete(Escuela escuela) {
		sessionFactory.getCurrentSession().delete(escuela);
	}
	
	public Escuela searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(Escuela.class, id);
	}
	
	public List<Escuela> allSchools() {
		Query<Escuela> result = sessionFactory.getCurrentSession().createQuery(QUERY1,Escuela.class);
		List<Escuela> res = result.getResultList();
		return res.isEmpty()?new ArrayList<Escuela>():res;
	}
}
