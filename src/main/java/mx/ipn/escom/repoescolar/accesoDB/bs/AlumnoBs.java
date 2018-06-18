package mx.ipn.escom.repoescolar.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.AlumnoDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Alumno;

@Service("alumnoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AlumnoBs {
	
	@Autowired
	private AlumnoDao alumnoDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Alumno save(Alumno alumno) {
		return alumnoDao.save(alumno);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Alumno update(Alumno alumno) {
		Alumno model = searchByBoleta(alumno.getBoleta());
		model.setBoleta(alumno.getBoleta());
		model.setUsuario(alumno.getUsuario());
		return alumnoDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Alumno alumno) {
		alumnoDao.delete(alumno);
	}
	
	@Transactional(readOnly = true)
	public Alumno searchById(Integer id) {
		return alumnoDao.searchById(id);
	}
	
	@Transactional(readOnly = true)
	public Alumno searchByIdUsuario(Integer idUsuario) {
		return alumnoDao.searchByIdUsuario(idUsuario);
	}
	
	@Transactional(readOnly = true)
	public Alumno searchByBoleta(String boleta) {
		return alumnoDao.searchByBoleta(boleta);
	}
}
