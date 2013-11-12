import java.awt.Graphics;



public class Hand {	
	private int totalValue = 0;
	
	Card[] hand = new Card[11];
	private Deck cards;
	public Hand(Deck cards) {
		this.cards = cards;
		// for (int i=0; i < 11; i++) {
		// 	int totalValue = 0;

		// 	totalValue += cards[i].getValue();
		// 	if(totalValue < 21) {
		// 		hand[i] = cards[i];
		// 	}
		// }
		for (int i=0; i<11; i++) {
			

			if(totalValue < 21) {
				hand[i] = cards[i];
				totalValue += cards[i].value();
			}
		}

	}
	public void deal(Graphics g, int amount) {
		cards.draw(g, 0);
		cards.draw(g, 50);
	}

}