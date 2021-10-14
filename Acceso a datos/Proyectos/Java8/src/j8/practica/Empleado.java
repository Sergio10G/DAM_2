package j8.practica;

public class Empleado {
	//	Attributes
	private int id;
	private String nombre;
	private int nomina;
	
	//	Constructors
	public Empleado(int id, String nombre, int nomina) {
		this.id = id;
		this.nombre = nombre;
		this.nomina = nomina;
	}
	
	//	Methods
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", nomina=" + nomina + "]";
	}

	//	Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNomina() {
		return nomina;
	}

	public void setNomina(int nomina) {
		this.nomina = nomina;
	}
	
}
