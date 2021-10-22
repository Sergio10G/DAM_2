package com.sdiezg.ofertademanda;

public class Main {
	public static void main(String[] args) {
		Almacen almacen = new Almacen();
		Productor productor = new Productor(almacen);
		Consumidor consumidor = new Consumidor(almacen);

		productor.start();
		consumidor.start();

		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			productor.setActivo(false);
			productor.join();
			consumidor.setActivo(false);
			consumidor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		System.out.println("Ganancias totales: " + almacen.getGanancias() + "€");
	}
}
