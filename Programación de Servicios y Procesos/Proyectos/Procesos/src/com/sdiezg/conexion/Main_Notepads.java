package com.sdiezg.conexion;

public class Main_Notepads {
	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("notepad");
		try {
			for (int i = 0; i < 100; i++) {
				pb.start();
			}
		} catch (Exception e) {
			//TODO: handle exception
		}
	}
}
