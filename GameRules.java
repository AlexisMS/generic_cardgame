package generic_cardgame;

import java.util.*;

interface GameRules(){
	//boolean gameover = false;

	void setup(); //initial game state. Instance the deck(s), player(s) and whatever more the game may require
	int score(); //for use with Player.addScore(), so this function should return the score added (or subtracted) from the player's current score
	boolean endgame(); //checks any condition required to end the game, returning this.gameover set to true if the game is over and the players won't be able to take any actions
}