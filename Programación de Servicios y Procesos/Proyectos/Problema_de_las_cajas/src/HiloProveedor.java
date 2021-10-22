import java.util.List;

public class HiloProveedor extends Thread {
	//	Attributes
	private List<Integer> recursos;
	
	//	Constructors
	public HiloProveedor(List<Integer> recursos) {
		super();
		this.recursos = recursos;
	}
	
	//	Methods
	@Override
	public void run() {
		while (true) {
			synchronized (recursos) {
				recursos.add(1);
				System.out.println("Añadido un número. Total: " + recursos.size());
				recursos.notifyAll();
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//	Getters & Setters
	public List<Integer> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Integer> recursos) {
		this.recursos = recursos;
	}
	
}
