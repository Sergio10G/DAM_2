import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ping amazon.es");
		try {
			Process pro = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			//TODO: handle exception
		}
    }
}
