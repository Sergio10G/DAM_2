package j8.practica;

import java.util.Comparator;

public class ComparatorEmpleado implements Comparator<Empleado> {

	@Override
	public int compare(Empleado e1, Empleado e2) {
		return e1.getNomina() > e2.getNomina() ? -1 : 1;
	}
	
}
