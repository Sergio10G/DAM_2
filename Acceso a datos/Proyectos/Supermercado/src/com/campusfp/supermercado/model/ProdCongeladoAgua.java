package com.campusfp.supermercado.model;

import java.util.Date;

public class ProdCongeladoAgua extends ProdCongelado {
	//	Attributes
	private float salinidad;
	
	//	Constructors
	public ProdCongeladoAgua(Date fecha_caducidad, String num_lote, Date fecha_envasado,
			float temperatura_mantenimiento, String pais_origen) {
		super(fecha_caducidad, num_lote, fecha_envasado, temperatura_mantenimiento, pais_origen);
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
