package threads.ex02.controller;

import java.util.stream.IntStream;

public class MatrizThread extends Thread {
	private int[] vetor;
	private int linha;

	public MatrizThread(int linha, int[] vetor) {
		this.vetor = vetor;
		this.linha = linha;
	}

	@Override
	public void run() {
		exibirSoma();
	}

	
	private void exibirSoma() {
		System.out.println("Linha " + linha + " - Resultado = " + IntStream.of(vetor).sum());
	}


}
