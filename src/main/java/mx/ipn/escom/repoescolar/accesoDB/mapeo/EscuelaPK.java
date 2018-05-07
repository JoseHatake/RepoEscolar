package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Escuela database table.
 * 
 */
@Embeddable
public class EscuelaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idEscuela;

	@Column(insertable=false, updatable=false)
	private String FKAdministrativo;

	public EscuelaPK() {
	}
	public int getIdEscuela() {
		return this.idEscuela;
	}
	public void setIdEscuela(int idEscuela) {
		this.idEscuela = idEscuela;
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
		if (!(other instanceof EscuelaPK)) {
			return false;
		}
		EscuelaPK castOther = (EscuelaPK)other;
		return 
			(this.idEscuela == castOther.idEscuela)
			&& this.FKAdministrativo.equals(castOther.FKAdministrativo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEscuela;
		hash = hash * prime + this.FKAdministrativo.hashCode();
		
		return hash;
	}
}