package com.campusfp.supermercado.model;

import java.util.Date;

public class ProdCongelado extends ProdFrio {
	//	Attributes
	private float temperatura_mantenimiento;
	

	//	Constructors
	public ProdCongelado(Date fecha_caducidad, String num_lote, Date fecha_envasado, double d,
			String pais_origen) {
		super(fecha_caducidad, num_lote, fecha_envasado, pais_origen);
		this.temperatura_mantenimiento = temperatura_mantenimiento;
	}
	
	//	Methods
	@Override
	public String toString() {
		return "ProdCongelado [nombre=" + this.getNombre() + ", num_lote=" + this.getNum_lote() + ", fecha_caducidad=" + this.getFecha_caducidad() + 
			"fecha_envasado=" + this.getFecha_envasado() + ", pais_origen=" + this.getPais_origen() 
			+ ", temperatura_mantenimiento=" + this.getTemperatura_mantenimiento() + "]";
	}
	
	//	Getters & Setters
	public float getTemperatura_mantenimiento() {
		return temperatura_mantenimiento;
	}

	public void setTemperatura_mantenimiento(float temperatura_mantenimiento) {
		this.temperatura_mantenimiento = temperatura_mantenimiento;
	}
	
}
