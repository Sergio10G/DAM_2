package com.campusfp.veterinaria.model;

public class Perro extends Mascota {
	//	Attributes
	
	
	//	Constructors
	public Perro(String nombre) {
		super("Perro", nombre);
	}
	
	//	Methods
	@Override
	public void moverse() {
		System.out.println("Ando...");
	}
	
	//	Getters & Setters
	
	
}
