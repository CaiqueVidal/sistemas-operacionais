package extra.bilheteria.controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread {

	private int id;
	private Semaphore semaforo;
	private Random random;
	private static int ingressosDisponiveis = 100;
	private int ingressosComprados;
	private boolean status = false;
	
	public ThreadBilheteria(int id, Semaphore semaforo, Random random) {
		this.id = id;
		this.semaforo = semaforo;
		this.random = random;
	}
	
	@Override
	public void run() {
		logarSistema();
		if(status) {
			comprarIngresso();
			if(status) {
				try {
					semaforo.acquire();
					validarCompra();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
			}		
		}
		
	}

	private void logarSistema() {
		int tempo = random.nextInt(1951)+50;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tempo > 1000) {
			System.out.printf("timeout - usuário %d\n", id);
		} else {
			System.out.printf("Usuário %d logado\n",id);
			status = true;
		}
	}

	private void comprarIngresso() {
		int tempo = random.nextInt(2000)+1000;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tempo > 2500) {
			System.out.printf("final de tempo de sessão - usuário %d\n", id);
			status = false;
		} else {
			ingressosComprados = random.nextInt(4)+1;
		}
	}

	private void validarCompra() {
		System.out.printf("Validando compra do usuário %d\n", id);
		if(ingressosDisponiveis >= ingressosComprados) {
			ingressosDisponiveis -= ingressosComprados;
			System.out.printf("Usuário %d adquiriu %d ingresso(s). Restam %d ingressos disponíveis\n", id, ingressosComprados, ingressosDisponiveis);
		} else {
			System.out.printf("Compra não realizada. Usuário %d tentou comprar %d, temos %d ingresso(s)\n", id, ingressosComprados, ingressosDisponiveis);
		}
	}
	
}
