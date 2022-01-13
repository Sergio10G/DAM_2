import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner sc;
	private static FileInputStream fileInputStream;
	private static FileOutputStream fileOutputStream;
	private static ObjectInputStream objectInputStream;
	private static ObjectOutputStream objectOutputStream;
	private static Cuenta cuenta;

	public static void main(String[] args) {
		String nombre;
		String apellidos;
		File file = new File("./cuenta.dat");
		sc = new Scanner(System.in);
		
		if (!file.exists()) {
			System.out.println("Aun no existe ninguna cuenta. Se procederá con la creación...");
			System.out.println("Introduzca su nombre.");
			nombre = sc.nextLine();
			System.out.println("Introduzca sus apellidos.");
			apellidos = sc.nextLine();
			System.out.println("Cuenta creada con éxito!");
			Cliente cliente = new Cliente(nombre, apellidos);
			cuenta = new Cuenta(cliente, new ArrayList<Movimiento>());
		}
		else {
			try {
				fileInputStream = new FileInputStream(file);
				objectInputStream = new ObjectInputStream(fileInputStream);

			} catch (Exception e) {
				System.out.println("Ha habido algún error al intentar acceder al archivo.");
				e.printStackTrace();
				System.exit(0);
			}

			try {
				cuenta = (Cuenta) objectInputStream.readObject();
			} catch (Exception e) {
				System.out.println("Ha habido algún error al intentar leer el objeto cuenta.");
				e.printStackTrace();
				System.exit(0);
			}

			try {
				objectInputStream.close();
				fileInputStream.close();
			} catch (IOException e) {
				System.out.println("Ha habido algún error al intentar cerrar los streams de entrada.");
				e.printStackTrace();
				System.exit(0);
			}
		}

		boolean activo = true;
		while (activo) {
			clearTerminal();
			System.out.println("Bienvenid@ " + cuenta.getCliente().getNombre());
			System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
			System.out.println("Dinero en la cuenta: " + cuenta.calcularTotal() + " euros");
			System.out.println("¿Qué desea hacer?");
			System.out.println("-----------------------------------------------");
			System.out.println("1. Ingresar dinero");
			System.out.println("2. Retirar dinero");
			System.out.println("3. Mostrar movimientos");
			System.out.println("");
			System.out.println("0. Salir");
			System.out.println("-----------------------------------------------");

			boolean opcionCorrecta = false;
			int opcion = -1;
			while (!opcionCorrecta) {
				try {
					opcion = Integer.parseInt(sc.nextLine());
					if (opcion < 0 || opcion > 3) {
						throw new Exception();
					}
					opcionCorrecta = true;
				} catch (Exception e) {
					System.out.println("ERROR: La opcion debe ser un número del 0 al 3");
				}
			}

			switch (opcion) {
				case 1:
					realizarMovimiento("ingreso");
					break;

				case 2:
					realizarMovimiento("retirada");
					break;

				case 3:
					mostrarMovimientos();
					break;
				
				default:
					activo = false;
					break;
			}
		}

		try {
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
		} catch (Exception e) {
			System.out.println("Ha habido algún error al intentar crear los streams de salida.");
			e.printStackTrace();
			System.exit(0);
		}

		try {
			objectOutputStream.writeObject(cuenta);
			System.out.println("Datos guardados con éxito!");
		} catch (Exception e) {
			System.out.println("Ha habido algún error al intentar guardar los datos.");
			e.printStackTrace();
			System.exit(0);
		}

		try {
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			System.out.println("Ha habido algún error al intentar cerrar los streams de salida.");
			e.printStackTrace();
			System.exit(0);
		}

		sc.close();
	}

	private static void realizarMovimiento(String tipo) {
		boolean valorCorrecto = false;
		float importe = 0;
		boolean resultado;
		String msg;
		System.out.println("REALIZAR MOVIMIENTO");
		while (!valorCorrecto) {
			System.out.println("Introduzca el importe:");
			try {
				importe = Float.parseFloat(sc.nextLine());
				if (importe < 0) {
					throw new Exception();
				}
				valorCorrecto = true;
			} catch (Exception e) {
				System.out.println("ERROR: El valor introducido ha de ser un número y ser positivo.");
			}
		}
		resultado = cuenta.realizarMovimiento(tipo, importe);
		if (resultado) {
			msg = "Movimiento realizado con éxito!";
		}
		else {
			msg = "No se ha podido realizar el movimiento.";
		}
		confirmMsg(msg);
	}

	private static void mostrarMovimientos() {
		System.out.println("MOSTRAR MOVIMIENTOS");
		for (Movimiento movimiento : cuenta.getMovimientos()) {
			System.out.println(movimiento);
		}
		confirmMsg("");
	}

	private static void confirmMsg(String msg) {
		System.out.println(msg);
		System.out.println("Presione INTRO para continuar...");
		sc.nextLine();
	}

	private static void clearTerminal() {
		System.out.print("\033[H\033[2J");  
    	System.out.flush();  
	}

}
