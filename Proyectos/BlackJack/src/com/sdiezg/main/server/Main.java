package com.sdiezg.main.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

import com.sdiezg.classes.app.ClientReceiver;

public class Main {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		byte[] buf = new byte[1024];

		try {
			DatagramSocket socket = new DatagramSocket(5111);
			
			// Bucle de recepcion de players
			ClientReceiver cr = new ClientReceiver(socket);
			cr.start();
			String s = "";
			while (!s.equals("stop")) {
				System.out.println("Receiving clients... Type \"stop\" to stop.");
				s = sc.nextLine();
			}
			cr.turnOff();
			cr.join();
			
			// Bucle del juego
			while (true) {
				String mensaje = "nombre" + ": " + sc.nextLine();
				buf = mensaje.getBytes();
				DatagramPacket packet = new DatagramPacket(buf, buf.length, p1.getAddress(), p1.getPort());
				socket.send(packet);
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
