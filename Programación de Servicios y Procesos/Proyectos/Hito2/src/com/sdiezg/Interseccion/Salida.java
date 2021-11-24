package com.sdiezg.interseccion;

import java.util.List;
import java.util.Date;

public class Salida implements Runnable {
    // ATTRIBUTES
    private List<Coche> via;
    private int maxMillis;
    private int segundosSemaforo;
    
    // CONSTRUCTORS
    public Salida(List<Coche> via, int segundosSemaforo) {
        this.via = via;
        this.maxMillis = 200;
        this.segundosSemaforo = segundosSemaforo;
    }
    
    // METHDOS
    @Override
    public void run() {
		// Se registra el tiempo de inicio en t0
        long t0 = (new Date()).getTime();
		// Salen coches mientras que hayan pasado menos segundos que los especificados en segundosSemaforo
        while ((new Date()).getTime() - t0 < segundosSemaforo * 1000) {
            try {
                if (via.size() > 0) {
                    synchronized (via) {
                        cocheSale();
                    }
                    Thread.sleep(maxMillis);
                }
            }
            catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public synchronized void cocheSale() {
        if (via.size() > 0)
            via.remove(via.size() - 1);
    }

    // GETTERS AND SETTERS
    public List<Coche> getVia() {
        return via;
    }
    
    public void setVia(List<Coche> via) {
        this.via = via;
    }
    
    public int getMaxMillis() {
        return maxMillis;
    }
    
    public void setMaxMillis(int maxMillis) {
        this.maxMillis = maxMillis;
    }

    public int getSegundosSemaforo() {
        return segundosSemaforo;
    }

    public void setSegundosSemaforo(int segundosSemaforo) {
        this.segundosSemaforo = segundosSemaforo;
    }
}
