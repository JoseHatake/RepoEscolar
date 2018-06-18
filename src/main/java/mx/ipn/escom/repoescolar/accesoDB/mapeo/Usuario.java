package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;

	private String nick;

	private int password;

	//bi-directional many-to-one association to Administrador
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	private List<Administrador> administradors;

	//bi-directional many-to-one association to Administrativo
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	private List<Administrativo> administrativos;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to JefeAcademia
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	private List<JefeAcademia> jefeAcademias;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
	private List<Profesor> profesors;

	//bi-directional many-to-one association to Escuela
	@ManyToOne
	@JoinColumn(name="EscuelaFK")
	private Escuela escuela;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PersonaFK")
	private Persona persona;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getPassword() {
		return this.password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public List<Administrador> getAdministradors() {
		return this.administradors;
	}

	public void setAdministradors(List<Administrador> administradors) {
		this.administradors = administradors;
	}

	public Administrador addAdministrador(Administrador administrador) {
		getAdministradors().add(administrador);
		administrador.setUsuario(this);

		return administrador;
	}

	public Administrador removeAdministrador(Administrador administrador) {
		getAdministradors().remove(administrador);
		administrador.setUsuario(null);

		return administrador;
	}

	public List<Administrativo> getAdministrativos() {
		return this.administrativos;
	}

	public void setAdministrativos(List<Administrativo> administrativos) {
		this.administrativos = administrativos;
	}

	public Administrativo addAdministrativo(Administrativo administrativo) {
		getAdministrativos().add(administrativo);
		administrativo.setUsuario(this);

		return administrativo;
	}

	public Administrativo removeAdministrativo(Administrativo administrativo) {
		getAdministrativos().remove(administrativo);
		administrativo.setUsuario(null);

		return administrativo;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno addAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
		alumno.setUsuario(this);

		return alumno;
	}

	public Alumno removeAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
		alumno.setUsuario(null);

		return alumno;
	}

	public List<JefeAcademia> getJefeAcademias() {
		return this.jefeAcademias;
	}

	public void setJefeAcademias(List<JefeAcademia> jefeAcademias) {
		this.jefeAcademias = jefeAcademias;
	}

	public JefeAcademia addJefeAcademia(JefeAcademia jefeAcademia) {
		getJefeAcademias().add(jefeAcademia);
		jefeAcademia.setUsuario(this);

		return jefeAcademia;
	}

	public JefeAcademia removeJefeAcademia(JefeAcademia jefeAcademia) {
		getJefeAcademias().remove(jefeAcademia);
		jefeAcademia.setUsuario(null);

		return jefeAcademia;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setUsuario(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setUsuario(null);

		return profesor;
	}

	public Escuela getEscuela() {
		return this.escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Boolean isNew() {
		return this.persona == null;
	}
}