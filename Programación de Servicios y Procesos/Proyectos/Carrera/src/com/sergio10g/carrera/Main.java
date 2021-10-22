package com.sergio10g.carrera;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Posicion pos = new Posicion();
		Corredor c1 = new Corredor("Pistorius");
		Corredor c2 = new Corredor("Antonio");
		Corredor c3 = new Corredor("John");
		Corredor c4 = new Corredor("Miguel");
		Corredor c5 = new Corredor("Juan");
		List<Correr> corredores = new ArrayList<Correr>();

		corredores.add(new Correr(c1, 100, pos));
		corredores.add(new Correr(c2, 100, pos));
		corredores.add(new Correr(c3, 100, pos));
		corredores.add(new Correr(c4, 100, pos));
		corredores.add(new Correr(c5, 100, pos));

		Carrera car = new Carrera(corredores);

		car.run();
		try {
			car.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (Correr correr : corredores) {
			System.out.println(correr.getCor().getNombre() + ": " + correr.getCor().getLugar());
		}
	}
}
