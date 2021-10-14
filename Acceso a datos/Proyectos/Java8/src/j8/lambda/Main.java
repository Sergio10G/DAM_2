package j8.lambda;

public class Main {
	public static void main(String[] args) {
		/* Usamos la interfaz IPrinter
		IPrinter p = System.out::println;

		p.print("Hola mundo!");
		*/
		
		IMiInterfaceFuncional mif = (x, y) -> {
			return x + " " + y;
		};

		System.out.println(mif.concatenador("Hola", "mundo"));
	}
}
