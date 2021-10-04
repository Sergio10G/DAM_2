package com.campusfp.observer;

import java.util.ArrayList;
import java.util.List;

public class Vaca implements IComportamientoVaca{
	//	Attributes
	private List<VacaObserver> observadores = new ArrayList<VacaObserver>();
	

	//	Constructors
	
	
	//	Methods
	@Override
	public void agregarObservador(VacaObserver obs) {
		observadores.add(obs);
	}

	@Override
	public void mover() {
		System.out.println("La vaca se mueve.");
		for (VacaObserver obs : observadores) {
			obs.siLaVacaSeMueve();
		}
	}

	@Override
	public void mugir() {
		System.out.println("La vaca muge.");
		for (VacaObserver obs : observadores) {
			obs.siLaVacaMuge();
		}
	}
	
	//	Getters & Setters
	
	
}
