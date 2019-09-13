package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Principal
{

	public static void main(String[] args)
	{
		System.out.println(":: Informe o endereco do arquivo, por favor: ");
		Arquivo.setCaminho();
		
		Path caminhoDoArquivo = Paths.get(Arquivo.getCaminho());
		boolean arquivoJaExiste = Files.exists(caminhoDoArquivo);
		
		if (arquivoJaExiste == false)
		{
			try 
			{
				Path criarCaminhoDoArquivo = Files.createFile (caminhoDoArquivo);
				System.out.println ("Arquivo criado em : "+criarCaminhoDoArquivo);
				arquivoJaExiste = true;
			} catch (IOException e)
			{
				System.out.println ("\n:: O Arquivo ja existe no caminho informado, por favor delete o arquivo e "
						+ "reinicie o programa.");
			}
		}
		
		if (arquivoJaExiste == true)
		{
			try
			{
				System.out.println("Escreva a mensagem desejada, por favor:");
				Arquivo.setMensagem();
				Opicoes.mostrarOpicoes();
				byte[] byteDaMensagem = Opicoes.getOpicoes().getBytes();
				@SuppressWarnings("unused")
				Path escreverNoArquivo = Files.write(caminhoDoArquivo, byteDaMensagem);
			} catch (IOException e)
			{
				System.out.println (":: Ouve problemas ao ler a mensagem e escreve-la no arquivo.");
			}
			
		}
		
		try 
		{
			List<String> linhasDoArquivo = Files.readAllLines (caminhoDoArquivo);
			System.out.println ("\n:: A leitura do arquivo "+ caminhoDoArquivo + " foi concluido.\n"
					+ "Informacao do arquivo:\n");
			
			for (String stringTemporario : linhasDoArquivo)
			{
				System.out.println(stringTemporario);
			}
			
		} catch (IOException e)
		{
			System.out.println (":: O Arquivo nao pode ser lido.");
		}
		
	}

}
