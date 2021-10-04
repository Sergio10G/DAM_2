package com.campusfp.ProyectoGato.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.campusfp.ProyectoGato.model.Gato;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Gato> gatos = new ArrayList<Gato>();
		String nombre, raza, color, eleccion;
		boolean acabado = false;
		boolean elegido = false;

		while (!acabado) {
			nombre = "";
			raza = "";
			color = "";
			eleccion = "";
			elegido = false;

			System.out.println("Vas a introducir un gato.");
			System.out.println("¿Nombre del gato?");
			nombre = sc.nextLine();
			System.out.println("¿Color del gato?");
			color = sc.nextLine();
			System.out.println("¿Raza del gato?");
			raza = sc.nextLine();
			System.out.println("¿Estás seguro de introducir el siguiente gato? " + nombre + ", " + raza + ", " + color 
			+ ". [s/n]");
			while (!elegido) {
				eleccion = sc.nextLine();
				if (eleccion.equals("s") || eleccion.equals("n") || eleccion.equals(""))
					elegido = true;
				else
					System.out.println("La elección introducida es incorrecta. Prueba a no poner nada o poner s para " 
					+ "aceptar, o poner n para denegar.");
			}
			if (eleccion.equals("s") || eleccion.equals(""))
			{
				gatos.add(new Gato(nombre, color, raza));
				System.out.println("Gato " + nombre + " introducido con éxito!");
				System.out.println("¿Quieres introducir otro gato? [s/n]");
				eleccion = "";
				elegido = false;
				while (!elegido) {
					eleccion = sc.nextLine();
					if (eleccion.equals("s") || eleccion.equals("n") ||eleccion.equals(""))
						elegido = true;
					else
						System.out.println("La elección introducida es incorrecta. Prueba a no poner nada o poner s para " 
						+ "aceptar, o poner n para denegar.");
				}
				if (eleccion.equals("n"))
					acabado = true;
			}
		}
		System.out.println("---------------------------------------------------------------------");
		Collections.sort(gatos);
		pintarGatos(gatos);
		sc.close();
	}

	public static void pintarGatos(ArrayList<Gato> gatos) {
		System.out.println("Gatos introducidos");
		for (Gato g : gatos)
			System.out.println("Gato " + g.getNombre() + ". Es " + g.getColor() + ", y de raza " + g.getRaza() + ".");
	}
}
