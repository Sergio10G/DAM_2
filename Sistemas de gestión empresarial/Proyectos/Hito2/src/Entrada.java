import java.util.List;

public class Entrada extends Thread{
	//	Attributes
	private int max_millis;
	private List<Coche> via;
	private boolean activo;
	
	//	Constructors
	public Entrada(int max_millis, List<Coche> via) {
		this.max_millis = max_millis;
		this.via = via;
		this.activo = true;
	}
	
	//	Methods
	@Override
	public void run() {
		while (this.activo) {
			synchronized (this.via) {
				via.add(new Coche());
			}
			try {
				sleep((int) (Math.random() * this.max_millis));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//	Getters & Setters
	public int getMax_millis() {
		return max_millis;
	}

	public void setMax_millis(int max_millis) {
		this.max_millis = max_millis;
	}

	public List<Coche> getVia() {
		return via;
	}

	public void setVia(List<Coche> via) {
		this.via = via;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
