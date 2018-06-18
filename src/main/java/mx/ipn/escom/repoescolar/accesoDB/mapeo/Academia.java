package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Academia database table.
 * 
 */
@Entity
@NamedQuery(name="Academia.findAll", query="SELECT a FROM Academia a")
public class Academia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAcademias;

	private String nombre;

	//bi-directional many-to-one association to Escuela
	@ManyToOne
	@JoinColumn(name="EscuelaFK")
	private Escuela escuela;

	//bi-directional many-to-one association to JefeAcademia
	@ManyToOne
	@JoinColumn(name="JefeAcademiaFK")
	private JefeAcademia jefeAcademia;

	//bi-directional many-to-one association to Materia
	@OneToMany(mappedBy="academia", fetch=FetchType.EAGER)
	private List<Materia> materias;

	public Academia() {
	}

	public int getIdAcademias() {
		return this.idAcademias;
	}

	public void setIdAcademias(int idAcademias) {
		this.idAcademias = idAcademias;
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