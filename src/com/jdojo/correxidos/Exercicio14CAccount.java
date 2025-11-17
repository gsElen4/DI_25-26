package com.jdojo.correxidos;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Exercicio14CAccount {
	
	private DoubleProperty balance = new SimpleDoubleProperty(this, "balance", 100);
	
		public Exercicio14CAccount() {
			
		}
		
	public Exercicio14CAccount(double balance) {
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
