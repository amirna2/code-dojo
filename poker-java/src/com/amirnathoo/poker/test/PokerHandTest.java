package com.amirnathoo.poker.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.amirnathoo.poker.Card;
import com.amirnathoo.poker.PokerHand;

class PokerHandTest {

	Card singlePair[] = {
		 new Card(Card.A, Card.CLUB),
		 new Card(Card.A, Card.HEART),
		 new Card(Card.Two, Card.DIAMOND),
		 new Card(Card.J, Card.SPADE),
		 new Card(Card.Five, Card.CLUB) 
	};
	
	Card doublePairs[] = {
		 new Card(Card.A, Card.CLUB),
		 new Card(Card.A, Card.HEART),
		 new Card(Card.Q, Card.DIAMOND),
		 new Card(Card.Q, Card.SPADE),
		 new Card(Card.Five, Card.CLUB) 
	};
	
	Card threeOfAKind[] = {
			 new Card(Card.A, Card.CLUB),
			 new Card(Card.Q, Card.HEART),
			 new Card(Card.Q, Card.DIAMOND),
			 new Card(Card.Q, Card.SPADE),
			 new Card(Card.Five, Card.CLUB) 
	};
	
	Card fourOfAKind[] = {
			 new Card(Card.A, Card.CLUB),
			 new Card(Card.Q, Card.HEART),
			 new Card(Card.Q, Card.DIAMOND),
			 new Card(Card.Q, Card.SPADE),
			 new Card(Card.Q, Card.CLUB) 
	};
	
	Card straight[] = {
			 new Card(Card.Nine, Card.CLUB),
			 new Card(Card.Eight, Card.HEART),
			 new Card(Card.Seven, Card.DIAMOND),
			 new Card(Card.Six, Card.SPADE),
			 new Card(Card.Five, Card.CLUB) 
	};
	
	Card flush[] = {
			 new Card(Card.K, Card.HEART),
			 new Card(Card.Q, Card.HEART),
			 new Card(Card.Two, Card.HEART),
			 new Card(Card.A, Card.HEART),
			 new Card(Card.J, Card.HEART) 
	};
	
	Card straightFlush[] = {
			 new Card(Card.Ten, Card.HEART),
			 new Card(Card.Nine, Card.HEART),
			 new Card(Card.Eight, Card.HEART),
			 new Card(Card.Seven, Card.HEART),
			 new Card(Card.Six, Card.HEART) 
	};
	
	Card royalFlush[] = {
			 new Card(Card.Ten, Card.CLUB),
			 new Card(Card.K, Card.CLUB),
			 new Card(Card.Q, Card.CLUB),
			 new Card(Card.J, Card.CLUB),
			 new Card(Card.A, Card.CLUB) 
	};
	
	
	Card fullHouse[] = {
			 new Card(Card.K, Card.CLUB),
			 new Card(Card.K, Card.SPADE),
			 new Card(Card.Six, Card.CLUB),
			 new Card(Card.Six, Card.DIAMOND),
			 new Card(Card.Six, Card.HEART) 
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
		assertTrue(hand.getCards()[0].equals(new Card(Card.Two, Card.DIAMOND)));
		
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
	
	@DisplayName("Is single pair")
	@Test
	void testIsSinglePair() {
		PokerHand hand = new PokerHand(singlePair);
		assertTrue(hand.isOnePair());		
	}

	@DisplayName("Is not single pair")
	@Test
	void testIsNotSinglePair() {
		PokerHand hand = new PokerHand(fullHouse);
		assertFalse(hand.isOnePair());		
	}
	
	@DisplayName("Is double pairs")
	@Test
	void testIsDoublePairs() {
		PokerHand hand = new PokerHand(doublePairs);
		assertTrue(hand.isTwoPairs());		
	}

	@DisplayName("Is not double pairs")
	@Test
	void testIsNotDoublePair() {
		PokerHand hand = new PokerHand(fullHouse);
		assertFalse(hand.isTwoPairs());		
	}
	
	@DisplayName("Is full house")
	@Test
	void testIsFullHouse() {
		PokerHand hand = new PokerHand(fullHouse);
		assertTrue(hand.isFullHouse());		
	}
	
	@DisplayName("Is not a full house")
	@Test
	void testIsNotFullHouse() {
		PokerHand hand = new PokerHand(doublePairs);
		assertFalse(hand.isFullHouse());		
	}
	
	
	@DisplayName("Is three of a kind")
	@Test
	void testIsThreeOfAKind() {
		PokerHand hand = new PokerHand(threeOfAKind);
		assertTrue(hand.isThreeOfAKind());		
	}
	
	@DisplayName("Is not three of a kind")
	@Test
	void testIsNotThreeOfAKind() {
		PokerHand hand = new PokerHand(doublePairs);
		assertFalse(hand.isThreeOfAKind());		
	}
	
	@DisplayName("Is four of a kind")
	@Test
	void testIsFourOfAKind() {
		PokerHand hand = new PokerHand(fourOfAKind);
		assertTrue(hand.isFourOfAKind());		
	}
	
	@DisplayName("Is not four of a kind")
	@Test
	void testIsNotFourOfAKind() {
		PokerHand hand = new PokerHand(fullHouse);
		assertFalse(hand.isFourOfAKind());		
	}
	
	@DisplayName("Is royal flush")
	@Test
	void testIsRoyalFlush() {
		PokerHand hand = new PokerHand(royalFlush);
		assertTrue(hand.isRoyalFlush());		
	}
	
	@DisplayName("Is not royal flush")
	@Test
	void testIsNotRoyalFlush() {
		PokerHand hand = new PokerHand(flush);
		assertFalse(hand.isRoyalFlush());		
	}
	
	@DisplayName("Is flush")
	@Test
	void testIsFlush() {
		PokerHand hand = new PokerHand(flush);
		assertTrue(hand.isFlush());		
	}
	
	@DisplayName("Is not flush")
	@Test
	void testIsNotFlush() {
		PokerHand hand = new PokerHand(royalFlush);
		assertFalse(hand.isFlush());		
	}
	
	@DisplayName("Is straight flush")
	@Test
	void testIsStraightFlush() {
		PokerHand hand = new PokerHand(straightFlush);
		assertTrue(hand.isStraightFlush());		
	}
	
	@DisplayName("Is not straight flush")
	@Test
	void testIsNotStraightFlush() {
		PokerHand hand = new PokerHand(royalFlush);
		assertFalse(hand.isStraightFlush());		
	}
	
	@DisplayName("Is straight")
	@Test
	void testIsStraight() {
		PokerHand hand = new PokerHand(straight);
		assertTrue(hand.isStraight());		
	}
	
	@DisplayName("Is not straight")
	@Test
	void testIsNotStraight() {
		PokerHand hand = new PokerHand(royalFlush);
		assertFalse(hand.isStraight());		
	}
	
}
