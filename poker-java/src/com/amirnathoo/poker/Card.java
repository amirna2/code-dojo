package com.amirnathoo.poker;

import java.util.Objects;


// Note: Card constructor validations are not part of this Kata

public class Card {
	
	
	// low cards
	public static final int Two = 2;
	public static final int Three = 3;
	public static final int Four = 4;
	public static final int Five = 5;
	public static final int Six = 6;
	public static final int Seven = 7;
	public static final int Eight= 8;
	public static final int Nine = 9;
	public static final int Ten = 10;
	
	
	// high cards
	public static final int J = 11;
	public static final int Q = 12;
	public static final int K = 13;
	public static final int A = 14;
		
	// suits
	public static final  int CLUB = 10;
	public static final  int DIAMOND = 20;
	public static final  int HEART = 30;
	public static final  int SPADE = 40;
		
	// Club=1, Diamond=2, Heart=3, Spade=4
	private int suit = 0;
	
	// 2, 3, 4...10...J=11, Q=12, K=13, A=14
	private int rank = 0;
	
	public Card() {}
			
	public Card(int rank, int suit) {
		this.suit = suit;
		this.rank = rank;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}

}
