package mx.ipn.escom.repoescolar.accesoDB.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Curso;

@Service("cursoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class CursoDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private String QUERY1 = "select a from Curso a where ProfesorFK = ?1";
	
	public Curso save(Curso curso) {
		sessionFactory.getCurrentSession().save(curso);
		return curso;
	}
	
	public Curso update(Curso curso) {
		sessionFactory.getCurrentSession().merge(curso);
		sessionFactory.getCurrentSession().update(curso);
		return curso;
	}
	
	public void delete(Curso curso) {
		sessionFactory.getCurrentSession().delete(curso);
	}
	
	public Curso searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(Curso.class, id);
	}
	
	public List<Curso> cursoByIdTeacher(Integer profesorFK) {
		Query<Curso> result = sessionFactory.getCurrentSession().createQuery(QUERY1,Curso.class);
		result.setParameter(1, profesorFK);
		List<Curso> res = result.getResultList();
		return res.isEmpty()?new ArrayList<Curso>():res;
	}
}
