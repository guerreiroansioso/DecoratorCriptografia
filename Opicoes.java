package src;

import java.util.Scanner;

public class Opicoes
{
	private static int opicaoSelecionada = 0;
	private static String guardarResposta;
	
	public static void mostrarOpicoes()
	{
		System.out.println(":: Selecione uma opicao de critografia, porfavor"
				+ "\n (1) Sem criptografia."
				+ "\n (2) Com criptografia deixar MAIUSCULO.");
		
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		opicaoSelecionada = entrada.nextInt();
		
		if(opicaoSelecionada == 1)
		{
			Criptografia criptografando = new ModeloCriptografia();
			guardarResposta = criptografando.criptografarMensagem(Arquivo.getMensagem());
		} else if (opicaoSelecionada == 2)
		{
			Criptografia criptografando = new Maiusculo(new ModeloCriptografia());
			guardarResposta = criptografando.criptografarMensagem(Arquivo.getMensagem());
		} else if (opicaoSelecionada == 3)
		{
			
		} else if (opicaoSelecionada == 4)
		{
			
		}
	}
	
	public static String getOpicoes() { return guardarResposta; }
}
