package com.sergio10g.ejercicio.comparable;

public class Persona implements Comparable {
	//	Attributes
	private String nombre;
	private String apellido;
	private int edad;
	
	//	Constructors
	public Persona(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	//	Methods
	@Override
	public String toString() {
		return "Persona [apellido=" + apellido + ", edad=" + edad + ", nombre=" + nombre + "]";
	}

	@Override
	public int compareTo(Object o) {
		Persona otra = (Persona) o;
		return this.getNombre().compareTo(otra.getNombre());
	}

	//	Getters & Setters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
