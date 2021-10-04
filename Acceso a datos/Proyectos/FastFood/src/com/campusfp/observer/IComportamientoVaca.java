package com.campusfp.observer;

public interface IComportamientoVaca {
	void agregarObservador(VacaObserver obs);
	void mover();
	void mugir();
}
