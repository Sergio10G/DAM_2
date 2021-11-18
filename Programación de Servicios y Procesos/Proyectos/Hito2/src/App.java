import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Coche> viaConcurrida = new ArrayList<Coche>();
        List<Coche> viaNormal1 = new ArrayList<Coche>();
        List<Coche> viaNormal2 = new ArrayList<Coche>();
        List<Coche> viaNormal3 = new ArrayList<Coche>();

        Entrada entradaConcurrida = new Entrada(viaConcurrida, 100);
        Entrada entradaNormal1 = new Entrada(viaNormal1, 500);
        Entrada entradaNormal2 = new Entrada(viaNormal2, 500);
        Entrada entradaNormal3 = new Entrada(viaNormal3, 500);

        Salida salidaConcurrida = new Salida(viaConcurrida, 10);
        Salida salidaNormal1 = new Salida(viaNormal1, 5);
        Salida salidaNormal2 = new Salida(viaNormal2, 5);
        Salida salidaNormal3 = new Salida(viaNormal3, 5);

        List<Salida> salidas = new ArrayList<Salida>();

        salidas.add(salidaConcurrida);
        salidas.add(salidaNormal1);
        salidas.add(salidaNormal2);
        salidas.add(salidaNormal3);

        Semaforo semaforo = new Semaforo(salidas);

        entradaConcurrida.start();
        entradaNormal1.start();
        entradaNormal2.start();
        entradaNormal3.start();
        semaforo.start();

        Thread.sleep(10000);
        
        entradaConcurrida.setActivo(false);
        entradaNormal1.setActivo(false);
        entradaNormal2.setActivo(false);
        entradaNormal3.setActivo(false);
        semaforo.setActivo(false);

        System.out.println("--- Datos al final de la ejecución ---");
        System.out.println("--- Via concurrida: " + viaConcurrida.size() + " coches.");
        System.out.println("--- Via normal 1: " + viaNormal1.size() + " coches.");
        System.out.println("--- Via normal 2: " + viaNormal2.size() + " coches.");
        System.out.println("--- Via normal 3: " + viaNormal3.size() + " coches.");
        System.out.println("--------------------------------------");
    }
}
