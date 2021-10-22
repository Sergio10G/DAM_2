package com.sergio10g.ejercicios.integrador.clases;

import java.util.List;

public class Empleado {
	//	Attributes
	private String nombre;
	private String email;
	private int categoria;
	private List<Jornales> lsJornales;
	
	//	Constructors
	public Empleado(String nombre, String email, int categoria, List<Jornales> lsJornales) {
		this.nombre = nombre;
		this.email = email;
		this.categoria = categoria;
		this.lsJornales = lsJornales;
	}
	
	//	Methods
	@Override
	public String toString() {
		return "Empleado [categoria=" + categoria + ", email=" + email + ", lsJornales=" + lsJornales + ", nombre="
				+ nombre + "]";
	}
	
	//	Getters & Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public List<Jornales> getLsJornales() {
		return lsJornales;
	}
	public void setLsJornales(List<Jornales> lsJornales) {
		this.lsJornales = lsJornales;
	}
	
}
