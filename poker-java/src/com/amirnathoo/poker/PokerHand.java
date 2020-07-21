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

	public boolean isRoyalFlush() {
		// is straight, flush and the last card is an ace.
		boolean r1, r2, r3;
		r1 = isFlush();
		r2 = isStraight();
		r3 = (cards[HAND_SIZE-1].getRank() == Card.A);
		return (r1 && r2 && r3);
	}

	public boolean isStraightFlush() {
		return (isFlush() && isStraight());
	}

	public boolean isFourOfaKind() {
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
		boolean r;
		r = cards[0].getSuit() == cards[1].getSuit() && cards[1].getSuit() == cards[2].getSuit()
				&& cards[2].getSuit() == cards[3].getSuit() && cards[3].getSuit() == cards[4].getSuit();

		return r;
	}

	public boolean isStraight() {
		boolean r = true;
		for (int i = 0; i < HAND_SIZE - 1; i++) {
			if (cards[i].getRank() != (cards[i + 1].getRank() - 1)) {
				r = false;
				break;
			}
		}
		return r;

	}

	public boolean isThreeOfAKind() {
		boolean r = false;
		if(isFourOfaKind() || isFullHouse()) {
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
		if(isFourOfaKind()) {
			return r;
		} 
		
		// x.x.y.y.z || x.y.y.z.z 
			
		r = (cards[0].getRank() == cards[1].getRank() && cards[2].getRank() == cards[3].getRank()) ||
			(cards[1].getRank() == cards[2].getRank() && cards[3].getRank() == cards[4].getRank());

		return r;
	}

	public boolean isOnePair() {
		boolean r = false;
		if(isThreeOfAKind() || isFourOfaKind() || isFullHouse() || isTwoPairs())
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
				&& !isFourOfaKind() && !isTwoPairs() && !isOnePair()) {
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
