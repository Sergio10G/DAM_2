package com.campusfp.supermercado.model;

import java.util.Date;

public class ProdCongelado extends ProdFrio {
	//	Attributes
	

	//	Constructors
	public ProdCongelado(Date fecha_caducidad, String num_lote, Date fecha_envasado, float temperatura_mantenimiento,
			String pais_origen) {
		super(fecha_caducidad, num_lote, fecha_envasado, temperatura_mantenimiento, pais_origen);
	}
	
	//	Methods
	@Override
	public String toString() {
		return "ProdCongelado [num_lote=" + this.getNum_lote() + ", fecha_caducidad=" + this.getFecha_caducidad() + 
			"fecha_envasado=" + this.getFecha_envasado() + ", pais_origen=" + this.getPais_origen() 
			+ ", temperatura_mantenimiento=" + this.getTemperatura_mantenimiento() + "]";
	}
	
	//	Getters & Setters
	
	
}
