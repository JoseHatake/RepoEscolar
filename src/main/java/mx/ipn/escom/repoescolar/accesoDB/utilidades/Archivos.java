package mx.ipn.escom.repoescolar.accesoDB.utilidades;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.fileupload.FileItem;

public class Archivos {
	private String contexto;
	private final static String ARCHIVERO = "/img";
	
	public Archivos() {
		super();
	}

	public Archivos(String contexto) {
		super();
		this.contexto = contexto;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	public Boolean guardarImagenEnArchivo(FileItem item,String archivo,String nombre) {
		File file;
		Boolean flag;
		
		flag = true;
        try {
        		if (!this.existeArchivo(archivo))
        			this.crearArchivo(archivo);
        		file = new File(contexto + ARCHIVERO + "/" + archivo, nombre);
			item.write(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
        return flag;
	}
	
	public Boolean existeArchivo(String archivo) {
		File file;
		file = new File(contexto + ARCHIVERO + "/" + archivo);
		return file.exists();
	}
	
	public void borrarArchivo(String directorio) {
		File file;
		file = new File(contexto + ARCHIVERO + "/" + directorio);
		file.delete();
	}
	
	public Boolean exiteDocumento(String archivo,String documento) {
		File file;
		file = new File(contexto + ARCHIVERO + "/" + archivo + "/" + documento);
		return file.exists();
	}
	
	public void crearArchivo(String directorio) {
		File file;
		file = new File(contexto + ARCHIVERO + "/" + directorio);
		file.mkdirs();
	}
	
	public Boolean renombrarDirectorio(String directorioAntes, String directorioNuevo){
		File fileAntes,fileDespues;
		fileAntes = new File(contexto + ARCHIVERO + "/" + directorioAntes);
		fileDespues = new File(contexto + ARCHIVERO + "/" + directorioNuevo);
		return fileAntes.renameTo(fileDespues);
	}
	
	public Boolean renombrarDocumento(String archivo,String documentoViejo, String documentoNuevo) {
		File fileAntes,fileDespues;
		fileAntes = new File(contexto + ARCHIVERO + "/" + archivo + "/" + documentoViejo);
		fileDespues = new File(contexto + ARCHIVERO + "/" + archivo,documentoNuevo);
		return fileAntes.renameTo(fileDespues);
	}
	
	public String obtenerImagenCodificada(String archivo,String imagen) throws IOException {
		File file;
		Path filePath;
		file = new File(contexto + ARCHIVERO + "/" + archivo + "/" + imagen);
		filePath = Paths.get(contexto + ARCHIVERO + "/" + archivo + "/" + file.getName());
        byte[] bytes = Base64.getEncoder().encode(Files.readAllBytes(filePath));
        return new String(bytes, "UTF-8");
	}
}
