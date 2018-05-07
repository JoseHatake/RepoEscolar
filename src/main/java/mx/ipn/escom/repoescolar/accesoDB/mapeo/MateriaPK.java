package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Materias database table.
 * 
 */
@Embeddable
public class MateriaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idMaterias;

	@Column(insertable=false, updatable=false)
	private int FKAcademias;

	@Column(insertable=false, updatable=false)
	private String FKJefeAcademia;

	@Column(insertable=false, updatable=false)
	private int FKEscuela;

	@Column(insertable=false, updatable=false)
	private String FKAdministrativo;

	public MateriaPK() {
	}
	public int getIdMaterias() {
		return this.idMaterias;
	}
	public void setIdMaterias(int idMaterias) {
		this.idMaterias = idMaterias;
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MateriaPK)) {
			return false;
		}
		MateriaPK castOther = (MateriaPK)other;
		return 
			(this.idMaterias == castOther.idMaterias)
			&& (this.FKAcademias == castOther.FKAcademias)
			&& this.FKJefeAcademia.equals(castOther.FKJefeAcademia)
			&& (this.FKEscuela == castOther.FKEscuela)
			&& this.FKAdministrativo.equals(castOther.FKAdministrativo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idMaterias;
		hash = hash * prime + this.FKAcademias;
		hash = hash * prime + this.FKJefeAcademia.hashCode();
		hash = hash * prime + this.FKEscuela;
		hash = hash * prime + this.FKAdministrativo.hashCode();
		
		return hash;
	}
}