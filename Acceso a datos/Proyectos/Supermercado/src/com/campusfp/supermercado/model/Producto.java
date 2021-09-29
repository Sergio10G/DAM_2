package com.campusfp.supermercado.model;

import java.util.Date;

public abstract class Producto {
	//	Attributes
	private Date fecha_caducidad;
	private String num_lote;
	
	//	Constructors
	public Producto(Date fecha_caducidad, String num_lote) {
		this.fecha_caducidad = fecha_caducidad;
		this.num_lote = num_lote;
	}
	
	//	Methods
	
	//	Getters & Setters
	public Date getFecha_caducidad() {
		return fecha_caducidad;
	}
	
	public void setFecha_caducidad(Date fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}
	public String getNum_lote() {
		return num_lote;
	}
	public void setNum_lote(String num_lote) {
		this.num_lote = num_lote;
	}

}
