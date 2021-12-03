package com.sdiezg.tcpconsumer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
		try {
			Socket socket = new Socket("edition.cnn.com", 80);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String peticion =	"GET /EVENTS/1996/year.in.review/ HTTP/1.1\r\n" + 
								"Host: edition.cnn.com\r\n";
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);	
			pw.println(peticion);
			String linea = "";
			while (true) {
				if (br.ready()) {
					while ((linea = br.readLine()) != null) {
						if (linea.contains("<TITLE>")) {
							linea = linea.trim();
							linea = linea.replace("<TITLE>", "");
							linea = linea.replace("</TITLE>", "");
							System.out.println(linea);
						}
					}
					break;
				}
			}
			
			br.close();
			pw.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
