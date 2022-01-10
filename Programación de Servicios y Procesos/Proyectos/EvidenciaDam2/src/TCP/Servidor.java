package TCP;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(5112);

			while (true) {
				Socket socket = serverSocket.accept();

				System.out.println("Cliente conectado");
				ServerHilo sh = new ServerHilo(socket);
				sh.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
