package com.campusfp.supermercado.model;

import java.util.Date;

public class ProdCongeladoNitro extends ProdCongelado {
	//	Attributes
	private String metodo_congelacion;
	private float segundos_exp;
	
	//	Constructors
	public ProdCongeladoNitro(Date fecha_caducidad, String num_lote, String nombre, Date fecha_envasado,
			String pais_origen, float temperatura_mantenimiento, String metodo_congelacion, float segundos_exp) {
		super(fecha_caducidad, num_lote, nombre, fecha_envasado, pais_origen, temperatura_mantenimiento);
		this.metodo_congelacion = metodo_congelacion;
		this.segundos_exp = segundos_exp;
	}

	//	Methods
	public String toString() {
		return "ProdCongeladoNitro [nombre=" + this.getNombre() + ", num_lote=" + this.getNum_lote() + ", fecha_caducidad=" + this.getFecha_caducidad()
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
