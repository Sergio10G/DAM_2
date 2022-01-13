import java.io.Serializable;

public class Contacto implements Serializable {
	// Attributes
	private static final long serialVersionUID = -4624046047796483183L;
	private String nombre;
	private String telefono;

	// Constructors
	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	// Methods
	@Override
	public String toString() {
		return "Contacto[" + nombre + "-" + telefono + "]";
	}

	// Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}
}