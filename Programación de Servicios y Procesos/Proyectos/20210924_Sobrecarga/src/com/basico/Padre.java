package com.basico;

import java.util.Date;

public abstract class Padre {
	//	Attributes
	private String nombre;
	private int unidades;
	private boolean descuento;
	private Date fecha;

	//	Constructors


	//	Methods
	public void saludar() {
		System.out.println("Hola");
	}

	protected void escribir() {
		System.out.println("Escribiendo...");
	}

	private void leer() {
		System.out.println("Leyendo...");
	}

	public String comunicar() {
		return "Estoy comunicando";
	}

	public int sumar(int x, int y){
		return x + y;
	}

	//	Getters and setters


}
