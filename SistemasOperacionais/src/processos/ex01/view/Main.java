package processos.ex01.view;

import javax.swing.JOptionPane;

import processos.ex01.controller.RedesController;;
public class Main {

	public static void main(String[] args) {
		RedesController pc = new RedesController();
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"Menu de escolhas \n1 - ip \n2 - ping \n9 - Finalizar"));
			switch (opc) {
			case 1:
				pc.ip();
				break;
			case 2:
				pc.ping();
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Fim");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida");
			}
		}

	}
}