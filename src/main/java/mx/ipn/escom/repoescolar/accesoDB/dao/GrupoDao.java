package mx.ipn.escom.repoescolar.accesoDB.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Grupo;

@Service("grupoDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GrupoDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Grupo save(Grupo grupo) {
		sessionFactory.getCurrentSession().save(grupo);
		return grupo;
	}
	
	public Grupo update(Grupo grupo) {
		sessionFactory.getCurrentSession().merge(grupo);
		sessionFactory.getCurrentSession().update(grupo);
		return grupo;
	}
	
	public void delete(Grupo grupo) {
		sessionFactory.getCurrentSession().delete(grupo);
	}
	
	public Grupo searchById(Integer idGrupo) {
		return sessionFactory.getCurrentSession().load(Grupo.class, idGrupo);
	}
}
