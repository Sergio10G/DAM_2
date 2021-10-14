package j8.practica;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		ArrayList<Empleado> lista = new ArrayList<>();
		lista.add(new Empleado(0, "Paula", 1300));
		lista.add(new Empleado(1, "Antonio", 1200));
		lista.add(new Empleado(2, "Ricardo", 1600));
		lista.add(new Empleado(3, "María", 1500));

		// Collections.sort(lista, new ComparatorEmpleado());
		Collections.sort(lista, (e1, e2) -> e1.getNomina() > e2.getNomina() ? 1 : -1);

		for (Empleado e : lista) {
			System.out.println(e);
		}
	}
}