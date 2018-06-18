package mx.ipn.escom.repoescolar.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.GrupoDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Grupo;

@Service("grupoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GrupoBs {
	
	@Autowired
	private GrupoDao grupoDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Grupo save(Grupo grupo) {
		return grupoDao.save(grupo);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Grupo update(Grupo grupo) {
		Grupo model = searchById(grupo.getIdGrupo());
		model.setCursos(grupo.getCursos());
		model.setEscuela(grupo.getEscuela());
		model.setGrupo(grupo.getGrupo());
		return grupoDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Grupo grupo) {
		grupoDao.delete(grupo);
	}
	
	@Transactional(readOnly = true)
	public Grupo searchById(Integer idGrupo) {
		return grupoDao.searchById(idGrupo);
	}
}
