package com.campusfp.veterinaria.model;

public class Pez extends Mascota {
	//	Attributes
	
	
	//	Constructors
	public Pez(String nombre) {
		super("Pez", nombre);
	}
	
	//	Methods
	@Override
	public void moverse() {
		System.out.println("Nado...");
	}
	
	//	Getters & Setters
	
	
}
