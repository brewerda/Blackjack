import java.awt.*;
import java.applet.*;

import javax.swing.*;
import java.awt.event.*;

public class BlackjackApplet extends Applet implements ActionListener{
	private JButton hit,stay,reset;
	private JLabel bust;
	private int value = 0;
	private JLabel win,lost;
	private String answer;



	private Deck table;
	private Hand player;
	private Hand dealer;
	private int totalCards;


	public void init() {
		//super();


		int total = 0;
		table = new Deck();
		player = new Hand();
		dealer = new Hand();
		table.shuffle();
		player.addACard(table.deal());
		dealer.addACard(table.deal());
		player.addACard(table.deal());
		dealer.addACard(table.deal());

	

		String title = "Hit";

		hit = new JButton(title);
		hit.setActionCommand(title);
		hit.addActionListener(this);
		this.add(hit);

		title = "Stay";
		stay = new JButton(title);
		stay.setActionCommand(title);
		stay.addActionListener(this);
		this.add(stay);
		
		title = "New Game";
		reset = new JButton(title);
		reset.setActionCommand(title);
		reset.addActionListener(this);
		this.add(reset);




	}

	public Deck getTable() {
		return this.table;
	}
	public Hand getPlayer() {
		return this.player;
	}
	public void setTable(Deck table) {
		this.table = table;
	}
	public void setPlayer(Hand player) {
		this.player = player;
	}

	public void actionPerformed(ActionEvent ae) {

		 if("Hit".equals(ae.getActionCommand())) {
		 	int playerTotal = player.getValue();
		 	if(playerTotal < 21) {
		 		player.addACard(table.deal());
		 		repaint();
		 	} else if(playerTotal > 21) {
		 		bust = new JLabel("Bust");
		 		bust.setFont(new Font("sansserif", Font.BOLD, 32));
		 		this.add(bust);
		 		repaint();
		 	}
		 } else if("Stay".equals(ae.getActionCommand())) {
		 	int dealertotal = dealer.getValue();
		 	while(dealertotal < 17) {
		 		dealer.addACard(table.deal());
		 		dealertotal = dealer.getValue();
		 	}
		 }else if("New Game".equals(ae.getActionCommand())) {
		 	init();
		 	repaint();
		 }


	}


	public void paint(Graphics g) {
		super.paint(g);
		player.drawPlayer(g);

		dealer.drawDealerFirst(g);
		g.drawString(answer, 200, 400);
	}


}