package mx.ipn.escom.repoescolar.accesoDB.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.CursoDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Curso;

@Service("cursoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class CursoBs {
	
	@Autowired
	private CursoDao cursoDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Curso save(Curso curso) {
		return cursoDao.save(curso);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Curso update(Curso curso) {
		Curso model = searchById(curso.getIdCurso());
		model.setAlumnos(curso.getAlumnos());
		model.setMateria(curso.getMateria());
		model.setProfesor(curso.getProfesor());
		model.setGrupo(curso.getGrupo());
		return cursoDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Curso curso) {
		cursoDao.delete(curso);
	}
	
	@Transactional(readOnly = true)
	public Curso searchById(Integer id) {
		return cursoDao.searchById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Curso> cursoByIdTeacher(Integer profesorFK) {
		return cursoDao.cursoByIdTeacher(profesorFK);
	}
}
