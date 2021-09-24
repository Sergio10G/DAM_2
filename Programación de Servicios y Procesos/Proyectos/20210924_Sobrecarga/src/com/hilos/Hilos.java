package com.hilos;

public class Hilos extends Thread{
	public static void main(String[] args) {
		Hilos hilo1 = new Hilos();
		Hilos hilo2 = new Hilos();
		hilo1.start();
		hilo2.start();
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread() + ": " + (i + 1));
		}
		super.run();
	}
}
