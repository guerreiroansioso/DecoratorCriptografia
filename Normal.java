package src;

public class Normal extends DecoratorCriptografia
{
	private String guardarCriptografia;
	
	public Normal(Criptografia novaCriptografia) {
		super(novaCriptografia);
	}
	
	@Override
	public String criptografarMensagem(String mensagemRecebida)
	{
		guardarCriptografia = mensagemRecebida;
		return criptografiaTemporaria.criptografarMensagem(guardarCriptografia) + guardarCriptografia;
	}

	@Override
	public String descriptografarMensagem(String mensagemRecebida)
	{
		return criptografiaTemporaria.descriptografarMensagem(guardarCriptografia) + guardarCriptografia;
	}
}


// return criptografiaTemporaria.criptografarMensagem(mensagemRecebida) + mensagemRecebida