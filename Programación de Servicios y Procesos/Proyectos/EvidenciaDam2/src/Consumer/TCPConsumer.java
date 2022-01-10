package Consumer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPConsumer {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("roble.pntic.mec.es", 80);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String peticion = "GET /apantoja/pagiedu.htm HTTP/1.1\r\n" + "Host: roble.pntic.mec.es\r\n";
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println(peticion);
			//Continuar

			System.out.println("Conectandose al sitio web...");
			while (true) {
				if (br.ready()) {
					break;
				}
			}

			System.out.println("Leyendo el sitio web...");
			String linea = "";
			int aperturas = 0;
			int cierres = 0;
			while (br.ready() && (linea = br.readLine()) != null) {
				linea = linea.toLowerCase();
				if (linea.contains("<p")) {
					aperturas++;
				}
				if (linea.contains("</p>")) {
					cierres++;
				}
			}

			System.out.println();
			System.out.println("Total de aperturas: " + aperturas);
			System.out.println("Total de cierres: " + cierres);
			if (aperturas == cierres) {
				System.out.println("Hay los mismos cierres que aperturas.");
			}
			else if (aperturas > cierres) {
				System.out.println("Hay menos cierres que aperturas.");
			}
			else {
				System.out.println("Hay más cierres que aperturas.");
			}
			
			br.close();
			pw.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
