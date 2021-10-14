public class CronometroMins extends Thread {
	//	Attributes
	private int mins;
	
	//	Constructors
	public CronometroMins() {
		this.mins = 0;
	}
	
	//	Methods
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("Minutos: " + mins);
				mins++;
				sleep(60000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//	Getters & Setters
	public long getMins() {
		return mins;
	}

	public void setMins(int mins) {
		this.mins = mins;
	}
	
}

