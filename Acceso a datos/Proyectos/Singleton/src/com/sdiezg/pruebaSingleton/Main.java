package com.sdiezg.pruebaSingleton;

public class Main {
	public static void main(String[] args) {
		// Mal
		Singleton s1 = new Singleton();
		// Bien
		Singleton s2 = Singleton.getSelf();
	}
}
