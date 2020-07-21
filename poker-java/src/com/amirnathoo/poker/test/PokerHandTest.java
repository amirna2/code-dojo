package com.amirnathoo.poker.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.amirnathoo.poker.Card;
import com.amirnathoo.poker.PokerHand;

class PokerHandTest {

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

}
