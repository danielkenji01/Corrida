package model;

import java.util.ArrayList;
import java.util.List;

public class Corrida {

	private List<Piloto> pilotos = new ArrayList<Piloto>();
	
	private int posicao = 1;
	
	private Volta melhorVolta;
	
	private Piloto pilotoVencedor;

	public List<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public Volta getMelhorVolta() {
		return melhorVolta;
	}

	public void setMelhorVolta(Volta melhorVolta) {
		this.melhorVolta = melhorVolta;
	}

	public Piloto getPilotoVencedor() {
		return pilotoVencedor;
	}

	public void setPilotoVencedor(Piloto pilotoVencedor) {
		this.pilotoVencedor = pilotoVencedor;
	}
	
}