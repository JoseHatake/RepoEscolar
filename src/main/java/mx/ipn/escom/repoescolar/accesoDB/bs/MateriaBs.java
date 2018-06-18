package mx.ipn.escom.repoescolar.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.MateriaDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Materia;

@Service("materiaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class MateriaBs {
	
	@Autowired
	private MateriaDao materiaDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Materia save(Materia materia) {
		return materiaDao.save(materia);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Materia update(Materia materia) {
		Materia model = searchById(materia.getIdMaterias());
		model.setNivel(materia.getNivel());
		model.setNombre(materia.getNombre());
		return materiaDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Materia materia) {
		materiaDao.delete(materia);
	}
	
	@Transactional(readOnly = true)
	public Materia searchById(Integer materiaPK) {
		return materiaDao.searchById(materiaPK);
	}
}
