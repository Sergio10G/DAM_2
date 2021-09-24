package com.hilos;

import java.util.Date;

public class Hilos2 implements Runnable{
	@Override
	public void run() {
		System.out.println("Mensaje del hilo: " + new Date() + " " + Thread.currentThread());
		
	}

	public static void main(String[] args) {
		Hilos2 hilos2 = new Hilos2();
		Thread hiloobjeto = new Thread(hilos2);
		hiloobjeto.setPriority(9);
		hiloobjeto.setName("Hilo nombrao");
		hiloobjeto.setDaemon(true);
		hiloobjeto.start();
		System.out.println(hiloobjeto.isDaemon());
	}
}
