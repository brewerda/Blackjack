public class Card {
	private int value;
	private int value2;
	private String suit;

	public Card(int value, String suit) {
		this.suit = suit;
		this.value = value;
		// System.out.println("" + this.value + " of " + suit);
	}
	public Card(int value, int value2, String suit) {
		this.suit = suit;
		this.value = value;
		this.value2 = value2;
	}
	public int getValue() {
		return this.value;
	}
	public void setValue() {
		this.value = value;
	}
	public String getSuit() {
		return this.suit;
	}
	public void setSuit() {
		this.suit = suit;
	}
}