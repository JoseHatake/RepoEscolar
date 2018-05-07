package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Materias_has_Profesor_has_Alumno database table.
 * 
 */
@Entity
@NamedQuery(name="Materias_has_Profesor_has_Alumno.findAll", query="SELECT m FROM Materias_has_Profesor_has_Alumno m")
public class Materias_has_Profesor_has_Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Materias_has_Profesor_has_AlumnoPK id;

	//bi-directional many-to-one association to Aviso
	@OneToMany(mappedBy="materiasHasProfesorHasAlumno")
	private List<Aviso> avisos;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="materiasHasProfesorHasAlumno")
	private List<Horario> horarios;

	public Materias_has_Profesor_has_Alumno() {
	}

	public Materias_has_Profesor_has_AlumnoPK getId() {
		return this.id;
	}

	public void setId(Materias_has_Profesor_has_AlumnoPK id) {
		this.id = id;
	}

	public List<Aviso> getAvisos() {
		return this.avisos;
	}

	public void setAvisos(List<Aviso> avisos) {
		this.avisos = avisos;
	}

	public Aviso addAviso(Aviso aviso) {
		getAvisos().add(aviso);
		aviso.setMateriasHasProfesorHasAlumno(this);

		return aviso;
	}

	public Aviso removeAviso(Aviso aviso) {
		getAvisos().remove(aviso);
		aviso.setMateriasHasProfesorHasAlumno(null);

		return aviso;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setMateriasHasProfesorHasAlumno(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setMateriasHasProfesorHasAlumno(null);

		return horario;
	}

}