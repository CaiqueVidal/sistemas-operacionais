package threads.ex04.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PersonagemController implements ActionListener {
	private JLabel lblPerson1;
	private JLabel lblPerson2;
	private JButton btnIniciar;
	private JTextField txtVencedor;
	private JTextField txtPerdedor;

	public PersonagemController(JLabel lblPerson1, JLabel lblPerson2, JButton btnIniciar, JTextField txtVencedor, JTextField txtPerdedor) {
		this.lblPerson1 = lblPerson1;
		this.lblPerson2 = lblPerson2;
		this.btnIniciar = btnIniciar;
		this.txtVencedor = txtVencedor;
		this.txtPerdedor = txtPerdedor;
	}

	private void gerarPersonagem() {
		Thread t1 = new ThreadCorrida(lblPerson1, btnIniciar, "Carro1", txtVencedor, txtPerdedor, this);
		Thread t2 = new ThreadCorrida(lblPerson2, btnIniciar, "Carro2", txtVencedor, txtPerdedor, this);
		t1.start();
		t2.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gerarPersonagem();
	}
	
	public void retornarPosicao() {
		lblPerson1.setBounds(10, 53, 55, 55);
		lblPerson2.setBounds(10, 130, 55, 55);
	}
}