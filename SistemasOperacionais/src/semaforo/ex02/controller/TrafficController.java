package semaforo.ex02.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TrafficController implements ActionListener{
	private JLabel lblCarroN;
	private JLabel lblCarroS;
	private JLabel lblCarroL;
	private JLabel lblCarroO;
	private JButton btnIniciar;
	
	public TrafficController(JLabel lblCarroN, JLabel lblCarroS, JLabel lblCarroL, JLabel lblCarroO, JButton btnIniciar) {
		this.lblCarroN = lblCarroN;
		this.lblCarroS = lblCarroS;
		this.lblCarroL = lblCarroL;
		this.lblCarroO = lblCarroO;
		this.btnIniciar = btnIniciar;
	}

	public void iniciarDeslocamento() {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idCar=1; idCar <= 4; idCar++) {
			Thread car = new ThreadCar(lblCarroN, lblCarroS, lblCarroL, lblCarroO, btnIniciar,idCar, semaforo, this);
			car.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		iniciarDeslocamento();
	}
	
	public void retornarPosicao() {
		lblCarroN.setBounds(174, 28, 21, 55);
		lblCarroS.setBounds(211, 174, 21, 55);
		lblCarroL.setBounds(249, 139, 55, 21);
		lblCarroO.setBounds(93, 102, 55, 21);
	}
}