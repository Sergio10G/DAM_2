public class Cronometro extends Thread{
	//	Attributes
	private long millis;
	
	//	Constructors
	public Cronometro() {
		this.millis = 0;
	}

	//	Methods
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println((millis / 60000) + ":" + (millis/1000 % 60) + ":" + (millis % 1000 / 10));
				sleep(10);
				millis += 10;
			}
		} catch (Exception e) {
			//TODO: handle exception
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
