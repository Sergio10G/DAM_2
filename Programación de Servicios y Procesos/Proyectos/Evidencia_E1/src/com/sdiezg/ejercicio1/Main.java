package com.sdiezg.ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		File out = new File("salida_ej1.txt");
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "program.bat");
		pb.redirectOutput(out);

		System.out.println("Primera ejecución...");
		try {
			Process p = pb.start();
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Primera ejecución finalizada. Datos guardados en el archivo " + out.getAbsolutePath());
		System.out.println();
		System.out.println("Segunda ejecución...");
		
		ProcessBuilder pb2 = new ProcessBuilder("notepad", "salida_ej1.txt");
		try {
			pb2.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Conteo de números
		int superados = 0;
		ProcessBuilder pb3 = new ProcessBuilder("cmd", "/c", "program.bat");
		try {
			Process p2 = pb3.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()));
			String line = br.readLine();
			while (!line.equals(".")) {
				int num = Integer.parseInt(line);
				if (num > 30000)
					superados++;
				line = br.readLine();
			}
			p2.waitFor();
			if (superados == 0) {
				System.out.println("No se ha superado 30000 en ningún momento.");
			}
			else {
				System.out.println(superados + " número/s ha/n superado los 30000.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
