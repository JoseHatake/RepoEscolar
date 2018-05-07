package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Aviso database table.
 * 
 */
@Embeddable
public class AvisoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idAviso;

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

	@Column(insertable=false, updatable=false)
	private int FKAlumno;

	public AvisoPK() {
	}
	public int getIdAviso() {
		return this.idAviso;
	}
	public void setIdAviso(int idAviso) {
		this.idAviso = idAviso;
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
	public int getFKAlumno() {
		return this.FKAlumno;
	}
	public void setFKAlumno(int FKAlumno) {
		this.FKAlumno = FKAlumno;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AvisoPK)) {
			return false;
		}
		AvisoPK castOther = (AvisoPK)other;
		return 
			(this.idAviso == castOther.idAviso)
			&& (this.FKMaterias == castOther.FKMaterias)
			&& (this.FKAcademias == castOther.FKAcademias)
			&& this.FKJefeAcademia.equals(castOther.FKJefeAcademia)
			&& (this.FKEscuela == castOther.FKEscuela)
			&& this.FKAdministrativo.equals(castOther.FKAdministrativo)
			&& this.FKProfesor.equals(castOther.FKProfesor)
			&& (this.FKAlumno == castOther.FKAlumno);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAviso;
		hash = hash * prime + this.FKMaterias;
		hash = hash * prime + this.FKAcademias;
		hash = hash * prime + this.FKJefeAcademia.hashCode();
		hash = hash * prime + this.FKEscuela;
		hash = hash * prime + this.FKAdministrativo.hashCode();
		hash = hash * prime + this.FKProfesor.hashCode();
		hash = hash * prime + this.FKAlumno;
		
		return hash;
	}
}