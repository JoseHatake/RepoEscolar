package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaPK id;

	private String correo;

	private String nombre;

	private int telefon;

	//bi-directional many-to-one association to Administrativo
	@ManyToOne
	@JoinColumn(name="FKAdministrativo", insertable = false,updatable = false)
	private Administrativo administrativo;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="FKAlumno", insertable = false,updatable = false)
	private Alumno alumno;

	//bi-directional many-to-one association to JefeAcademia
	@ManyToOne
	@JoinColumn(name="FKJefeAcademia", insertable = false,updatable = false)
	private JefeAcademia jefeAcademia;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="FKProfesor", insertable = false,updatable = false)
	private Profesor profesor;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="persona")
	private List<Usuario> usuarios;

	public Persona() {
	}

	public PersonaPK getId() {
		return this.id;
	}

	public void setId(PersonaPK id) {
		this.id = id;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefon() {
		return this.telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public Administrativo getAdministrativo() {
		return this.administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public JefeAcademia getJefeAcademia() {
		return this.jefeAcademia;
	}

	public void setJefeAcademia(JefeAcademia jefeAcademia) {
		this.jefeAcademia = jefeAcademia;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPersona(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPersona(null);

		return usuario;
	}

}