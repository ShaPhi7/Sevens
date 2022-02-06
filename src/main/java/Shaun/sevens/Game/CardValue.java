package Shaun.sevens.Game;

public enum CardValue {
	
	TWO("2", 0),
	THREE("3", 1),
	FOUR("4", 2),
	FIVE("5", 3),
	SIX("6", 4),
	SEVEN("7", 5),
	EIGHT("8", 6),
	NINE("9", 7),
	TEN("10", 8),
	JACK("Jack", 9),
	QUEEN("Queen", 10),
	KING("King", 11),
	ACE("Ace", 12); //Ace is "high"
	
	private final String cardValueText;
	private final int ordinal; //just used to easily order the cards where needed 

	CardValue(String cardValueText, int ordinal) {
		this.cardValueText = cardValueText;
		this.ordinal = ordinal;
	}
	
	public String getCardValueText() {
		return cardValueText;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}
