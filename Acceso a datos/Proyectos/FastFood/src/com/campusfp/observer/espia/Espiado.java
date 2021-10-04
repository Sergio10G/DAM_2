package com.campusfp.observer.espia;

import java.util.ArrayList;
import java.util.List;

public class Espiado implements Sujeto {
	//	Attributes
	private List<Observer> espias = new ArrayList<Observer>();
	
	//	Constructors
	
	
	//	Methods
	@Override
	public void agregarEspia(Observer obs) {
		espias.add(obs);
	}

	@Override
	public void entrar() {
		System.out.println("Entro a mi casa.");
		notificar(1);
	}

	@Override
	public void salir() {
		System.out.println("Salgo de mi casa.");
		notificar(2);
	}

	@Override
	public void notificar(int accion) {
		for (Observer esp : espias) {
			if (accion == 1)
				esp.espiadoEntra();
			else if (accion == 2)
				esp.espiadoSale();
		}
	}
	
	//	Getters & Setters
	
	
}
