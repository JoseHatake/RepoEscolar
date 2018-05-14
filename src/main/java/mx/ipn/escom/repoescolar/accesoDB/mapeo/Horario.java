package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Horario database table.
 * 
 */
@Entity
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HorarioPK id;

	private String dia;

	private String hora;

	//bi-directional many-to-one association to Materias_has_Profesor_has_Alumno
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="FKAcademias", referencedColumnName="FKAcademias", insertable = false,updatable = false),
		@JoinColumn(name="FKAdministrativo", referencedColumnName="FKAdministrativo", insertable = false,updatable = false),
		@JoinColumn(name="FKAlumno", referencedColumnName="FKAlumno", insertable = false,updatable = false),
		@JoinColumn(name="FKEscuela", referencedColumnName="FKEscuela", insertable = false,updatable = false),
		@JoinColumn(name="FKJefeAcademia", referencedColumnName="FKJefeAcademia", insertable = false,updatable = false),
		@JoinColumn(name="FKMaterias", referencedColumnName="FKMaterias", insertable = false,updatable = false),
		@JoinColumn(name="FKProfesor", referencedColumnName="FKProfesor", insertable = false,updatable = false)
		})
	private Materias_has_Profesor_has_Alumno materiasHasProfesorHasAlumno;

	public Horario() {
	}

	public HorarioPK getId() {
		return this.id;
	}

	public void setId(HorarioPK id) {
		this.id = id;
	}

	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Materias_has_Profesor_has_Alumno getMateriasHasProfesorHasAlumno() {
		return this.materiasHasProfesorHasAlumno;
	}

	public void setMateriasHasProfesorHasAlumno(Materias_has_Profesor_has_Alumno materiasHasProfesorHasAlumno) {
		this.materiasHasProfesorHasAlumno = materiasHasProfesorHasAlumno;
	}

}