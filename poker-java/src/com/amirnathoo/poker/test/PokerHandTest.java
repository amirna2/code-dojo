package com.amirnathoo.poker.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.amirnathoo.poker.Card;
import com.amirnathoo.poker.PokerHand;

class PokerHandTest {

	Card pair[] = {
		 new Card(Card.A, Card.CLUB),
		 new Card(Card.A, Card.HEART),
		 new Card(Card.Two, Card.DIAMOND),
		 new Card(Card.J, Card.SPADE),
		 new Card(Card.Five, Card.CLUB) 
	};
	
	Card doublePair[] = {
		 new Card(Card.A, Card.CLUB),
		 new Card(Card.A, Card.HEART),
		 new Card(Card.Q, Card.DIAMOND),
		 new Card(Card.Q, Card.SPADE),
		 new Card(Card.Five, Card.CLUB) 
	};
	
	Card ThreeOfAKind[] = {
			 new Card(Card.A, Card.CLUB),
			 new Card(Card.Q, Card.HEART),
			 new Card(Card.Q, Card.DIAMOND),
			 new Card(Card.Q, Card.SPADE),
			 new Card(Card.Five, Card.CLUB) 
	};
	
	Card FourOfAKind[] = {
			 new Card(Card.A, Card.CLUB),
			 new Card(Card.Q, Card.HEART),
			 new Card(Card.Q, Card.DIAMOND),
			 new Card(Card.Q, Card.SPADE),
			 new Card(Card.Q, Card.CLUB) 
	};
	
	Card flush[] = {
			 new Card(Card.K, Card.HEART),
			 new Card(Card.Q, Card.HEART),
			 new Card(Card.Two, Card.HEART),
			 new Card(Card.A, Card.HEART),
			 new Card(Card.J, Card.HEART) 
	};
	
	Card royalFlush[] = {
			 new Card(Card.Ten, Card.CLUB),
			 new Card(Card.K, Card.CLUB),
			 new Card(Card.Q, Card.CLUB),
			 new Card(Card.J, Card.CLUB),
			 new Card(Card.A, Card.CLUB) 
	};
	
	
	Card highCard[] = {
			 new Card(Card.K, Card.HEART),
			 new Card(Card.Two, Card.HEART),
			 new Card(Card.Five, Card.CLUB),
			 new Card(Card.Three, Card.SPADE),
			 new Card(Card.Six, Card.DIAMOND) 
	};
	
	@DisplayName("Creates a poker hand with 5 cards")
	@Test
	void createAPokerHand() {
		
		
		Card cards[] = { new Card(Card.A, Card.CLUB),
						 new Card(Card.A, Card.HEART),
						 new Card(Card.Two, Card.DIAMOND),
						 new Card(Card.J, Card.SPADE),
						 new Card(Card.Five, Card.CLUB) };
		PokerHand hand = new PokerHand(cards);
		
		assertNotNull(hand.getCards());
		assertEquals(hand.getCards()[0], new Card(Card.A, Card.CLUB));
		
	}
	
	@DisplayName("Sort hand by rank")
	@Test
	void sortHandByRankAscending() {
		Card cards[] = { new Card(Card.A, Card.CLUB),
				 new Card(Card.A, Card.HEART),
				 new Card(Card.Two, Card.DIAMOND),
				 new Card(Card.J, Card.SPADE),
				 new Card(Card.Five, Card.CLUB) };
		PokerHand hand = new PokerHand(cards);
		hand.sortByRankAscending();
		assertEquals(hand.getCards()[0].getRank(), Card.Two);
		assertEquals(hand.getCards()[PokerHand.HAND_SIZE - 1].getRank(), Card.A);
		

	}
	
	@DisplayName("Is a high card")
	@Test
	void testIsHighHand() {
		PokerHand hand = new PokerHand(highCard);
		assertTrue(hand.isHighCard());		
	}
	
	@DisplayName("Is not a high card")
	@Test
	void testIsNotHighHand() {
		PokerHand hand = new PokerHand(flush);
		assertFalse(hand.isHighCard());		
	}

}
