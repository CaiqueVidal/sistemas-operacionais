package extra.bilheteria.view;

import java.util.Random;
import java.util.concurrent.Semaphore;

import  extra.bilheteria.controller.ThreadBilheteria;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);
		Random random = new Random();
		
		for(int id =1; id <= 300; id++) {
			Thread t = new ThreadBilheteria(id, semaforo, random);
			t.start();
		}
	}
	
}
