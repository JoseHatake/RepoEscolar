package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Materias database table.
 * 
 */
@Entity
@Table(name="Materias")
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMaterias;

	private int nivel;

	private String nombre;

	//bi-directional many-to-one association to Archivo
	@OneToMany(mappedBy="materia", fetch=FetchType.EAGER)
	private List<Archivo> archivos;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="materia", fetch=FetchType.EAGER)
	private List<Curso> cursos;

	//bi-directional many-to-one association to Academia
	@ManyToOne
	@JoinColumn(name="AcademiaFK")
	private Academia academia;

	public Materia() {
	}

	public int getIdMaterias() {
		return this.idMaterias;
	}

	public void setIdMaterias(int idMaterias) {
		this.idMaterias = idMaterias;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Archivo> getArchivos() {
		return this.archivos;
	}

	public void setArchivos(List<Archivo> archivos) {
		this.archivos = archivos;
	}

	public Archivo addArchivo(Archivo archivo) {
		getArchivos().add(archivo);
		archivo.setMateria(this);

		return archivo;
	}

	public Archivo removeArchivo(Archivo archivo) {
		getArchivos().remove(archivo);
		archivo.setMateria(null);

		return archivo;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setMateria(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setMateria(null);

		return curso;
	}

	public Academia getAcademia() {
		return this.academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}

}