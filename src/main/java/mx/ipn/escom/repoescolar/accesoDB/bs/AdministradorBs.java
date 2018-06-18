package mx.ipn.escom.repoescolar.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.AdministradorDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Administrador;

@Service("administradorBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AdministradorBs {
	
	@Autowired
	private AdministradorDao administradorDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Administrador save(Administrador administrador) {
		return administradorDao.save(administrador);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Administrador update(Administrador administrador) {
		Administrador model = searchById(administrador.getIdAdministrador());
		model.setUsuario(administrador.getUsuario());
		return administradorDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Administrador administrador) {
		administradorDao.delete(administrador);
	}
	
	@Transactional(readOnly = true)
	public Administrador searchById(Integer id) {
		return administradorDao.searchById(id);
	}
	
	@Transactional(readOnly = true)
	public Administrador searchByIdUsuario(Integer idUsuario) {
		return administradorDao.searchByIdUsuario(idUsuario);
	}
}
