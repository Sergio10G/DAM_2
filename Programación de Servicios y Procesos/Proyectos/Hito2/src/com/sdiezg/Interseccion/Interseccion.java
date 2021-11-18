package com.sdiezg.Interseccion;

import java.util.ArrayList;
import java.util.List;

public class Interseccion extends Thread {
    // ATTRIBUTES
    private List<Salida> salidas;
    private List<Entrada> entradas;
    private boolean activo;

    // CONSTRUCTORS
    public Interseccion() {
        this.salidas = new ArrayList<Salida>();
        this.entradas = new ArrayList<Entrada>();
        this.activo = true;
    }
    
    // METHDOS
    @Override
    public void run() {
        // Los coches empiezan a llegar por las entradas
        for (Entrada entrada : entradas) {
            entrada.start();
        }
        while (activo) {
            // Se alternan las salidas de los coches de una en una
            for (Salida salida : salidas) {
                Thread hiloSalida = new Thread(salida);
                hiloSalida.start();
                try {
                    // Esperamos hasta que acabe el tiempo de semáforo de la salida
                    hiloSalida.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!activo)
                    break;
            }         
        }
        // Se ha acabado la simulación, se cierran las entradas.
        for (Entrada entrada : entradas) {
            entrada.setActivo(false);
        }
    }
    
    // GETTERS AND SETTERS
    public void addEntrada(Entrada entrada) {
        this.entradas.add(entrada);
    }

    public void addSalida(Salida salida) {
        this.salidas.add(salida);
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
