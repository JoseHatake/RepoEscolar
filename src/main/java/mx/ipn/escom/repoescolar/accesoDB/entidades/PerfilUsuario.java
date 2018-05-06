package mx.ipn.escom.repoescolar.accesoDB.entidades;

public class PerfilUsuario {
	private String nombre;
	private String avatar;
	private Integer rol;
	
	public PerfilUsuario(String nombre, String avatar, Integer rol) {
		super();
		this.nombre = nombre;
		this.avatar = avatar;
		this.rol = rol;
	}

	public PerfilUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getRol() {
		return rol;
	}

	public void setRol(Integer rol) {
		this.rol = rol;
	}
}
