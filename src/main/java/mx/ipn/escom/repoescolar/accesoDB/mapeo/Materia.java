package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Materias database table.
 * 
 */
@Entity
@Table(name="Materias")
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MateriaPK id;

	private int nivel;

	private String nombre;

	//bi-directional many-to-one association to Academia
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="FKAcademias", referencedColumnName="idAcademias"),
		@JoinColumn(name="FKAdministrativo", referencedColumnName="FKAdministrativo"),
		@JoinColumn(name="FKEscuela", referencedColumnName="FKEscuela"),
		@JoinColumn(name="FKJefeAcademia", referencedColumnName="FKJefeAcademia")
		})
	private Academia academia;

	//bi-directional many-to-many association to Profesor
	@ManyToMany(mappedBy="materias")
	private List<Profesor> profesors;

	public Materia() {
	}

	public MateriaPK getId() {
		return this.id;
	}

	public void setId(MateriaPK id) {
		this.id = id;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Academia getAcademia() {
		return this.academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

}