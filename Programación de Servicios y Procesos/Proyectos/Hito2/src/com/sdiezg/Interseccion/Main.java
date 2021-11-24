package com.sdiezg.interseccion;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Cambiar esta variable para cambiar la duracion de la simulación (en segundos).
        int segsSimulacion = 150;
        
        // Creamos las vias, que serán representadas por listas de coches.
        List<Coche> viaConcurrida = new ArrayList<Coche>();
        List<Coche> viaNormal1 = new ArrayList<Coche>();
        List<Coche> viaNormal2 = new ArrayList<Coche>();
        List<Coche> viaNormal3 = new ArrayList<Coche>();

		// Creamos la interseccion, que será el hilo que controle todos los demás hilos, así como el "semáforo".
        Interseccion interseccion = new Interseccion();

		// Añadimos los hilos de entrada de coches a la intersección
        interseccion.addEntrada(new Entrada(viaConcurrida, 100));
        interseccion.addEntrada(new Entrada(viaNormal1, 500));
        interseccion.addEntrada(new Entrada(viaNormal2, 500));
        interseccion.addEntrada(new Entrada(viaNormal3, 500));

		// Añadimos los hilos de salida de coches a la intersección
        interseccion.addSalida(new Salida(viaConcurrida, 10));
        interseccion.addSalida(new Salida(viaNormal1, 5));
        interseccion.addSalida(new Salida(viaNormal2, 5));
        interseccion.addSalida(new Salida(viaNormal3, 5));

		// Comienza la ejecución del programa
        interseccion.start();
        System.out.println("Comenzando la simulación...");

        // Bucle de espera del programa, dará 150 vueltas tardando 1 segundo por vuelta, y después se cerrarán los hilos y se
        // mostrará la información
        for (int i = 0; i < segsSimulacion; i++) {
            int segsRestantes = segsSimulacion - i;
            // Esta linea de abajo pinta el tiempo restante en el formato mm:ss, por eso es tan larga
            System.out.println("Tiempo restante: " + "0" + (segsRestantes / 60) + ":" + (segsRestantes % 60 < 10 ? "0" : "") + (segsRestantes % 60));
            Thread.sleep(1000);
			// Limpiar la consola
			System.out.print("\033[H\033[2J");  
    		System.out.flush();  
        }

		// Enviamos la señal de apagado a la intersección, que a su vez apagará el resto de hilos.
        interseccion.setActivo(false);

        System.out.println("--- Datos al final de la ejecución ---");
        System.out.println("--- Via concurrida: " + viaConcurrida.size() + " coches.");
        System.out.println("--- Via normal 1: " + viaNormal1.size() + " coches.");
        System.out.println("--- Via normal 2: " + viaNormal2.size() + " coches.");
        System.out.println("--- Via normal 3: " + viaNormal3.size() + " coches.");
        System.out.println("--------------------------------------");
    }
}
