package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Materias_has_Profesor database table.
 * 
 */
@Embeddable
public class Materias_has_ProfesorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int FKMaterias;

	@Column(insertable=false, updatable=false)
	private int FKAcademias;

	@Column(insertable=false, updatable=false)
	private String FKJefeAcademia;

	@Column(insertable=false, updatable=false)
	private int FKEscuela;

	@Column(insertable=false, updatable=false)
	private String FKAdministrativo;

	@Column(insertable=false, updatable=false)
	private String FKProfesor;

	public Materias_has_ProfesorPK() {
	}
	public int getFKMaterias() {
		return this.FKMaterias;
	}
	public void setFKMaterias(int FKMaterias) {
		this.FKMaterias = FKMaterias;
	}
	public int getFKAcademias() {
		return this.FKAcademias;
	}
	public void setFKAcademias(int FKAcademias) {
		this.FKAcademias = FKAcademias;
	}
	public String getFKJefeAcademia() {
		return this.FKJefeAcademia;
	}
	public void setFKJefeAcademia(String FKJefeAcademia) {
		this.FKJefeAcademia = FKJefeAcademia;
	}
	public int getFKEscuela() {
		return this.FKEscuela;
	}
	public void setFKEscuela(int FKEscuela) {
		this.FKEscuela = FKEscuela;
	}
	public String getFKAdministrativo() {
		return this.FKAdministrativo;
	}
	public void setFKAdministrativo(String FKAdministrativo) {
		this.FKAdministrativo = FKAdministrativo;
	}
	public String getFKProfesor() {
		return this.FKProfesor;
	}
	public void setFKProfesor(String FKProfesor) {
		this.FKProfesor = FKProfesor;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Materias_has_ProfesorPK)) {
			return false;
		}
		Materias_has_ProfesorPK castOther = (Materias_has_ProfesorPK)other;
		return 
			(this.FKMaterias == castOther.FKMaterias)
			&& (this.FKAcademias == castOther.FKAcademias)
			&& this.FKJefeAcademia.equals(castOther.FKJefeAcademia)
			&& (this.FKEscuela == castOther.FKEscuela)
			&& this.FKAdministrativo.equals(castOther.FKAdministrativo)
			&& this.FKProfesor.equals(castOther.FKProfesor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.FKMaterias;
		hash = hash * prime + this.FKAcademias;
		hash = hash * prime + this.FKJefeAcademia.hashCode();
		hash = hash * prime + this.FKEscuela;
		hash = hash * prime + this.FKAdministrativo.hashCode();
		hash = hash * prime + this.FKProfesor.hashCode();
		
		return hash;
	}
}