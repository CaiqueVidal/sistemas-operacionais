package semaforo.ex04.view;

import java.util.Random;
import java.util.concurrent.Semaphore;

import semaforo.ex04.controller.ThreadBanco;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforoDeposito = new Semaphore(permissoes);
		Semaphore semaforoSaque = new Semaphore(permissoes);
		Random random = new Random();
		
		for(int id =1; id <= 20; id++) {
			int saldo = random.nextInt(1000);
			int valorTransacao = random.nextInt(500);
			int tipo = random.nextInt(2);
			if(tipo == 1) {
				Thread t = new ThreadBanco(id, saldo, valorTransacao, semaforoDeposito, 1);
				t.start();
			} else {
				Thread t = new ThreadBanco(id, saldo, valorTransacao, semaforoSaque, 0);
				t.start();
			}
			
		}
	}
	
}
