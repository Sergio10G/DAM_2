package com.avanzado.model;

public class Cliente {
	//	Attributes
	private int id;
	private String nombre;
	private int unidades;
	
	//	Constructors
	
	
	//	Methods
	
	
	//	Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
}
