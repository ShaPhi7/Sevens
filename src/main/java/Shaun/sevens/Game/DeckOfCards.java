package Shaun.sevens.Game;

import java.util.Collections;
import java.util.Vector;

/**
 * The central deck of cards. Probably could have survived without this class but it
 * felt neater to tidy away related methods to here.
 */
public class DeckOfCards {
	
	private Vector<Card> cardsInDeck = createCardsAndShuffle();

	private Vector<Card> createCardsAndShuffle()
	{
		Vector<Card> ret = createCards();
		
		System.out.println("Currently shuffling cards...");
		GameOfSevens.pause();
		
		Collections.shuffle(ret);
		
		return ret;
	}

	protected Vector<Card> createCards()
	{
		Vector<Card> ret = new Vector<Card>();
		for (CardSuit suit : CardSuit.values())
		{
			for (CardValue value : CardValue.values())
			{
				ret.add(new Card(suit, value));
			}
		}
		return ret;
	}

	public Vector<Card> getCardsInDeck()
	{
		return cardsInDeck;
	}

	public void dealCardToPlayerIfNotEmpty(Player player)
	{
		if (!cardsInDeck.isEmpty())
		{
			Card cardToDeal = cardsInDeck.firstElement();
			player.addCardToHand(cardToDeal);
			cardsInDeck.remove(cardToDeal);
		}
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
		return this.cardsInDeck.equals(((DeckOfCards)obj).cardsInDeck);
		}
}
