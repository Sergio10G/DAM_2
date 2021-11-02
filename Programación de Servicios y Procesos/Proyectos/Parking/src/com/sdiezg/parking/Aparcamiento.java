package com.sdiezg.parking;

public class Aparcamiento {
	//	Attributes
	private int plazasLibres;
	private int cochesAtendidos;
	
	//	Constructors
	public Aparcamiento() {
		this.plazasLibres = 20;
		this.cochesAtendidos = 0;
	}
	
	//	Methods
	public void ocuparPlaza() {
		this.plazasLibres--;
		this.cochesAtendidos++;
	}

	public void liberarPlaza() {
		this.plazasLibres++;
	}
	
	//	Getters & Setters
	public int getPlazasLibres() {
		return this.plazasLibres;
	}

	public int getCochesAtendidos() {
		return this.cochesAtendidos;
	}
	
}
