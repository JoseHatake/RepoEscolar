package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idProfesor;

	//bi-directional many-to-many association to Materia
	@ManyToMany
	@JoinTable(
		name="Materias_has_Profesor"
		, joinColumns={
			@JoinColumn(name="FKProfesor")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FKAcademias", referencedColumnName="FKAcademias"),
			@JoinColumn(name="FKAdministrativo", referencedColumnName="FKAdministrativo"),
			@JoinColumn(name="FKEscuela", referencedColumnName="FKEscuela"),
			@JoinColumn(name="FKJefeAcademia", referencedColumnName="FKJefeAcademia"),
			@JoinColumn(name="FKMaterias", referencedColumnName="idMaterias")
			}
		)
	private List<Materia> materias;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="profesor")
	private List<Persona> personas;

	public Profesor() {
	}

	public String getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(String idProfesor) {
		this.idProfesor = idProfesor;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setProfesor(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setProfesor(null);

		return persona;
	}

}