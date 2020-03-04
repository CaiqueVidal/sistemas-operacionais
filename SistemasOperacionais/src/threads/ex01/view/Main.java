package threads.ex01.view;

import threads.ex01.controller.PrintThread;

public class Main {

	public static void main(String[] args) {

		for (int c = 0; c < 5; c++) {
			Thread t = new PrintThread(c);
			t.start();
		}

	}

}