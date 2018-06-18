package mx.ipn.escom.repoescolar.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.JefeAcademiaDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.JefeAcademia;

@Service("jefeAcademiaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class JefeAcademiaBs {

	@Autowired
	private JefeAcademiaDao jefeAcademiaDao;
	
	@Transactional(rollbackFor = Exception.class)
	public JefeAcademia save(JefeAcademia jefeAcademia) {
		return jefeAcademiaDao.save(jefeAcademia);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public JefeAcademia update(JefeAcademia jefeAcademia) {
		JefeAcademia model = searchById(jefeAcademia.getIdJefeAcademia());
		model.setUsuario(jefeAcademia.getUsuario());
		model.setAcademias(jefeAcademia.getAcademias());
		return jefeAcademiaDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(JefeAcademia jefeAcademia) {
		jefeAcademiaDao.delete(jefeAcademia);
	}
	
	@Transactional(readOnly = true)
	public JefeAcademia searchById(Integer id) {
		return jefeAcademiaDao.searchById(id);
	}
	
	@Transactional(readOnly = true)
	public JefeAcademia searchByIdUsuario(Integer idUsuario) {
		return jefeAcademiaDao.searchByIdUsuario(idUsuario);
	}
}
