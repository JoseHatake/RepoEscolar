package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCurso;

	//bi-directional many-to-one association to Clase
	@OneToMany(mappedBy="curso", fetch=FetchType.EAGER)
	private List<Clase> clases;

	//bi-directional many-to-many association to Alumno
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="Clase"
		, joinColumns={
			@JoinColumn(name="CursoFK")
			}
		, inverseJoinColumns={
			@JoinColumn(name="AlumnoFK")
			}
		)
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="GruposFK")
	private Grupo grupo;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="MateriasFK")
	private Materia materia;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="ProfesorFK")
	private Profesor profesor;

	public Curso() {
	}

	public int getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public List<Clase> getClases() {
		return this.clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public Clase addClas(Clase clas) {
		getClases().add(clas);
		clas.setCurso(this);

		return clas;
	}

	public Clase removeClas(Clase clas) {
		getClases().remove(clas);
		clas.setCurso(null);

		return clas;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}