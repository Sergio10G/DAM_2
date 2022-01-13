import java.io.Serializable;
import java.time.LocalDateTime;

public class Movimiento implements Serializable {
	// Attributes
	private static final long serialVersionUID = 8716289688550239807L;
	private String tipo;
	private float cantidad;
	private LocalDateTime fecha;

	// Constructors
	public Movimiento(String tipo, float cantidad) {
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.fecha = LocalDateTime.now();
	}

	// Methods
	@Override
	public String toString() {
		return "[" + fecha.toString() + "] " + tipo + ": " + cantidad + " euros";
	}

	// Getters & Setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

}
