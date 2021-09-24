package com.basico;

public class Ejecutar {
	public static void main(String[] args) {
		Hijo hijo = new Hijo();
		//Padre padre = new Padre();
		String mensaje = hijo.comunicar();
		
		System.out.println(mensaje);
		hijo.escribir();
	}
}
