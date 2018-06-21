package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Alumno database table.
 * 
 */
@Entity
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAlumno;

	private String boleta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioFK")
	private Usuario usuario;

	//bi-directional many-to-one association to Clase
	@OneToMany(mappedBy="alumno", fetch=FetchType.EAGER)
	private List<Clase> clases;

	//bi-directional many-to-many association to Curso
	@ManyToMany(mappedBy="alumnos", fetch=FetchType.EAGER)
	private List<Curso> cursos;

	public Alumno() {
	}

	public int getIdAlumno() {
		return this.idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getBoleta() {
		return this.boleta;
	}

	public void setBoleta(String boleta) {
		this.boleta = boleta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Clase> getClases() {
		return this.clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public Clase addClas(Clase clas) {
		getClases().add(clas);
		clas.setAlumno(this);

		return clas;
	}

	public Clase removeClas(Clase clas) {
		getClases().remove(clas);
		clas.setAlumno(null);

		return clas;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Boolean isNew() {
		return this.usuario == null;
	}
	
	public Boolean isRegistered() {
		return this.boleta != null;
	}
}