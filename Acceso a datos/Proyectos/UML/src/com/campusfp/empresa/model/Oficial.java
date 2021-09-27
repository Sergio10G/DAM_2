package com.campusfp.empresa.model;

public class Oficial extends Tecnico {
	//	Attributes
    public String categoria;
	
	
	//	Constructors
	public Oficial(String nombre, String codigoTaller, String categoria) {
		super(nombre, codigoTaller);
		this.categoria = categoria;
	}
	
	//	Methods
	@Override
    public String toString() {
        return "Oficial [nombre=" + this.getNombre() + ", codigoTaller=" +
		this.getCodigoTaller() + ", categoria=" + this.categoria + "]";
    }
	
	//	Getters & Setters
	public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}