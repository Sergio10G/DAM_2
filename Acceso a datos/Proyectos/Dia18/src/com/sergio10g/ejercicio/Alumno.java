package com.sergio10g.ejercicio;

public class Alumno {
	//	Attributes
	private String nombre;
	private int edad;
	
	//	Constructors
	public Alumno(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	//	Methods
	@Override
	public String toString() {
		return "Alumno [edad=" + edad + ", nombre=" + nombre + "]";
	}

	//	Getters & Setters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
