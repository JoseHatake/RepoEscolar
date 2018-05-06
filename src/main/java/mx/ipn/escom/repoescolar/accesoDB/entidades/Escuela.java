package mx.ipn.escom.repoescolar.accesoDB.entidades;

public class Escuela {
	private String nombre;
	private String escudo;
	private Integer id;
	
	public Escuela() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Escuela(String nombre, String escudo, Integer id) {
		super();
		this.nombre = nombre;
		this.escudo = escudo;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEscudo() {
		return escudo;
	}
	
	public void setEscudo(String escudo) {
		this.escudo = escudo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
