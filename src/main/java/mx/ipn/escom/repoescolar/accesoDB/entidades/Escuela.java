package mx.ipn.escom.repoescolar.accesoDB.entidades;

public class Escuela {
	private String nombre;
	private String escudo;
	private String sitioWeb;
	private String referencia;
	private Integer id;
	
	public Escuela() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
}
