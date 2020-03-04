package processos.ex02.view;

import javax.swing.JOptionPane;

import processos.ex02.controller.ProcessosController;;


public class Main {
	
	
	public static void main(String[] args) {
		ProcessosController pc = new ProcessosController();
		int opc = 0;
		String parametro = "";
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Menu de escolhas \n1 - Processos ativos "
					+ "\n2 - Matar processo pelo Nome \n3 - Matar processo pelo PID \n9 - Finalizar"));
			switch (opc) {
			case 1:
				pc.configurarSistema();
				pc.processosAtivos();
				break;
				
			case 2:
				parametro = JOptionPane.showInputDialog("Qual o nome do processo que você deseja matar ?");
				pc.configurarSistema();
				pc.matarProcessoNome(parametro);
				break;
				
			case 3:
				parametro = JOptionPane.showInputDialog("Qual o PID do processo que você deseja matar ?");
				pc.configurarSistema();
				pc.matarProcessoPID(parametro);
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
