package mx.ipn.escom.repoescolar.accesoDB.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.ArchivoDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Archivo;

@Service("archivoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ArchivoBs {

	@Autowired
	private ArchivoDao archivoDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Archivo save(Archivo archivo) {
		return archivoDao.save(archivo);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Archivo update(Archivo archivo) {
		Archivo model = searchById(archivo.getIdArchivo());
		model.setNombre(archivo.getNombre());
		model.setFechaSubida(archivo.getFechaSubida());
		model.setMateria(archivo.getMateria());
		model.setProfesor(archivo.getProfesor());
		return archivoDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Archivo archivo) {
		archivoDao.delete(archivo);
	}

	@Transactional(readOnly = true)
	public Archivo searchById(Integer id) {
		return archivoDao.searchById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Archivo> searchByIdMateriaIdProfesor(Integer idMateria, Integer idProfesor) {
		return archivoDao.searchByIdMateriaIdProfesor(idMateria, idProfesor);
	}
}
