import java.awt.*;
import java.applet.*;

public class BlackjackApplet extends Applet {
	private Deck table;
	private Hand player;

	public void init() {
		table = new Deck();
		player = new Hand(table);
		
	}

	public void paint(Graphics g) {
		table.draw(g, 50);
		table.shuffle();
		// table.draw(g, 200);
		player.deal(g, 200);

	}
}