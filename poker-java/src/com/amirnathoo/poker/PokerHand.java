package com.amirnathoo.poker;

public class PokerHand {

	public static final int HAND_SIZE = 5;

	private Card[] cards = new Card[HAND_SIZE];

	public PokerHand(Card cards[]) {
		for (int i = 0; i < HAND_SIZE; i++) {
			this.cards[i] = cards[i];
		}
		sortByRankAscending();
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	// Utility methods
	private boolean areCardsSameSuit() {
		boolean r = false;
		r = cards[0].getSuit() == cards[1].getSuit() && cards[1].getSuit() == cards[2].getSuit()
				&& cards[2].getSuit() == cards[3].getSuit() && cards[3].getSuit() == cards[4].getSuit();
		return r;
		
	}
		
	private boolean areCardsStraight() {
		boolean r = true;
		for (int i = 0; i < HAND_SIZE - 1; i++) {
			if (cards[i].getRank() != (cards[i + 1].getRank() - 1)) {
				r = false;
				break;
			}
		}
		return r;
	}
	
	private boolean isLastCardAnAce() {
		// This assumes cards are sorted in ascending order
		return (cards[HAND_SIZE-1].getRank() == Card.A);
	}

	// Evaluator methods
	public boolean isRoyalFlush() {
		boolean r1, r2, r3;
		r1 = areCardsSameSuit();
		r2 = areCardsStraight();
		r3 = isLastCardAnAce();
		return (r1 && r2 && r3);
	}
	
	public boolean isStraightFlush() {
		return (areCardsSameSuit() && areCardsStraight() && !isLastCardAnAce());
	}

	public boolean isFourOfAKind() {
		boolean r1, r2;

		// check for x.x.x.x.y || y.x.x.x.x
		r1 = (cards[0].getRank() == cards[1].getRank()) && (cards[1].getRank() == cards[2].getRank()) && (cards[2].getRank() == cards[3].getRank());
		r2 = (cards[1].getRank() == cards[2].getRank()) && (cards[2].getRank() == cards[3].getRank()) && (cards[3].getRank() == cards[4].getRank());

		return (r1 || r2);
	}
	
	public boolean isFullHouse() {
		boolean r1, r2;
		// check for x.x.y.y.y || x.x.x.y.y
		r1 = (cards[0].getRank() == cards[1].getRank()) &&
			 (cards[2].getRank() == cards[3].getRank()) &&
			 (cards[3].getRank() == cards[4].getRank());

		r2 = (cards[0].getRank() == cards[1].getRank()) &&
		     (cards[1].getRank() == cards[2].getRank()) &&
			 (cards[3].getRank() == cards[4].getRank());

		return (r1 || r2);
	}

	public boolean isFlush() {
		boolean r = false;
		
		if(isRoyalFlush() || isStraightFlush()) {
			return r;
		}
		
		r = areCardsSameSuit();
		
		return r;
	}
	
	public boolean isStraight() {
		return areCardsStraight() && !areCardsSameSuit();
	}
	
	public boolean isThreeOfAKind() {
		boolean r = false;
		if(isFourOfAKind() || isFullHouse()) {
			return r;
		}
		// x.x.x.y.z || y.x.x.x.z || y.z.x.x.x
		if ( (cards[0].getRank() == cards[1].getRank() && cards[1].getRank() == cards[2].getRank()) ||
				  (cards[1].getRank() == cards[2].getRank() && cards[2].getRank() == cards[3].getRank()) ||
				  (cards[3].getRank() == cards[2].getRank() && cards[3].getRank() == cards[4].getRank())) {
	        r = true;
		}
		return r;
	}

	public boolean isTwoPairs() {
		boolean r = false;
		if(isFourOfAKind() || isFullHouse()) {
			return r;
		} 
		
		// x.x.y.y.z || x.y.y.z.z 
			
		r = (cards[0].getRank() == cards[1].getRank() && cards[2].getRank() == cards[3].getRank()) ||
			(cards[1].getRank() == cards[2].getRank() && cards[3].getRank() == cards[4].getRank());

		return r;
	}

	public boolean isOnePair() {
		boolean r = false;
		if(isThreeOfAKind() || isFourOfAKind() || isFullHouse() || isTwoPairs())
		{
			return r;
		}
		// w.w.x.y.z || x.w.w.y.z || x.y.w.w.z || x.y.z.w.w
		if ( cards[0].getRank() == cards[1].getRank() || cards[1].getRank() == cards[2].getRank() ||
			 cards[2].getRank() == cards[3].getRank() || cards[3].getRank() == cards[4].getRank())
		{
			r = true;
		}
		return r;	
	}

	public boolean isHighCard() {
		boolean r = false;

		if (!isRoyalFlush() && !isFlush() && !isStraight() && !isFullHouse() && !isStraightFlush() && !isThreeOfAKind()
				&& !isFourOfAKind() && !isTwoPairs() && !isOnePair()) {
			r = true;
		}
		return r;
	}


	// Sort the hand by rank: e.g 2,3,4,...,10,J=11, Q=12,K=13,A=14
	public void sortByRankAscending() {
		int smallest;
		Card c;
		for (int i = 0; i < HAND_SIZE - 1; i++) {
			// find smallest card
			smallest = i;
			for (int j = i + 1; j < HAND_SIZE; j++) {
				if (cards[j].getRank() < cards[smallest].getRank()) {
					smallest = j;
				}
			}
			// swap it to the right spot
			c = cards[i];
			cards[i] = cards[smallest];
			cards[smallest] = c;
		}
	}
}
