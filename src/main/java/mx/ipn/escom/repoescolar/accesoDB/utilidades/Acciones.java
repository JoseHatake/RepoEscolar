package mx.ipn.escom.repoescolar.accesoDB.utilidades;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.repoescolar.accesoDB.bs.AcademiaBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.AdministradorBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.AdministrativoBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.AlumnoBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.ArchivoBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.ClaseBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.CursoBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.EscuelaBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.GrupoBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.JefeAcademiaBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.MateriaBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.PersonaBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.ProfesorBs;
import mx.ipn.escom.repoescolar.accesoDB.bs.UsuarioBs;
import mx.ipn.escom.repoescolar.accesoDB.entidades.Escuela;
import mx.ipn.escom.repoescolar.accesoDB.entidades.PerfilUsuario;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Academia;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Administrativo;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Alumno;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Archivo;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Clase;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Curso;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Grupo;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.JefeAcademia;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Materia;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Persona;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Profesor;
import mx.ipn.escom.repoescolar.accesoDB.mapeo.Usuario;
import mx.ipn.escom.repoescolar.accesoDB.utilidades.StringCodificador;

/**
 * Servlet implementation class Acciones
 */
public class Acciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioBs usuarioBs;
	
	@Autowired
	private AdministradorBs administradorBs;
	
	@Autowired
	private AdministrativoBs administrativoBs;
	
	@Autowired
	private ProfesorBs profesorBs;
	
	@Autowired
	private AlumnoBs alumnoBs;
	
	@Autowired
	private JefeAcademiaBs jefeAcademiaBs;
	
	@Autowired
	private PersonaBs personaBs;
	
	@Autowired
	private EscuelaBs escuelaBs;
	
	@Autowired
	private AcademiaBs academiaBs;
	
	@Autowired
	private CursoBs cursoBs;
	
	@Autowired
	private ArchivoBs archivoBs;
	
	@Autowired
	private MateriaBs materiaBs;
	
	@Autowired
	private ClaseBs claseBs;
	
	@Autowired
	private GrupoBs grupoBs;
    
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
				iniciarSesion(request,response);
				break;
			case 4:
				registrarUsuario(request);
				break;
			case 5:
				direccion = cerrarSesion(request);
				break;
			case 6:
				cargdaAcademiasMaterias(request);
				break;
			case 7:
				infoParaCargarContenido(request);
				break;
			case 8:
				cargaDocumentos(request);
				break;
			case 9:
				infoGestionaMateria(request);
				break;
			case 10:
				borrarCurso(request);
				break;
			case 11:
				crearCursos(request);
				break;
			case 12:
				borrarArchivo(request);
				break;
			case 13:
				try {
					direccion = descargarDocumentos(request);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 14:
				cargaArchivosPorMateriaProfesor(request);
				break;
			case 15:
				cargaCursosAlumno(request);
				break;
			case 16:
				infoGrupos(request);
				break;
			case 17:
				borrarClase(request);
				break;
			case 18:
				inscribirClase(request);
				break;
			case 19:
				crearGrupos(request);
				break;
			case 20:
				borrarGrupos(request);
				break;
			case 21:
				registrarEscuela(request);
				break;
			case 22:
				generarBoletasAlumno(request);
				break;
			case 23:
				crearAcademias(request);
				break;
			case 24:
				borrarAcademias(request);
				break;
			case 25:
				infoJefeAcademia(request);
				break;
			case 26:
				cambiarJefeAcademia(request);
				break;
			case 27:
				editarPerfil(request);
				break;
			case 28:
				infoMateriasJefeAcademia(request);
				break;
			case 29:
				borrarMaterias(request);
				break;
			case 30:
				agregarMaterias(request);
				break;
		}
		rd = request.getRequestDispatcher(direccion);
		rd.forward(request, response);
	}
	
	private void agregarMaterias(HttpServletRequest request) {
		String[] materiaNueva,nivelMateria;
		Integer idAcademias,counter,nivel;
		Academia academia;
		Materia materia;
		
		idAcademias = Integer.parseInt(request.getParameter("academia"));
		materiaNueva = request.getParameterValues("materiaNueva");
		nivelMateria = request.getParameterValues("nivelMateria");
		academia = academiaBs.searchById(idAcademias);
		
		counter = 0;
		for (String nombreMateria : materiaNueva) {
			nivel = Integer.parseInt(nivelMateria[counter++]);
			materia = new Materia();
			materia.setAcademia(academia);
			materia.setNivel(nivel);
			materia.setNombre(nombreMateria);
			materiaBs.save(materia);
		}
		infoMateriasJefeAcademia(request);
	}
	private void borrarMaterias(HttpServletRequest request) {
		String[] materiaAEliminar;
		Integer idMateria;
		Materia materia;
		
		materiaAEliminar = request.getParameterValues("materiaAEliminar");
		for (String materiaElim : materiaAEliminar) {
			idMateria = Integer.parseInt(materiaElim);
			materia = materiaBs.searchById(idMateria);
			materiaBs.delete(materia);
		}
		infoMateriasJefeAcademia(request);
	}
	private void infoMateriasJefeAcademia(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario usuario;
		JefeAcademia jefeAcademia;
		Academia academia;
		List<Materia> materias;
		
		usuario = (Usuario) session.getAttribute("usuario");
		jefeAcademia = jefeAcademiaBs.searchByIdUsuario(usuario.getIdUsuario());
		
		academia = jefeAcademia.getAcademias().get(0);
		materias = academia.getMaterias();
		request.setAttribute("materias", materias);
		request.setAttribute("academia", academia);
	}
	private void editarPerfil(HttpServletRequest request) {
		HttpSession session = request.getSession();
		StringCodificador codificador = new StringCodificador();
		Persona persona;
		Usuario usuario;
		PerfilUsuario perfil;
		Archivos archivo = new Archivos();
		String contexto,path;
		
		contexto = (String) session.getAttribute("contexto");
		archivo.setContexto(contexto);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(5120);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try{
            List<FileItem> partes;
            FileItem item;
            File file;
            
            partes = upload.parseRequest(request);
            
            item = partes.get(0);
    		usuario = (Usuario) session.getAttribute("usuario");
    		perfil = (PerfilUsuario) session.getAttribute("perfil");
            path = contexto + "/img/perfil/";
            
            persona = usuario.getPersona();
            
            persona.setNombres(codificador.codificar(partes.get(1).getString()));
			persona.setApellidos(codificador.codificar(partes.get(2).getString()));
			persona.setTelefono(partes.get(3).getString());
			persona.setCorreo(codificador.codificar(partes.get(4).getString()));
			//persona = personaBs.update(persona);
			
			usuario.setPersona(persona);
			usuario = usuarioBs.update(usuario);
    		
            file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            
            if(item.getSize()!=0){
                file = new File(path,persona.getIdPersona() + ".png");
                item.write(file);
            }
            
            factory.setRepository(file);
            
			perfil.setNombre(persona.getNombres());
			if (archivo.existeArchivo("perfil/" + persona.getIdPersona() + ".png"))
				perfil.setAvatar(archivo.obtenerImagenCodificada("perfil/", persona.getIdPersona() + ".png"));
			session.setAttribute("usuario", usuario);
			session.setAttribute("perfil", perfil);
        }catch (Exception e) {
        	System.err.println(e);
		}
	}
	private void cambiarJefeAcademia(HttpServletRequest request) {
		Integer idProfesorNuevoJefeAcademia,IdAcademia;
		Academia academia;
		List<Academia> academias = new ArrayList<Academia>();
		Profesor profesor;
		JefeAcademia jefeAcademiaNuevoActual;
		
		IdAcademia = Integer.parseInt(request.getParameter("academia"));
		idProfesorNuevoJefeAcademia = Integer.parseInt(request.getParameter("nuevoJefeAcademia"));
		
		academia = academiaBs.searchById(IdAcademia);
		jefeAcademiaNuevoActual = academia.getJefeAcademia();
		if (jefeAcademiaNuevoActual == null)
			jefeAcademiaNuevoActual = new JefeAcademia();
		academias.add(academia);
		
		
		if (!jefeAcademiaNuevoActual.isNew()) {
			//El jefe de academia pasa a ser profesor
			profesor = new Profesor();
			profesor.setUsuario(jefeAcademiaNuevoActual.getUsuario());
			profesorBs.save(profesor);
			
			//Actualizo el jefe de academia
			profesor = profesorBs.searchById(idProfesorNuevoJefeAcademia);
			jefeAcademiaNuevoActual.setUsuario(profesor.getUsuario());
			jefeAcademiaBs.update(jefeAcademiaNuevoActual);
		}
		else {
			//Guardo el jefe de academia
			profesor = profesorBs.searchById(idProfesorNuevoJefeAcademia);
			jefeAcademiaNuevoActual.setUsuario(profesor.getUsuario());
			jefeAcademiaBs.save(jefeAcademiaNuevoActual);
		}
		
		//Elimino al profesor que pasa a ser jefe de academia
		profesorBs.delete(profesor);
		
		infoJefeAcademia(request);
	}
	private void infoJefeAcademia(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Profesor> profesores;
		Usuario usuario;
		
		usuario = (Usuario) session.getAttribute("usuario");
		
		profesores = profesorBs.searchByIdSchool(usuario.getEscuela().getIdEscuela());
		request.setAttribute("profesores", profesores);
		cargdaAcademiasMaterias(request);
	}
	private void borrarAcademias(HttpServletRequest request) {
		Academia academia;
		String[] academiaAEliminar;
		Integer idAcademia;
		
		academiaAEliminar = request.getParameterValues("academiaAEliminar");
		
		for (String academiaElim : academiaAEliminar) {
			idAcademia = Integer.parseInt(academiaElim);
			academia = academiaBs.searchById(idAcademia);
			academiaBs.delete(academia);
		}
		cargdaAcademiasMaterias(request);
	}
	private void crearAcademias(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Escuela escuelaUtil;
		mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela escuela;
		Academia academia;
		String[] academiaNueva;
		
		escuelaUtil = (Escuela) session.getAttribute("escuela");
		academiaNueva = request.getParameterValues("academiaNueva");
		escuela = escuelaBs.searchById(escuelaUtil.getId());
		
		for (String nombre : academiaNueva) {
			academia = new Academia();
			academia.setEscuela(escuela);
			academia.setNombre(nombre);
			academiaBs.save(academia);
		}
		cargdaAcademiasMaterias(request);
	}
	private void generarBoletasAlumno(HttpServletRequest request) {
		Integer boletaInicial,boletaFinal,mensaje;
		Alumno alumno;
		
		boletaInicial = Integer.parseInt(request.getParameter("inicial"));
		boletaFinal = Integer.parseInt(request.getParameter("final"));
		
		for (Integer i = boletaInicial; i <= boletaFinal; i++) {
			alumno = new Alumno();
			alumno.setBoleta(i.toString());
			alumnoBs.save(alumno);
		}
		mensaje = 5;
		request.setAttribute("mensaje",mensaje);
		request.setAttribute("boletaInicial", boletaInicial);
		request.setAttribute("boletaFinal", boletaFinal);
	}
	private void registrarEscuela(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String nombre,direccion,telefono,extension,sitioWeb,referencia,contexto,path,claveAdminPlano,claveProfesorPlano;
		Integer mensaje,claveAdmin,claveProfesor;
		StringCodificador codificador = new StringCodificador();
		mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela escuela;
		
		contexto = (String) session.getAttribute("contexto");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(5120);
        ServletFileUpload upload = new ServletFileUpload(factory);
        mensaje = 4;
        try{
            List<FileItem> partes;
            FileItem item;
            File file;
            
            partes = upload.parseRequest(request);
            
            item = partes.get(0);
            nombre = codificador.codificar(partes.get(1).getString());
    		direccion = codificador.codificar(partes.get(2).getString());
    		telefono = partes.get(3).getString();
    		extension = partes.get(4).getString();
    		sitioWeb = codificador.codificar(partes.get(5).getString());
    		referencia = codificador.codificar(partes.get(6).getString());
    		claveAdminPlano = partes.get(7).getString();
    		claveProfesorPlano = partes.get(8).getString();
    		claveAdmin = claveAdminPlano.hashCode();
    		claveProfesor = claveProfesorPlano.hashCode();
            
            path = contexto + "/img/escuelas/" + referencia;
            file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            
            factory.setRepository(file);
    		
            if(item.getSize()!=0){
                file = new File(path,referencia + ".png");
                item.write(file);
            }
            
            escuela = new mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela();
    		escuela.setNombre(nombre);
    		escuela.setDireccion(direccion);
    		escuela.setTelefono(telefono);
    		escuela.setExtension(extension);
    		escuela.setSitioWeb(sitioWeb);
    		escuela.setReferencia(referencia);
    		escuela.setClaveAdmin(claveAdmin);
    		escuela.setClaveProfesor(claveProfesor);
    		escuela = escuelaBs.save(escuela);
    		
    		request.setAttribute("claveAdmin", claveAdminPlano);
    		request.setAttribute("claveProfesor", claveProfesorPlano);
    		request.setAttribute("escuela", escuela);
    		mensaje = 3;
        }catch (Exception e) {
        	System.err.println(e);
        	mensaje = 4;
		}
        request.setAttribute("mensaje", mensaje);
	}
	private void borrarGrupos(HttpServletRequest request) {
		String[] gruposAEliminar;
		Integer idGrupo;
		
		gruposAEliminar = request.getParameterValues("gruposAEliminar");
		
		for (String grupo : gruposAEliminar) {
			idGrupo = Integer.parseInt(grupo);
			grupoBs.delete(grupoBs.searchById(idGrupo));
		}
		infoGrupos(request);
	}
	private void crearGrupos(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String[] niveles,turno,numeroGrupo;
		String nombreGrupo;
		Integer counter,numeroDeGrupos;
		Escuela escuelaUtil;
		mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela escuela;
		Grupo grupo;
		
		escuelaUtil = (Escuela) session.getAttribute("escuela");
		niveles = request.getParameterValues("niveles");
		turno = request.getParameterValues("turno");
		numeroGrupo = request.getParameterValues("numeroGrupo");
		
		escuela = escuelaBs.searchById(escuelaUtil.getId());
		counter = 0;
		for (String nivel : niveles) {
			nombreGrupo = nivel + "-" + turno[counter];
			numeroDeGrupos = Integer.parseInt(numeroGrupo[counter]);
			for (int i = 1; i <= numeroDeGrupos; i++) {
				grupo = new Grupo();
				grupo.setEscuela(escuela);
				grupo.setGrupo(nombreGrupo + i);
				grupoBs.save(grupo);
			}
		}
		infoGrupos(request);
	}
	private void inscribirClase(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario usuario;
		Alumno alumno;
		Integer idCurso;
		Curso cursoDB;
		Clase claseInscrita;
		String[] materiaAInscribir;
		
		usuario = (Usuario) session.getAttribute("usuario");
		alumno = alumnoBs.searchByIdUsuario(usuario.getIdUsuario());
		
		materiaAInscribir = request.getParameterValues("materiaAInscribir");
		
		for (String curso : materiaAInscribir) {
			idCurso = Integer.parseInt(curso);
			cursoDB = cursoBs.searchById(idCurso);
			
			claseInscrita = new Clase();
			claseInscrita.setAlumno(alumno);
			claseInscrita.setCurso(cursoDB);
			claseBs.save(claseInscrita);
		}
		infoGrupos(request);
	}
	private void borrarClase(HttpServletRequest request) {
		String[] idClaseAsociada;
		Clase clase;
		Integer idClase;
		
		idClaseAsociada = request.getParameterValues("claseAsociada");
		
		for (String idClaseA : idClaseAsociada) {
			idClase = Integer.parseInt(idClaseA);
			clase = claseBs.searchById(idClase);
			claseBs.delete(clase);
		}
		infoGrupos(request);
	}
	private void infoGrupos(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Escuela escuelaUtil;
		Usuario usuario;
		Alumno alumno;
		mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela escuelaDB;
		List<Grupo> todosLosGrupos;
		
		usuario = (Usuario) session.getAttribute("usuario");
		escuelaUtil = (Escuela) session.getAttribute("escuela");
		escuelaDB = escuelaBs.searchById(escuelaUtil.getId());
		
		if (!alumnoBs.searchByIdUsuario(usuario.getIdUsuario()).isNew()) {
			alumno = alumnoBs.searchByIdUsuario(usuario.getIdUsuario());
			request.setAttribute("alumno", alumno);
		}
		
		todosLosGrupos = escuelaDB.getGrupos();
		request.setAttribute("todosLosGrupos", todosLosGrupos);
	}
	private void cargaCursosAlumno(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario usuario;
		Alumno alumno;
		List<Curso> cursos;
		
		usuario = (Usuario) session.getAttribute("usuario");
		alumno = alumnoBs.searchByIdUsuario(usuario.getIdUsuario());
		
		cursos = alumno.getCursos();
		
		request.setAttribute("cursos", cursos);
	}
	private void cargaArchivosPorMateriaProfesor(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer idMateria,idProfesor;
		Boolean profesor;
		Materia materia;
		Usuario usuario;
		Alumno alumno;
		List<Archivo> archivos;
		
		idMateria = Integer.parseInt(request.getParameter("selectMateria"));
		profesor = Boolean.valueOf(request.getParameter("profesor"));
		
		if (profesor) {
			usuario = (Usuario) session.getAttribute("usuario");
			alumno = alumnoBs.searchByIdUsuario(usuario.getIdUsuario());
			idProfesor = 0;
			for (Curso curso: alumno.getCursos()) {
				if (curso.getMateria().getIdMaterias() == idMateria) {
					idProfesor = curso.getProfesor().getIdProfesor();
					break;
				}
			}
			archivos = archivoBs.searchByIdMateriaIdProfesor(idMateria, idProfesor);
		}
		else {
			materia = materiaBs.searchById(idMateria);
			archivos = materia.getArchivos();
		}
		
		request.setAttribute("archivos", archivos);
	}
	private String descargarDocumentos(HttpServletRequest request) throws IOException, URISyntaxException {
		HttpSession session = request.getSession();
		Archivo archivoDB;
		List<Archivo> archivos;
		Escuela escuelaUtil;
		Usuario usuario;
		String[] archivoSelect;
		String contexto,pathDirectory,nombreZIP;
		
		contexto = (String) session.getAttribute("contexto");
		usuario = (Usuario) session.getAttribute("usuario");
		escuelaUtil = (Escuela) session.getAttribute("escuela");
		archivoSelect = request.getParameterValues("archivoSelect");
		
		Map<String, String> env = new HashMap<>(); 
		archivos = new ArrayList<Archivo>();
		env.put("create", "true");
		
		nombreZIP = "RepoEscolar-" + escuelaUtil.getReferencia() + "-" + usuario.getIdUsuario();
		
		pathDirectory = "repositorio/descargas/" + nombreZIP + ".zip";
		
		URI uri = URI.create("jar:file://" + contexto + "/" + pathDirectory);

		try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
			for (String archivo : archivoSelect) {
				archivoDB = archivoBs.searchById(Integer.parseInt(archivo));
				archivos.add(archivoDB);
				Path externalTxtFile = Paths.get(contexto + "/repositorio/" + escuelaUtil.getReferencia() + "/" + archivoDB.getNombre());
			    Path pathInZipfile = zipfs.getPath("/" + archivoDB.getNombre());          
			    // copy a file into the zip file
			    Files.copy(externalTxtFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
			}
		}
		
		uri = new URI(pathDirectory);
		
		request.setAttribute("archivos", archivos);
		request.setAttribute("zipFile", uri);
		return "descargarArchivos.jsp";
	}
	private void borrarArchivo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		File file;
		Escuela escuelaUtil;
		Archivo archivoDB;
		String[] archivoSelect;
		String contexto;
		
		contexto = (String) session.getAttribute("contexto");
		escuelaUtil = (Escuela) session.getAttribute("escuela");
		archivoSelect = request.getParameterValues("archivoSelect");
		
		for (String archivo : archivoSelect) {
			archivoDB = archivoBs.searchById(Integer.parseInt(archivo));
			file = new File(contexto + "/repositorio/" + escuelaUtil.getReferencia() + "/" + archivoDB.getNombre());
			file.delete();
			archivoBs.delete(archivoDB);
		}
		infoParaCargarContenido(request);
	}
	private void crearCursos(HttpServletRequest request) {
		Integer idMateria,tmp1,tmp2,counter;
		Boolean flag;
		String [] listaProfesores,listaGrupos;
		List<Profesor> profesoresPorMateria;
		
		idMateria = Integer.parseInt(request.getParameter("materia"));
		listaProfesores = request.getParameterValues("listaProfesores");
		listaGrupos = request.getParameterValues("listaGrupos");
		profesoresPorMateria = profesorBs.searchByIdMateria(idMateria);
		
		counter = 0;
		for (String idProfesorSelect : listaProfesores) {
			tmp1 = Integer.parseInt(idProfesorSelect);
			tmp2 = Integer.parseInt(listaGrupos[counter]);
			flag = true;
			for (Profesor profesor : profesoresPorMateria) {
				if (profesor.getIdProfesor() == tmp1) {
					for (Curso curso : profesor.getCursos()) {
						if (curso.getGrupo().getIdGrupo() == tmp2) {
							flag = false;
							break;
						}
					}
					if (!flag)
						break;
				}
			}
			if (flag) {
				Curso curso = new Curso();
				curso.setMateria(materiaBs.searchById(idMateria));
				curso.setProfesor(profesorBs.searchById(tmp1));
				curso.setGrupo(grupoBs.searchById(tmp2));
				cursoBs.save(curso);
			}
			counter++;
		}
		infoGestionaMateria(request);
	}
	private void borrarCurso(HttpServletRequest request) {
		String[] idProfesores;
		Integer idProfesor,idMateria;
		List<Curso> cursosProfesor;
		
		idProfesores = request.getParameterValues("borrarProfesorDeMateria");
		idMateria = Integer.parseInt(request.getParameter("materia"));
		
		for (String idProfesorStrign : idProfesores) {
			idProfesor = Integer.parseInt(idProfesorStrign);
			cursosProfesor = cursoBs.cursoByIdTeacher(idProfesor);
			for (Curso curso2 : cursosProfesor) {
				if (curso2.getMateria().getIdMaterias() == idMateria) {
					cursoBs.delete(curso2);
					break;
				}
			}
		}
		
		infoGestionaMateria(request);
	}
	private void infoGestionaMateria(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario usuario;
		Escuela escuelaUtil;
		mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela escuelaDB;
		JefeAcademia jefeAcademia;
		List<Profesor> profesores;
		List<Grupo> todosLosGrupos;
		Academia academia;
		
		usuario = (Usuario) session.getAttribute("usuario");
		jefeAcademia = jefeAcademiaBs.searchByIdUsuario(usuario.getIdUsuario());
		
		academia = jefeAcademia.getAcademias().get(0);
		profesores = profesorBs.searchByIdSchool(usuario.getEscuela().getIdEscuela());
		
		escuelaUtil = (Escuela) session.getAttribute("escuela");
		escuelaDB = escuelaBs.searchById(escuelaUtil.getId());
		todosLosGrupos = escuelaDB.getGrupos();
		
		request.setAttribute("todosLosGrupos", todosLosGrupos);
		request.setAttribute("academia", academia);
		request.setAttribute("profesores", profesores);
	}
	private void infoParaCargarContenido(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario usuario;
		Profesor profesor;
		
		usuario = (Usuario) session.getAttribute("usuario");
		profesor = profesorBs.searchByIdUsuario(usuario.getIdUsuario());
		
		request.setAttribute("profesor", profesor);
	}
	private void cargaDocumentos(HttpServletRequest request) {
		HttpSession session = request.getSession();
		StringCodificador codificador = new StringCodificador();
		Escuela escuelaUtil;
		Usuario usuario;
		Profesor profesor;
		Archivo archivoDB;
		String contexto,fileName,path;
		Integer i,materia;
		
		contexto = (String) session.getAttribute("contexto");
		escuelaUtil = (Escuela) session.getAttribute("escuela");
		usuario = (Usuario) session.getAttribute("usuario");
		profesor = profesorBs.searchByIdUsuario(usuario.getIdUsuario());
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(5120);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try{
            List<FileItem> partes;
            FileItem item;
            File file;
            
            partes = upload.parseRequest(request);
            path = contexto + "/repositorio/" + escuelaUtil.getReferencia();
            file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            
            factory.setRepository(file);
            //String []namesFiles = file.list();
            i = 0;
            while(i < partes.size()){
            	materia = Integer.parseInt(codificador.codificar(partes.get(i++).getString()));
                item = partes.get(i++);
                fileName = item.getName();
                
                if(item.getSize()!=0){
                    file = new File(path,fileName);
                    item.write(file);
                    
                    archivoDB = new Archivo();
                    archivoDB.setMateria(materiaBs.searchById(materia));
                    archivoDB.setNombre(fileName);
                    archivoDB.setProfesor(profesor);
                    archivoBs.save(archivoDB);
                }
            }
        }catch (Exception e) {
        	System.err.println(e);
		}finally {
			infoParaCargarContenido(request);
		}
	}
	private void cargdaAcademiasMaterias(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Academia> academias;
		Escuela escuelaUtil;
		
		escuelaUtil = (Escuela) session.getAttribute("escuela");
		academias = academiaBs.academysByIdSchool(escuelaUtil.getId());
		
		request.setAttribute("academias", academias);
	}
	private String cerrarSesion(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuario");
		session.removeAttribute("perfil");
		session.removeAttribute("escuela");
		
		return "Acciones?accion=1&direccion=index.jsp";
	}
	private void registrarUsuario(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Persona persona;
		Usuario usuario;
		Alumno alumno;
		Escuela escuelaUtil;
		mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela escuelaDB;
		String nombre,nick,boleta,contexto,path;
		Integer mensaje,cargo,claveAcceso;
		StringCodificador codificador = new StringCodificador();
		
		contexto = (String) session.getAttribute("contexto");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(5120);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try{
            List<FileItem> partes;
            FileItem item;
            File file;
            
            partes = upload.parseRequest(request);
            
            item = partes.get(0);
            escuelaUtil = (Escuela) session.getAttribute("escuela");
            path = contexto + "/img/perfil/";
    		
            file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            
            factory.setRepository(file);
            
            escuelaDB = escuelaBs.searchById(escuelaUtil.getId());
    		
            if (Integer.parseInt(partes.get(8).getString()) != 0)
            	cargo = Integer.parseInt(partes.get(8).getString());
            else if(Integer.parseInt(partes.get(9).getString()) != 0)
            	cargo = Integer.parseInt(partes.get(9).getString());
            else
            	cargo = 0;
            
            boleta = partes.get(5).getString();
            if (cargo == 1) { //Administrativo
				claveAcceso = partes.get(10).getString().hashCode();
				if (claveAcceso.equals(escuelaDB.getClaveAdmin())) {
					persona = new Persona();
        			persona.setNombres(codificador.codificar(partes.get(1).getString()));
        			persona.setApellidos(codificador.codificar(partes.get(2).getString()));
        			persona.setTelefono(codificador.codificar(partes.get(3).getString()));
        			persona.setCorreo(codificador.codificar(partes.get(4).getString()));
        			persona = personaBs.save(persona);
        			
        			usuario = new Usuario();
        			usuario.setNick(boleta);
        			usuario.setPassword(codificador.codificar(partes.get(6).getString()).hashCode());
        			usuario.setPersona(persona);
        			usuario.setEscuela(escuelaBs.searchById(escuelaUtil.getId()));
        			usuario = usuarioBs.save(usuario);
        			
        			Administrativo admin = new Administrativo();
        			admin.setUsuario(usuario);
        			
        			administrativoBs.save(admin);
        			
        			nombre = codificador.codificar(partes.get(1).getString()) + " " + codificador.codificar(partes.get(2).getString());
        			nick = boleta;
        			
        			if(item.getSize()!=0){
                        file = new File(path,persona.getIdPersona() + ".png");
                        item.write(file);
                    }
        			
        			request.setAttribute("nombre",nombre);
        			request.setAttribute("nick", nick);
        			
        			mensaje = 1;
				}
				else
					mensaje = 2;
			}
            else if (cargo == 2) {//Profesor
            	claveAcceso = partes.get(10).getString().hashCode();
				if (claveAcceso.equals(escuelaDB.getClaveProfesor())) {
					persona = new Persona();
        			persona.setNombres(codificador.codificar(partes.get(1).getString()));
        			persona.setApellidos(codificador.codificar(partes.get(2).getString()));
        			persona.setTelefono(codificador.codificar(partes.get(3).getString()));
        			persona.setCorreo(codificador.codificar(partes.get(4).getString()));
        			persona = personaBs.save(persona);
        			
        			usuario = new Usuario();
        			usuario.setNick(boleta);
        			usuario.setPassword(codificador.codificar(partes.get(6).getString()).hashCode());
        			usuario.setPersona(persona);
        			usuario.setEscuela(escuelaBs.searchById(escuelaUtil.getId()));
        			usuario = usuarioBs.save(usuario);
        			
        			Profesor profesor = new Profesor();
        			profesor.setUsuario(usuario);
        			
        			profesorBs.save(profesor);
        			
        			nombre = codificador.codificar(partes.get(1).getString()) + " " + codificador.codificar(partes.get(2).getString());
        			nick = boleta;
        			
        			if(item.getSize()!=0){
                        file = new File(path,persona.getIdPersona() + ".png");
                        item.write(file);
                    }
        			
        			request.setAttribute("nombre",nombre);
        			request.setAttribute("nick", nick);
        			
        			mensaje = 1;
				}
				else
					mensaje = 2;
            }
            else {
        		usuario = usuarioBs.searchByNick(boleta);
        		alumno = alumnoBs.searchByBoleta(boleta);
        		if (usuario.isNew() && alumno.isNew()) {
        			persona = new Persona();
        			persona.setNombres(codificador.codificar(partes.get(1).getString()));
        			persona.setApellidos(codificador.codificar(partes.get(2).getString()));
        			persona.setTelefono(codificador.codificar(partes.get(3).getString()));
        			persona.setCorreo(codificador.codificar(partes.get(4).getString()));
        			persona = personaBs.save(persona);
        			
        			usuario = new Usuario();
        			usuario.setNick(boleta);
        			usuario.setPassword(codificador.codificar(partes.get(6).getString()).hashCode());
        			usuario.setPersona(persona);
        			usuario.setEscuela(escuelaBs.searchById(escuelaUtil.getId()));
        			usuario = usuarioBs.save(usuario);
        			
        			alumno.setUsuario(usuario);
        			alumno = alumnoBs.update(alumno);
        			
        			nombre = codificador.codificar(partes.get(1).getString()) + " " + codificador.codificar(partes.get(2).getString());
        			nick = boleta;
        			
        			if(item.getSize()!=0){
                        file = new File(path,persona.getIdPersona() + ".png");
                        item.write(file);
                    }
        			
        			request.setAttribute("nombre",nombre);
        			request.setAttribute("nick", nick);
        			
        			mensaje = 1;
        		}
        		else {
        			mensaje = 2;
        		}
            }
        }catch (Exception e) {
        	System.err.println(e);
        	mensaje = 2;
		}
		
		request.setAttribute("mensaje", mensaje);
	}
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Archivos archivo = new Archivos();
		PerfilUsuario perfil = new PerfilUsuario();
		Usuario usuario;
		Persona persona;
		String contexto,password,nick;
		Integer passHash;
		
		contexto = (String) session.getAttribute("contexto");
		archivo.setContexto(contexto);
		
		nick = request.getParameter("numeroAcceso");
		password = request.getParameter("clave");
		passHash = password.hashCode();
		
		usuario = usuarioBs.validateLogIn(nick, passHash);
		if (!usuario.isNew()) {
			if (!jefeAcademiaBs.searchByIdUsuario(usuario.getIdUsuario()).isNew()) {
				perfil.setRol(5);//JefeAcademia
			}
			else if (!administrativoBs.searchByIdUsuario(usuario.getIdUsuario()).isNew()) {
				perfil.setRol(4);//Administrativo
			}
			else if (!administradorBs.searchByIdUsuario(usuario.getIdUsuario()).isNew()) {
				perfil.setRol(3);//Administrador

				Escuela escuela = new Escuela();
				if (archivo.existeArchivo("admin.png"))
					escuela.setEscudo(archivo.obtenerImagenCodificada("", "admin.png"));
				escuela.setId(0);
				escuela.setNombre("Administrador");
				escuela.setSitioWeb("http://www.ipn.mx/Paginas/inicio.aspx");
				session.setAttribute("escuela", escuela);
			}
			else if (!profesorBs.searchByIdUsuario(usuario.getIdUsuario()).isNew()) {
				perfil.setRol(2);//Profesor
			}
			else if (!alumnoBs.searchByIdUsuario(usuario.getIdUsuario()).isNew()) {
				perfil.setRol(1);//Alumno
			}
			persona = personaBs.searchById(usuario.getPersona().getIdPersona());
			perfil.setNombre(persona.getNombres());
			if (archivo.existeArchivo("perfil/" + persona.getIdPersona() + ".png"))
				perfil.setAvatar(archivo.obtenerImagenCodificada("perfil/", persona.getIdPersona() + ".png"));
			session.setAttribute("usuario", usuario);
			session.setAttribute("perfil", perfil);
		}
		else {
			RequestDispatcher rd = null;
			String direccion = "inicioSesion.jsp";
			rd = request.getRequestDispatcher(direccion);
			rd.forward(request, response);
		}
	}
	
	private void cargarSesionEscuela(HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		Archivos archivo = new Archivos();
		Escuela escuelaUtil = new Escuela();
		mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela escuelaDB;
		String contexto;
		Integer idEscuela;
		
		contexto = (String) session.getAttribute("contexto");
		archivo.setContexto(contexto);
		idEscuela = Integer.parseInt(request.getParameter("escuela"));
		
		escuelaDB = escuelaBs.searchById(idEscuela);
		
		if (archivo.existeArchivo("escuelas/" + escuelaDB.getReferencia() + "/" + escuelaDB.getReferencia() + ".png"))
			escuelaUtil.setEscudo(archivo.obtenerImagenCodificada("escuelas/" + escuelaDB.getReferencia(), escuelaDB.getReferencia() + ".png"));
		escuelaUtil.setId(idEscuela);
		escuelaUtil.setNombre(escuelaDB.getNombre());
		escuelaUtil.setReferencia(escuelaDB.getReferencia());
		escuelaUtil.setSitioWeb(escuelaDB.getSitioWeb());
		
		session.setAttribute("escuela", escuelaUtil);
	}
	
	private void cargarEscuelas(HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		Archivos archivo = new Archivos();
		List<mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela> escuelas;
		List<Escuela> escuelasUtil;
		escuelasUtil = new ArrayList<Escuela>();
		String contexto,escudo;
		
		contexto = this.getServletConfig().getServletContext().getRealPath("/");
		
		escuelas = escuelaBs.allSchools();
		
		archivo.setContexto(contexto);
		Escuela escuelaUtil;
		
		for (mx.ipn.escom.repoescolar.accesoDB.mapeo.Escuela escuela : escuelas) {
			escudo = archivo.obtenerImagenCodificada("/escuelas/" + escuela.getReferencia(), escuela.getReferencia() + ".png");
			escuelaUtil = new Escuela();
			escuelaUtil.setEscudo(escudo);
			escuelaUtil.setNombre(escuela.getNombre());
			escuelaUtil.setReferencia(escuela.getReferencia());
			escuelaUtil.setSitioWeb(escuela.getSitioWeb());
			escuelaUtil.setId(escuela.getIdEscuela());
			escuelasUtil.add(escuelaUtil);
		}
		
		request.setAttribute("escuelas", escuelasUtil);
		session.setAttribute("contexto", contexto);
	}

}
