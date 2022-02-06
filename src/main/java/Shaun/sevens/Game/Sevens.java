package Shaun.sevens.Game;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * main class to work out who our players are and kick off the game.
 */
public class Sevens {

	public static final Scanner scanner = new Scanner(System.in);
	
	private static Vector<Player> players = new Vector<Player>();
	
    public static void main( String[] args )
    {
        try
        {	
        	sayHiAndFindOutUsersName();
        	
        	playTheGame();
        	
        	sayGoodbye();
		} 
        catch (IOException e)
        {	
			e.printStackTrace();
			System.out.println("Hit unexpected error, the application will now terminate.");
		}
    }

	private static void sayGoodbye() {
		System.out.println("Thanks for playing!");
	}

	private static void playTheGame() {
		boolean keepPlaying = true;
		while (keepPlaying)
		{
			GameOfSevens game = new GameOfSevens(players);
			Player winner = game.playGameToDetermineWinner();
		
			declareWinner(winner);
			
			calculateAndShowScores();
			
			keepPlaying = isAnotherGameAndPrepared();
		}
	}

	private static void calculateAndShowScores()
	{
		calculateScores();
		
		showScores();
	}

	private static void showScores() {

		System.out.println("The current scores are (lower is better!):");
		
		for (Player player : players)
		{
			System.out.println(player.getName() + ": " + player.getScore());
		}
	}

	private static void calculateScores() {
		for (Player player : players)
		{
			int currentScore = player.getScore();
			int newScore = currentScore + player.getNumberOfCardsInHand();
			player.setScore(newScore);
		}
	}

	private static boolean isAnotherGameAndPrepared() {
		boolean keepPlaying = true;
		String userInput = "";
		
		System.out.println("That was fun! Enter 0 to close, or any character to play again!");
		userInput = scanner.nextLine();
		if (userInput.equals("0"))
		{
			keepPlaying = false;
		}
		else
		{
			//this is necessary to balance out which player get's extra cards.
			rotateFirstPlayer();
		}
		return keepPlaying;
	}

	private static void rotateFirstPlayer() {
		Player firstElement = players.firstElement();
		players.remove(firstElement);
		players.add(firstElement);
	}

	private static void sayHiAndFindOutUsersName() throws IOException
	{
		System.out.println("Welcome to the Sevens game! \n"
				+ "This game is currently for 3 players - yourself, against two computer opponents.\n"
				+ "The rules to the game can be found at https://www.wikihow.com/Play-Sevens-(Card-Game).");
		
		initPlayers();
	}
	
	private static void declareWinner(Player winner) {
		System.out.println(winner.getName() + " won the game!");
		
	}
	
	/**
	 * could easily make this section nicer to allow more than 3 players (human or computer) to play.
	 */
	private static void initPlayers() throws IOException
	{ 
		System.out.println("Please enter your name:");
		String userName = scanner.nextLine();
		players.add(new Player(userName));
		players.add(new PlayerComputerEasy("COM 1 (EASY)"));
		players.add(new PlayerComputerHard("COM 2 (HARD)"));
	} 
}
