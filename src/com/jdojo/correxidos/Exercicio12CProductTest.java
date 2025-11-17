package com.jdojo.correxidos;
import java.beans.PropertyChangeEvent;

public class Exercicio12CProductTest {

	public static void main (String[] args) {
		Exercicio12CProduct newProduct = new Exercicio12CProduct();
		
		System.out.println(newProduct);
		computeDiscount(newProduct.getPrice());
		
		//4. Suscribimos un listener ao prezo do produto.
		newProduct.addPropertyChangeListener(Exercicio12CProductTest::handlePropertyChange);
		
		//6. Modificamos o prezo para comprobar se lanzamos o listener.
		newProduct.setPrice(20.0);
		newProduct.setPrice(20.0);
		newProduct.setPrice(30.0);
	}
	
	
	//5. O listener é a implementación da interface
	public static void handlePropertyChange(PropertyChangeEvent e) {
	      String propertyName= e.getPropertyName();
	      if("price".equals(propertyName)) {
	    	  System.out.println("Precio novo " + e.getNewValue());
	    	  System.out.println("Precio antigo " + e.getOldValue());
	    	  computeDiscount((Double)e.getNewValue());
	      }
	}


	private static void computeDiscount(Double newValue) {
		final double DISCOUNT = 10.0;
		double discount = newValue - (newValue * DISCOUNT /100);
		System.out.println("--------- Calculo desconto -----------");
  	  	System.out.println("Precio novo: " + newValue + " Precio con desconto: " + discount);
  	  	System.out.println("-------------------------------------");
	}
}
