package com.sdiezg.tcp.guessinggame;

public class Juego {
	//	Attributes
	private int secretNum;
	private boolean fin;
	private int numPlayers;
	
	//	Constructors
	public Juego(int secretNum) {
		this.secretNum = secretNum;
		this.fin = false;
		this.numPlayers = 0;
	}
	
	//	Methods
	
	
	//	Getters & Setters
	public int getSecretNum() {
		return secretNum;
	}

	public void setSecretNum(int secretNum) {
		this.secretNum = secretNum;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}
	
}
