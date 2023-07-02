package com.exam.demo.utils;

import java.util.Base64;

public class Encripta {

	public static String getEncriptar(String encrip) {
		   String cadenaCodificada = Base64.getEncoder().encodeToString(encrip.getBytes());
	return cadenaCodificada;
	}
	
	public static String getDesencriptar(String descrip) {
		
		byte[] bytesDecodificados = Base64.getDecoder().decode(descrip);
        String cadenaDecodificada = new String(bytesDecodificados);
        
    return cadenaDecodificada;
	}
	
}
