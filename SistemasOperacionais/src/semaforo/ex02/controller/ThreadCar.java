package semaforo.ex02.controller;

import java.awt.Rectangle;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ThreadCar extends Thread {

	private int idCar;
	private static int direcaoCarro;
	private static int contador;
	private Semaphore semaforo;
	private JLabel lblCarroN;
	private JLabel lblCarroS;
	private JLabel lblCarroL;
	private JLabel lblCarroO;
	private JButton btnIniciar;
	private TrafficController trafficController;

	public ThreadCar(JLabel lblCarroN, JLabel lblCarroS, JLabel lblCarroL, JLabel lblCarroO, JButton btnIniciar,
			int idCar, Semaphore semaforo, TrafficController trafficController) {
		this.idCar = idCar;
		this.semaforo = semaforo;
		this.lblCarroN = lblCarroN;
		this.lblCarroS = lblCarroS;
		this.lblCarroL = lblCarroL;
		this.lblCarroO = lblCarroO;
		this.btnIniciar = btnIniciar;
		this.trafficController = trafficController;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			atravessar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void atravessar() {
		btnIniciar.setVisible(false);
		direcaoCarro = 0;
		
		if(idCar <= 2) {
			direcaoCarro = idCar + 2;
		} else {
			direcaoCarro = idCar - 2;
		}
		
		switch (direcaoCarro) {
		case 1:
			System.out.printf("Carro #%d foi do L para o O \n", idCar);
			movimentarCarro(lblCarroL, "x", 2);
			break;
			
		case 2:
			System.out.printf("Carro #%d foi do O para o L \n", idCar);
			movimentarCarro(lblCarroO, "x", 1);
			break;
			
		case 3:
			System.out.printf("Carro #%d foi do N para o S \n", idCar);
			movimentarCarro(lblCarroN, "y", 1);	
			break;

		case 4:
			System.out.printf("Carro #%d foi do S para o N \n", idCar);
			movimentarCarro(lblCarroS, "y", 2);	
			break;
		
		default:
			System.out.println(direcaoCarro);
			break;
			
		}
		contador ++;
		if(contador > 3) {
			btnIniciar.setVisible(true);
			trafficController.retornarPosicao();
			contador = 0;
		}
	}
	
	
	private void movimentarCarro(JLabel lblCarro, String eixo, int op) {
		Rectangle posicao;
		posicao = lblCarro.getBounds();
		int contador = 0;
			while (contador < 150) {
				if(eixo == "x" && op == 2) {
					posicao.x -= 20;
				} else if (eixo == "x" && op == 1) {
					posicao.x += 20;
				} else if (eixo == "y" && op == 2) {
					posicao.y -= 20;
				} else if (eixo == "y" && op == 1) {
					posicao.y += 20;
				}
				lblCarro.setBounds(posicao);
				try {
					Thread.sleep(50);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				contador += 20;
			} 
		
	}

	
}