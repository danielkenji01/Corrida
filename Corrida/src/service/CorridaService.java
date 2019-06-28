package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import model.Corrida;
import model.Piloto;
import model.Volta;
import util.NomePilotoUtil;

public class CorridaService {

	public Corrida iniciarCorrida(BufferedReader reader) throws IOException {
		
		Corrida corrida = new Corrida();
		
		String linha;
		
		boolean primeiro = true;
		
		Map<String, Piloto> pilotoMap = new HashMap<String, Piloto>();
		
		while ((linha = reader.readLine()) != null) {
			
			linha = linha.replaceAll("\\s", "");
			
			if (primeiro) {
				primeiro = false;
				continue;
			}
			
			LocalTime time = LocalTime.parse(linha.substring(0, 12));
			
			linha = linha.replaceAll(time.toString(), "");
			
			String codigo = linha.substring(0, 3);
			linha = linha.replaceFirst(codigo, "");
			
			linha = linha.replaceAll("–", "");

			String nome = NomePilotoUtil.pegarNomePiloto(linha);
			
			linha = linha.replaceAll(nome, "");
			
			int numeroVolta = Integer.valueOf(String.valueOf(linha.charAt(0)));
			
			linha = linha.substring(1);

			int minutes = Integer.valueOf(String.valueOf(linha.charAt(0)));
			int seconds = Integer.valueOf(linha.substring(2, 4));
			int nanoSeconds = Integer.valueOf(linha.substring(5, 8));
			
			LocalTime tempoVolta = LocalTime.of(0, minutes, seconds, nanoSeconds);
			
			linha = linha.substring(8);
			
			double velocidadeMedia = Double.parseDouble(linha.replaceAll(",", "."));
			
			Volta volta = new Volta(tempoVolta, numeroVolta, velocidadeMedia);
			
			if (!pilotoMap.containsKey(codigo)) {
				Piloto piloto = new Piloto();
				
				piloto.setCodigo(codigo);
				piloto.setNome(nome);
				
				piloto.getVoltas().add(volta);
				
				corrida.getPilotos().add(piloto);
				pilotoMap.put(codigo, piloto);
				
				this.validarTerminoCorrida(piloto, corrida);
				
			} else {
				Piloto piloto = pilotoMap.get(codigo);
				
				piloto.getVoltas().add(volta);
				
				this.validarTerminoCorrida(piloto, corrida);
			}
		}
		
		return corrida;
	}
	
	private void validarTerminoCorrida(Piloto piloto, Corrida corrida) {
		if (piloto.getVoltas().size() == 4) {
			
			int posicao = corrida.getPosicao();
			
			if (posicao == 1) {
				corrida.setPilotoVencedor(piloto);
			}
			
			piloto.setPosicaoFinal(posicao);
			corrida.setPosicao(posicao+1);
		}
	}
	
	public void exibirInformacoes(Corrida corrida) {
		for (Piloto piloto : corrida.getPilotos()) {
			
			System.out.println("----------------------------------------");
			
			if (piloto.getPosicaoFinal() == 0) {
				
				int posicao = corrida.getPosicao();
				
				piloto.setPosicaoFinal(posicao);
				corrida.setPosicao(posicao+1);
			}
			
			System.out.println(String.format("%sº posição: %s - %s", piloto.getPosicaoFinal(), piloto.getCodigo(), piloto.getNome()));
			System.out.println(String.format("Voltas completadas: %s", piloto.getVoltas().size()));

			int minutos = 0;
			int segundos = 0;
			int nanoSegundos = 0;
			
			double velocidadeMedia = 0d;
			
			for (Volta volta : piloto.getVoltas()) {
				
				velocidadeMedia += volta.getVelocidadeMedia();
				
				minutos += volta.getTempo().getMinute();
				segundos += volta.getTempo().getSecond();
				
				if (segundos > 60) {
					minutos++;
					segundos -= 60;
				}
				
				nanoSegundos += volta.getTempo().getNano();
				
				if (corrida.getMelhorVolta() == null || corrida.getMelhorVolta().getTempo().compareTo(volta.getTempo()) == 1) {
					corrida.setMelhorVolta(volta);
				}
				
				if (piloto.getMelhorVolta() == null || piloto.getMelhorVolta().getTempo().compareTo(volta.getTempo()) == 1) {
					piloto.setMelhorVolta(volta);
				}
			}
			
			velocidadeMedia = velocidadeMedia / piloto.getVoltas().size();
			
			LocalTime tempoProva = LocalTime.of(0, minutos, segundos, nanoSegundos);
			
			System.out.println(String.format("Velocidade média do piloto: %s", velocidadeMedia));
			System.out.println(String.format("Melhor volta do piloto: %s", piloto.getMelhorVolta().getTempo()));
			System.out.println(String.format("Tempo total: %s", tempoProva));
			
		}
		
		System.out.println("----------------------------------------");
		System.out.println(String.format("Melhor volta da corrida: %s", corrida.getMelhorVolta().getTempo()));
	}
	
}