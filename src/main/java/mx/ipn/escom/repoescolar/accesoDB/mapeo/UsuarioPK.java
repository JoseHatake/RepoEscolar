package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Usuario database table.
 * 
 */
@Embeddable
public class UsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String FKJefeAcademia;

	@Column(insertable=false, updatable=false)
	private String FKAdministrativo;

	@Column(insertable=false, updatable=false)
	private int FKAlumno;

	@Column(insertable=false, updatable=false)
	private String FKProfesor;

	public UsuarioPK() {
	}
	public String getFKJefeAcademia() {
		return this.FKJefeAcademia;
	}
	public void setFKJefeAcademia(String FKJefeAcademia) {
		this.FKJefeAcademia = FKJefeAcademia;
	}
	public String getFKAdministrativo() {
		return this.FKAdministrativo;
	}
	public void setFKAdministrativo(String FKAdministrativo) {
		this.FKAdministrativo = FKAdministrativo;
	}
	public int getFKAlumno() {
		return this.FKAlumno;
	}
	public void setFKAlumno(int FKAlumno) {
		this.FKAlumno = FKAlumno;
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
		if (!(other instanceof UsuarioPK)) {
			return false;
		}
		UsuarioPK castOther = (UsuarioPK)other;
		return 
			this.FKJefeAcademia.equals(castOther.FKJefeAcademia)
			&& this.FKAdministrativo.equals(castOther.FKAdministrativo)
			&& (this.FKAlumno == castOther.FKAlumno)
			&& this.FKProfesor.equals(castOther.FKProfesor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.FKJefeAcademia.hashCode();
		hash = hash * prime + this.FKAdministrativo.hashCode();
		hash = hash * prime + this.FKAlumno;
		hash = hash * prime + this.FKProfesor.hashCode();
		
		return hash;
	}
}