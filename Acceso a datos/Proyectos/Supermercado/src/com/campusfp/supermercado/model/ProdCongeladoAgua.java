package com.campusfp.supermercado.model;

import java.util.Date;

public class ProdCongeladoAgua extends ProdCongelado {
	//	Attributes
	private float salinidad;
	
	//	Constructors
	public ProdCongeladoAgua(Date fecha_caducidad, String num_lote, String nombre, Date fecha_envasado,
			String pais_origen, float temperatura_mantenimiento, float salinidad) {
		super(fecha_caducidad, num_lote, nombre, fecha_envasado, pais_origen, temperatura_mantenimiento);
		this.salinidad = salinidad;
	}
	
	//	Methods
	public String toString() {
		return "ProdCongeladoAgua [nombre=" + this.getNombre() + ", num_lote=" + this.getNum_lote() + ", fecha_caducidad=" + this.getFecha_caducidad() + 
			"fecha_envasado=" + this.getFecha_envasado() + ", pais_origen=" + this.getPais_origen() 
			+ ", temperatura_mantenimiento=" + this.getTemperatura_mantenimiento() + ", salinidad=" + salinidad + "]";
	}
	
	//	Getters & Setters
	public float getSalinidad() {
		return salinidad;
	}

	public void setSalinidad(float salinidad) {
		this.salinidad = salinidad;
	}
	
}
