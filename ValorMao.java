//this file was written by Valdivino Morais

//package poker;

import java.util.*;


public class ValorMao {
//Deve ser alterado para conter as cartas do jogador
	ArrayList<String> cartaLista;
	String[] carta = {"Ac", "1d", "2h", "3s", "4c", "5d", "6h"};


//mudar
	public ValorMao(ArrayList<String> cartaLista) {
//super();
		this.reset(cartaLista);
	}


	String[] convertList(ArrayList<String> cartaLista){
		String[] cartas = new String[7];
		for(int i = 0; i < 7; i++){
			cartas[i] = cartaLista.get(i);
		}
		return cartas;

	}

	void reset(ArrayList<String> cartaLista){
		this.cartaLista = cartaLista;
		carta = convertList(cartaLista);
	}


	String classificaMao(){
		String valorMao;
		valorMao = "";
		if(checarRoyalFlush() == "royalFlush"){
			valorMao = "royalFlush";
		}else{
			if(checarStraightFlush() == "straightFlush"){
				valorMao = "straightFlush";
			}else{
				if(checarQuadra() == "quadra"){
					valorMao = "quadra";
				}else{
					if(checarFullHouse() == "fullHouse"){
						valorMao = "fullHouse";
					}else{
						if(checarFlush() == "flush"){
							valorMao = "flush";
						}else{
							if(checarSequencia() == "sequencia"){
								valorMao = "sequencia";
							}else{
								if(checarTrinca() == "trinca"){
									valorMao = "trinca";
								}else{
									if(checarDuasDuplas() == "duasDuplas"){
										valorMao = "duasDuplas";
									}else{
										if(checarDupla() == "dupla"){
											valorMao = "dupla";
										}else{
											valorMao = checarMaiorCarta();
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return valorMao;
	}
	String checarRoyalFlush(){
		if(((checarMaiorCarta()).equals("14"))&&(checarStraightFlush().equals("straightFlush"))){
			return "royalFlush";
		}else{
			return "nao";
		}
	}
	String checarMaiorCarta(){
		int[] a = new int[7];
		a = arrayNumeroCarta();
		Arrays.sort(a);
		int n = a[6];
		return ""+n;
	}
	String checarStraightFlush(){
		if((checarFlush().equals("flush"))&&(checarSequencia().equals("sequencia"))){
			return "straightFlush";
		}else{
			return "nao";
		}
	}
	String checarFlush(){
		String[] a = new String[7];
		a = arrayNaipeCarta();
		int cont0 = 0, cont1 = 0, cont2 = 0, cont3 = 0;
		for(int i = 0; i < 7; i++){
			if (a[i].equals("c")){
				cont0++;
			}
			if (a[i].equals("d")){
				cont1++;
			}
			if (a[i].equals("h")){
				cont2++;
			}
			if (a[i].equals("s")){
				cont3++;
			}
		}
		if((cont0 >= 5)||(cont1 >= 5)||(cont2 >= 5)||(cont3 >= 5)){
			return "flush";
		}else{
			return "nao";
		}
	}
	String checarQuadra(){
		String result = "nao";
		int[] a = new int[7];
		int[] cont = new int[13];
		a = arrayNumeroCarta();
		for(int j = 0; j < 13; j++){
			for(int i = 0; i < 5; i++){
				if (a[i] == j+1) cont[j]++;
			}
			if(cont[j] == 4) result = "quadra";
		}
		return result;
	}
	String checarFullHouse(){
		String result = "nao";
		if((checarTrinca().equals("trinca"))&&((checarDupla().equals("dupla"))||(checarDuasDuplas().equals("duasDuplas")))){
			result = "fullHouse";
		}
		return result;
	}
	String checarTrinca(){
		String result = "nao";
		int[] a = new int[7];
		int[] cont = new int[13];
		a = arrayNumeroCarta();
		for(int j = 0; j < 13; j++){
			for(int i = 0; i < 5; i++){
				if (a[i] == j+1) cont[j]++;
			}
			if(cont[j] == 3) result = "trinca";
		}
		return result;
	}
	String checarDuasDuplas(){
		String result = "nao";
		int[] a = new int[7];
		int[] cont = new int[13];
		int contDupla = 0;
		a = arrayNumeroCarta();
		for(int j = 0; j < 13; j++){
			for(int i = 0; i < 5; i++){
				if (a[i] == j+1) cont[j]++;
			}
		}
		for(int i = 0; i < 13; i++){
			if(cont[i] >= 2)contDupla++;
		}
		if (contDupla == 2){
			result = "duasDuplas";
		}
		return result;
	}
	String checarDupla(){
		String result = "nao";
		int[] a = new int[7];
		int[] cont = new int[13];
		int contDupla = 0;
		a = arrayNumeroCarta();
		for(int j = 0; j < 13; j++){
			for(int i = 0; i < 5; i++){
				if (a[i] == j+1) cont[j]++;
			}
		}
		for(int i = 0; i < 13; i++){
			if(cont[i] == 2)contDupla++;
		}
		if (contDupla == 1){
			result = "dupla";
		}
		return result;
	}
	String checarSequencia(){
		int[] a = new int[7];
		a = arrayNumeroCarta();
		Arrays.sort(a);
		int cont1 = 0, cont2 = 0, cont3 = 0;
		for(int i = 0; i < 4; i++){
			if (a[i + 1] - a[i] == 1) cont1++;
		}
		for(int i = 1; i < 5; i++){
			if (a[i + 1] - a[i] == 1) cont2++;
		}
		for(int i = 2; i < 6; i++){
			if (a[i + 1] - a[i] == 1) cont3++;
		}
		if((cont1 == 4)||(cont2 == 4)||(cont3 == 4)){
			return "sequencia";
		}else{
			return "nao";
		}
	}
	int[] arrayNumeroCarta(){
		int[] mao = new int[7];
		for(int i = 0; i < 7; i++){
			if((""+carta[i].charAt(0)).equals("A")){
				mao[i] = 14;
			}else if((""+carta[i].charAt(0)).equals("K")){
				mao[i] = 13;
			}else if((""+carta[i].charAt(0)).equals("Q")){
				mao[i] = 12;
			}else if((""+carta[i].charAt(0)).equals("J")){
				mao[i] = 11;
			}else{
				if(((""+carta[i].charAt(0)).equals("1"))&&((""+carta[i].charAt(1)).equals("0"))){
					mao[i] = 10;
				}else{
					mao[i] = Integer.parseInt(""+carta[i].charAt(0));
				}
			}
		}
		return mao;
	}
	String[] arrayNaipeCarta(){
		String[] mao = new String[7];
		for(int i = 0; i < 7; i++){
			if(((""+carta[i].charAt(0)).equals("1"))&&((""+carta[i].charAt(1)).equals("0"))){
				mao[i] = ""+carta[i].charAt(2);
			}else{
				mao[i] = ""+carta[i].charAt(1);
			}
		}
		return mao;
	}
}
