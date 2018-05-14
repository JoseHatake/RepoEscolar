package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Archivo database table.
 * 
 */
@Entity
@NamedQuery(name="Archivo.findAll", query="SELECT a FROM Archivo a")
public class Archivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ArchivoPK id;

	private String nombre;

	//bi-directional many-to-one association to Materias_has_Profesor
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="FKAcademias", referencedColumnName="FKAcademias", insertable = false,updatable = false),
		@JoinColumn(name="FKAdministrativo", referencedColumnName="FKAdministrativo", insertable = false,updatable = false),
		@JoinColumn(name="FKEscuela", referencedColumnName="FKEscuela", insertable = false,updatable = false),
		@JoinColumn(name="FKJefeAcademia", referencedColumnName="FKJefeAcademia", insertable = false,updatable = false),
		@JoinColumn(name="FKMaterias", referencedColumnName="FKMaterias", insertable = false,updatable = false),
		@JoinColumn(name="FKProfesor", referencedColumnName="FKProfesor", insertable = false,updatable = false)
		})
	private Materias_has_Profesor materiasHasProfesor;

	public Archivo() {
	}

	public ArchivoPK getId() {
		return this.id;
	}

	public void setId(ArchivoPK id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Materias_has_Profesor getMateriasHasProfesor() {
		return this.materiasHasProfesor;
	}

	public void setMateriasHasProfesor(Materias_has_Profesor materiasHasProfesor) {
		this.materiasHasProfesor = materiasHasProfesor;
	}

}