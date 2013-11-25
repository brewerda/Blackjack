import java.awt.*;
import java.applet.*;

import javax.swing.*;
import java.awt.event.*;

public class BlackjackApplet extends Applet implements ActionListener{
	private JButton hit,stay,reset, down, bet;
	private JLabel bust;
	private int value = 0;
	private JLabel win,lost, walletLabel, potLabel, score;
	private String answer;



	private Deck table;
	private Hand player;
	private Hand dealer;
	private int totalCards;
	private int wallet, pot, dealerwallet;
	private int playerWin = 0;
	private int dealerWin = 0;


	public void init() {
		

		setWallet(1000);
		setPot(0);

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


		walletLabel = new JLabel("You have $" + wallet + " dollars.");
		walletLabel.setFont(new Font("sansserif", Font.BOLD, 32));
		this.add(walletLabel);

		potLabel = new JLabel("There is $" + getpot() + " in the pot");
		potLabel.setFont(new Font("sansserif", Font.BOLD, 32));
		this.add(potLabel);

		


	

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

		title = "Bet $10";
		bet = new JButton(title);
		bet.setActionCommand(title);
		bet.addActionListener(this);
		this.add(bet);

		title = "Double Down";
		down = new JButton(title);
		down.setActionCommand(title);
		down.addActionListener(this);
		this.add(down);
		
		title = "New Game";
		reset = new JButton(title);
		reset.setActionCommand(title);
		reset.addActionListener(this);
		this.add(reset);

		score = new JLabel("             Currently Playing");
		score.setFont(new Font("sansserif", Font.BOLD, 32));
		this.add(score);




	}
	public int getWallet() {
		return this.wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	public int getpot() {
		return this.pot;
	}
	public void setPot(int pot) {
		this.pot = pot;
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
		int playerTotal = player.getValue();
		 if("Hit".equals(ae.getActionCommand())) {
		 	if(playerTotal < 21) {
		 		player.addACard(table.deal());
		 		repaint();
		 	}
		 	playerTotal = player.getValue();
		 	if(playerTotal > 21) {
		 			setWallet(getWallet() - getpot());
		 			score.setText("You Busted! Dealer Wins");
		 	} if(playerTotal == 21) {
		 		setWallet(getWallet() + getpot());
		 		score.setText("You Win!!!!");
		 	}
		 	} 
			 else if("Stay".equals(ae.getActionCommand())) {
		 	int dealertotal = dealer.getValue();
		 	while(dealertotal < 17) {
		 		dealer.addACard(table.deal());
		 		dealertotal = dealer.getValue();
		 	}

		 }else if("New Game".equals(ae.getActionCommand())) {
		 	init();
		 	repaint();
		 }
		 if("Bet $10".equals(ae.getActionCommand())) {
		 	setWallet(getWallet() - 10);
		 	walletLabel.setText("You have $" + getWallet() + " dollars.");
		 	setPot(getpot() + 20);
		 	potLabel.setText("There is $" + getpot() + " in the pot.");
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