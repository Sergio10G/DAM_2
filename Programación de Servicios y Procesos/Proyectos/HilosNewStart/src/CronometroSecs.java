public class CronometroSecs extends Thread {
	//	Attributes
	private int secs;
	
	//	Constructors
	public CronometroSecs() {
		this.secs = 0;
	}
	
	//	Methods
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("Segundos: " + secs);
				secs++;
				if (secs == 60)
					secs = 0;
				sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//	Getters & Setters
	public long getSecs() {
		return secs;
	}

	public void setSecs(int secs) {
		this.secs = secs;
	}
	
}

