package com.campusfp.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestInputStream {
	public static void main(String[] args) {
		TestInputStream t = new TestInputStream();
		try {
			leerLineas("numeros.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static byte[] leerDatos(String fichero) throws IOException {
		InputStream is = new FileInputStream(fichero);

		if (is.available() > 0) {
			byte[] data = new byte[is.available()];
			is.read(data);
			is.close();
			return data;
		}
		is.close();
		return new byte[]{};
	}

	public static void leerDatos2(String fichero) throws IOException {
		InputStream is = new FileInputStream(fichero);
		int i;
		
		while ((i = is.read()) != -1)
			System.out.print((char) i);
		is.close();
	}

	public static void leerLineas(String fichero) throws IOException {
		InputStream is = new FileInputStream(fichero);
		int numLines = 0;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = br.readLine()) != null)
			{
				numLines++;
				System.out.println(numLines + ": " + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
