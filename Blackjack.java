package generic_cardgame;

import java.util.*;

class Blackjack implements GameRules{

	boolean gameover;

	Blackjack(){
		this.setup();
	}

	@Override
	void setup(){
		gameover = false;
	}

	@Override
	int score(){

	}

	@Override
	boolean endgame(){

	}
}