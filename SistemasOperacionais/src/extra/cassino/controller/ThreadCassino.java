package extra.cassino.controller;

import java.util.Random;

public class ThreadCassino extends Thread {

	private int id;
	private int pontos;
	private static int colocacao;
	private Random random;
	
	public ThreadCassino(int id, Random random) {
		this.id = id;
		this.random = random;
	}
	
	@Override
	public void run() {
		jogarDados();
	}

	private void jogarDados() {
		int d1;
		int d2;
		while(pontos < 5) {
			d1 = random.nextInt(6)+1;
			d2 = random.nextInt(6)+1;
			
			if( ((d1+d2 == 7) || (d1+d2 == 11)) ) {
				pontos ++;
				System.out.printf("Jogador %d tem %d pontos\n", id, pontos);

			}
		}
		colocacao ++;
		
		switch (colocacao) {
		case 1:
			System.out.printf("Jogardor %d foi o %d° - ganhou 5000,00\n", id, colocacao);
			break;
		case 2:
			System.out.printf("Jogardor %d foi o %d° - ganhou 4000,00\n", id, colocacao);
			break;
		case 3:
			System.out.printf("Jogardor %d foi o %d° - ganhou 3000,00\n", id, colocacao);
			break;

		default:
			System.out.printf("O Jogador %d não ganhou nada\n", id);
			break;
		}
		
		
	}
	
}