package mx.ipn.escom.repoescolar.accesoDB.mapeo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the JefeAcademia database table.
 * 
 */
@Entity
@NamedQuery(name="JefeAcademia.findAll", query="SELECT j FROM JefeAcademia j")
public class JefeAcademia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idJefeAcademia;

	//bi-directional many-to-one association to Academia
	@OneToMany(mappedBy="jefeAcademia", fetch=FetchType.EAGER)
	private List<Academia> academias;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioFK")
	private Usuario usuario;

	public JefeAcademia() {
	}

	public int getIdJefeAcademia() {
		return this.idJefeAcademia;
	}

	public void setIdJefeAcademia(int idJefeAcademia) {
		this.idJefeAcademia = idJefeAcademia;
	}

	public List<Academia> getAcademias() {
		return this.academias;
	}

	public void setAcademias(List<Academia> academias) {
		this.academias = academias;
	}

	public Academia addAcademia(Academia academia) {
		getAcademias().add(academia);
		academia.setJefeAcademia(this);

		return academia;
	}

	public Academia removeAcademia(Academia academia) {
		getAcademias().remove(academia);
		academia.setJefeAcademia(null);

		return academia;
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