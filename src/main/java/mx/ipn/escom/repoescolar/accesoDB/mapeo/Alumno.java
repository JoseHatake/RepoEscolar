package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Alumno database table.
 * 
 */
@Entity
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int boleta;

	//bi-directional many-to-many association to Materias_has_Profesor
	@ManyToMany(mappedBy="alumnos")
	private List<Materias_has_Profesor> materiasHasProfesors;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="alumno")
	private List<Persona> personas;

	public Alumno() {
	}

	public int getBoleta() {
		return this.boleta;
	}

	public void setBoleta(int boleta) {
		this.boleta = boleta;
	}

	public List<Materias_has_Profesor> getMateriasHasProfesors() {
		return this.materiasHasProfesors;
	}

	public void setMateriasHasProfesors(List<Materias_has_Profesor> materiasHasProfesors) {
		this.materiasHasProfesors = materiasHasProfesors;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setAlumno(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setAlumno(null);

		return persona;
	}

}