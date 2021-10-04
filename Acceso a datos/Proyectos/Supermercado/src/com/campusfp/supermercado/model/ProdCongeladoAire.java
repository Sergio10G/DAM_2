package com.campusfp.supermercado.model;

import java.util.Date;

public class ProdCongeladoAire extends ProdCongelado {
	//	Attributes
	private float pcO2;
	private float pcCO2;
	private float pcH2O;
	
	//	Constructors
	public ProdCongeladoAire(Date fecha_caducidad, String num_lote, String nombre, Date fecha_envasado,
			String pais_origen, float temperatura_mantenimiento, float pcO2, float pcCO2, float pcH2O) {
		super(fecha_caducidad, num_lote, nombre, fecha_envasado, pais_origen, temperatura_mantenimiento);
		this.pcO2 = pcO2;
		this.pcCO2 = pcCO2;
		this.pcH2O = pcH2O;
	}

	//	Methods
	@Override
	public String toString() {
		return "ProdCongeladoAire [nombre=" + this.getNombre() + ", num_lote=" + this.getNum_lote() + ", fecha_caducidad=" + this.getFecha_caducidad()
		+ "fecha_envasado=" + this.getFecha_envasado() + ", pais_origen=" + this.getPais_origen() 
		+ ", temperatura_mantenimiento=" + this.getTemperatura_mantenimiento() + ", pcCO2=" + pcCO2
		+ ", pcH2O=" + pcH2O + ", pcO2=" + pcO2 + "]";
	}
	
	//	Getters & Setters
	public float getPcO2() {
		return pcO2;
	}
	
	public void setPcO2(float pcO2) {
		this.pcO2 = pcO2;
	}

	public float getPcCO2() {
		return pcCO2;
	}

	public void setPcCO2(float pcCO2) {
		this.pcCO2 = pcCO2;
	}

	public float getPcH2O() {
		return pcH2O;
	}

	public void setPcH2O(float pcH2O) {
		this.pcH2O = pcH2O;
	}
	
	
}
