import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Lector> lectores = new ArrayList<>();
        Archivo arch = new Archivo();
        lectores.add(new Lector("Pistorius", arch));
        lectores.add(new Lector("Winston", arch));
        lectores.add(new Lector("JoseJuan", arch));
        lectores.add(new Lector("JuanJose", arch));
        lectores.add(new Lector("Chema", arch));
		lectores.add(new Lector("1", arch));
        lectores.add(new Lector("2", arch));
        lectores.add(new Lector("3", arch));

        for (Lector lector : lectores) {
            lector.start();
			Thread.sleep(100);
        }
    /*
        for (Lector lector : lectores) {
            lector.join();
        }

        System.out.println("Se acabó!");
    */
    }
}
