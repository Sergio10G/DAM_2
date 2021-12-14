package com.sdiezg.tcpconsumer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.sdiezg.tcpconsumer.Colors.EColors;

public class Main {

	public static List<String> htmlContent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br;
		PrintWriter pw;
		htmlContent = new ArrayList<>();

		// Limpiar la consola
		System.out.print("\033[H\033[2J");  
    	System.out.flush();  

		Colors.printString(EColors.PURPLE, "> Sdiezg's ");
		Colors.printlnString(EColors.BLUE, "Web Analyzer");
		Colors.printlnString(EColors.CYAN, "Webs sugeridas: milk.com");
		Colors.printlnString(EColors.YELLOW, "Introduce una URL (dejar vacío para URL por defecto):");
		String urlInput = sc.nextLine();
		if (urlInput.equals(""))
			urlInput = "edition.cnn.com/EVENTS/1996/year.in.review/";
		if (!urlInput.endsWith("/"))
			urlInput += "/";
		String url = urlInput;
		if (urlInput.contains("http")) {
			url = urlInput.split("://")[1];
		}
		String host = url.split("/")[0];
		String path = url.replace(host, "");

		String peticion =	"GET " + path + " HTTP/1.1\r\n" + 
								"Host: " + host + "\r\n";

		try {
			Socket socket = new Socket(host, 80);

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);

			pw.println(peticion);
			//System.out.println(peticion);

			Colors.printlnString(EColors.YELLOW, "Intentando conectarse a " + url + " ...");

			long t0 = (new Date()).getTime();
			while (true) {
				if (br.ready()) {
					break;
				}
				long t1 = (new Date()).getTime();
				if (t1 - t0 > 10000){
					throw new Exception();
				}
			}

			Colors.printlnString(EColors.GREEN, "Conexión establecida con éxito.\n");

			String linea = "";
			while (br.ready() && (linea = br.readLine()) != null) {
				htmlContent.add(linea);
			}

			Colors.printString(EColors.YELLOW, "TÍTULO:\t\t");
			System.out.println(findTag("title"));
			Colors.printString(EColors.YELLOW, "METADATOS:\t");
			System.out.println(findTag("head"));
			Colors.printString(EColors.YELLOW, "SCRIPTS:\t");
			System.out.println(findAllInlineTags("script").size() > 0 ? findAllInlineTags("script") : "none");
			Colors.printString(EColors.YELLOW, "LINKS:\t\t");
			System.out.println(findAllInlineTags("link").size() > 0 ? findAllInlineTags("link") : "none");
			Colors.printString(EColors.YELLOW, "Nº DE PÁRRAFOS:\t");
			System.out.println(findAllTags("p").size());

			sc.close();
			socket.close();
		} catch (Exception e) {
			Colors.printlnString(EColors.RED, "No se ha podido establecer la conexión con el host.");
		}
	}

	public static String findTag(String tagName) {
		String tag = "<" + tagName + ">";
		String tagClose = "</" + tagName + ">";

		String out = "";
		boolean found = false;

		for (String line : htmlContent) {
			if (line.contains(tagName) || line.contains(tagName.toUpperCase()) || line.contains(tag) || line.contains(tag.toUpperCase())) {
				found = true;
			}
			if (found) {
				out += line + "\n";
			}
			if (line.contains(tagClose) || line.contains(tagClose.toUpperCase()))
				break;
		}
		return removeTags(tagName, out);
	}

	public static List<String> findAllTags(String tagName) {
		List<String> lines = new ArrayList<>();
		String tag = "<" + tagName + ">";
		String tagClose = "</" + tagName + ">";

		String out = "";
		boolean found = false;

		for (String line : htmlContent) {
			if (line.contains(tagName) || line.contains(tagName.toUpperCase()) || line.contains(tag) || line.contains(tag.toUpperCase())) {
				found = true;
			}
			if (found) {
				out += line + " ";
				if (line.contains(tagClose) || line.contains(tagClose.toUpperCase())) {
					lines.add(removeTags(tagName, out));
					out = "";
					found = false;
				}
			}
		}
		return lines;
	}

	public static List<String> findAllInlineTags(String tagName) {
		List<String> lines = new ArrayList<>();
		String tag = "<" + tagName + ">";
		String tagClose = "</" + tagName + ">";
		String simpleClose = "/>";

		String out = "";
		boolean found = false;

		for (String line : htmlContent) {
			if (line.contains(tagName) || line.contains(tagName.toUpperCase()) || line.contains(tag) || line.contains(tag.toUpperCase())) {
				found = true;
			}
			if (found) {
				out += line + " ";
				if (line.contains(tagClose) || line.contains(tagClose.toUpperCase()) || line.contains(simpleClose)) {
					lines.add(removeTags(tagName, out));
					out = "";
					found = false;
				}
			}
		}
		return lines;
	}

	public static String removeTags(String tagName, String line) {
		String tag = "<" + tagName + ">";
		String tagClose = "</" + tagName + ">";
		//String simpleClose = "/>";

		String out = line.replace(tag, "").replace(tag.toUpperCase(), "");
		out = out.replace(tagClose, "").replace(tagClose.toUpperCase(), "");
		//out = out.replace(simpleClose, "");
		return out.trim();
	}
}