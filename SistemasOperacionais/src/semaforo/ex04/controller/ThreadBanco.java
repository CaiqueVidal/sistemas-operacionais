package semaforo.ex04.controller;

import java.util.concurrent.Semaphore;

public class ThreadBanco extends Thread {

	private int id;
	private int saldo;
	private int valorTransacao;
	private Semaphore semaforo;
	private int tipo;
	
	public ThreadBanco(int id, int saldo, int valorTransacao, Semaphore semaforo, int tipo) {
		this.id = id;
		this.saldo =saldo;
		this.valorTransacao = valorTransacao;
		this.semaforo = semaforo;
		this.tipo = tipo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			calcularTransacao();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			finalizarTransacao();
			semaforo.release();
		}
	}

	private void calcularTransacao() {
		if(tipo == 0) {
			sacarValor();
			
		} else {
			depositarValor();
			
		}
	}

	private void sacarValor() {
		saldo -= valorTransacao;
		System.out.printf("Conta %d realizou um saque\n", id);
	}

	private void depositarValor() {
		saldo += valorTransacao;
		System.out.printf("Conta %d realizou um deposito\n", id);
	}


	private void finalizarTransacao() {
		if(tipo == 0) {
			System.out.printf(">>Saque realizado, conta %d / saldo: %d<< \n", id, saldo);
		} else {
			System.out.printf(">>Deposito realizado, conta %d / saldo: %d<< \n", id, saldo);
		}
	}
	
}
