package semaforo.ex01.controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {

	private int idPessoa;
	private static int posChegada;
	private Semaphore semaforo;
	private Random random;

	public ThreadPessoa(int idPessoa, Semaphore semaforo, Random random) {
			this.idPessoa = idPessoa;
			this.semaforo = semaforo;
			this.random = random;
		}

	@Override
	public void run() {
		pessoaAndando();
		try {
			semaforo.acquire();
			pessoaAtravessando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			travessiaCompleta();
		}

	}

	private void pessoaAndando() {
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = random.nextInt(3)+4;
		int tempo = 1000;
		

		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("%d° Pessoa já andou %d metros \n", idPessoa, distanciaPercorrida);
		}

		posChegada++;
		System.out.printf("%d° Pessoa foi o %d° a chegar \n", idPessoa, posChegada);
	}

	private void pessoaAtravessando() {
		System.out.printf("%d° Pessoa cruzando a porta \n", idPessoa);
		int tempo = random.nextInt(1001)+1000;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void travessiaCompleta() {
		System.out.printf("Pessoa #%d atravessou \n", idPessoa);

	}

}
