package HiloJoin;

public class Principal {
	public static void main(String[] args) {
		Hilo h1 = new Hilo(20, "Hilo 1");
		Hilo h2 = new Hilo(30, "Hilo 2");

		h1.start();
		h2.start();
		try {
			h1.join();
			h2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin del programa");
	}
}
