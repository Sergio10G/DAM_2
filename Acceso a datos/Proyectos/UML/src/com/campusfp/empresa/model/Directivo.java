package com.campusfp.empresa.model;

public class Directivo extends Empleado {
	//	Attributes
    public String area;
	
	
	//	Constructors
	public Directivo(String nombre, String area) {
		super(nombre);
		this.area = area;
	}
	
	//	Methods
	@Override
    public String toString() {
        return "Directivo [nombre=" + this.getNombre() + 
		", area=" + this.area + "]";
    } 
	
	//	Getters & Setters
	public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
	
}
