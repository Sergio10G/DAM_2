package com.sergio10g.ejercicios.integrador.clases;

public class Liquidacion{
	//	Attributes
	private Empleado empleado;
	private float monto;
	
	//	Constructors
	public Liquidacion(Empleado empleado, float monto) {
		this.empleado = empleado;
		this.monto = monto;
	}
	
	//	Methods
	@Override
	public String toString() {
		return "Liquidacion [empleado=" + empleado + ", monto=" + monto + "]";
	}
	
	//	Getters & Setters
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
}
