package model;

import java.util.ArrayList;
import java.util.List;

public class Piloto {

	private String codigo;
	
	private String nome;
	
	private List<Volta> voltas = new ArrayList<Volta>();
	
	private int posicaoFinal;
	
	private Volta melhorVolta;

	public Volta getMelhorVolta() {
		return melhorVolta;
	}

	public void setMelhorVolta(Volta melhorVolta) {
		this.melhorVolta = melhorVolta;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Volta> getVoltas() {
		return voltas;
	}

	public void setVoltas(List<Volta> voltas) {
		this.voltas = voltas;
	}

	public int getPosicaoFinal() {
		return posicaoFinal;
	}

	public void setPosicaoFinal(int posicaoFinal) {
		this.posicaoFinal = posicaoFinal;
	}
	
}