package src;

public class ModeloCriptografia implements Criptografia
{
	@SuppressWarnings("unused")
	private String guardarCriptografia;
	
	@Override
	public String criptografarMensagem(String mensagemRecebida)
	{
		mensagemRecebida = Filtro.filtrarMensagem(mensagemRecebida);
		mensagemRecebida = mensagemRecebida.toUpperCase();
		return mensagemRecebida;
	}

	@Override
	public String descriptografarMensagem(String mensagemRecebida)
	{
		return mensagemRecebida;
	}
}
