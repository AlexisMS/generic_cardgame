//package generic_cardgame;

import java.util.*;

class Rules{
//class Blackjack implements GameRules{

	boolean first;
	Player player;
	Player dealer;
	Deck deck;

	String result;

	Rules(){
		this.setup();
	}

	//@Override
	void setup(){
		first = true;
		player = new Player();
		dealer = new Player();
		deck = new Deck();

		this.playerHit();
		this.dealerHit();

		ArrayList<String> playerhand = this.getPlayerHand();
		ArrayList<String> dealerhand = this.getDealerHand();

		ArrayList<String> cartas1 = new ArrayList<String>();
		for (int i = 0; i<2; i++){
			cartas1.add(playerhand.get(i));
		}
		for (int i = 0; i<5; i++){
			cartas1.add(dealerhand.get(i));
		}
		ArrayList<String> cartas2 = new ArrayList<String>();
		for (int i = 2; i<4; i++){
			cartas2.add(playerhand.get(i));
		}
		for (int i = 0; i<5; i++){
			cartas2.add(dealerhand.get(i));
		}

		//String[] cartas1 = {"Ac", "1h", "2h", "10c", "Jc", "Qc", "Kc"};
		//String[] cartas2 = {"Jc", "1d", "2d", "3d", "4d", "5d", "6h"};
		ValorMao mao1 = new ValorMao(cartas1);
		String maoJogador1 = mao1.classificaMao();
		ValorMao mao2 = new ValorMao(cartas2);
		String maoJogador2 = mao2.classificaMao();

		ComparaDuasMaos rodada = new ComparaDuasMaos(maoJogador1, maoJogador2);
		result = rodada.comparaMaos();
	}

	String getResult(){
		return result;
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
