package com.campusfp.observer.espia;

public class Espia implements Observer {
	//	Attributes
	
	
	//	Constructors
	
	
	//	Methods
	@Override
	public void espiadoEntra() {
		System.out.println("El sujeto ha entrado.");
	}

	@Override
	public void espiadoSale() {
		System.out.println("El sujeto ha salido.");
	}
	
	//	Getters & Setters
	
	
}
