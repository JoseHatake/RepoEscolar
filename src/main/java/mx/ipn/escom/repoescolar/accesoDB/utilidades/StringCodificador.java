package mx.ipn.escom.repoescolar.accesoDB.utilidades;

import java.io.UnsupportedEncodingException;

public class StringCodificador {
	private final static String ESTANDAR = "ISO_8859_1";
	private final static String ENCODER = "UTF-8";
	
	public StringCodificador() {
		super();
	}
	
	public String codificar(String string) throws UnsupportedEncodingException {
		byte[] ptext = string.getBytes(ESTANDAR); 
        String value = new String(ptext,ENCODER);
        return value;
	}
}
