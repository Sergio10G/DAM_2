package com.teoria;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public class PoolHiloCallable {
	
	private static final Instant INICIO = Instant.now();

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		System.out.println(INICIO);
	
		Callable<String> tarea = () -> {
			try {
				log("Empieza la tarea.");
				Thread.sleep(5000);
				log("Fin.");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "Resultado del callable";
		};

		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> futuro = executor.submit(tarea);
		//executor.submit(tarea);
		System.out.println(futuro.get());
		executor.shutdown();
	}

	private static void log(String mensaje) {
		System.out.println(Duration.between(INICIO, Instant.now()) + mensaje + Thread.currentThread());
	}
}
