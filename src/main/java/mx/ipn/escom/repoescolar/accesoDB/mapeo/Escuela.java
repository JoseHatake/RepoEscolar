package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Escuela database table.
 * 
 */
@Entity
@NamedQuery(name="Escuela.findAll", query="SELECT e FROM Escuela e")
public class Escuela implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEscuela;

	private int claveAdmin;

	private int claveProfesor;

	private String direccion;

	private String extension;

	private String nombre;

	private String referencia;

	private String sitioWeb;

	private String telefono;

	//bi-directional many-to-one association to Academia
	@OneToMany(mappedBy="escuela", fetch=FetchType.EAGER)
	private List<Academia> academias;

	//bi-directional many-to-one association to Grupo
	@OneToMany(mappedBy="escuela", fetch=FetchType.EAGER)
	private List<Grupo> grupos;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="escuela", fetch=FetchType.EAGER)
	private List<Usuario> usuarios;

	public Escuela() {
	}

	public int getIdEscuela() {
		return this.idEscuela;
	}

	public void setIdEscuela(int idEscuela) {
		this.idEscuela = idEscuela;
	}

	public int getClaveAdmin() {
		return this.claveAdmin;
	}

	public void setClaveAdmin(int claveAdmin) {
		this.claveAdmin = claveAdmin;
	}

	public int getClaveProfesor() {
		return this.claveProfesor;
	}

	public void setClaveProfesor(int claveProfesor) {
		this.claveProfesor = claveProfesor;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getSitioWeb() {
		return this.sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Academia> getAcademias() {
		return this.academias;
	}

	public void setAcademias(List<Academia> academias) {
		this.academias = academias;
	}

	public Academia addAcademia(Academia academia) {
		getAcademias().add(academia);
		academia.setEscuela(this);

		return academia;
	}

	public Academia removeAcademia(Academia academia) {
		getAcademias().remove(academia);
		academia.setEscuela(null);

		return academia;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupos().add(grupo);
		grupo.setEscuela(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupos().remove(grupo);
		grupo.setEscuela(null);

		return grupo;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setEscuela(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setEscuela(null);

		return usuario;
	}

}