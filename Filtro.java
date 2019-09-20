package src;

public class Filtro
{	
	public static String filtrarMensagem(String mensagemRecebida)
	{
		String mensagemTemporaria = "";
		
		for(int numero = 0; numero < mensagemRecebida.length(); numero++)
		{
			if(mensagemRecebida.charAt(numero) >= 'A' && mensagemRecebida.charAt(numero) <='Z')
			{
				mensagemTemporaria = mensagemTemporaria + mensagemRecebida.charAt(numero);
			}
			
			if(mensagemRecebida.charAt(numero) >= 'a' && mensagemRecebida.charAt(numero) <='z')
			{
				mensagemTemporaria = mensagemTemporaria + mensagemRecebida.charAt(numero);
			}
		}
		return mensagemTemporaria;
	}
}