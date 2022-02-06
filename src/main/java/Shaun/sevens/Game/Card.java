package Shaun.sevens.Game;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/**
 * Each card knows what it's suit (e.g. hearts) is and what it's value is (e.g. King)
 */
public class Card {

	private CardSuit suit = null;
	private CardValue value = null;

	public Card(CardSuit suit, CardValue value)
	{
		this.suit = suit;
		this.value = value;
	}
	
	@Override public String toString()
	{
		return getCardValueText() + " of " + getCardSuitText();
	}
	
	public boolean isValidToPlay(Vector<Card> playedCards)
	{
		//I can always play a 7
		if (getValue().equals(CardValue.SEVEN))
		{
			return true;
		}
		
		Vector<Card> allCardsOfSuit = getAllCardsOfSuit(getSuit(), playedCards);
		
		//I can only ever play cards with value one higher or one lower than that of a card
		//which is already played with the same suit. As the values of the cards of each suit
		//can only proceed in one direction, it is fine to just check both at once. e.g. if I am
		//trying to play an 8, I do not need to worry about whether a 9 has already been played as
		//as the 8 is required for the 9 to have been played (and vice versa for numbers < 7)
		for (Card cardToCheck : allCardsOfSuit)
		{
			if (Math.abs(this.getCardValueOrdinal() - cardToCheck.getCardValueOrdinal()) == 1)
			{
				return true;
			}
			else if (this.getCardValueOrdinal() == cardToCheck.getCardValueOrdinal())
			{
				System.out.println("You're trying to play an already played card, which should not be possible.");
			}
		}
		return false;
	}

	public static Vector<Card> getAllCardsOfSuit(CardSuit cardSuit, Vector<Card> cards) {
		Vector<Card> ret = new Vector<Card>();
		for (Card card : cards)
		{
			if (card.getSuit().equals(cardSuit))
			{
				ret.add(card);
			}
		}
		return ret;
	}
	
	public static Vector<Card> sortCards(Vector<Card> cards) {
		Vector<Card> sortedCards = new Vector<Card>();
		for (CardSuit suit : CardSuit.values())
		{
			Vector<Card> allCardsOfSuit = Card.getAllCardsOfSuit(suit, cards);
			Collections.sort(allCardsOfSuit, Card.COMPARE_BY_VALUE);
			sortedCards.addAll(allCardsOfSuit);
		}
		return sortedCards;
	}
	
	public static Comparator<Card> COMPARE_BY_VALUE = new Comparator<Card>()
	{
	    @Override
	    public int compare(Card c1, Card c2)
	    {
	        if (c1.getCardValueOrdinal() - c2.getCardValueOrdinal() > 0)
	        {
	        	return 1;
	        }
	        else if (c1.getCardValueOrdinal() - c2.getCardValueOrdinal() < 0)
	        {
	        	return -1;
	        }
	        else
	        {
	        	return 0;
	        }
	    }
	};
	
	/**
	 * getters/setters/helpers
	 */
	public CardSuit getSuit() {
		return suit;
	}

	public CardValue getValue() {
		return value;
	}
	
	public String getCardSuitText() {
		return getSuit().getCardSuitText();
	}
	
	public String getCardValueText() {
		return getValue().getCardValueText();
	}
	
	public int getCardValueOrdinal() {
		return getValue().getOrdinal();
	}

	public int getDistanceFromSeven() {
		int ordinalOfSeven = CardValue.SEVEN.getOrdinal();
		int ordinalOfCard = this.getCardValueOrdinal();
		return Math.abs(ordinalOfSeven - ordinalOfCard);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
		{
			return false;
		}
		
		if (!obj.getClass().equals(this.getClass()))
		{
			return false;
		}
		
		return this.getSuit().equals(((Card)obj).getSuit())
		  && this.getValue().equals(((Card)obj).getValue());
	}
}
