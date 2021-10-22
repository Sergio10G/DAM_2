package com.sergio10g.clases;

public class HiloTemporizador extends Thread{
	//	Attributes
	private int idTemp;
	private Temporizador temp;
	private long metaMillis;
	
	//	Constructors
	public HiloTemporizador(int idTemp, int metaSegundos) {
		super();
		this.idTemp = idTemp;
		this.temp = new Temporizador();
		this.metaMillis = metaSegundos * 1000;
	}
	
	//	Methods
	@Override
	public void run() {
		while (temp.getMillis() < metaMillis)
		{
			/*
			if (temp.getMillis() % 1000 == 0)
				System.out.println((metaMillis - temp.getMillis()) / 1000);
			*/
			temp.advance(100);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Temporizador " + idTemp + " ha terminado.");
	}
	
	//	Getters & Setters
	public Temporizador getTemp() {
		return temp;
	}

	public void setTemp(Temporizador temp) {
		this.temp = temp;
	}

	public long getMetaMillis() {
		return metaMillis;
	}

	public void setMetaMillis(long metaMillis) {
		this.metaMillis = metaMillis;
	}
	
}
