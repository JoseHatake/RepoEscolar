package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Aviso database table.
 * 
 */
@Entity
@NamedQuery(name="Aviso.findAll", query="SELECT a FROM Aviso a")
public class Aviso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvisoPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Lob
	private String notificacion;

	//bi-directional many-to-one association to Materias_has_Profesor_has_Alumno
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="FKAcademias", referencedColumnName="FKAcademias"),
		@JoinColumn(name="FKAdministrativo", referencedColumnName="FKAdministrativo"),
		@JoinColumn(name="FKAlumno", referencedColumnName="FKAlumno"),
		@JoinColumn(name="FKEscuela", referencedColumnName="FKEscuela"),
		@JoinColumn(name="FKJefeAcademia", referencedColumnName="FKJefeAcademia"),
		@JoinColumn(name="FKMaterias", referencedColumnName="FKMaterias"),
		@JoinColumn(name="FKProfesor", referencedColumnName="FKProfesor")
		})
	private Materias_has_Profesor_has_Alumno materiasHasProfesorHasAlumno;

	public Aviso() {
	}

	public AvisoPK getId() {
		return this.id;
	}

	public void setId(AvisoPK id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNotificacion() {
		return this.notificacion;
	}

	public void setNotificacion(String notificacion) {
		this.notificacion = notificacion;
	}

	public Materias_has_Profesor_has_Alumno getMateriasHasProfesorHasAlumno() {
		return this.materiasHasProfesorHasAlumno;
	}

	public void setMateriasHasProfesorHasAlumno(Materias_has_Profesor_has_Alumno materiasHasProfesorHasAlumno) {
		this.materiasHasProfesorHasAlumno = materiasHasProfesorHasAlumno;
	}

}