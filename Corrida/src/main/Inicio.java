package main;

import java.io.BufferedReader;
import java.io.IOException;

import model.Corrida;
import service.CorridaService;
import util.ReadFileUtil;

public class Inicio {
	
	private static final String NOME_ARQUIVO = "race.txt";

	public static void main(String[] args) throws IOException {
		
		CorridaService corridaService = new CorridaService();
		
		BufferedReader reader = ReadFileUtil.lerArquivo(NOME_ARQUIVO);

		Corrida corrida = corridaService.iniciarCorrida(reader);
		
		corridaService.exibirInformacoes(corrida);
		
		reader.close();
	}

}
