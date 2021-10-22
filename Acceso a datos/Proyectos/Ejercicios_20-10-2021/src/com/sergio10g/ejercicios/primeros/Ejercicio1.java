package com.sergio10g.ejercicios.primeros;

public class Ejercicio1 {
	public static void main(String[] args) {
		int x = 5;
		int y = -3;

		Ejercicio1 test = new Ejercicio1();
		System.out.println(x + " + " + y + " = " + test.sumar(x, y));
	}

	public int sumar(int x, int y) {
		return x + y;
	}
}
