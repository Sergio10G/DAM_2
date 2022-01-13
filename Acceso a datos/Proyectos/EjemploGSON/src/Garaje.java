import java.util.ArrayList;

public class Garaje {
	private String direccion;
	private ArrayList<Coche> plazas;

	public Garaje(String direccion) {
		this.direccion = direccion;
		this.plazas = new ArrayList<Coche>();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void asignarPlaza(Coche c, int numeroPlaza) {
		c.setPlaza(numeroPlaza);
		this.plazas.add(c);
	}

	@Override
	public String toString() {
		return "Garaje [direccion=" + direccion + ", plazas=" + plazas + "]";
	}

}
