package threads.ex04.controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThreadCorrida extends Thread {
	private JLabel lblPerson;
	private JButton btnIniciar;
	private JTextField txtVencedor;
	private JTextField txtPerdedor;
	private String nome = "";
	private final int fim = 380;
	private static int colocacao = 0;
	private PersonagemController controller;

	public ThreadCorrida(JLabel lblPerson, JButton btnIniciar, String nome, JTextField txtVencedor, 
			JTextField txtPerdedor, PersonagemController controller) {
		this.lblPerson = lblPerson;
		this.btnIniciar = btnIniciar;
		this.txtVencedor = txtVencedor;
		this.txtPerdedor = txtPerdedor;
		this.nome = nome;
		this.controller = controller;
	}

	private void moverPersonagem() {
		btnIniciar.setVisible(false);
		txtVencedor.setText("");
		txtPerdedor.setText("");
		
		Rectangle posicao;
		posicao = lblPerson.getBounds();
		Random random = new Random();
		int numero = 0;
		int contador = 0;
		
		while (contador < fim) {
			numero = random.nextInt(6)*2;
			posicao.x += numero; 
			
			lblPerson.setBounds(posicao);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			contador += numero;
		}
		
		colocacao ++;
		
		if(colocacao > 0 && colocacao < 2) {
			txtVencedor.setText(nome);

		} else {
			txtPerdedor.setText(nome);
			btnIniciar.setVisible(true);
			colocacao = 0;
			controller.retornarPosicao();
		}
		
		

	}

	@Override
	public void run() {
		moverPersonagem();
	}
}