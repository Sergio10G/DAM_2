package com.sdiezg.parking;

public class Coche extends Thread {
	//	Attributes
	private Aparcamiento aparcamiento;
	
	//	Constructors
	public Coche(Aparcamiento aparcamiento) {
		this.aparcamiento = aparcamiento;
	}
	
	//	Methods
	/*
	@Override
	public void run() {
		if (aparcamiento.getPlazasLibres() == 0) {
			try {
					synchronized (aparcamiento) {
						aparcamiento.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		synchronized (aparcamiento) {
			aparcamiento.ocuparPlaza();
		}
		System.out.println("Plaza ocupada. Quedan " + aparcamiento.getPlazasLibres());
		try {
			sleep((int) (Math.random() * 1000 + 1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (aparcamiento) {
			aparcamiento.liberarPlaza();
		}
		System.out.println("Plaza liberada. Quedan " + aparcamiento.getPlazasLibres());

	}
	*/
	@Override
	public void run() {
		while (true) {
			if (aparcamiento.getPlazasLibres() > 0) {
				synchronized (aparcamiento) {
					aparcamiento.ocuparPlaza();
				}
				//System.out.println("Plaza ocupada. Quedan " + aparcamiento.getPlazasLibres());
				try {
					sleep((int)(Math.random() * 1000 + 1));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (aparcamiento) {
					aparcamiento.liberarPlaza();
					aparcamiento.notifyAll();
				}
				//System.out.println("Plaza libre. Quedan " + aparcamiento.getPlazasLibres());
				break;
			}
			else {
				synchronized (aparcamiento) {
					try {
						aparcamiento.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
	
	//	Getters & Setters
	
}
