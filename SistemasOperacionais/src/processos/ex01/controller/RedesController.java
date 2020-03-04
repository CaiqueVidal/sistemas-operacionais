package processos.ex01.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	private String processoIp = "";
	private String adaptador = "";
	private String protocoloIp = "";
	private String quebraSplitIp = "";
	private int posicaoSplitIp = 0;

	private String processoPing = "";
	private String quebraSplitPing = "";
	private int posicaoSplitPing = 0;

	public void ip() {
		configurarSistema();
		try {
			Process p = Runtime.getRuntime().exec(processoIp);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha;
			String rotulo = "";
			while ((linha = buffer.readLine()) != null) {
				if (linha.contains(adaptador)) {
					rotulo = linha;
				} else if (linha.contains(protocoloIp)) {
					String resultado = linha.split(quebraSplitIp)[posicaoSplitIp];
					System.out.println(rotulo + " \n" + resultado);
				}
			}

			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ping() {
		configurarSistema();
		try {
			Process p = Runtime.getRuntime().exec(processoPing);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			String ultimaLinha = linha;
			while (linha != null) {
				ultimaLinha = linha;
				linha = buffer.readLine();
			}
			String resultado = ultimaLinha.split(quebraSplitPing)[posicaoSplitPing];
			System.out.println(resultado);

			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void configurarSistema() {
		String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			processoIp = "ipconfig";
			adaptador = "Adapt";
			protocoloIp = "IPv4";
			quebraSplitIp = ":";
			posicaoSplitIp = 1;

			processoPing = "ping -n 10 google.com.br";
			quebraSplitPing = " ";
			posicaoSplitPing = 12;
		} else {
			processoIp = "ifconfig";
			adaptador = "flags";
			protocoloIp = "inet ";
			quebraSplitIp = " ";
			posicaoSplitIp = 1;

			processoPing = "ping -c 10 www.google.com";
			quebraSplitPing = "/";
			posicaoSplitPing = 4;
		}
	}
}
