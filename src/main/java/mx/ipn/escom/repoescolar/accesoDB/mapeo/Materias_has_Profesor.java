package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Materias_has_Profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Materias_has_Profesor.findAll", query="SELECT m FROM Materias_has_Profesor m")
public class Materias_has_Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Materias_has_ProfesorPK id;

	//bi-directional many-to-one association to Archivo
	@OneToMany(mappedBy="materiasHasProfesor")
	private List<Archivo> archivos;

	//bi-directional many-to-many association to Alumno
	@ManyToMany
	@JoinTable(
		name="Materias_has_Profesor_has_Alumno"
		, joinColumns={
			@JoinColumn(name="FKAcademias", referencedColumnName="FKAcademias"),
			@JoinColumn(name="FKAdministrativo", referencedColumnName="FKAdministrativo"),
			@JoinColumn(name="FKEscuela", referencedColumnName="FKEscuela"),
			@JoinColumn(name="FKJefeAcademia", referencedColumnName="FKJefeAcademia"),
			@JoinColumn(name="FKMaterias", referencedColumnName="FKMaterias"),
			@JoinColumn(name="FKProfesor", referencedColumnName="FKProfesor")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FKAlumno")
			}
		)
	private List<Alumno> alumnos;

	public Materias_has_Profesor() {
	}

	public Materias_has_ProfesorPK getId() {
		return this.id;
	}

	public void setId(Materias_has_ProfesorPK id) {
		this.id = id;
	}

	public List<Archivo> getArchivos() {
		return this.archivos;
	}

	public void setArchivos(List<Archivo> archivos) {
		this.archivos = archivos;
	}

	public Archivo addArchivo(Archivo archivo) {
		getArchivos().add(archivo);
		archivo.setMateriasHasProfesor(this);

		return archivo;
	}

	public Archivo removeArchivo(Archivo archivo) {
		getArchivos().remove(archivo);
		archivo.setMateriasHasProfesor(null);

		return archivo;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}