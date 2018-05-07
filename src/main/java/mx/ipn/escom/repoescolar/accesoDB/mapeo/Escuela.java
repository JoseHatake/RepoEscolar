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

	@EmbeddedId
	private EscuelaPK id;

	private String direccion;

	private int extension;

	private String nombre;

	private int telefono;

	//bi-directional many-to-one association to Academia
	@OneToMany(mappedBy="escuela")
	private List<Academia> academias;

	//bi-directional many-to-one association to Administrativo
	@ManyToOne
	@JoinColumn(name="FKAdministrativo")
	private Administrativo administrativo;

	public Escuela() {
	}

	public EscuelaPK getId() {
		return this.id;
	}

	public void setId(EscuelaPK id) {
		this.id = id;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getExtension() {
		return this.extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
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

	public Administrativo getAdministrativo() {
		return this.administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}

}