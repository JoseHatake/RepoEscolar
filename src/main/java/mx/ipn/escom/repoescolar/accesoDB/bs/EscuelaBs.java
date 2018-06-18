package mx.ipn.escom.repoescolar.accesoDB.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.EscuelaDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela;

@Service("escuelaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class EscuelaBs {
	
	@Autowired
	private EscuelaDao escuelaDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Escuela save(Escuela escuela) {
		return escuelaDao.save(escuela);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Escuela update(Escuela escuela) {
		Escuela model = searchById(escuela.getIdEscuela());
		model.setNombre(escuela.getNombre());
		model.setAcademias(escuela.getAcademias());
		model.setDireccion(escuela.getDireccion());
		model.setExtension(escuela.getExtension());
		model.setReferencia(escuela.getReferencia());
		model.setSitioWeb(escuela.getSitioWeb());
		model.setTelefono(escuela.getTelefono());
		model.setClaveAdmin(escuela.getClaveAdmin());
		model.setClaveProfesor(escuela.getClaveProfesor());
		model.setUsuarios(escuela.getUsuarios());
		model.setGrupos(escuela.getGrupos());
		return escuelaDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Escuela escuela) {
		escuelaDao.delete(escuela);
	}
	
	@Transactional(readOnly = true)
	public Escuela searchById(Integer id) {
		return escuelaDao.searchById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Escuela> allSchools() {
		return escuelaDao.allSchools();
	}
}
