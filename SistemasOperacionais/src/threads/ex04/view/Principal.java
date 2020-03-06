package threads.ex04.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import threads.ex04.controller.CarroController;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtVencedor;
	private JTextField txtPerdedor;

	
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
		setBounds(100, 100, 466, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPerson1 = new JLabel("P1");
		lblPerson1.setIcon(new ImageIcon("C:\\Users\\caiqu\\Desktop\\Caique\\3 Imagens\\teste\\tb2.jpg"));
		lblPerson1.setForeground(Color.RED);
		lblPerson1.setBounds(10, 53, 55, 55);
		contentPane.add(lblPerson1);
		
		JLabel lblPerson2 = new JLabel("P2");
		lblPerson2.setIcon(new ImageIcon("C:\\Users\\caiqu\\Desktop\\Caique\\3 Imagens\\teste\\ty2.jpg"));
		lblPerson2.setForeground(Color.BLUE);
		lblPerson2.setBounds(10, 130, 55, 55);
		contentPane.add(lblPerson2);
		
		JLabel lblNewLabel = new JLabel("Vencedor");
		lblNewLabel.setBounds(10, 214, 55, 14);
		contentPane.add(lblNewLabel);
		
		txtVencedor = new JTextField();
		txtVencedor.setForeground(new Color(0, 128, 0));
		txtVencedor.setEditable(false);
		txtVencedor.setBounds(75, 211, 86, 20);
		contentPane.add(txtVencedor);
		txtVencedor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Perdedor");
		lblNewLabel_1.setBounds(234, 214, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		txtPerdedor = new JTextField();
		txtPerdedor.setForeground(new Color(255, 0, 0));
		txtPerdedor.setEditable(false);
		txtPerdedor.setBounds(299, 211, 86, 20);
		contentPane.add(txtPerdedor);
		txtPerdedor.setColumns(10);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(314, 11, 89, 23);
		contentPane.add(btnIniciar);
		
		CarroController personagemController = new CarroController(lblPerson1, lblPerson2, btnIniciar, txtVencedor, txtPerdedor);
		btnIniciar.addActionListener(personagemController);
		
		
		
	}
}
