package com.campusfp.veterinaria.model;

public class Mascota extends Animal {
	//	Attributes
	private String nombre;
	
	//	Constructors
	public Mascota(String nombre) {
		this.nombre = nombre;
	}

	public Mascota(String tipo, String nombre) {
		super.setTipo(tipo);
		this.nombre = nombre;
	}
	
	//	Methods
	@Override
	public void moverse() {
		System.out.println("La mascota se mueve");
	}

	//	Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
}
