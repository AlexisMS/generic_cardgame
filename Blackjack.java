package generic_cardgame;

import java.util.*;

class Blackjack implements GameRules{

	boolean gameover;
	Player player;
	Player dealer;
	Deck deck;

	Blackjack(){
		this.setup();
	}

	@Override
	void setup(){
		gameover = false;
		player = new Player();
		dealer = new Player();
		deck = new Deck();
	}

	@Override
	int score(int score, ArrayList<String> playerhand){
		int new_score = 0;
		ArrayList<String> hand = playerhand;
		for(int i=0; i<hand.size(); i++){
			switch (hand.get(i)){
				case "Ac" : case "Ad" : case "Ah" : case "As" :
					new_score += 1;
					break;
				case "2c" : case "2d" : case "2h" : case "2s" :
					new_score += 2;
					break;
				case "3c" : case "3d" : case "3h" : case "3s" :
					new_score += 3;
					break;
				case "4c" : case "4d" : case "4h" : case "4s" :
					new_score += 4;
					break;
				case "5c" : case "5d" : case "5h" : case "5s" :
					new_score += 5;
					break;
				case "6c" : case "6d" : case "6h" : case "6s" :
					new_score += 6;
					break;
				case "7c" : case "7d" : case "7h" : case "7s" :
					new_score += 7;
					break;
				case "8c" : case "8d" : case "8h" : case "8s" :
					new_score += 8;
					break;
				case "9c" : case "9d" : case "9h" : case "9s" :
					new_score += 9;
					break;
				case "10c" : case "10d" : case "10h" : case "10s" :
					new_score += 10;
					break;
				case "Jc" : case "Jd" : case "Jh" : case "Js" :
					new_score += 10;
					break;
				case "Qc" : case "Qd" : case "Qh" : case "Qs" :
					new_score += 10;
					break;
				case "Kc" : case "Kd" : case "Kh" : case "Ks" :
					new_score += 10;
					break;
				default : System.out.println("ERROR: invalid card value");
					break;
			}
		}
		if(hand.contains("Ac") || hand.contains("Ad") || hand.contains("Ah") || hand.contains("As")){ //aditional calculation required for when the A rule comes up (A can be either 1 or 11)
			int temp_score = new_score + 10;
			if (temp_score < 22)
				new_score = temp_score;
		}
		return (new_score - score);
	}

	@Override
	boolean endgame(){

	}
}