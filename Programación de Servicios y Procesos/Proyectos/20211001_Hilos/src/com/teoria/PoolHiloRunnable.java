package com.teoria;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public class PoolHiloRunnable {
	
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

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(tarea);
		executor.submit(tarea);
		executor.shutdown();
	}

	private static void log(String mensaje) {
		System.out.println(Duration.between(INICIO, Instant.now()) + mensaje + Thread.currentThread());
	}
}
