package semaforo.ex02.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semaforo.ex02.controller.TrafficController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarroN = new JLabel("");
		lblCarroN.setIcon(new ImageIcon(Principal.class.getResource("/semaforo/ex02/img/greenC.jpg")));
		lblCarroN.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarroN.setBounds(174, 28, 21, 55);
		contentPane.add(lblCarroN);
		
		JLabel lblCarroS = new JLabel("");
		lblCarroS.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarroS.setIcon(new ImageIcon(Principal.class.getResource("/semaforo/ex02/img/redC.jpg")));
		lblCarroS.setBounds(211, 174, 21, 55);
		contentPane.add(lblCarroS);
		
		JLabel lblCarroL = new JLabel("");
		lblCarroL.setIcon(new ImageIcon(Principal.class.getResource("/semaforo/ex02/img/blackC.jpg")));
		lblCarroL.setBounds(249, 139, 55, 21);
		contentPane.add(lblCarroL);
		
		JLabel lblCarroO = new JLabel("");
		lblCarroO.setIcon(new ImageIcon(Principal.class.getResource("/semaforo/ex02/img/blueC.jpg")));
		lblCarroO.setBounds(93, 102, 55, 21);
		contentPane.add(lblCarroO);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(29, 199, 89, 23);
		contentPane.add(btnIniciar);
		
		TrafficController trafficController = new TrafficController(lblCarroN, lblCarroS, lblCarroL, lblCarroO, btnIniciar);
		btnIniciar.addActionListener(trafficController);
		
	}
}
