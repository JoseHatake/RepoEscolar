package mx.ipn.escom.repoescolar.accesoDB.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.ProfesorDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Profesor;

@Service("profesorBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ProfesorBs {
	
	@Autowired
	private ProfesorDao profesorDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Profesor save(Profesor profesor) {
		return profesorDao.save(profesor);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Profesor update(Profesor profesor) {
		Profesor model = searchById(profesor.getIdProfesor());
		model.setCursos(profesor.getCursos());
		model.setUsuario(profesor.getUsuario());
		return profesorDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Profesor profesor) {
		profesorDao.delete(profesor);
	}
	
	@Transactional(readOnly = true)
	public Profesor searchById(Integer id) {
		return profesorDao.searchById(id);
	}
	
	@Transactional(readOnly = true)
	public Profesor searchByIdUsuario(Integer idUsuario) {
		return profesorDao.searchByIdUsuario(idUsuario);
	}
	
	@Transactional(readOnly = true)
	public List<Profesor> searchByIdSchool(Integer idEscuela) {
		return profesorDao.searchByIdSchool(idEscuela);
	}
	
	@Transactional(readOnly = true)
	public List<Profesor> searchByIdMateria(Integer idMateria) {
		return profesorDao.searchByIdMateria(idMateria);
	}
}
