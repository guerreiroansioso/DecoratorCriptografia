package src;

public class Maiusculo extends DecoratorCriptografia
{	
	public Maiusculo(Criptografia novaCriptografia) {
		super(novaCriptografia);
	}
	
	@Override
	public String criptografarMensagem(String mensagemRecebida)
	{
		String guardarCriptografia = criptografiaTemporaria.criptografarMensagem(mensagemRecebida).toUpperCase();
		return guardarCriptografia;
	}

	@Override
	public String descriptografarMensagem(String mensagemRecebida)
	{
		String guardarCriptografia = criptografiaTemporaria.criptografarMensagem(mensagemRecebida).toUpperCase();
		return guardarCriptografia;
	}
}