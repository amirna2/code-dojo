package com.amirnathoo.poker.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.amirnathoo.poker.Card;


class CardTest {

	@DisplayName("Creates a default card")
	@Test
	void createDefaultCard() {
		Card card = new Card();
		
		assertEquals(card.getRank(), 0);
		assertEquals(card.getSuit(), 0);
	}

	@DisplayName("Creates a card with given suit & rank")
	@Test
	void createCardWithGivenSuiteAndRank() {
		// A Jack of Diamond
		Card card = new Card(Card.J, Card.DIAMOND);
		
		assertEquals(card.getRank(), Card.J);
		assertEquals(card.getSuit(), Card.DIAMOND);
	}
	
	
	@DisplayName("Test that 2 cards are identical")
	@Test
	void compareTwoIdenticalCards() {
		// A Jack of Diamond
		Card card1 = new Card(Card.J, Card.DIAMOND);
		Card card2 = new Card(Card.J, Card.DIAMOND);

		assertTrue(card1.equals(card2));
	}
	
	@DisplayName("Test that 2 cards suits are different")
	@Test
	void compareTwoCardsWithdDifferentSuits() {
		
		Card card1 = new Card(Card.J, Card.CLUB);
		Card card2 = new Card(Card.J, Card.DIAMOND);

		assertFalse(card1.equals(card2));
	}
	
	@DisplayName("Test that 2 cards ranks are different")
	@Test
	void compareTwoCardsWithdDifferentRanks() {
		
		Card card1 = new Card(Card.K, Card.CLUB);
		Card card2 = new Card(Card.J, Card.CLUB);

		assertFalse(card1.equals(card2));
	}
	
	@DisplayName("Test that 2 cards suits & ranks are different")
	@Test
	void compareTwoCardsWithdDifferentRanksAndSuits() {
		
		Card card1 = new Card(Card.K, Card.DIAMOND);
		Card card2 = new Card(Card.J, Card.CLUB);

		assertFalse(card1.equals(card2));
	}
}
