package com.sergio10g.ejercicio.vehiculos;

public class Vehiculo implements Comparable<Vehiculo>{
	//	Attributes
	private String matricula;
    private Modelo modelo;
    private int kilometros;
	
	//	Constructors
	public Vehiculo(String matricula, Modelo modelo, int kilometros) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.kilometros = kilometros;
    }
	
	//	Methods
	@Override
    public String toString() {
        return "[ " + matricula + ", " + modelo.toString() + ", " + kilometros + " ]";
    }
	
	@Override
	public int compareTo(Vehiculo v) {
		return this.getKilometros() >= v.getKilometros() ? 1 : -1;
	}

	//	Getters & Setters
	public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

}
