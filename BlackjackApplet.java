import java.awt.*;
import java.applet.*;

import javax.swing.*;
import java.awt.event.*;

public class BlackjackApplet extends Applet implements ActionListener{
	private JButton hit,stay,reset, down, bet, reduce;
	private JLabel bust;
	private int value = 0;
	private JLabel win,lost, walletLabel, potLabel, score;
	private String answer;



	private Deck table;
	private Hand player;
	private Hand dealer;
	private int totalCards;
	private int wallet, pot, dealerwallet, playerBet, playerTotal, dealerTotal;
	private int playerWin = 0;
	private int dealerWin = 0;
	private boolean front = false;
	private JLabel playerwin,dealerwin;


	public void startinit() {
			score.setText("                     		Currently Playing");

			playerBet = 0;
			setPot(0);
		 	int total = 0;
			table = new Deck();
			player = new Hand();
			dealer = new Hand();
			table.shuffle();
			player.addACard(table.deal());
			dealer.addACard(table.deal());
			player.addACard(table.deal());
			dealer.addACard(table.deal());
		 	playerTotal = player.getValue();
		 	dealerTotal = dealer.getValue();
		 	hit.setEnabled(false);
		 	stay.setEnabled(false);
		 	bet.setEnabled(true);
		 	reset.setEnabled(true);
		 	down.setEnabled(false);
		 	reduce.setEnabled(false);
	}
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
		walletLabel.setFont(new Font("sansserif", Font.BOLD, 24));
		this.add(walletLabel);

		potLabel = new JLabel("There is $" + getpot() + " in the pot");
		potLabel.setFont(new Font("sansserif", Font.BOLD, 24));
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

		title = "Reduce Bet";
		reduce = new JButton(title);
		reduce.setActionCommand(title);
		reduce.addActionListener(this);
		this.add(reduce);

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

		score = new JLabel("                     		Currently Playing");
		score.setFont(new Font("sansserif", Font.BOLD, 24));
		this.add(score);

		playerwin = new JLabel("Player Wins: " + playerWin);
		playerwin.setFont(new Font("sansserif", Font.BOLD, 24));
		this.add(playerwin);

		dealerwin = new JLabel("Dealer Wins: " + dealerWin);
		dealerwin.setFont(new Font("sansserif", Font.BOLD, 24));
		this.add(dealerwin);


		hit.setEnabled(false);
		stay.setEnabled(false);
		bet.setEnabled(true);
		reset.setEnabled(true);
		down.setEnabled(false);
		reduce.setEnabled(false);


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
		int dealerTotal = dealer.getValue();
		bet.setEnabled(false);
		 if("Hit".equals(ae.getActionCommand())) {

		 	if(playerTotal < 21) {
		 		player.addACard(table.deal());
		 		repaint();
		 	}
		 	playerTotal = player.getValue();
		 	  if(playerTotal > 21) {
		 	  		hit.setEnabled(false);
		 	 		setWallet(getWallet() - getpot());
		 	 		score.setText("You Busted! Dealer Wins");
		 	 		dealerWin++;
		 	 }else if(playerTotal == 21) {
		 	 	hit.setEnabled(false);
		 	 	setWallet(getWallet() + getpot());
		 	 	score.setText("21!!!!");
		 	 	playerWin++;
		 	 }
		 	 //else if(playerTotal > dealerTotal && dealerTotal < 21 && playerTotal <=21) {
		 	// 	setWallet(getWallet() + getpot());
		 	// 	score.setText("You Win!!!!");
		 	// }else if(dealerTotal > playerTotal && dealerTotal <=21 && playerTotal < 21) {
		 	// 	setWallet(getWallet() - getpot());
		 	// 	score.setText("You Lost");
		 	// }else if (dealerTotal == playerTotal) {
		 	// 	setWallet(getWallet());
		 	// 	score.setText("Draw");
		 	// }
		 	}else if("Stay".equals(ae.getActionCommand())) {
		 	int dealertotal = dealer.getValue();
		 	front = true;
		 	hit.setEnabled(false);
		 	down.setEnabled(false);

		 	while(dealertotal < 16 ) {
		 		dealer.addACard(table.deal());
		 		dealertotal=dealer.getValue();
		 		repaint();

		 		if(playerTotal > 21) {
		 			setWallet(getWallet() - getpot());
		 			score.setText("You Busted! Dealer Wins");
		 			dealerWin++;
		 	}else if(playerTotal == 21) {
		 		setWallet(getWallet() + getpot());
		 		score.setText("21!!!!");
		 		playerWin++;
		 	}else if(playerTotal > dealerTotal && dealerTotal < 21 && playerTotal <=21) {
		 		setWallet(getWallet() + getpot());
		 		score.setText("You Win!!!!");
		 		playerWin++;
		 	}else if(dealerTotal > playerTotal && dealerTotal <=21 && playerTotal < 21) {
		 		setWallet(getWallet() - getpot());
		 		score.setText("You Lost");
		 		dealerWin++;
		 	}else if (dealerTotal == playerTotal) {
		 		setWallet(getWallet());
		 		score.setText("Draw");
		 	}
		 	} if( dealertotal <= 21 && dealertotal >= 16) {
		 		dealertotal = dealer.getValue();
		 		repaint();


		 		if(playerTotal > 21) {
		 			setWallet(getWallet() - getpot());
		 			score.setText("You Busted! Dealer Wins");
		 			dealerWin++;
		 	}else if(playerTotal == 21) {
		 		setWallet(getWallet() + getpot());
		 		score.setText("21!!!!");
		 		playerWin++;
		 	}else if(playerTotal > dealerTotal && dealerTotal < 21 && playerTotal <=21) {
		 		setWallet(getWallet() + getpot());
		 		score.setText("You Win!!!!");
		 		playerWin++;
		 	}else if(dealerTotal > playerTotal && dealerTotal <=21 && playerTotal < 21) {
		 		setWallet(getWallet() - getpot());
		 		score.setText("You Lost");
		 		dealerWin++;
		 	}else if (dealerTotal == playerTotal) {
		 		setWallet(getWallet());
		 		score.setText("Draw");
		 	}
		 	}

		 }else if("New Game".equals(ae.getActionCommand())) {
		 	front = false;
		 	setWallet(getWallet());
		 	walletLabel.setText("You have $" + getWallet() + " dollars.");
		 	playerwin.setText("Player Wins: " + playerWin);
		 	dealerwin.setText("Dealer Wins: " + dealerWin);
		 	startinit();
		 	potLabel.setText("There is $" + getpot() + " in the pot.");
		 	repaint();

		 	
		 }
		 if("Double Down".equals(ae.getActionCommand())) {
		 	bet.setEnabled(false);
		 	hit.setEnabled(false);
		 	stay.setEnabled(false);
		 	front = true;
		 	setWallet(getWallet() - playerBet);
		 	walletLabel.setText("You have $" + getWallet() + " dollars.");
		 	setPot(getpot() + playerBet);
		 	potLabel.setText("There is $" + getpot() + " in the pot.");

		 	player.addACard(table.deal());
		 	repaint();

		 	playerTotal = player.getValue();
		 	if(playerTotal > 21) {
		 		setWallet(getWallet() - getpot());
		 		score.setText("You Busted! Dealer Wins");

		 	}else if (playerTotal == 21) {
		 		setWallet(getWallet() + getpot());
		 		score.setText("21!!!!");
		 	}else if (playerTotal > dealerTotal && dealerTotal < 21 && playerTotal <=21) {
		 		setWallet(getWallet() + getpot());
		 		score.setText("You Win!!!!");
		 	}else if (dealerTotal > playerTotal && dealerTotal <= 21 && playerTotal < 21) {
		 		setWallet(getWallet() - getpot());
		 		score.setText("You Lost.");
		 	}else if(dealerTotal == playerTotal) {
		 		setWallet(getWallet());
		 		score.setText("Draw");
		 	}
		 	repaint();

		 }
		 if("Bet $10".equals(ae.getActionCommand())) {
		 	hit.setEnabled(true);
		 	stay.setEnabled(true);
		 	reset.setEnabled(true);
		 	down.setEnabled(true);
		 	bet.setEnabled(true);
		 	reduce.setEnabled(true);

		 	setWallet(getWallet() - 10);
		 	walletLabel.setText("You have $" + getWallet() + " dollars.");
		 	setPot(getpot() + 20);
		 	potLabel.setText("There is $" + getpot() + " in the pot.");
		 	playerBet += 10;
		 	repaint();
		 }
		 if("Reduce Bet".equals(ae.getActionCommand())) {
		 	bet.setEnabled(true);
		 	if(getpot() >= 20) {
		 	setWallet(getWallet() + 10);
		 	walletLabel.setText("You have $" + getWallet() + " dollars.");
		 	setPot(getpot() - 20);
		 	potLabel.setText("There is $" + getpot() + " in the pot.");
		 	playerBet -= 10;
		 	repaint();
		 } else if(getpot() < 20) {
		 	score.setText("You have not committed any money to bet.");
		 }
		 }




	}


	public void paint(Graphics g) {
		super.paint(g);
		player.drawPlayer(g);
		if(front == true) {
			dealer.drawDealer(g);
		} else {
			dealer.drawDealerFirst(g);
		}

		
		//g.drawString(answer, 200, 400);
	}


}