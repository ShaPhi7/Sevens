package Shaun.sevens.Game;

public enum CardSuit {
	DIAMONDS("Diamonds"),
	SPADES("Spades"),
	HEARTS("Hearts"),
	CLUBS("Clubs");
	
	private final String cardSuitText;

	CardSuit(String cardSuitText) {
		this.cardSuitText = cardSuitText;
	}
	
	public String getCardSuitText() {
		return cardSuitText;
	}
}
