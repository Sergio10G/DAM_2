package com.campusfp.supermercado.model;

import java.util.Date;

public class ProdRefrigerado extends ProdFrio {
	//	Attributes
	private String cod_org_supervision;
	private float temperatura_mantenimiento;
	
	//	Constructors
	public ProdRefrigerado(Date fecha_caducidad, String num_lote, String nombre, Date fecha_envasado,
			String pais_origen, String cod_org_supervision, float temperatura_mantenimiento) {
		super(fecha_caducidad, num_lote, nombre, fecha_envasado, pais_origen);
		this.cod_org_supervision = cod_org_supervision;
		this.temperatura_mantenimiento = temperatura_mantenimiento;
	}
	
	//	Methods
	@Override
	public String toString() {
		return "ProdRefrigerado [nombre=" + this.getNombre() + ", num_lote=" + this.getNum_lote() + ", fecha_caducidad=" + this.getFecha_caducidad()
			+ ", cod_org_supervision=" + cod_org_supervision + ", fecha_envasado=" + this.getFecha_envasado() +
			", pais_origen=" + this.getPais_origen() + ", temperatura_mantenimiento=" +
			this.getTemperatura_mantenimiento() + "]";
	}
	
	//	Getters & Setters
	public String getCod_org_supervision() {
		return cod_org_supervision;
	}

	public void setCod_org_supervision(String cod_org_supervision) {
		this.cod_org_supervision = cod_org_supervision;
	}
	
	public float getTemperatura_mantenimiento() {
		return temperatura_mantenimiento;
	}

	public void setTemperatura_mantenimiento(float temperatura_mantenimiento) {
		this.temperatura_mantenimiento = temperatura_mantenimiento;
	}
}
