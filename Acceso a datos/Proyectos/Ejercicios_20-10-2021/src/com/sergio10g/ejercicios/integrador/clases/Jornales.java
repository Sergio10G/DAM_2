package com.sergio10g.ejercicios.integrador.clases;

public class Jornales {
	//	Attributes
	private float horasTrab;
	private float diasTrab;
	
	//	Constructors
	public Jornales(float horasTrab, float diasTrab) {
		this.horasTrab = horasTrab;
		this.diasTrab = diasTrab;
	}
	
	//	Methods
	@Override
	public String toString() {
		return "Jornales [diasTrab=" + diasTrab + ", horasTrab=" + horasTrab + "]";
	}
	
	//	Getters & Setters
	public float getHorasTrab() {
		return horasTrab;
	}
	public void setHorasTrab(float horasTrab) {
		this.horasTrab = horasTrab;
	}
	public float getDiasTrab() {
		return diasTrab;
	}
	public void setDiasTrab(float diasTrab) {
		this.diasTrab = diasTrab;
	}
	
}
