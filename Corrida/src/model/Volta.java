package model;

import java.time.LocalTime;

public class Volta {

	private LocalTime tempo;

	private int numero;
	
	private double velocidadeMedia;
	
	public Volta() {
		
	}

	public Volta(LocalTime tempo, int numero, double velocidadeMedia) {
		this.tempo = tempo;
		this.numero = numero;
		this.velocidadeMedia = velocidadeMedia;
	}

	public LocalTime getTempo() {
		return tempo;
	}

	public void setTempo(LocalTime tempo) {
		this.tempo = tempo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	
}