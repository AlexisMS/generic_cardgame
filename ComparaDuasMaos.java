//package poker;

public class ComparaDuasMaos {
	String mao1 = "", mao2 = "";

	public ComparaDuasMaos(String mao1, String mao2) {
		//super();
		this.mao1 = mao1;
		this.mao2 = mao2;
	}

	String comparaMaos(){
		if(valorInteiroMao(mao1)<valorInteiroMao(mao2)){
			return "*** Jogador1: "+mao1+ " ***** Jogador2: "+mao2+" *** \n"
			+ "Jogador2 venceu";
		}else{
			return "*** Jogador1: "+mao1+ " ***** Jogador2: "+mao2+" *** \n"
			+ "Jogador1 venceu";
		} 
	}
	int valorInteiroMao(String mao){
		int n;
		if(mao.equals("royalFlush")){
			n = 10;
		}else if(mao.equals("straightFlush")){
			n = 9;
		}else if(mao.equals("quadra")){
			n = 8;
		}else if(mao.equals("fullHouse")){
			n = 7;
		}else if(mao.equals("flush")){
			n = 6;
		}else if(mao.equals("sequencia")){
			n = 5;
		}else if(mao.equals("trinca")){
			n = 4;
		}else if(mao.equals("duasDuplas")){
			n = 3;
		}else if(mao.equals("dupla")){
			n = 2;
		}else{
			n = 1;
		}
		return n;
	}
}