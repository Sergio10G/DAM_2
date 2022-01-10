package TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 5112);
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			while (true) {
				int seg = entrada.readInt();
				System.out.println("Conectado por: "+seg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
