package extra.cassino.view;

import java.util.Random;

import extra.cassino.controller.ThreadCassino;

public class Principal {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		for(int id = 1; id <= 10; id++) {
			Thread t = new ThreadCassino(id, random);
			t.start();
		}
		
	}
}
