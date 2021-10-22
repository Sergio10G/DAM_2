package com.sergio10g.carrera;

public class Corredor {
	//	Attributes
	private String nombre;
	private int lugar;
	
	//	Constructors
	public Corredor(String nombre) {
		this.nombre = nombre;
	}
	
	//	Methods
	
	
	//	Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLugar() {
		return lugar;
	}

	public void setLugar(int lugar) {
		this.lugar = lugar;
	}
	
}
