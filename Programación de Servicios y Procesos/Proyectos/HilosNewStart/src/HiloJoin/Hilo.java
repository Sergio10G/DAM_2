package HiloJoin;

public class Hilo extends Thread {
	//	Attributes
	private int  num;
	private String  nombre;
	
	//	Constructors
	public Hilo(int num, String nombre) {
		this.num = num;
		this.nombre = nombre;
	}
	
	//	Methods
	@Override
	public void run() {
		for (int i = 0; i < num; i++) {
			System.out.println(nombre + " " + i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//	Getters & Setters
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
