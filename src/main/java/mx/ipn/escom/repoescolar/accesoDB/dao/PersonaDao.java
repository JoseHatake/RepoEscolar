package mx.ipn.escom.repoescolar.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Persona;

@Service("personaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PersonaDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Persona save(Persona persona) {
		sessionFactory.getCurrentSession().save(persona);
		return persona;
	}
	
	public Persona update(Persona persona) {
		sessionFactory.getCurrentSession().merge(persona);
		sessionFactory.getCurrentSession().update(persona);
		return persona;
	}
	
	public void delete(Persona persona) {
		sessionFactory.getCurrentSession().delete(persona);
	}
	
	public Persona searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(Persona.class, id);
	}
}
