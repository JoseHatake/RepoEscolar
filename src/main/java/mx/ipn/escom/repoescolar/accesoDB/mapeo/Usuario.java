package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioPK id;

	private int password;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="FKAdministrativo", referencedColumnName="FKAdministrativo", insertable = false,updatable = false),
		@JoinColumn(name="FKAlumno", referencedColumnName="FKAlumno", insertable = false,updatable = false),
		@JoinColumn(name="FKJefeAcademia", referencedColumnName="FKJefeAcademia", insertable = false,updatable = false),
		@JoinColumn(name="FKProfesor", referencedColumnName="FKProfesor", insertable = false,updatable = false)
		})
	private Persona persona;

	public Usuario() {
	}

	public UsuarioPK getId() {
		return this.id;
	}

	public void setId(UsuarioPK id) {
		this.id = id;
	}

	public int getPassword() {
		return this.password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}