package src;

import java.util.Scanner;

public class Opicoes
{
	private static int opicaoSelecionada = 0;
	private static String guardarResposta, guardarDescriptografia;
	
	public static void mostrarOpicoes()
	{
		System.out.print("\n:: Selecione uma opicao de critografia, porfavor"
				+ "\n (1) Sem criptografia."
				+ "\n (2) Com criptografia cifra de CEZAR."
				+ "\n (3) Com criptografia cifra de VIRGENERE."
				+ "\n (3) Com criptografia cifra de CEZAR + cifra de VIRGENERE\n-> ");
		
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		opicaoSelecionada = entrada.nextInt();
		
		if(opicaoSelecionada == 1)
		{
			Criptografia criptografando = new ModeloCriptografia();
			guardarResposta = criptografando.criptografarMensagem(Arquivo.getMensagem());
		} else if (opicaoSelecionada == 2)
		{
			Criptografia criptografando = new Cezar(new ModeloCriptografia());
			guardarResposta = criptografando.criptografarMensagem(Arquivo.getMensagem());
		} else if (opicaoSelecionada == 3)
		{
			Criptografia criptografando = new Virgenere(new ModeloCriptografia());
			guardarResposta = criptografando.criptografarMensagem(Arquivo.getMensagem());
		} else if (opicaoSelecionada == 4)
		{
			Criptografia criptografando = new Virgenere(new Cezar(new ModeloCriptografia()));
			guardarResposta = criptografando.criptografarMensagem(Arquivo.getMensagem());
		}
	}
	
	public static String descriptografar(String mensagemNoArquivo)
	{
		if(opicaoSelecionada == 1)
		{
			Criptografia criptografando = new ModeloCriptografia();
			return guardarDescriptografia = criptografando.descriptografarMensagem(mensagemNoArquivo);
		} else if (opicaoSelecionada == 2)
		{
			Criptografia criptografando = new Cezar(new ModeloCriptografia());
			return guardarDescriptografia = criptografando.descriptografarMensagem(mensagemNoArquivo);
		} else if (opicaoSelecionada == 3)
		{
			Criptografia criptografando = new Virgenere(new ModeloCriptografia());
			return guardarDescriptografia = criptografando.descriptografarMensagem(mensagemNoArquivo);
		}
		
		return mensagemNoArquivo;
	}
	
	public static void setOpicaoSelecionada(int Valor) { opicaoSelecionada = Valor; }
	
	public static String getOpicoes() { return guardarResposta; }
	
	public static String getOpicoesDescriptografia() { return guardarDescriptografia; }
}
