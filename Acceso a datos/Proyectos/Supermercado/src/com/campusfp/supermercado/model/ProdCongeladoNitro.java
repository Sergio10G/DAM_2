package com.campusfp.supermercado.model;

import java.util.Date;

public class ProdCongeladoNitro extends ProdCongelado {
	//	Attributes
	private String metodo_congelacion;
	private float segundos_exp;
	
	//	Constructors
	public ProdCongeladoNitro(Date fecha_caducidad, String num_lote, Date fecha_envasado,
			float temperatura_mantenimiento, String pais_origen, String metodo_congelacion, float segundos_exp) {
		super(fecha_caducidad, num_lote, fecha_envasado, temperatura_mantenimiento, pais_origen);
		this.metodo_congelacion = metodo_congelacion;
		this.segundos_exp = segundos_exp;
	}
	
	//	Methods
	public String toString() {
		return "ProdCongeladoNitro [num_lote=" + this.getNum_lote() + ", fecha_caducidad=" + this.getFecha_caducidad()
			+ "fecha_envasado=" + this.getFecha_envasado() + ", pais_origen=" + this.getPais_origen() 
			+ ", temperatura_mantenimiento=" + this.getTemperatura_mantenimiento() + "metodo_congelacion="
			+ metodo_congelacion + ", segundos_exp=" + segundos_exp + "]";
	}
	
	//	Getters & Setters
	public String getMetodo_congelacion() {
		return metodo_congelacion;
	}

	public void setMetodo_congelacion(String metodo_congelacion) {
		this.metodo_congelacion = metodo_congelacion;
	}

	public float getSegundos_exp() {
		return segundos_exp;
	}

	public void setSegundos_exp(float segundos_exp) {
		this.segundos_exp = segundos_exp;
	}
	
}
