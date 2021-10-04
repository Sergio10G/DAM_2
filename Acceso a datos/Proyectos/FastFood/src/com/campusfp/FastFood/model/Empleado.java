package com.campusfp.FastFood.model;

public class Empleado {
	//	Attributes
	private String nombre;
	private Restaurante trabajo;
	
	//	Constructors
	public Empleado(String nombre, Restaurante trabajo) {
		this.nombre = nombre;
		this.trabajo = trabajo;
	}
	
	//	Methods
	
	
	//	Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Restaurante getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Restaurante trabajo) {
		this.trabajo = trabajo;
	}
	
}
