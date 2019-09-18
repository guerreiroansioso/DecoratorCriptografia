package src;

import java.util.Scanner;

public class Cezar extends DecoratorCriptografia
{	
	public Cezar(Criptografia novaCriptografia)
	{
		super(novaCriptografia);
	}
	
	private int guardarChave = 0;
	
	Scanner entrada = new Scanner(System.in);
	
	@Override
	public String criptografarMensagem(String mensagemRecebida)
	{
		System.out.print("\nDigite a chave de criptografia:\n-> ");
		guardarChave = entrada.nextInt();
		
		String guardarCriptografia = criptografiaTemporaria.criptografarMensagem(mensagemRecebida);
		guardarCriptografia = deslocarCezar(guardarChave, guardarCriptografia);
		return guardarCriptografia;
	}

	@Override
	public String descriptografarMensagem(String mensagemRecebida)
	{
		String guardarCriptografia = criptografiaTemporaria.criptografarMensagem(mensagemRecebida);
		return guardarCriptografia;
	}
	
	private String deslocarCezar(int chaveDeCriptografia, String mensagemUtilizado)
	{
		String novaMensagem = "";
		int chaveRedimencionada = 0, numeroLoop = 0;
		
		while(numeroLoop < chaveDeCriptografia)
		{
			if(chaveRedimencionada > 24) { chaveRedimencionada = 0; } else { chaveRedimencionada++; }
			numeroLoop++;
		}
		
		for(int numero = 0; numero < mensagemUtilizado.length(); numero ++)
		{
			int mensagemInteiros = ((int) mensagemUtilizado.charAt(numero)) + chaveRedimencionada;
			
			if(mensagemInteiros > 90 && mensagemInteiros <= (90 + chaveRedimencionada))
			{
				mensagemInteiros -= 26;
			}
			
			if(mensagemInteiros > 122 && mensagemInteiros <= (122 + chaveRedimencionada))
			{
				mensagemInteiros -= 26;
			}
			
			novaMensagem += (char)mensagemInteiros;
		}
		return novaMensagem;
	}
}

















