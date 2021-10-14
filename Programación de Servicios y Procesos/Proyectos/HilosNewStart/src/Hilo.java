public class Hilo extends Thread {
	//	Attributes
	private String mensaje;
	
	//	Constructors
	public Hilo(String mensaje) {
		this.mensaje = mensaje;
	}
	
	//	Methods
	@Override
	public void run() {
		try {
			for (int i = 0; i < 1000000; i++) {
				if (i % 1000 == 0) {
					System.out.println(mensaje + " - " + (i / 10000));
					//sleep(10);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//	Getters & Setters
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
