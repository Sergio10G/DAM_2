import java.util.List;

public class Salida extends Thread {
    // ATTRIBUTES
    private List<Coche> via;
    private int maxMillis;
    private int segundosSemaforo;
    private boolean activo;
    private boolean semaforoVerde;
    
    // CONSTRUCTORS
    public Salida(List<Coche> via, int segundosSemaforo) {
        this.via = via;
        this.maxMillis = 200;
        this.segundosSemaforo = segundosSemaforo;
        this.activo = true;
        this.semaforoVerde = false;
    }
    
    // METHDOS
    @Override
    public void run() {
        while (activo) {
            if (semaforoVerde) {
                System.out.println("SEMAFORO VERDE__________________________");
                try {
                    if (via.size() > 0) {
                        synchronized (via) {
                            cocheSale();
                        }
                        System.out.println("Sale un coche.");
                        Thread.sleep(maxMillis);
                    }
                    else {
                        synchronized (via) {
                            via.wait();
                        }
                    }
                }
                catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
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

    public void semaforoRojo() {
        this.semaforoVerde = false;
    }

    public void semaforoVerde() {
        this.semaforoVerde = true;
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
