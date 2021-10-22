package com.sergio10g.ejercicios.primeros;

import java.util.Arrays;

public class Ejercicio6y7 {
	//	Attributes
	
	
	//	Constructors
	
	
	//	Methods
	public float calcularPromedio(int[] arr) {
		int sum = 0;
		for (int n : arr) {
			sum += n;
		}
		return sum / arr.length;
	}

	public float calcularPromedioLambda(int[] arr) {
		return (float) Arrays.stream(arr).average().getAsDouble();
	}
	
	//	Getters & Setters
	
	
}
