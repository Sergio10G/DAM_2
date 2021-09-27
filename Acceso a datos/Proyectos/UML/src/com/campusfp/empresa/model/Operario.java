package com.campusfp.empresa.model;

public class Operario extends Tecnico {
	//	Attributes
    public String maquina;
	
	
	//	Constructors
	public Operario(String nombre, String codigoTaller, String maquina) {
		super(nombre, codigoTaller);
		this.maquina = maquina;
	}
	
	//	Methods
	@Override
    public String toString() {
        return "Operario [nombre=" + this.getNombre() + ", codigoTaller=" +
		this.getCodigoTaller() + ", maquina=" + this.maquina +"]";
    }
	
	//	Getters & Setters
	public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }
	
}