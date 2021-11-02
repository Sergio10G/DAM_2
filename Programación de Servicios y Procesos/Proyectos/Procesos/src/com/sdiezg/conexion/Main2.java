package com.sdiezg.conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			List<String> results = new ArrayList<>();
			System.out.println("Introduce una dirección de internet:");
			String url = sc.nextLine();
			System.out.println("Quieres introducir otra ip? s/n");
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ping " + url);
			try {
				Process pro = pb.start();
				BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
				String line;
				while ((line = br.readLine()) != null) {
					results.add(line);
				}

				if (results.get(1).equals("vuelva a intentarlo.") || results.get(9).trim().equals("(100% perdidos),"))
					System.out.println("No se ha podido conectar a la url especificada.");
				else {
					ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", "ping " + url);
					pb2.redirectOutput(new File(url + ".txt"));
					pb2.start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			String dec = sc.nextLine();
			if (dec.toLowerCase().equals("n"))
				break;
		}
		sc.close();
	}
}
