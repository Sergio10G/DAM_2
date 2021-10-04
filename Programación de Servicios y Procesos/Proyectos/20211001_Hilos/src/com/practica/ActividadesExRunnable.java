package com.practica;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ActividadesExRunnable {
	public static void main(String[] args) {
		String frase = "Hola buenos días que tal estás.";
		
		Runnable tarea = () -> {
			Actividades.contarPalabras(frase);
		};

		ExecutorService es = Executors.newSingleThreadExecutor();
		es.submit(tarea);
		es.shutdown();
	}
}
