public class Deck {

	private int value;
	private String name;


	public Deck() {
		spades = new Suit();
		diamonds = new Suit();
		
	}

	public void Suit() {
		Card ace = new Card("Ace", 1, 11);
		Card two = new Card("Two", 2);
		Card three = new Card("Three", 3);
		Card four = new Card("Four", 4);
		Card five = new Card("Five", 5);
		Card six = new Card("Six", 6);
		Card seven = new Card("Seven", 7);
		Card eight = new Card("Eight", 8);
		Card nine = new Card("Nine", 9);
		Card ten = new Card("Ten", 10);
		Card jack = new Card("Jack", 10);
		Card queen = new Card("Queen", 10);
		Card king = new Card("King", 10);
	}


}