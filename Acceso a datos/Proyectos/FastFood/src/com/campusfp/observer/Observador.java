package com.campusfp.observer;

public class Observador implements VacaObserver {

	
	//	Attributes
	
	
	//	Constructors
	
	
	//	Methods
	@Override
	public void siLaVacaMuge() {
		System.out.println("He visto a la vaca mugir.");
	}

	@Override
	public void siLaVacaSeMueve() {
		System.out.println("He visto a la vaca moverse.");
	}
	
	//	Getters & Setters
	
	
}
