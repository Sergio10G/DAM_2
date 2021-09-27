package com.campusfp.veterinaria.model;

public abstract class SerHumano implements ICharlable {
	//	Attributes
	private String nombre;
	
	//	Constructors
	public SerHumano(String nombre) {
		this.nombre = nombre;
	}
	
	//	Methods
	@Override
	public void hablar() {
		System.out.println("Hola!");
	}

	@Override
	public void hablar(String mensaje) {
		System.out.println(mensaje);
	}
	
	//	Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
