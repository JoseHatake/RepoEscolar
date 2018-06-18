package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProfesor;

	//bi-directional many-to-one association to Archivo
	@OneToMany(mappedBy="profesor", fetch=FetchType.EAGER)
	private List<Archivo> archivos;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="profesor", fetch=FetchType.EAGER)
	private List<Curso> cursos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioFk")
	private Usuario usuario;

	public Profesor() {
	}

	public int getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public List<Archivo> getArchivos() {
		return this.archivos;
	}

	public void setArchivos(List<Archivo> archivos) {
		this.archivos = archivos;
	}

	public Archivo addArchivo(Archivo archivo) {
		getArchivos().add(archivo);
		archivo.setProfesor(this);

		return archivo;
	}

	public Archivo removeArchivo(Archivo archivo) {
		getArchivos().remove(archivo);
		archivo.setProfesor(null);

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
		curso.setProfesor(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setProfesor(null);

		return curso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean isNew() {
		return this.usuario == null;
	}
}