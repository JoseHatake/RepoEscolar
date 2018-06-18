package mx.ipn.escom.repoescolar.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Clase;

@Service("claseDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ClaseDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Clase save(Clase clase) {
		sessionFactory.getCurrentSession().save(clase);
		return clase;
	}
	
	public Clase update(Clase clase) {
		sessionFactory.getCurrentSession().merge(clase);
		sessionFactory.getCurrentSession().update(clase);
		return clase;
	}
	
	public void delete(Clase clase) {
		sessionFactory.getCurrentSession().delete(clase);
	}
	
	public Clase searchById(Integer idClase) {
		return sessionFactory.getCurrentSession().load(Clase.class, idClase);
	}
}
