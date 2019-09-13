package src;

import java.util.Scanner;

public class Arquivo
{
	private static String caminhoDoArquivo, mensagemDoUsuarioDigitada;
	
	static Scanner entrada = new Scanner(System.in);
	
	static void setCaminho ()
	{
		System.out.print("-> ");
		String fazerLeitura = entrada.nextLine();
		caminhoDoArquivo = fazerLeitura;
	}
	
	static String getCaminho()
	{
		return caminhoDoArquivo;
	}
	
	static void setMensagem()
	{
		System.out.print("-> ");
		String fazerLeitura = entrada.nextLine();
		mensagemDoUsuarioDigitada = Filtro.filtrarMensagem(fazerLeitura);
	}
	
	static String getMensagem()
	{
		return mensagemDoUsuarioDigitada;
	}
}
