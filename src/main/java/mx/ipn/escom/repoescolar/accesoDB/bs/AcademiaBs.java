package mx.ipn.escom.repoescolar.accesoDB.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.AcademiaDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Academia;

@Service("academiaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AcademiaBs {
	@Autowired
	private AcademiaDao academiaDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Academia save(Academia academia) {
		return academiaDao.save(academia);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Academia update(Academia academia) {
		Academia model = searchById(academia.getIdAcademias());
		model.setEscuela(academia.getEscuela());
		model.setNombre(academia.getNombre());
		model.setJefeAcademia(academia.getJefeAcademia());
		return academiaDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Academia academia) {
		academiaDao.delete(academia);
	}
	
	@Transactional(readOnly = true)
	public Academia searchById(Integer id) {
		return academiaDao.searchById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Academia> academysByIdSchool(Integer idSchool) {
		return academiaDao.academysByIdSchool(idSchool);
	}
}
