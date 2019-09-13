package src;

public abstract class DecoratorCriptografia implements Criptografia
{
	protected Criptografia criptografiaTemporaria;
	
	public DecoratorCriptografia(Criptografia novaCriptografia)
	{
		criptografiaTemporaria = novaCriptografia;
	}
	
	@Override
	public String criptografarMensagem(String mensagemRecebida)
	{
		return criptografiaTemporaria.criptografarMensagem(mensagemRecebida);
	}

	@Override
	public String descriptografarMensagem(String mensagemRecebida)
	{
		return criptografiaTemporaria.descriptografarMensagem(mensagemRecebida);
	}
}
