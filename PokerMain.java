import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;

class Main {

	public static void main (String[] args){
		JFrame f;
	    f = new JFrame();
	    JPanel tela;
	    tela = new JPanel();

	    f.setContentPane(tela);
	    configTela(tela);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setSize(1600,600); //lar x alt
	    f.setVisible(true);
		}

	static void configTela(JPanel tela){
		JPanel playarea = new JPanel();
	  	playarea.setLayout(new BorderLayout(10,10));

	    JLabel r=new JLabel("POKER SIMULATOR", SwingConstants.CENTER);
	    r.setVerticalAlignment(SwingConstants.BOTTOM);

	    JPanel buttons = new JPanel();
	    JPanel centerhand = new JPanel();
	    JLabel card1 = new JLabel();
	    JLabel card2 = new JLabel();
	    JLabel card3 = new JLabel();
	    JLabel card4 = new JLabel();
	    JLabel card5 = new JLabel();
	    JLabel card1d = new JLabel();
	    JLabel card2d = new JLabel();
	    JLabel card3d = new JLabel();
	    JLabel card4d = new JLabel();
	    JLabel card5d = new JLabel();
	    JPanel cardDealer = new JPanel();

	    JButton b;
	    JLabel left = new JLabel("DEALER");
	    JLabel right = new JLabel("YOU");
	    JButton end = new JButton("STOP");
	    Rules rules = new Rules();

	    tela.setLayout(new BorderLayout(10,10));
	    tela.add(playarea,BorderLayout.CENTER);
	    playarea.add(r,BorderLayout.CENTER);
	    playarea.add(centerhand,BorderLayout.PAGE_END);
	    playarea.add(cardDealer,BorderLayout.PAGE_START);
	    centerhand.add(card1);
	    centerhand.add(card2);
	    centerhand.add(card3);
	    centerhand.add(card4);
	    centerhand.add(card5);
	    cardDealer.add(card1d);
	    cardDealer.add(card2d);
	    cardDealer.add(card3d);
	    cardDealer.add(card4d);
	    cardDealer.add(card5d);
	    tela.add(buttons,BorderLayout.PAGE_END);
	    buttons.add(b=new JButton("play"));


		b.addActionListener(new PokerStep(buttons,card1,card2,card3,card4,card5, card1d,card2d,card3d,card4d,card5d,left,right,r,b,end,tela,rules));


	}
}
