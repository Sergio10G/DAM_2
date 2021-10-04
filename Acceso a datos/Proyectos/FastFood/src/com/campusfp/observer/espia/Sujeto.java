package com.campusfp.observer.espia;

public interface Sujeto {
	void agregarEspia(Observer obs);
	void entrar();
	void salir();
	void notificar(int accion);
}
