package com.campusfp.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class TestOutputStream {
	public static void main(String[] args) {
		TestOutputStream tos = new TestOutputStream();

		try {
			tos.escribirFichero("miFichero", (new Date()).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void escribirFichero(String nombreFichero, String contenido) throws IOException {
		File fichero;
		FileOutputStream fos;
		byte[] contenidoBytes;

		fichero = new File(nombreFichero);
		fos = new FileOutputStream(fichero);
		if (!fichero.exists()) {
			File.createTempFile(nombreFichero, ".txt");
			//fichero.createNewFile();
		}
		contenidoBytes = contenido.getBytes();
		fos.write(contenidoBytes);
		fos.flush();	// Necesario para que se imprima
		fos.close();
		System.out.println("Fichero " + nombreFichero + " escrito.");
	}
}
