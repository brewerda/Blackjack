import java.awt.*;
import java.applet.*;

public class BlackjackApplet extends Applet {
	private Deck table;
	private Hand player;

	public void init(Graphics g) {
		table = new Deck();
		player = new Hand(table, g);
		
	}

	public void paint(Graphics g) {
		// table.draw(g, 0,50, 51);
		table.shuffle();
		// table.draw(g, 200);
		player.hand(g,2);

	}
}