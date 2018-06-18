package mx.ipn.escom.repoescolar.accesoDB.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.repoescolar.accesoDB.mapeo.Usuario;

@Service("usuarioDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsuarioDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	protected String QUERY1 = "select a from Usuario a where nick = ?1 and password = ?2";
	protected String QUERY2 = "select a from Usuario a where nick like concat('%',?1,'%')";
	
	public Usuario save(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
		return usuario;
	}
	
	public Usuario update(Usuario usuario) {
		sessionFactory.getCurrentSession().merge(usuario);
		sessionFactory.getCurrentSession().update(usuario);
		return usuario;
	}
	
	public void delete(Usuario usuario) {
		sessionFactory.getCurrentSession().delete(usuario);
	}
	
	public Usuario searchById(Integer id) {
		return sessionFactory.getCurrentSession().load(Usuario.class, id);
	}
	
	public Usuario searchByNick(String nick) {
		Query<Usuario> res = sessionFactory.getCurrentSession().createQuery(QUERY2,Usuario.class);
		res.setParameter(1, nick);
		List<Usuario> identified = res.getResultList();
		return identified.isEmpty()?new Usuario():identified.get(0);
	}
	
	public Usuario validateLogIn(String nick,Integer passHash) {
		Query<Usuario> res = sessionFactory.getCurrentSession().createQuery(QUERY1,Usuario.class);
		res.setParameter(1, nick);
		res.setParameter(2, passHash);
		List<Usuario> identified = res.getResultList();
		return identified.isEmpty()?new Usuario():identified.get(0);
	}
}
