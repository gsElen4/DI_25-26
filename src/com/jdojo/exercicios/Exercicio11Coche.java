package com.jdojo.exercicios;

public class Exercicio11Coche {
	private String marca;
	private static int velocidade;
	
	public Exercicio11Coche() {
	}
	
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getVelocidade() {
		return velocidade;
	}
	
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
	public void acelerar(int aumento) {
		velocidade = velocidade + aumento;
	}
}
