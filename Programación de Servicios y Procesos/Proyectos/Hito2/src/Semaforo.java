import java.util.List;

public class Semaforo extends Thread {
    // ATTRIBUTES
    private List<Salida> salidas;
    private boolean activo;

    // CONSTRUCTORS
    public Semaforo(List<Salida> salidas) {
        this.salidas = salidas;
        this.activo = true;
    }
    
    // METHDOS
    @Override
    public void run() {
        for (Salida salida : salidas) {
            salida.start();
        }
        while (activo) {
            try {
                for (Salida salida : salidas) {
                    salida.semaforoVerde();
                    sleep(salida.getSegundosSemaforo());
                    salida.semaforoRojo();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
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
