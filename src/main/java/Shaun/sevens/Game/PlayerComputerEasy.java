package Shaun.sevens.Game;

import java.util.Vector;

/**
 * easy computer just keeps the game going by picking a valid card to play at random.
 */
public class PlayerComputerEasy extends Player {

	public PlayerComputerEasy(String name) {
		super(name);
	}

	@Override
	public Card selectValidCardToPlayReturningNullIfNoneAreValid(Vector<Card> playedCards)
	{	
		System.out.println(getName() + " is thinking...");
		GameOfSevens.pause();
		
		Card cardToPlay = null;
		Vector<Card> validCardsToPlay = getValidCardsToPlay(playedCards);
		if (!validCardsToPlay.isEmpty())
		{
			double random = Math.random() * validCardsToPlay.size();
			int randomIndex = (int) Math.floor(random);
			cardToPlay = validCardsToPlay.get(randomIndex);
		}
		return cardToPlay;
	}
}
