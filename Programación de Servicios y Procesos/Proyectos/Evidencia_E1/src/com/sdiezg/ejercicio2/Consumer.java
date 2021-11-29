package com.sdiezg.ejercicio2;

import java.util.List;

public class Consumer extends Thread{
	//	Attributes
	private List<Integer> numbers;
	
	//	Constructors
	public Consumer(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	//	Methods
	@Override
	public void run() {
		while (true) {
			synchronized (numbers) {
				try {
					numbers.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
<<<<<<< HEAD
			}
			for (Integer num : numbers) {
				System.out.println("Consumed: " + num);
				try {
					sleep(num);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			synchronized (numbers) {
=======
				for (Integer num : numbers) {
					System.out.println("Consumed: " + num);
					try {
						sleep(num);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
>>>>>>> 9036cbce5ca762e7d81e9d1040481f666760ae67
				numbers.clear();
				System.out.println("Ended consuming.");
				numbers.notify();
			}
		}
	}
	
	//	Getters & Setters
	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
}
