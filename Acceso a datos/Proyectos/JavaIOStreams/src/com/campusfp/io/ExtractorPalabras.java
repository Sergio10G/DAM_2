package com.campusfp.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ExtractorPalabras {
	public static void main(String[] args) {
		ExtractorPalabras ep = new ExtractorPalabras();
		ArrayList<String> words = new ArrayList<String>();

		try {
			words = ep.extraerPalabras("poema.txt");
			ep.escribirFichero("palabrasPoema.txt", words);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> extraerPalabras(String nombreFichero) throws FileNotFoundException {
		InputStream is = new FileInputStream(nombreFichero);
		String[] lineWords;
		ArrayList<String> wordList = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = br.readLine()) != null)
			{
				if (line.equals(""))
					continue;
				lineWords = line.split(" ");
				for (String s : lineWords) {
					if (s.toLowerCase().startsWith("a"))
						wordList.add(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wordList;
	}

	public void escribirFichero(String nombreFichero, ArrayList<String> contenido) throws IOException {
		File fichero;
		FileOutputStream fos;
		byte[] contenidoBytes;
		int c;

		fichero = new File(nombreFichero);
		fos = new FileOutputStream(fichero);
		if (!fichero.exists()) {
			File.createTempFile(nombreFichero, ".txt");
		}
		c = 0;
		for (String s : contenido) {
			if (c != contenido.size() - 1){
				if (!s.endsWith(","))
					s += ',';
				s += '\n';
			}
			contenidoBytes = s.getBytes();
			fos.write(contenidoBytes);
			c++;
		}
		fos.flush();	// Necesario para que se imprima
		fos.close();
		System.out.println("Fichero " + nombreFichero + " escrito.");
	}
}
