package com.sdiezg.classes.game;

public class Card {
	//	Attributes
	private int value;
	private CardSuit suit;
	private String name;
	
	//	Constructors
	public Card(int value, CardSuit suit) {
		this.value = value;
		this.suit = suit;
		this.name = "ERROR (" + value + ")";

		if (value > 1 && value < 11)
			this.name = Integer.toString(value);
		else {
			if (value == 1)
				this.name = "Ace";
			else if (value == 11)
				this.name = "Jack";
			else if (value == 12)
				this.name = "Queen";
			else if (value == 13)
				this.name = "King";
		}
	}
	
	//	Methods
	@Override
	public String toString() {
		return "[" + name + " of " + this.getSuitStr() + "]";
	}

	private String getSuitStr() {
		String suitStr = null;
		switch (this.suit) {
			case SPADES:
				suitStr = "Spades";
				break;
			case HEARTS:
				suitStr = "Hearts";
				break;
			case CLUBS:
				suitStr = "Clubs";
				break;
			case DIAMONDS:
				suitStr = "Diamonds";
				break;
		}
		return suitStr;
	}
	
	//	Getters & Setters
	public int getValue() {
		return value;
	}

	public CardSuit getSuit() {
		return suit;
	}

	public String getName() {
		return name;
	}
	
}
