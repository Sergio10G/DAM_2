package com.campusfp.supermercado.model;

import java.util.Date;

public class ProdFresco extends Producto {
	//	Attributes
	private Date fecha_envasado;
	private String pais_origen;
	
	//	Constructors
	public ProdFresco(Date fecha_caducidad, String num_lote, Date fecha_envasado, String pais_origen) {
		super(fecha_caducidad, num_lote);
		this.fecha_envasado = fecha_envasado;
		this.pais_origen = pais_origen;
	}
	
	//	Methods
	@Override
	public String toString() {
		return "ProdFresco [num_lote=" + this.getNum_lote() + ", fecha_caducidad=" + this.getFecha_caducidad() +
		", fecha_envasado=" + this.fecha_envasado +  ", pais_origen=" + this.pais_origen + "]";
	}
	
	
	//	Getters & Setters
	public Date getFecha_envasado() {
		return fecha_envasado;
	}

	public void setFecha_envasado(Date fecha_envasado) {
		this.fecha_envasado = fecha_envasado;
	}

	public String getPais_origen() {
		return pais_origen;
	}

	public void setPais_origen(String pais_origen) {
		this.pais_origen = pais_origen;
	}
	
}
