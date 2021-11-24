package com.sdiezg.classes.game;

import java.util.ArrayList;
import java.util.List;

public class Player {
	//	Attributes
	private List<Card> cards;
	private String name;
	
	//	Constructors
	public Player(String name) {
		this.name = name;
		this.cards = new ArrayList<Card>();
	}
	
	//	Methods

	public void receiveCard(Card card) {
		this.cards.add(card);
	}

	@Override
	public String toString() {
		return "Player [cards=" + cards + ", name=" + name + "]";
	}

	//	Getters & Setters
	public List<Card> getCards() {
		return cards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
