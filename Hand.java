import java.awt.Graphics;



public class Hand {	
	private int totalValue = 0;
	
	private int amountOfCards;
	private Deck cards;
	public Hand(Deck cards, Graphics g) {
		int xOffset = 0;
		Card[] hand = new Card[11];
		this.cards = cards;
		int totalValue = 0;

		for (int i=0; i<hand.length; i++) {
			if( totalValue < 21) {
				dealPlayer(g,1);
			}
			totalValue += hand[i].getValue();
			xOffset += 25;
			// if(hitMe == 1) {
			// 	cards.draw(g, 50, 1);

			// }
		}
		this.amountOfCards = 0;
	}
	public void dealPlayer(Graphics g, int number) {
		cards.draw(g,0, 50, 1);
	}
	public void dealDealer(Graphics g,int number) {
		cards.draw(g,0, 200, 4);
	}

	// public int hitMe() {
	// 	//true ==1;
	// 	//false == 0;
	// }
    public void draw(Graphics g) {          
                for (int i=0; i<amountOfCards; i++) {
                	this.hand[i].draw(g, new Rectangle(x, 50, 200, 300));
                

               x+= 25;
                }
        }

}