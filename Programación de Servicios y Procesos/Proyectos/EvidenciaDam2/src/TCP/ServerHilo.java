package TCP;

import java.io.DataOutputStream;
import java.net.Socket;

public class ServerHilo extends Thread{

	private Socket socket;

	public ServerHilo(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		int segs = 0;
		while (true) {
			try {
				DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());

				outStream.writeInt(segs);

				Thread.sleep(1000);
				segs++;
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
