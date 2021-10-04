package com.campusfp.supermercado.model;

import java.util.Date;

public class ProdFresco extends ProdFrio {
	//	Attributes

	
	//	Constructors
	public ProdFresco(Date fecha_caducidad, String num_lote, String nombre, Date fecha_envasado, String pais_origen) {
		super(fecha_caducidad, num_lote, nombre, fecha_envasado, pais_origen);
	}
	
	//	Methods
	@Override
	public String toString() {
		return "nombre=" + this.getNombre() + ", ProdFresco [num_lote=" + this.getNum_lote() + ", fecha_caducidad=" + this.getFecha_caducidad() +
		", fecha_envasado=" + this.getFecha_envasado() +  ", pais_origen=" + this.getPais_origen() + "]";
	}
	
	//	Getters & Setters
	
}
