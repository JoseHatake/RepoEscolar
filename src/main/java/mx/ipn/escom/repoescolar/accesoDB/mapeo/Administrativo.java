package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Administrativo database table.
 * 
 */
@Entity
@NamedQuery(name="Administrativo.findAll", query="SELECT a FROM Administrativo a")
public class Administrativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idAdministrativo;

	//bi-directional many-to-one association to Escuela
	@OneToMany(mappedBy="administrativo")
	private List<Escuela> escuelas;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="administrativo")
	private List<Persona> personas;

	public Administrativo() {
	}

	public String getIdAdministrativo() {
		return this.idAdministrativo;
	}

	public void setIdAdministrativo(String idAdministrativo) {
		this.idAdministrativo = idAdministrativo;
	}

	public List<Escuela> getEscuelas() {
		return this.escuelas;
	}

	public void setEscuelas(List<Escuela> escuelas) {
		this.escuelas = escuelas;
	}

	public Escuela addEscuela(Escuela escuela) {
		getEscuelas().add(escuela);
		escuela.setAdministrativo(this);

		return escuela;
	}

	public Escuela removeEscuela(Escuela escuela) {
		getEscuelas().remove(escuela);
		escuela.setAdministrativo(null);

		return escuela;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setAdministrativo(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setAdministrativo(null);

		return persona;
	}

}