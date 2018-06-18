package mx.ipn.escom.repoescolar.accesoDB.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.repoescolar.accesoDB.dao.PersonaDao;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Persona;

@Service("personaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PersonaBs {
	
	@Autowired
	private PersonaDao personaDao;
	
	@Transactional(rollbackFor = Exception.class)
	public Persona save(Persona persona) {
		return personaDao.save(persona);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Persona update(Persona persona) {
		Persona model = searchById(persona.getIdPersona());
		model.setNombres(persona.getNombres());
		model.setApellidos(persona.getApellidos());
		model.setTelefono(persona.getTelefono());
		model.setCorreo(persona.getCorreo());
		return personaDao.update(model);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Persona persona) {
		personaDao.delete(persona);
	}
	
	@Transactional(readOnly = true)
	public Persona searchById(Integer personaPK) {
		return personaDao.searchById(personaPK);
	}
}
