package com.sergio10g.clases;

public class Temporizador {
	//	Attributes
	private long millis;
	
	//	Constructors
	public Temporizador() {
		this.millis = 0;
	}
	
	//	Methods
	public void advance(int adv) {
		this.millis += adv;
	}
	
	//	Getters & Setters
	public long getMillis() {
		return millis;
	}

	public void setMillis(long millis) {
		this.millis = millis;
	}
	
}
