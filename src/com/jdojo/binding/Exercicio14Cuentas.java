package com.jdojo.binding;

public class Exercicio14Cuentas {
	public static void main(String[]args) {
	Exercicio14Account acc1 = new Exercicio14Account(1000.0);
	Exercicio14Account acc2 = new Exercicio14Account(2000.0);

	acc2.balanceProperty().bind(acc1.balanceProperty());
	
	
}
}