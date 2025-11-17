package com.jdojo.correxidos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Exercicio12CProduct {

	private String name;
	private Double price;
	
	// 1. pcs leva a lista de escoitadores. this representa a instancia bean que será orixe dos cambios.
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	// Constructor sen argumentos dacordo á convención JavaBeans
	public Exercicio12CProduct() {
		this.name="default";
		this.price = 10.0;
	}

	// Getters e setters que representan as propiedades
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double newPrice) {
		double oldPrice = this.price;
		this.price = newPrice;
		
		//2. No caso de existir escoitadores os notificamos do cambio.
		pcs.firePropertyChange("price", oldPrice, newPrice);
	}
	
	//3. Precisamos ademáis os métodos para engadir e eliminar escoitadores
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	//Sobreescribimos toString() para unha representación dos datos máis clara.
	@Override
	public String toString() {
		return "name = " + name + ", price = " + price;
	}
}