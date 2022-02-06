package Shaun.sevens.Game;

import java.util.Vector;

/**
 * A (human) player of the game. Computer players can just override the selectValidCardToPlay method.
 */
public class Player {
	
	private final String name;
	private Vector<Card> cardsInHand = new Vector<Card>();
	private int score = 0;

	public Player(String name) {
		this.name = name;
	}

	public Card selectValidCardToPlayReturningNullIfNoneAreValid(Vector<Card> playedCards)
	{	
		printCardsInHand();
		
		Card cardToPlay = null;
		
		Vector<Card> validCardsToPlay = getValidCardsToPlay(playedCards);
		if (!validCardsToPlay.isEmpty())
		{
			while (cardToPlay == null)
			{
				System.out.println("Enter the number of the card you wish to play.");
				System.out.println("e.g. entering '5' means playing the card at 5) in the list.");
				String cardToPlayStr = Sevens.scanner.nextLine();
				cardToPlayStr.replace(")", ""); //just in case user enters 5), instead of '5'.
				Card cardUserIntendsToPlay = null;
				try {
					Integer cardToPlayInt = Integer.valueOf(cardToPlayStr);
					if (cardToPlayInt > 0
					  && cardToPlayInt < cardsInHand.size() + 1) 
					{
						//the list we give user starts from 1, not 0.
						cardUserIntendsToPlay = cardsInHand.elementAt(cardToPlayInt - 1);
					}
				}
				catch (NumberFormatException e){} //user entered rubbish, get them to pick again.
				
				if (cardUserIntendsToPlay != null
				  && cardUserIntendsToPlay.isValidToPlay(playedCards))
				{
					cardToPlay = cardUserIntendsToPlay;
				}
				else
				{
					System.out.println("Doing that is not a valid move!");
				}
			}
		}
		else
		{
			System.out.println("There are no cards that you can play!");
		}
		return cardToPlay; 
	}
	
	private void printCardsInHand() {
		System.out.println("You have the following cards in your hand: ");
		
		for (int i=1;i<=cardsInHand.size();i++)
		{
			Card card = cardsInHand.get(i-1);
			System.out.println(i + ") " + card.toString());
		}
	}

	public boolean hasWon()
	{
		return cardsInHand.isEmpty(); //a player wins once all cards are played
	}
	
	public Vector<Card> getValidCardsToPlay(Vector<Card> playedCards)
	{
		Vector<Card> ret = new Vector<Card>();
		
		for (Card cardInHand : cardsInHand)
		{
			if (cardInHand.isValidToPlay(playedCards))
			{
				ret.add(cardInHand);
			}
		}
		return ret;
	}

	public int getNumberOfCardsInHand() {
		return cardsInHand.size();
	}
	
	public Vector<Card> getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(Vector<Card> cardsInHand) {
		this.cardsInHand = cardsInHand;
	}

	public void addCardToHand(Card cardToAdd) {
		Vector<Card> cardsCurrentlyInHand = getCardsInHand();
		cardsCurrentlyInHand.add(cardToAdd);
		
		//probably not efficient to do this each time here but vector is small
		//and it feels more future proof to do it here.
		cardsCurrentlyInHand = Card.sortCards(cardsCurrentlyInHand);
		
		setCardsInHand(cardsCurrentlyInHand);
	}
	
	public void clearCardsInHand()
	{
		cardsInHand = new Vector<Card>();
	}
	
	public String getName() {
		return name;
	}

	public boolean hasCardInHand(CardSuit suit, CardValue value)
	{
		for (Card cardInHand : getCardsInHand())
		{
			if (cardInHand.getSuit().equals(suit)
			  && cardInHand.getValue().equals(value))
			{
				return true;
			}
		}	
		return false;
	}

	public void playCard(Card cardToPlay, Vector<Card> playedCards)
	{
		getCardsInHand().remove(cardToPlay);
		playedCards.add(cardToPlay);
	}

	public void playCard(CardSuit suit, CardValue value, Vector<Card> playedCards)
	{
		Card cardToPlay = getSpecificCardInHand(suit, value);
		if (cardToPlay != null)
		{
			playCard(cardToPlay, playedCards);
		}
	}

	private Card getSpecificCardInHand(CardSuit suit, CardValue value)
	{
		for (Card cardInHand : getCardsInHand())
		{
			if (cardInHand.getSuit().equals(suit)
			  && cardInHand.getValue().equals(value))
			{
				return cardInHand;
			}
		}
		return null;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
