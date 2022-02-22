package Asimetrico;

public class Main {
	public static void main(String[] args) {
		String mensaje = "Hola mundo";
		Cifrado cif = new Cifrado("1234");
		byte[] cript = cif.encriptar(mensaje);
		System.out.println(cript);
		System.out.println(cif.desencriptar(cript));
	}
}
