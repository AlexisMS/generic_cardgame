//package generic_cardgame;

import java.util.*;

class Player{
	private int score;
	private ArrayList<String> hand;
	private boolean status; //is this person a winner? (y/n)

	Player(){
		score = 0;
		hand = new ArrayList<String>();
		status = false; //you're a loser until proven otherwise
	}

	/*
	* HAND FUNCTIONS
	*/

	ArrayList<String> getHandList(){
		return hand;
	}

	String getHand(){
		return hand.toString();
	}

	void addHand(String card){
		hand.add(card);
	}

	void resetHand(){
		hand.clear();
	}

	/*
	* SCORE FUNCTIONS
	*/

	int getScore(){
		return score;
	}

	void addScore(int val){
		score+=val;
	}

	void resetScore(){
		score = 0;
	}

	/*
	* STATUS FUNCTIONS
	*/

	void victory(){
		this.status = true;
	}

	void defeat(){
		this.status = false;
	}

	boolean getStatus(){
		return status;
	}
	
}
