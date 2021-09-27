package com.campusfp.empresa.model;

public class Empleado {
	//	Attributes
    public String nombre;
	
	
	//	Constructors
	public Empleado(String nombre) {
		this.nombre = nombre;
	}
	
	//	Methods
	@Override
    public String toString() {
        return "Empleado [nombre=" + this.nombre + "]";
    }
	
	public float calcularSalario(int horas, float valor_hora) {
		return horas * valor_hora;
	}

	//	Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}