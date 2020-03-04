package processos.ex02.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;


public class ProcessosController {

	private String listarProcesso = "";
	private String matarProcNome = "";
	private String matarProcPID = "";
	
	public ProcessosController() {
		super();
	}
	
	
	public void processosAtivos() {
		try {
			Process p = Runtime.getRuntime().exec(listarProcesso);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();

			}

			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

			
	}
	
	
	public void matarProcessoNome (String param) {
		String cmdNome = matarProcNome;
		StringBuffer buffer = new StringBuffer();
		
		try {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
			chamaProcesso(buffer.toString());
		} catch ( Exception e ) {

		}
	}
	
	
	public void matarProcessoPID (String param) {
		String cmdPid = matarProcPID;
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
			chamaProcesso(buffer.toString());
		} catch ( NumberFormatException e ) {
			JOptionPane.showMessageDialog(null, "PID contém apenas números");
		}
	}
	
	
	public void chamaProcesso(String processo) {
		try {
			Runtime.getRuntime().exec(processo);
		}catch (Exception e) {
			if (e.getMessage().contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(processo);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void configurarSistema() {
		String os = System.getProperty("os.name");
		if(os.contains("Windows")) {
			listarProcesso = "tasklist";
			matarProcNome = "TASKKILL /IM";
			matarProcPID = "TASKKILL /PID";	
		} else {
			listarProcesso = "ps";
			matarProcNome = "pkill";
			matarProcPID = "kill -9";	
		}
			
	}
	
}
