package Shaun.sevens.Game;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.*;

public class DeckOfCardsTest
{
	@Test
	public void testCreateCards() {
		DeckOfCards testDeck = new DeckOfCards();
		
		Vector<Card> result = testDeck.createCards();
		
		Vector<Card> expected = createCardsLongWay();
		
		assertEquals(expected, result);
	}

	private Vector<Card> createCardsLongWay() {
		Vector<Card> cards = new Vector<Card>();
		
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.TWO));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.THREE));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.FOUR));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.FIVE));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.SIX));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.SEVEN));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.EIGHT));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.TEN));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.JACK));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.QUEEN));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.KING));
		cards.add(new Card(CardSuit.DIAMONDS, CardValue.ACE));
	
		cards.add(new Card(CardSuit.SPADES, CardValue.TWO));
		cards.add(new Card(CardSuit.SPADES, CardValue.THREE));
		cards.add(new Card(CardSuit.SPADES, CardValue.FOUR));
		cards.add(new Card(CardSuit.SPADES, CardValue.FIVE));
		cards.add(new Card(CardSuit.SPADES, CardValue.SIX));
		cards.add(new Card(CardSuit.SPADES, CardValue.SEVEN));
		cards.add(new Card(CardSuit.SPADES, CardValue.EIGHT));
		cards.add(new Card(CardSuit.SPADES, CardValue.NINE));
		cards.add(new Card(CardSuit.SPADES, CardValue.TEN));
		cards.add(new Card(CardSuit.SPADES, CardValue.JACK));
		cards.add(new Card(CardSuit.SPADES, CardValue.QUEEN));
		cards.add(new Card(CardSuit.SPADES, CardValue.KING));
		cards.add(new Card(CardSuit.SPADES, CardValue.ACE));
		
		cards.add(new Card(CardSuit.HEARTS, CardValue.TWO));
		cards.add(new Card(CardSuit.HEARTS, CardValue.THREE));
		cards.add(new Card(CardSuit.HEARTS, CardValue.FOUR));
		cards.add(new Card(CardSuit.HEARTS, CardValue.FIVE));
		cards.add(new Card(CardSuit.HEARTS, CardValue.SIX));
		cards.add(new Card(CardSuit.HEARTS, CardValue.SEVEN));
		cards.add(new Card(CardSuit.HEARTS, CardValue.EIGHT));
		cards.add(new Card(CardSuit.HEARTS, CardValue.NINE));
		cards.add(new Card(CardSuit.HEARTS, CardValue.TEN));
		cards.add(new Card(CardSuit.HEARTS, CardValue.JACK));
		cards.add(new Card(CardSuit.HEARTS, CardValue.QUEEN));
		cards.add(new Card(CardSuit.HEARTS, CardValue.KING));
		cards.add(new Card(CardSuit.HEARTS, CardValue.ACE));

		cards.add(new Card(CardSuit.CLUBS, CardValue.TWO));
		cards.add(new Card(CardSuit.CLUBS, CardValue.THREE));
		cards.add(new Card(CardSuit.CLUBS, CardValue.FOUR));
		cards.add(new Card(CardSuit.CLUBS, CardValue.FIVE));
		cards.add(new Card(CardSuit.CLUBS, CardValue.SIX));
		cards.add(new Card(CardSuit.CLUBS, CardValue.SEVEN));
		cards.add(new Card(CardSuit.CLUBS, CardValue.EIGHT));
		cards.add(new Card(CardSuit.CLUBS, CardValue.NINE));
		cards.add(new Card(CardSuit.CLUBS, CardValue.TEN));
		cards.add(new Card(CardSuit.CLUBS, CardValue.JACK));
		cards.add(new Card(CardSuit.CLUBS, CardValue.QUEEN));
		cards.add(new Card(CardSuit.CLUBS, CardValue.KING));
		cards.add(new Card(CardSuit.CLUBS, CardValue.ACE));
			
		return cards;
	}
}
