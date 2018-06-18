package mx.ipn.escom.repoescolar.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.UsuarioDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Usuario;

@Service("usuarioBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsuarioBs {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Usuario update(Usuario usuario) {
		Usuario model = searchById(usuario.getIdUsuario());
		model.setPassword(usuario.getPassword());
		model.setPersona(usuario.getPersona());
		return usuarioDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Usuario usuario) {
		usuarioDao.delete(usuario);
	}
	
	@Transactional(readOnly = true)
	public Usuario searchById(Integer id) {
		return usuarioDao.searchById(id);
	}
	
	@Transactional(readOnly = true)
	public Usuario searchByNick(String nick) {
		return usuarioDao.searchByNick(nick);
	}
	
	@Transactional(readOnly = true)
	public Usuario validateLogIn(String nick,Integer passHash) {
		return usuarioDao.validateLogIn(nick, passHash);
	}
}
