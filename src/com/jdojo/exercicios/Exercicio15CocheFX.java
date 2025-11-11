package com.jdojo.exercicios;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Exercicio15CocheFX {
	
	private StringProperty marca = new SimpleStringProperty();
	private IntegerProperty velocidade = new SimpleIntegerProperty();

	public Exercicio15CocheFX() {
	}
	
	public String getMarca() {
		return marca.get();
	}
	
	public void setMarca(String marca) {
		this.marca.set(marca);
	}
	
	public int getVelocidade() {
		return velocidade.get();
	}
	
	public void setVelocidade(int velocidade) {
		this.velocidade.set(velocidade);
	}
	
	public void acelerar(int aumento) {
	this.velocidade.set(this.velocidade.get()+ aumento);	
	}
	
	public StringProperty marcaProperty() {
		return marca;
	}
	public IntegerProperty velocidadeProperty() {
		return velocidade;
	}
}
