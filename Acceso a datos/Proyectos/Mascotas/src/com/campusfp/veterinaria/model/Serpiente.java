package com.campusfp.veterinaria.model;

public class Serpiente extends Mascota {
	//	Attributes
	
	
	//	Constructors
	public Serpiente(String nombre) {
		super("Serpiente", nombre);
	}
	
	//	Methods
	@Override
	public void moverse() {
		System.out.println("Repto...");
	}
	
	//	Getters & Setters
	
	
}
