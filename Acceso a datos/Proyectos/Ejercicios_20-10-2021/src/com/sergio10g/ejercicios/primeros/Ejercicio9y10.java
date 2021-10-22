package com.sergio10g.ejercicios.primeros;

import java.util.Arrays;

public class Ejercicio9y10 {
	//	Attributes
	
	
	//	Constructors
	
	
	//	Methods
	public int segundoMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		int seg = max;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > seg && arr[i] < max)
				seg = arr[i];
		}
		return seg;
	}

	public int segundoMaxStream(int[] arr) {
		int[] arr2 = Arrays.stream(arr).distinct().sorted().toArray();
		return arr2[arr2.length - 2];
	}
	
	//	Getters & Setters
	
	
}
