package com.campusfp.veterinaria.model;

public abstract class Animal {
	//	Attributes
	private String tipo;
	
	//	Methods
	public abstract void moverse();

	public void comer() {
		System.out.println("Me alimento...");
	}

	public void dormir() {
		System.out.println("Descanso...");
	}
	
	//	Getters & Setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
