package com.jdojo.correxidos;
import javafx.beans.Observable;

public class Exercicio14CCuentas {
	public static void main(String[] args) {
	        
		Exercicio14CAccount acc1 = new Exercicio14CAccount(2000.0);
		Exercicio14CAccount acc2 = new Exercicio14CAccount(100.0);
	        
	        
	        // Ligamos a propiedade balance acc2 á propiedade balance de acc1
	        acc2.balanceProperty().bind(acc1.balanceProperty());
	        
	        
	        // Engadimos un InvalidationListener ou listener de invalidación na propiedade balance do acc2
	        acc2.balanceProperty().addListener((Observable observable) -> {
	            System.out.println("\n[InvalidationListener] -> A propiedade 'balance' de acc2 foi invalidada.");
	            System.out.println("O valor cambiou, pero aínda non foi validado.\n");
	        });
	        
	        // Engadimos un ChangeListener ou listener de cambio
	        acc2.balanceProperty().addListener((obx, oldVal, newVal) -> {
	            System.out.println("\n[ChangeListener] -> Cambiou o balance de acc2:");
	            System.out.println("   Valor antigo: " + oldVal);
	            System.out.println("   Valor novo:   " + newVal + "\n");
	        });
	        
	        // Comprobamos estado do saldo inicial
	        System.out.println("=== Saldo inicial ===");
	        System.out.println("acc1: " + acc1.getBalance());
	        System.out.println("acc2: " + acc2.getBalance());
	        
	        // Comezamos cos cambios
	        System.out.println("\n--- Cambiando saldo de acc1 a 1200.0 ---");
	        acc1.setBalance(1200.0);
	        
	        // Validamos acc2 chamando getBalance()
	        System.out.println("[Validando..] Saldo actual de acc2 (despois de validar): " + acc2.getBalance());        
	        
	        System.out.println("\n--- Cambiando saldo de acc1 a 1300.0 ---");
	        acc1.setBalance(1300.0); 
	        // Validamos acc2
	        System.out.println("[Validando..] Saldo actual de acc2 (despois de validar): " + acc2.getBalance());

	        System.out.println("\n--- Cambiando saldo de acc1 a 1300.0 (mesmo valor, non debería disparar eventos) ---");
	        acc1.setBalance(1300.0);

	    }
}