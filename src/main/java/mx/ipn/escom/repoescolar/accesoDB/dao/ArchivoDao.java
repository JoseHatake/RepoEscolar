package mx.ipn.escom.repoescolar.accesoDB.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Archivo;

@Service("archivoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ArchivoDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private String QUERY1 = "select a from Archivo a where MateriaFK = ?1 and ProfesorFK = ?2";
	
	public Archivo save(Archivo archivo) {
		sessionFactory.getCurrentSession().save(archivo);
		return archivo;
	}
	
	public Archivo update(Archivo archivo) {
		sessionFactory.getCurrentSession().merge(archivo);
		sessionFactory.getCurrentSession().update(archivo);
		return archivo;
	}
	
	public void delete(Archivo archivo) {
		sessionFactory.getCurrentSession().delete(archivo);
	}
	
	public Archivo searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(Archivo.class, id);
	}
	
	public List<Archivo> searchByIdMateriaIdProfesor(Integer idMateria, Integer idProfesor) {
		Query<Archivo> result = sessionFactory.getCurrentSession().createQuery(QUERY1,Archivo.class);
		result.setParameter(1, idMateria);
		result.setParameter(2, idProfesor);
		List<Archivo> res = result.getResultList();
		return res.isEmpty()?new ArrayList<Archivo>():res;
	}
}
