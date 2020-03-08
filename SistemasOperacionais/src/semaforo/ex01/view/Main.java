package semaforo.ex01.view;

import java.util.Random;
import java.util.concurrent.Semaphore;

import semaforo.ex01.controller.ThreadPessoa;

public class Main {

	public static void main(String[] args) {
		
		Random random = new Random();
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idPessoa = 1; idPessoa <= 4; idPessoa++) {
			Thread pessoa = new ThreadPessoa(idPessoa, semaforo, random);
			pessoa.start();
		}
	}
}