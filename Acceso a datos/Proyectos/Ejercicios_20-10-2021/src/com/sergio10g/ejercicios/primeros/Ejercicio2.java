package com.sergio10g.ejercicios.primeros;

public class Ejercicio2 {
	//	Attributes
	
	
	//	Constructors
	
	
	//	Methods
	public long sumarMultiplos3(int n) {
		long suma = 0;
		for (int i = 0; i < n; i++) {
			if (i % 3 == 0)
				suma += i;
		}
		return suma;
	}
	
	//	Getters & Setters
	
	
}
