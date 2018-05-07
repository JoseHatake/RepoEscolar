package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Academias database table.
 * 
 */
@Embeddable
public class AcademiaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idAcademias;

	@Column(insertable=false, updatable=false)
	private String FKJefeAcademia;

	@Column(insertable=false, updatable=false)
	private int FKEscuela;

	@Column(insertable=false, updatable=false)
	private String FKAdministrativo;

	public AcademiaPK() {
	}
	public int getIdAcademias() {
		return this.idAcademias;
	}
	public void setIdAcademias(int idAcademias) {
		this.idAcademias = idAcademias;
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AcademiaPK)) {
			return false;
		}
		AcademiaPK castOther = (AcademiaPK)other;
		return 
			(this.idAcademias == castOther.idAcademias)
			&& this.FKJefeAcademia.equals(castOther.FKJefeAcademia)
			&& (this.FKEscuela == castOther.FKEscuela)
			&& this.FKAdministrativo.equals(castOther.FKAdministrativo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAcademias;
		hash = hash * prime + this.FKJefeAcademia.hashCode();
		hash = hash * prime + this.FKEscuela;
		hash = hash * prime + this.FKAdministrativo.hashCode();
		
		return hash;
	}
}