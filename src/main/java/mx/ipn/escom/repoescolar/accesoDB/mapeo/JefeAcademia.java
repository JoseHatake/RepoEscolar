package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the JefeAcademia database table.
 * 
 */
@Entity
@NamedQuery(name="JefeAcademia.findAll", query="SELECT j FROM JefeAcademia j")
public class JefeAcademia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idJefeAcademia;

	//bi-directional many-to-one association to Academia
	@OneToMany(mappedBy="jefeAcademia")
	private List<Academia> academias;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="jefeAcademia")
	private List<Persona> personas;

	public JefeAcademia() {
	}

	public String getIdJefeAcademia() {
		return this.idJefeAcademia;
	}

	public void setIdJefeAcademia(String idJefeAcademia) {
		this.idJefeAcademia = idJefeAcademia;
	}

	public List<Academia> getAcademias() {
		return this.academias;
	}

	public void setAcademias(List<Academia> academias) {
		this.academias = academias;
	}

	public Academia addAcademia(Academia academia) {
		getAcademias().add(academia);
		academia.setJefeAcademia(this);

		return academia;
	}

	public Academia removeAcademia(Academia academia) {
		getAcademias().remove(academia);
		academia.setJefeAcademia(null);

		return academia;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setJefeAcademia(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setJefeAcademia(null);

		return persona;
	}

}