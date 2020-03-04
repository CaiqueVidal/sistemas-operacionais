package threads.ex03.view;

import threads.ex03.controller.CorridaThread;

public class Main {

	public static void main(String[] args) {
		for (int id = 0; id < 5; id++) {
			int posicaoInicial = 0;
			Thread t = new CorridaThread(id, posicaoInicial);
			t.start();
		}
		
	}

}
