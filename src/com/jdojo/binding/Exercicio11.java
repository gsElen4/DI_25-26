package com.jdojo.binding;

public class Exercicio11 {
	public static void name(String[]args) {
		Exercicio11Coche coche = new Exercicio11Coche();
		
		coche.setMarca("Ford");
		System.out.print("La marca del coche es: " + coche.getMarca());
		
		coche.setVelocidade(50);
		System.out.print("El coche va a: " + coche.getVelocidade()+" km/h");
		
		coche.acelerar(20);
		System.out.print("El coche va a: " + coche.getVelocidade()+" km/h");
	}
}


