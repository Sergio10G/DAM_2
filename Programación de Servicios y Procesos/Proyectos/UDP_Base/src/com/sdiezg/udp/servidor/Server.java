package com.sdiezg.udp.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) {
		byte[] buf = new byte[1024];
		try {
			DatagramSocket socket = new DatagramSocket(5111);
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			System.out.println("Esperando mensaje...");
			socket.receive(packet);
			String mensaje = new String(packet.getData());
			System.out.println("Mensaje recibido: " + mensaje);
			mensaje = "Mensaje recibido";
			buf = mensaje.getBytes();
			packet = new DatagramPacket(buf, buf.length, packet.getAddress(), packet.getPort());
			socket.send(packet);
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
