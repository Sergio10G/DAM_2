public class Lector extends Thread{
	//	Attributes
	private String nombre;
	private Archivo arch;
	
	//	Constructors
	public Lector(String nombre, Archivo arch) {
		super();
		this.nombre = nombre;
		this.arch = arch;
	}

	//	Methods
	@Override
	public void run() {
		while (true) {
			if(arch.getEstado() > 0) {
				synchronized (arch) {
					arch.setEstado(arch.getEstado() - 1);
					System.out.println(nombre + " está leyendo.");
				}
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (arch) {
					arch.setEstado(arch.getEstado() + 1);
					arch.notifyAll();
				}
				break;
			}
			else {
				synchronized (arch) {
					try {
						System.out.println(nombre + " está esperando.");
						arch.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println(nombre + " ha terminado de leer.");
	}
	
	//	Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Archivo getArch() {
		return arch;
	}

	public void setArch(Archivo arch) {
		this.arch = arch;
	}
	
}
