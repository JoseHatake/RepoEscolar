package mx.ipn.escom.repoescolar.accesoDB.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Profesor;

@Service("profesorDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ProfesorDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private String QUERY1 = "select a from Profesor a where UsuarioFK = ?1";
	private String QUERY2 = "select a from Profesor a,Usuario b where UsuarioFK = idUsuario and EscuelaFK = ?1";
	private String QUERY3 = "select a from Profesor a,Curso b where idProfesor = ProfesorFK and MateriasFK = ?1";
	
	public Profesor save(Profesor profesor) {
		sessionFactory.getCurrentSession().save(profesor);
		return profesor;
	}
	
	public Profesor update(Profesor profesor) {
		sessionFactory.getCurrentSession().merge(profesor);
		sessionFactory.getCurrentSession().update(profesor);
		return profesor;
	}
	
	public void delete(Profesor profesor) {
		sessionFactory.getCurrentSession().delete(profesor);
	}
	
	public Profesor searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(Profesor.class, id);
	}
	
	public Profesor searchByIdUsuario(Integer idUsuario) {
		Query<Profesor> result = sessionFactory.getCurrentSession().createQuery(QUERY1,Profesor.class);
		result.setParameter(1, idUsuario);
		List<Profesor> res = result.getResultList();
		return res.isEmpty()?new Profesor():res.get(0);
	}
	
	public List<Profesor> searchByIdSchool(Integer idEscuela) {
		Query<Profesor> result = sessionFactory.getCurrentSession().createQuery(QUERY2,Profesor.class);
		result.setParameter(1, idEscuela);
		List<Profesor> res = result.getResultList();
		return res.isEmpty()?new ArrayList<Profesor>():res;
	}
	
	public List<Profesor> searchByIdMateria(Integer idMateria) {
		Query<Profesor> result = sessionFactory.getCurrentSession().createQuery(QUERY3,Profesor.class);
		result.setParameter(1, idMateria);
		List<Profesor> res = result.getResultList();
		return res.isEmpty()?new ArrayList<Profesor>():res;
	}
}
