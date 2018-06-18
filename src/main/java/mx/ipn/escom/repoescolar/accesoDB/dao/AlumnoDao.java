package mx.ipn.escom.repoescolar.accesoDB.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Alumno;

@Service("alumnoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AlumnoDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private String QUERY1 = "select a from Alumno a where UsuarioFK = ?1";
	private String QUERY2 = "select a from Alumno a where boleta = ?1";
	
	public Alumno save(Alumno alumno) {
		sessionFactory.getCurrentSession().save(alumno);
		return alumno;
	}
	
	public Alumno update(Alumno alumno) {
		sessionFactory.getCurrentSession().merge(alumno);
		sessionFactory.getCurrentSession().update(alumno);
		return alumno;
	}
	
	public void delete(Alumno alumno) {
		sessionFactory.getCurrentSession().delete(alumno);
	}
	
	public Alumno searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(Alumno.class, id);
	}
	
	public Alumno searchByIdUsuario(Integer idUsuario) {
		Query<Alumno> result = sessionFactory.getCurrentSession().createQuery(QUERY1,Alumno.class);
		result.setParameter(1, idUsuario);
		List<Alumno> res = result.getResultList();
		return res.isEmpty()?new Alumno():res.get(0);
	}
	
	public Alumno searchByBoleta(String boleta) {
		Query<Alumno> result = sessionFactory.getCurrentSession().createQuery(QUERY2,Alumno.class);
		result.setParameter(1, boleta);
		List<Alumno> res = result.getResultList();
		return res.isEmpty()?new Alumno():res.get(0);
	}
}
