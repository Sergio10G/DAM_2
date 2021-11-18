package com.sdiezg.Interseccion;

import java.util.ArrayList;
import java.util.List;

public class Semaforo extends Thread {
    // ATTRIBUTES
    private List<Salida> salidas;
    private boolean activo;

    // CONSTRUCTORS
    public Semaforo(Salida salidaConcurrida, Salida salidaNormal1, Salida salidaNormal2, Salida salidaNormal3) {
        this.salidas = new ArrayList<Salida>();
        this.salidas.add(salidaConcurrida);
        this.salidas.add(salidaNormal1);
        this.salidas.add(salidaNormal2);
        this.salidas.add(salidaNormal3);
        this.activo = true;
    }
    
    // METHDOS
    @Override
    public void run() {
        while (activo) {
            for (Salida salida : salidas) {
                Thread hiloSalida = new Thread(salida);
                hiloSalida.start();
                try {
                    hiloSalida.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!activo)
                    break;
            }         
        }
    }
    
    // GETTERS AND SETTERS
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
