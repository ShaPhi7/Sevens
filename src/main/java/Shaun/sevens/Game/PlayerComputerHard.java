package Shaun.sevens.Game;

import java.util.Vector;

/**
 * This computer uses a basic strategy of playing the cards nearer the end of a stack than the middle.
 * e.g. if it has valid cards of 7, 8, 4, and King, then it is best to play the King, then 4, 8, and 
 * the worst card to play is a 7. This will hopefully means the opponent ends up with no valid cards to play.
 */
public class PlayerComputerHard extends Player {

	public PlayerComputerHard(String name) {
		super(name);
	}

	@Override
	public Card selectValidCardToPlayReturningNullIfNoneAreValid(Vector<Card> playedCards)
	{
		System.out.println(getName() + " is thinking...");
		GameOfSevens.pause();
		
		if (Math.random() * 10 < 1)
		{
			System.out.println(getName() + " is thinking really hard about this one...");
			GameOfSevens.pause();
		}
		
		Card cardToPlay = null;
		Vector<Card> validCardsToPlay = getValidCardsToPlay(playedCards);
		if (!validCardsToPlay.isEmpty())
		{
			cardToPlay = selectBestCardToPlay(validCardsToPlay);
		}
		return cardToPlay;
	}

	private Card selectBestCardToPlay(Vector<Card> validCardsToPlay)
	{
		Card cardToPlay = null;
		int currentBestDistance = -1;
		for (int i=0;i<validCardsToPlay.size();i++)
		{
			Card card = validCardsToPlay.get(i);
			int distanceFromSeven = card.getDistanceFromSeven();
			
			//in the case where two cards are equal distance from 7, I don't mind which get's played.
			//this could be improved further by checking playing cards that will help me be able to play
			//another card e.g. if both 10 hearts and 10 spades can be played, and I have Jack of spades,
			//then play the 10 spades.
			if (currentBestDistance < distanceFromSeven)
			{
				currentBestDistance = distanceFromSeven;
				cardToPlay = card;
			}
		}
		return cardToPlay;
	}	

}
