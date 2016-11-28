//(most of) this file was written by Valdivino Morais

//package poker;

import java.util.*;

public class Poker {

	public static void main(String[] args) {

		Rules rules = new Rules();
		rules.playerHit();
		rules.dealerHit();

		ArrayList<String> playerhand = rules.getPlayerHand();
		ArrayList<String> dealerhand = rules.getDealerHand();

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
		String result = rodada.comparaMaos();
		System.out.println(result);
	}

}
