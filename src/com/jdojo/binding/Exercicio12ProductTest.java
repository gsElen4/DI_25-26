package com.jdojo.binding;

public class Exercicio12ProductTest {
	 public static void main(String[] args) {
	  
	        Exercicio12Product p = new Exercicio12Product("Camiseta", 25.0);

	        System.out.println("Produto: " + p.getName());
	        System.out.println("Prezo inicial: " + p.getPrice());
	        System.out.println("Desconto: " + p.getDiscount());

	 
	        p.addPropertyChangeListener(evt -> {
	            if ("price".equals(evt.getPropertyName())) {
	                System.out.println(" O prezo cambiou:");
	                System.out.println("   Antigo: " + evt.getOldValue());
	                System.out.println("   Novo: " + evt.getNewValue());
	                System.out.println("   Novo desconto: " + ((Double) evt.getNewValue() * 0.10));
	            System.out.println();
	            }
	        });

	      
	        System.out.println("\nCambiando o prezo");
	        System.out.println("===================");
	        p.setPrice(30.0);
	        p.setPrice(30.0); 
	        p.setPrice(27.5); 
	        p.setPrice(22.0); 
	    }
}
