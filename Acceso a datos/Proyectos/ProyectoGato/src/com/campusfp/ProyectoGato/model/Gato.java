package com.campusfp.ProyectoGato.model;

public class Gato implements Comparable<Gato> {
	//	Attributes
	private String nombre;
	private String color;
	private String raza;
	
	//	Constructors
	public Gato(String nombre, String color, String raza) {
		this.nombre = nombre;
		this.color = color;
		this.raza = raza;
	}
	
	//	Methods
	@Override
	public int compareTo(Gato o) {
		return this.color.compareTo(o.getColor());
	}
	
	//	Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
}
