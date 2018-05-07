package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Academias database table.
 * 
 */
@Entity
@Table(name="Academias")
@NamedQuery(name="Academia.findAll", query="SELECT a FROM Academia a")
public class Academia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AcademiaPK id;

	private String nombre;

	//bi-directional many-to-one association to Escuela
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="FKAdministrativo", referencedColumnName="FKAdministrativo"),
		@JoinColumn(name="FKEscuela", referencedColumnName="idEscuela")
		})
	private Escuela escuela;

	//bi-directional many-to-one association to JefeAcademia
	@ManyToOne
	@JoinColumn(name="FKJefeAcademia")
	private JefeAcademia jefeAcademia;

	//bi-directional many-to-one association to Materia
	@OneToMany(mappedBy="academia")
	private List<Materia> materias;

	public Academia() {
	}

	public AcademiaPK getId() {
		return this.id;
	}

	public void setId(AcademiaPK id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Escuela getEscuela() {
		return this.escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}

	public JefeAcademia getJefeAcademia() {
		return this.jefeAcademia;
	}

	public void setJefeAcademia(JefeAcademia jefeAcademia) {
		this.jefeAcademia = jefeAcademia;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Materia addMateria(Materia materia) {
		getMaterias().add(materia);
		materia.setAcademia(this);

		return materia;
	}

	public Materia removeMateria(Materia materia) {
		getMaterias().remove(materia);
		materia.setAcademia(null);

		return materia;
	}

}