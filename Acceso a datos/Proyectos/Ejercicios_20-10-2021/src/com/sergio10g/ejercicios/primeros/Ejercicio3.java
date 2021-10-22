package com.sergio10g.ejercicios.primeros;

public class Ejercicio3 {
	//	Attributes
	
	
	//	Constructors
	
	
	//	Methods
	public int factorial(int n) {
		if (n <= 0)
			return 0;
		else if (n > 1)
			return n * factorial(n - 1);
		return 1;
	}
	
	//	Getters & Setters
	
	
}
