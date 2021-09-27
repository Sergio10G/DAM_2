package com.campusfp.empresa.model;

public class Tecnico extends Empleado {
	//	Attributes
    public String codigoTaller;
	
	
	//	Constructors
	public Tecnico(String nombre, String codigoTaller) {
		super(nombre);
		this.codigoTaller = codigoTaller;
	}
	
	//	Methods
	@Override
    public String toString() {
        return "Tecnico [nombre=" + this.getNombre() +
		", codigoTaller=" + this.codigoTaller + "]";
    }
	
	//	Getters & Setters
    public String getCodigoTaller() {
        return codigoTaller;
    }

    public void setCodigoTaller(String codigoTaller) {
        this.codigoTaller = codigoTaller;
    }

}