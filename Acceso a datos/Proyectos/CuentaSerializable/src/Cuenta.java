import java.io.Serializable;
import java.util.ArrayList;

public class Cuenta implements Serializable {
	// Attributes
	private static final long serialVersionUID = 907110784472390297L;
	private int numeroCuenta;
	private Cliente cliente;
	private ArrayList<Movimiento> movimientos;

	// Constructors
	public Cuenta(Cliente cliente, ArrayList<Movimiento> movimientos) {
		this.cliente = cliente;
		this.movimientos = movimientos;
		this.numeroCuenta = (int) (Math.random() * 1000000000);
	}

	// Methods
	public float calcularTotal() {
		float total = 0.0f;
		for (Movimiento movimiento : movimientos) {
			float cantidad = movimiento.getCantidad();
			if (movimiento.getTipo().equals("retirada")) {
				cantidad *= -1;
			}
			total += cantidad;
		}
		return total;
	}

	public boolean realizarMovimiento(String tipo, float cantidad) {
		if (tipo.equals("ingreso")) {
			movimientos.add(new Movimiento("ingreso", cantidad));
			return true;
		} else if (tipo.equals("retirada")) {
			if (cantidad > calcularTotal()) {
				System.out.println("Fondos insuficientes.");
				return false;
			}
			movimientos.add(new Movimiento("retirada", cantidad));
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Cuenta [num=" + numeroCuenta + "cliente=" + cliente + ", movimientos=" + movimientos + "]";
	}

	// Getters & Setters
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(ArrayList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

}
