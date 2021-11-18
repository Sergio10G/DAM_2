package com.sdiezg.Interseccion;

import java.util.List;
import java.util.Date;

public class Salida implements Runnable {
    // ATTRIBUTES
    private List<Coche> via;
    private int maxMillis;
    private int segundosSemaforo;
    private boolean activo;
    
    // CONSTRUCTORS
    public Salida(List<Coche> via, int segundosSemaforo) {
        this.via = via;
        this.maxMillis = 200;
        this.segundosSemaforo = segundosSemaforo;
        this.activo = true;
    }
    
    // METHDOS
    @Override
    public void run() {
        long t0 = (new Date()).getTime();
        //System.out.println("SEMAFORO VERDE__________________________");
        while (activo) {
            try {
                if (via.size() > 0) {
                    synchronized (via) {
                        cocheSale();
                    }
                    //System.out.println("Sale un coche.");
                    Thread.sleep(maxMillis);
                }
            }
            catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            long t1 = (new Date()).getTime();
            if (t1 - t0 >= segundosSemaforo * 1000)
                break;
        }
    }

    public void cocheEntra() {
        via.add(new Coche());
    }

    public void cocheSale() {
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
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getSegundosSemaforo() {
        return segundosSemaforo;
    }

    public void setSegundosSemaforo(int segundosSemaforo) {
        this.segundosSemaforo = segundosSemaforo;
    }
}
