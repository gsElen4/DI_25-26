package com.jdojo.binding;

public class Exercicio14Cuentas {
	public static void main(String[] args) {
		Exercicio14Account acc1 = new Exercicio14Account(1000.0);
		Exercicio14Account acc2 = new Exercicio14Account(2000.0);

		acc2.balanceProperty().bind(acc1.balanceProperty());

		acc2.balanceProperty().addListener(obs -> {
			System.out.println("O valor de acc2 está invalidado");
			System.out.println("O valor cambiou , pero ainda non foi validado");
		});

		acc2.balanceProperty().addListener((obs, oldValue, newValue) -> {
			System.out.println("O valor de acc2 antigo: " + oldValue);
			System.out.println("O valor de acc2 novo: " + newValue);
		});

		System.out.println("==Saldo inicial==");
		System.out.println("acc1: " + acc1.getBalance());
		System.out.println("acc1: " + acc2.getBalance());

		System.out.println("---Cambiando saldo de acc1 a 1200.0---");
		acc1.setBalance(1200.0);

		System.out.println("[Validando...] Saldo actual de acc2: " + acc2.getBalance());
	}
}