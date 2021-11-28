package com.sdiezg.ejercicio2;

import java.util.List;
import java.util.Random;

public class Generator extends Thread {
	private List<Integer> numbers;

	public Generator(List<Integer> numbers) {
		super();
		this.numbers = numbers;
	}

	@Override
	public void run() {
		while (true) {
			int n = new Random().nextInt(30);
			for (int i = 0; i < n; i++) {
				numbers.add(new Random().nextInt(1000));
				System.out.println("Generating...");
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("End process.");
			synchronized (numbers) {
				numbers.notify();
				try {
					numbers.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
