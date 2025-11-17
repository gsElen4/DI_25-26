package com.jdojo.correxidos;

public class Exercicio11C {
	public static void main(String[] args) {
		Exercicio11CCoche meuCoche = new Exercicio11CCoche();
		
		meuCoche.setMarca("Ford");
        System.out.println("A marca do coche é: " + meuCoche.getMarca());
        
        meuCoche.setVelocidade(50);
        System.out.println("Velocidade inicial: " + meuCoche.getVelocidade() + " km/h");
        
        // Usamos un método que modifica a propiedade
        meuCoche.acelerar(20);
        
        // Obter e imprimir a velocidade final
        System.out.println("Velocidade despois de acelerar: " + meuCoche.getVelocidade() + " km/h");
	}
}


