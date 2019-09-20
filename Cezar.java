package src;

import java.util.Scanner;

public class Cezar extends DecoratorCriptografia
{	
	public Cezar(Criptografia novaCriptografia)
	{
		super(novaCriptografia);
	}
	
	private int guardarChaveInt = 0;
	
	Scanner entrada = new Scanner(System.in);
	
	@Override
	public String criptografarMensagem(String mensagemRecebida)
	{
		System.out.print("\nDigite a chave de criptografia: (CEZAR)\n-> ");
		guardarChaveInt = entrada.nextInt();
		
		String guardarCriptografia = criptografiaTemporaria.criptografarMensagem(mensagemRecebida);
		guardarCriptografia = deslocarCezar(guardarChaveInt, guardarCriptografia);
		return guardarCriptografia;
	}

	@Override
	public String descriptografarMensagem(String mensagemRecebida)
	{
		System.out.print("\n\nDigite a chave de criptografia: (CEZAR)\n-> ");
		guardarChaveInt = entrada.nextInt();
		
		String guardarCriptografia = criptografiaTemporaria.descriptografarMensagem(mensagemRecebida);
		guardarCriptografia = arrumarCezar(guardarChaveInt, guardarCriptografia);
		return guardarCriptografia;
	}
	
	private String deslocarCezar(int chaveDeCriptografia, String mensagemUtilizado)
	{
		String novaMensagem = "";
		int[] arrayMensagem = new int[mensagemUtilizado.length()];
		int numeroLoop = 0, chaveRedimencionada = 0;
		
		while(numeroLoop < chaveDeCriptografia)
		{
			if(numeroLoop > 25) { chaveRedimencionada = 0; } else { chaveRedimencionada++; }
			numeroLoop++;
		}
		
		for(int numero = 0; numero < mensagemUtilizado.length(); numero++)
		{
			arrayMensagem[numero] = (int) mensagemUtilizado.charAt(numero) - 65;
		}
		
		for(int numero = 0, marcador = 1; numero < mensagemUtilizado.length(); numero++)
		{
			int numeroTemporario = chaveRedimencionada + arrayMensagem[numero] + 64;
			if(numeroTemporario < 90) { numeroTemporario += marcador; } else { numeroTemporario -= 25; }
			novaMensagem += (char)numeroTemporario;
		}
		
		return novaMensagem;
	}
	
	private String arrumarCezar(int chaveDeCriptografia, String mensagemUtilizado)
	{
		mensagemUtilizado = mensagemUtilizado.toUpperCase();
		String novaMensagem = "";
		int[] arrayMensagem = new int[mensagemUtilizado.length()];
		System.out.println(chaveDeCriptografia);
		int numeroLoop = 0, chaveRedimencionada = 0;
		
		while(numeroLoop < chaveDeCriptografia)
		{
			if(numeroLoop > 25) { chaveRedimencionada = 0; } else { chaveRedimencionada++; }
			numeroLoop++;
		}
		
		for(int numero = 0; numero < mensagemUtilizado.length(); numero++)
		{
			arrayMensagem[numero] = (int) mensagemUtilizado.charAt(numero) - 65;
		}
		
		for(int numero = 0, marcador = 1; numero < mensagemUtilizado.length(); numero++)
		{
			int numeroTemporario = arrayMensagem[numero] - chaveRedimencionada + 64;
			if(numeroTemporario < 90) { numeroTemporario += marcador; }
			if(numeroTemporario < 65) { numeroTemporario += 26; }
			novaMensagem += (char)numeroTemporario;
		}
		
		return novaMensagem;
	}
}