package com.campusfp.veterinaria.model;

public class Loro extends Mascota implements ICharlable {
	//	Attributes
	
	
	//	Constructors
	public Loro(String nombre) {
		super("Loro", nombre);
	}
	
	//	Methods
	@Override
	public void moverse() {
		System.out.println("Vuelo...");
	}

	@Override
	public void hablar() {
		System.out.println("Hola, soy un loro");
		
	}

	@Override
	public void hablar(String mensaje) {
		System.out.println(mensaje);
	}
	
	//	Getters & Setters
	
	
}
