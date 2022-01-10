package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

	public static void main(String[] args) {

		List<Lugar> lugares = new ArrayList<>();
		lugares.add(new Lugar("New York", 40.702749, -73.934609));
		lugares.add(new Lugar("Rio de Janeiro", -22.935391, -43.223767));
		lugares.add(new Lugar("Madrid", 40.427442, -3.701842));
		lugares.add(new Lugar("New Delhi", 28.573496, 77.228781));
		lugares.add(new Lugar("Sidney", -33.901702, 151.186618));
		
		//Continuar 
		// Lat: y
		// Lon: x
		try {
			Lugar lugarCliente;
			DatagramSocket socket = new DatagramSocket(5111);
			
			byte[] bufLat = new byte[1024];
			DatagramPacket pLat = new DatagramPacket(bufLat, bufLat.length);
			socket.receive(pLat);
			String strLat = new String(pLat.getData());
			byte[] bufLon = new byte[1024];
			DatagramPacket pLon = new DatagramPacket(bufLon, bufLon.length);
			socket.receive(pLon);
			String strLon = new String(pLon.getData());

			lugarCliente = new Lugar("cliente", Double.parseDouble(strLat), Double.parseDouble(strLon));
			Lugar lugarCercano = lugares.get(0);
			for (Lugar lugar : lugares) {
				if (calcularDistancia(lugarCliente, lugar) < calcularDistancia(lugarCliente, lugarCercano)) {
					lugarCercano = lugar;
				}
			}
			byte[] bufCercano = lugarCercano.nombre.getBytes();
			DatagramPacket pCercano = new DatagramPacket(bufCercano, bufCercano.length, pLat.getAddress(), pLat.getPort());
			socket.send(pCercano);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static double calcularDistancia(Lugar p1, Lugar p2) {
		double dist =  Math.sqrt(Math.pow(p2.longitud - p1.longitud, 2) + Math.pow(p2.latitud - p1.latitud, 2));
		System.out.println("Distancia de " + p1.nombre + " a " + p2.nombre + ": " + dist);
		return dist;
	}

}
