public class CronometroMillis extends Thread {
	//	Attributes
	private long millis;
	
	//	Constructors
	public CronometroMillis() {
		this.millis = 0;
	}
	
	//	Methods
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("Milis: " + millis);
				millis += 10;
				if (millis == 1000)
					millis = 0;
				sleep(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//	Getters & Setters
	public long getMillis() {
		return millis;
	}

	public void setMillis(long millis) {
		this.millis = millis;
	}
	
}
