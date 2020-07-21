package com.amirnathoo.poker;

public class PokerHand {
	
	private Card[] cards;
	
	public PokerHand(Card cards[]) {
		this.cards = cards;
		
	}
	
	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	
	boolean isRoyalFlush() {
		return false;
	}
	
	boolean isStriaghtFlush() {
		return false;
	}
	
	boolean isFourOfaKind() {
		return false;
	}
	
	boolean isFullHouse() {
		return false;
	}
	
	boolean isFlush() {
		return false;
	}
	
	boolean isStraight() {
		return false;
	}
	
	boolean isThreeOfAKind() {
		return false;
	}
	
	boolean isTwoPairs() {
		return false;
	}
	
	boolean isHighCard() {
		return false;
	}
	
	void sortHandBySuit() {
	}
	
	void sortHandByRank() {
		
	}
}
