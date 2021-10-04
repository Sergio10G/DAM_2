package com.practica;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ActividadesExCallable {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		int anio = 2004;

		Callable<Boolean> tarea = () -> {
			return Actividades.esBisiesto(anio);
		};

		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Boolean> futuro = es.submit(tarea);
		if ((boolean) futuro.get())
			System.out.println(anio + " es bisiesto.");
		else
			System.out.println(anio + " no es bisiesto.");
			
		es.shutdown();
	}
}
