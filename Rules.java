//package generic_cardgame;

import java.util.*;

class Rules{
//class Blackjack implements GameRules{

	boolean first;
	Player player;
	Player dealer;
	Deck deck;

	Rules(){
		this.setup();
	}

	//@Override
	void setup(){
		first = true;
		player = new Player();
		dealer = new Player();
		deck = new Deck();
	}

	void notFirst(){
		first = false;
	}

	void first(){
		first = true;
	}

	boolean getFirst(){
		return first;
	}

	void reset(){
		first = true;
		player.resetHand();
		dealer.resetHand();
		deck.resetDeck();
	}

	ArrayList<String> getPlayerHand(){
		return player.getHandList();
	}


	ArrayList<String> getDealerHand(){
		return dealer.getHandList();
	}

	

	void playerHit(){
		player.addHand(deck.drawCard());
		player.addHand(deck.drawCard());
		player.addHand(deck.drawCard());
		player.addHand(deck.drawCard());
		
	}

	void dealerHit(){
		dealer.addHand(deck.drawCard());
		dealer.addHand(deck.drawCard());
		dealer.addHand(deck.drawCard());
		dealer.addHand(deck.drawCard());
		dealer.addHand(deck.drawCard());

		
	}
}
