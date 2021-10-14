public class Main {
	public static void main(String[] args) {
		CronometroMins mns = new CronometroMins();
		CronometroSecs scs = new CronometroSecs();
		CronometroMillis mls = new CronometroMillis();

		mns.start();
		scs.start();
		mls.start();
	}
}
