package threads.ex01.controller;

public class PrintThread extends Thread {

	private int idThread;

	public PrintThread(int idThread) {
		this.idThread = idThread;
	}

	@Override
	public void run() {
		printarNumero();
	}

	private void printarNumero() {
		System.out.println(idThread);
	}

}