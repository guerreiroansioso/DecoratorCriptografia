package src;

import java.util.Scanner;

public class Virgenere extends DecoratorCriptografia
{	
	public Virgenere(Criptografia novaCriptografia)
	{
		super(novaCriptografia);
	}
	
	private String guardarChaveString = "";
	
	Scanner entrada = new Scanner(System.in);
	
	@Override
	public String criptografarMensagem(String mensagemRecebida)
	{
		System.out.print("\nDigite a chave de criptografia: (VIRGENERE)\n-> ");
		this.guardarChaveString = entrada.next();
		
		String guardarCriptografia = criptografiaTemporaria.criptografarMensagem(mensagemRecebida);
		guardarCriptografia = deslocarVirgenere(this.guardarChaveString, guardarCriptografia);
		return guardarCriptografia;
	}

	@Override
	public String descriptografarMensagem(String mensagemRecebida)
	{
		System.out.print("\n\nDigite a chave de criptografia: (VIRGENERE)\n-> ");
		this.guardarChaveString = entrada.next();
		
		String guardarCriptografia = criptografiaTemporaria.descriptografarMensagem(mensagemRecebida);
		guardarCriptografia = arrumarVirgenere(this.guardarChaveString, guardarCriptografia);
		return guardarCriptografia;
	}
	
	private String deslocarVirgenere(String chaveDeCriptografia, String mensagemUtilizado)
	{
		chaveDeCriptografia = chaveDeCriptografia.toUpperCase();
		String novaMensagem = "";
		int[] arrayChave = new int[mensagemUtilizado.length()];
		int[] arrayMensagem = new int[mensagemUtilizado.length()];
		
		for(int numero = 0, numeroChave = 0; numero < mensagemUtilizado.length(); numero++, numeroChave++)
		{
			arrayMensagem[numero] = (int) mensagemUtilizado.charAt(numero) - 65;
			arrayChave[numero] = (int) chaveDeCriptografia.charAt(numeroChave) - 65;
			if(numeroChave == chaveDeCriptografia.length() - 1) { numeroChave = -1; }
		}
		
		for(int numero = 0, marcador = 1; numero < mensagemUtilizado.length(); numero++)
		{
			int numeroTemporario = arrayChave[numero] + arrayMensagem[numero] + 64;
			if(numeroTemporario < 90) { numeroTemporario += marcador; } else { numeroTemporario -= 25; }
			novaMensagem += (char)numeroTemporario;
		}
		
		return novaMensagem;
	}
	
	private String arrumarVirgenere(String chaveDeCriptografia, String mensagemUtilizado)
	{
		chaveDeCriptografia = chaveDeCriptografia.toUpperCase();
		String novaMensagem = "";
		int[] arrayChave = new int[mensagemUtilizado.length()];
		int[] arrayMensagem = new int[mensagemUtilizado.length()];
		System.out.println(chaveDeCriptografia);
		
		for(int numero = 0, numeroChave = 0; numero < mensagemUtilizado.length(); numero++, numeroChave++)
		{
			arrayMensagem[numero] = (int) mensagemUtilizado.charAt(numero) - 65;
			arrayChave[numero] = (int) chaveDeCriptografia.charAt(numeroChave) - 65;
			if(numeroChave == chaveDeCriptografia.length() - 1) { numeroChave = -1; }
		}
		
		for(int numero = 0, marcador = 1; numero < mensagemUtilizado.length(); numero++)
		{
			int numeroTemporario = arrayMensagem[numero] - arrayChave[numero] + 64;
			if(numeroTemporario < 90) { numeroTemporario += marcador; }
			if(numeroTemporario < 64) { numeroTemporario += 26; }
			novaMensagem += (char)numeroTemporario;
		}
		
		return novaMensagem;
	}
}