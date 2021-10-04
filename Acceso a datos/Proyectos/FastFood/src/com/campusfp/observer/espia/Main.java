package com.campusfp.observer.espia;

public class Main {
	public static void main(String[] args) {
		Sujeto persona = new Espiado();
		Observer espia1 = new Espia();
		Observer espia2 = new Espia();
		Observer espia3 = new Espia();

		persona.agregarEspia(espia1);
		persona.agregarEspia(espia2);
		persona.agregarEspia(espia3);
		persona.entrar();
		persona.salir();
	}
}
