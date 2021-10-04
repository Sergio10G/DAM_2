package com.campusfp.observer;

public class Main {
	public static void main(String[] args) {
		Vaca vaca = new Vaca();
		VacaObserver vo1 = new Observador();
		VacaObserver vo2 = new Observador();
		VacaObserver vo3 = new Observador();
		
		vaca.agregarObservador(vo1);
		vaca.agregarObservador(vo2);
		vaca.agregarObservador(vo3);
		vaca.mover();
		vaca.mugir();
	}
}
