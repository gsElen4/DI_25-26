package com.jdojo.binding;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Exercicio14Account {
	
	private DoubleProperty balance = new SimpleDoubleProperty(this, "balance", 100);
	
		public Exercicio14Account() {
			
		}
		
	public Exercicio14Account(double balance) {
		this.balance.set(balance);
	}

	
	public final double getBalance() {
		return balance.get();
	}
	
	public final void setBalance(double balance) {
		this.balance.set(balance);;
	}
	
	public final DoubleProperty balanceProperty() {
		return this.balance;
	}

}
