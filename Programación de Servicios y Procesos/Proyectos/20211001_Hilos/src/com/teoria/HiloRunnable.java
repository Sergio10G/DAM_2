package com.teoria;

import java.time.Duration;
import java.time.Instant;

public class HiloRunnable {
	
	private static final Instant INICIO = Instant.now();

	public static void main(String[] args) {
		System.out.println(INICIO);
	
		Runnable tarea = () -> {
			try {
				log("Empieza la tarea.");
				Thread.sleep(5000);
				log("Fin.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		Thread hilo = new Thread(tarea);
		hilo.start();
		Thread hilo1 = new Thread(tarea);
		hilo1.start();
	}

	private static void log(String mensaje) {
		System.out.println(Duration.between(INICIO, Instant.now()) + mensaje);
	}
}
