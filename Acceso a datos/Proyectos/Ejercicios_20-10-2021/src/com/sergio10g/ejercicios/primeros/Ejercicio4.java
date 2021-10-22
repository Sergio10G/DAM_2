package com.sergio10g.ejercicios.primeros;

public class Ejercicio4 {
	//	Attributes
	
	
	//	Constructors
	
	
	//	Methods
	public String revString(String str) {
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			res += str.charAt(str.length() - i - 1);
		}
		return res;
	}

	public String nombreAlAzar(String[] arr) {
		return arr[(int) (Math.random() * arr.length)];
	}

	public int numAleatorioRango(int start, int end) {
		return (int) (Math.random() * (end - start + 1) + start);
	}
	
	//	Getters & Setters

	
}
