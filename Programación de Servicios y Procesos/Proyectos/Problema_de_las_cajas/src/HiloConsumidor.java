import java.util.List;

public class HiloConsumidor extends Thread{
	//	Attributes
	private List<Integer> recursos;
	
	//	Constructors
	public HiloConsumidor(List<Integer> recursos) {
		super.run();
		this.recursos = recursos;
	}
	
	//	Methods
	@Override
	public void run() {
		while (true) {
			if (recursos.size() > 0){
				recursos.remove(0);
				System.out.println("Extraido un número: Total: " + recursos.size());
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				synchronized (recursos) {
					try {
						recursos.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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
