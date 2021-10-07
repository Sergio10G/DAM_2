package com.campusfp.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcesarPoema {
	public static void main(String[] args) {
		try {
			leerLineas("poema.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void leerLineas(String fichero) throws IOException {
		InputStream is = new FileInputStream(fichero);
		int numWords = 0;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = br.readLine()) != null)
			{
				if (!line.equals(""))
					numWords += line.split(" ").length;
				System.out.println(line);
			}
			System.out.println("\nEl poema tiene " + numWords + " palabras");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
