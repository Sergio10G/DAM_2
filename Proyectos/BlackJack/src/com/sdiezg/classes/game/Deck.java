package com.sdiezg.classes.game;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	//	Attributes
	private List<Card> cards;
	
	//	Constructors
	public Deck() {
		this.cards = new ArrayList<Card>();

		renew();
	}
	
	//	Methods
	public void renew(){
		CardSuit[] suits = CardSuit.values();
		
		cards.clear();
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++) {
				cards.add(new Card(j, suits[i]));
			}
		}
	}

	public void renew(int numOfDecks){
		CardSuit[] suits = CardSuit.values();
		
		cards.clear();
		for (int x = 0; x < numOfDecks; x++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= 13; j++) {
					cards.add(new Card(j, suits[i]));
				}
			}
		}
	}

	public void shuffle() {
		List<Card> tempDeck = cards;
		cards = new ArrayList<Card>();

		while (tempDeck.size() > 0) {
			int index = (int) (Math.random() * tempDeck.size());
			cards.add(tempDeck.get(index));
			tempDeck.remove(index);
		}
	}

	public Card deal() {
		if (cards.size() == 0)
			return null;
		Card c = cards.get(0);
		cards.remove(0);
		return c;
	}

	@Override
	public String toString() {
		String s = "[Deck]\n";
		for (Card card : cards) {
			s += "  " + card + "\n";
		}
		s += "[Deck]";
		return s;
	}
	
	//	Getters & Setters
	public List<Card> getCards() {
		return cards;
	}
	
}
