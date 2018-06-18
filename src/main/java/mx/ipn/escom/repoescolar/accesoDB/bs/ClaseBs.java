package mx.ipn.escom.repoescolar.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.ClaseDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Clase;

@Service("claseBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ClaseBs {
	
	@Autowired
	private ClaseDao claseDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Clase save(Clase clase) {
		return claseDao.save(clase);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Clase update(Clase clase) {
		Clase model = searchById(clase.getIdClase());
		model.setAlumno(clase.getAlumno());
		model.setCurso(clase.getCurso());
		return claseDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Clase clase) {
		claseDao.delete(clase);
	}
	
	@Transactional(readOnly = true)
	public Clase searchById(Integer idClase) {
		return claseDao.searchById(idClase);
	}
}
