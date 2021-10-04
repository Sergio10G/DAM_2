package com.practica;

public class ActividadesHiloSimple implements Runnable{
	public static void main(String[] args) {
		ActividadesHiloSimple hs = new ActividadesHiloSimple();
		Thread hilo = new Thread(hs);
		hilo.start();
	}

	@Override
	public void run() {
		Actividades.primerosNums();
	}
}
