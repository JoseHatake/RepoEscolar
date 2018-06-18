package mx.ipn.escom.repoescolar.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.AdministrativoDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Administrativo;

@Service("administrativoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AdministrativoBs {
	@Autowired
	private AdministrativoDao administrativoDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Administrativo save(Administrativo administrativo) {
		return administrativoDao.save(administrativo);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Administrativo update(Administrativo administrativo) {
		Administrativo model = searchById(administrativo.getIdAdministrativo());
		model.setUsuario(administrativo.getUsuario());
		return administrativoDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Administrativo administrativo) {
		administrativoDao.delete(administrativo);
	}
	
	@Transactional(readOnly = true)
	public Administrativo searchById(Integer id) {
		return administrativoDao.searchById(id);
	}
	
	@Transactional(readOnly = true)
	public Administrativo searchByIdUsuario(Integer idUsuario) {
		return administrativoDao.searchByIdUsuario(idUsuario);
	}
}
