package mx.ipn.escom.repoescolar.accesoDB.utilidades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.repoescolar.accesoDB.entidades.Escuela;
import mx.ipn.escom.repoescolar.accesoDB.entidades.PerfilUsuario;

/**
 * Servlet implementation class Acciones
 */
public class Acciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		response.setCharacterEncoding("UTF-8");
		Integer accion = Integer.valueOf((String) request.getParameter("accion"));
		String direccion = request.getParameter("direccion");
		switch (accion) {
			case 1:
				cargarEscuelas(request);
				break;
			case 2:
				cargarSesionEscuela(request);
				break;
			case 3:
				direccion = iniciarSesion(request);
				break;
		}
		rd = request.getRequestDispatcher(direccion);
		rd.forward(request, response);
	}
	
	private String iniciarSesion(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Archivos archivo = new Archivos();
		PerfilUsuario perfil = new PerfilUsuario();
		String contexto,password,direccion;
		Integer log,pass;
		
		contexto = (String) session.getAttribute("contexto");
		archivo.setContexto(contexto);
		
		log = Integer.parseInt(request.getParameter("numeroBoleta"));
		password = request.getParameter("clave");
		pass = password.hashCode();
		
		//Agregar validación con DB
		
		perfil.setNombre("José Miguel");
		perfil.setRol(1);
		
		session.setAttribute("perfil", perfil);
		
		direccion = "inicioRepoEscolar.jsp";
		return direccion;
	}
	
	private void cargarSesionEscuela(HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		Archivos archivo = new Archivos();
		Escuela escuela = new Escuela();
		String contexto;
		Integer idEscuela;
		
		contexto = (String) session.getAttribute("contexto");
		archivo.setContexto(contexto);
		idEscuela = (Integer) request.getAttribute("escuela");
		
		escuela.setEscudo(archivo.obtenerImagenCodificada("escom", "escom.png"));
		escuela.setId(idEscuela);
		escuela.setNombre("Escuela Superior de Cómputo");
		
		session.setAttribute("escuela", escuela);
	}
	
	private void cargarEscuelas(HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		Archivos archivo = new Archivos();
		List<Escuela> escuelas = new ArrayList<Escuela>();
		String contexto,escudo;
		
		/* Datos de prueba, se tiene que traer de la DB */
		List<String> escuelasConsultadas = new ArrayList<String>();
		escuelasConsultadas.add("escom");
		escuelasConsultadas.add("escom");
		escuelasConsultadas.add("escom");
		escuelasConsultadas.add("escom");
		escuelasConsultadas.add("esiquie");
		/* Datos de prueba, se tiene que traer de la DB */
		
		contexto = this.getServletConfig().getServletContext().getRealPath("/");
		
		archivo.setContexto(contexto);
		for (String school : escuelasConsultadas) {
			escudo = archivo.obtenerImagenCodificada(school, school + ".png");
			escuelas.add(new Escuela("Escuela Superior de Cómputo",escudo,1));
		}
		
		request.setAttribute("escuelas", escuelas);
		session.setAttribute("contexto", contexto);
	}

}
