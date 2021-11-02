package com.sdiezg.parking;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Aparcamiento aparcamiento = new Aparcamiento();
		long t0 = (new Date()).getTime();
		
		while ((new Date()).getTime() - t0 < 24000 && aparcamiento.getCochesAtendidos() < 1000) {
			(new Coche(aparcamiento)).start();
			try {
				Thread.sleep((int) (Math.random() * 200 + 1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Se acabó el tiempo! " + aparcamiento.getCochesAtendidos() + 
		" coches servidos en " + (((new Date()).getTime() - t0)/1000) + " horas!");
	}
}
