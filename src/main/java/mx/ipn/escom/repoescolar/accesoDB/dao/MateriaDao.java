package mx.ipn.escom.repoescolar.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Materia;

@Service("materiaDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class MateriaDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Materia save(Materia materia) {
		sessionFactory.getCurrentSession().save(materia);
		return materia;
	}
	
	public Materia update(Materia materia) {
		sessionFactory.getCurrentSession().merge(materia);
		sessionFactory.getCurrentSession().update(materia);
		return materia;
	}
	
	public void delete(Materia materia) {
		sessionFactory.getCurrentSession().delete(materia);
	}
	
	public Materia searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(Materia.class, id);
	}
}
