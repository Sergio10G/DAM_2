package com.practica;

public class Actividades {
	//	Attributes
	
	
	//	Constructors
	public static void primerosNums() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i + 1);
			if (i != 9)
				System.out.print(", ");
		}
		System.out.println(".");
	}

	public static void contarPalabras(String frase) {
		int flag = 0;
		int cont = 0;
		
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) != ' ' && flag == 0)
			{
				cont++;
				flag = 1;
			}
			else if (frase.charAt(i) == ' ' && flag == 1)
				flag = 0;
		}
		System.out.println("La frase contiene " + cont + " palabras.");
	}

	public static boolean esBisiesto(int anio) {
		return (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
	}
	
	//	Methods
	
	
	//	Getters & Setters
	
	
}
