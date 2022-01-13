import java.io.Serializable;

public class Cliente implements Serializable{
	// Attributes
	private static final long serialVersionUID = 4591589474971391819L;
	private String nombre;
	private String apellidos;

	@Override
	public String toString() {
		return "Cliente [" + nombre + " " + apellidos + "]";
	}

	// Constructors
	public Cliente(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	// Methods

	// Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}
