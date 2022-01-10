package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Cliente {

	public static void main(String[] args) {
		Double latitud = new Random().nextDouble() * 180 - 90;
		Double longitud = new Random().nextDouble() * 360 - 180;
		System.out.println("Solicitando (" + latitud + ", " + longitud + ")");
		try {
			DatagramSocket socket = new DatagramSocket();
			byte[] buffer = latitud.toString().getBytes();
			DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"),
					5111);
			socket.send(paquete);
			buffer = longitud.toString().getBytes();
			paquete = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 5111);
			socket.send(paquete);
			buffer = new byte[1024];
			paquete = new DatagramPacket(buffer, buffer.length);
			socket.receive(paquete);
			String lugar = new String(paquete.getData());
			System.out.println("Estas cerca de : " + lugar);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
