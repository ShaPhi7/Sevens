package Shaun.sevens.Game;

import java.util.ListIterator;
import java.util.Vector;

/**
 * class controlling everything regarding playing the game once.
 */
public class GameOfSevens 
{
	private DeckOfCards deck = null;
	private Vector<Player> players = new Vector<Player>();
	private Player winner = null;
	
	public GameOfSevens(Vector<Player> players)
	{
		this.players = players;
	}
	
	public Player playGameToDetermineWinner()
	{
		init();
		
		Vector<Card> playedCards = new Vector<Card>();
		ListIterator<Player> playersListIterator = players.listIterator();
		
		Player player = null;
		takeFirstTurn(playersListIterator, playedCards);
		
		while (winner == null)
		{
			printPlayedCards(playedCards);
			
			if (!playersListIterator.hasNext())
			{
				playersListIterator = players.listIterator();
			}
			player = playersListIterator.next();
			
			System.out.println("\n" + "It is now " + player.getName() + "'s turn.");
			
			selectAndPlayCardIfPlayerHasValidCard(playedCards, player);
			
			if (player.hasWon())
			{
				winner = player;
			}
		}
		
		return winner;
	}

	private void takeFirstTurn(ListIterator<Player> playersListIterator, Vector<Card> playedCards) {
		
		Player player = playersListIterator.next();
		while (!player.hasCardInHand(CardSuit.DIAMONDS, CardValue.SEVEN))
		{
			player = playersListIterator.next();
		}
		player.playCard(CardSuit.DIAMONDS, CardValue.SEVEN, playedCards);
		
		System.out.println(player.getName() + " has the Seven of Diamonds, so plays that card first.");
	}

	private void selectAndPlayCardIfPlayerHasValidCard(Vector<Card> playedCards, Player player)
	{
		Card cardToPlay = player.selectValidCardToPlayReturningNullIfNoneAreValid(playedCards);
		if (cardToPlay != null)
		{
			player.playCard(cardToPlay, playedCards);
			System.out.println("\n" + player.getName() + " plays the " + cardToPlay.toString()
			+ " and has " + player.getNumberOfCardsInHand() + " cards left.");
		}
		else 
		{
			System.out.println("\n" + player.getName() + " knocks on the table - can't go!");
		}
	}

	private void printPlayedCards(Vector<Card> playedCards)
	{
		if (playedCards.isEmpty())
		{
			return;
		}
		
		StringBuilder sbCardsOnTable = getCardsOnTableString(playedCards);
		
		System.out.println(sbCardsOnTable.toString());
		pause();
	}

	private StringBuilder getCardsOnTableString(Vector<Card> playedCards)
	{
		StringBuilder sbCardsOnTable = new StringBuilder(); 
		sbCardsOnTable.append("\nThe following cards are now on the table:");
		
		playedCards = Card.sortCards(playedCards);
		
		for (CardSuit suit : CardSuit.values())
		{
			getCardsOnTableStringForSuit(sbCardsOnTable, suit, playedCards);
		}
		return sbCardsOnTable;
	}

	private void getCardsOnTableStringForSuit(StringBuilder sbCardsOnTable, CardSuit suit, Vector<Card> playedCards)
	{
		Vector<Card> allCardsOfSuitOnTable = Card.getAllCardsOfSuit(suit, playedCards);
		if (!allCardsOfSuitOnTable.isEmpty())
		{
			sbCardsOnTable.append("\n" + suit.getCardSuitText() + ":");

			for (int i=0;i<allCardsOfSuitOnTable.size();i++)
			{
				Card cardOnTable = allCardsOfSuitOnTable.get(i);
				sbCardsOnTable.append(" " + cardOnTable.getCardValueText());
			}
		}
	}

	private void init()
	{
		System.out.println("Starting the game - good luck!");
		
		for (Player player : players)
		{
			player.clearCardsInHand();
		}
		deck = new DeckOfCards();
		winner = null;
		
		
		dealCardsToPlayers();
	}

	private void dealCardsToPlayers() {
		
		int numberOfPlayers = players.size();
		
		while (!deck.getCardsInDeck().isEmpty())
		{
			for (int i=0;i<numberOfPlayers;i++)
			{
				Player player = players.get(i);
				deck.dealCardToPlayerIfNotEmpty(player);
			}
		}
		
		for (Player player : players)
		{
			System.out.println("Dealt " + player.getNumberOfCardsInHand() + " cards to " + player.getName() + ".");
		}
		pause();
	}

	/**
	 * only added this as a quick after-thought just because logging to 
	 * cli was too quick for the user to understand what was happening
	 */
	public static void pause() {
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
