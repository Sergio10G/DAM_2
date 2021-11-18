package com.sdiezg.Interseccion;

import java.util.List;

public class Entrada extends Thread{
    // ATTRIBUTES
    private List<Coche> via;
    private int maxMillis;
    private boolean activo;
    
    // CONSTRUCTORS
    public Entrada(List<Coche> via, int maxMillis) {
        this.via = via;
        this.maxMillis = maxMillis;
        this.activo = true;
    }
    
    // METHDOS
    @Override
    public void run() {
        while (activo) {
            synchronized (via) {
                cocheEntra();
                via.notifyAll();
            }
            //System.out.println("Entra un coche.");
            try {
                sleep((int) (Math.random() * maxMillis));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
    
}
