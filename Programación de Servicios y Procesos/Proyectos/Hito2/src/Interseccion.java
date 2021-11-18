import java.util.ArrayList;
import java.util.List;

public class Interseccion extends Thread{
    // ATTRIBUTES
    private boolean activo;
    private List<Coche> viaConcurrida;
    private List<List<Coche>> viasNormales;
    
    // CONSTRUCTORS
    public Interseccion() {
        this.activo = true;
        this.viaConcurrida = new ArrayList<Coche>();
        this.viasNormales = new ArrayList<List<Coche>>();
        for (int i = 0; i < 3; i++) {
            this.viasNormales.add(new ArrayList<Coche>());
        }
    }
    
    // METHDOS
    @Override
    public void run() {
        while (activo) {
            
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    
    // GETTERS AND SETTERS
    
    
}
