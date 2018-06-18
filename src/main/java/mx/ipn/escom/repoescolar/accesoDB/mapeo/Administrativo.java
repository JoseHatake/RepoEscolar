package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Administrativo database table.
 * 
 */
@Entity
@NamedQuery(name="Administrativo.findAll", query="SELECT a FROM Administrativo a")
public class Administrativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdministrativo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioFK")
	private Usuario usuario;

	public Administrativo() {
	}

	public int getIdAdministrativo() {
		return this.idAdministrativo;
	}

	public void setIdAdministrativo(int idAdministrativo) {
		this.idAdministrativo = idAdministrativo;
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