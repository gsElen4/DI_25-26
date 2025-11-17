package com.jdojo.correxidos;

public class Exercicio11CCoche {
	private String marca;
	private static int velocidade;
	
	public Exercicio11CCoche() {
	}
		
		// Métodos getter e setter para a propiedade marca e a propiedade velocidade
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
	    
	    // Método para modificala velocidade
	    public void acelerar(int incremento) {
	    	this.velocidade +=incremento;
	    }
}
