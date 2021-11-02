package com.sdiezg.conexion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> results = new ArrayList<>();
		System.out.println("Introduce una dirección de internet:");
		String url = sc.nextLine();
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
			else
				System.out.println("Conexión realizada correctamente");
			/*
			int i = 0;
			for (String string : results) 
				System.out.println(i++ + ": " + string);
			*/
		} catch (Exception e) {
			//TODO: handle exception
		}
	}
}
