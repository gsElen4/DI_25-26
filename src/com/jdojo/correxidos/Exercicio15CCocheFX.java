package com.jdojo.correxidos;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Exercicio15CCocheFX {
	
	private StringProperty marca = new SimpleStringProperty();
    private IntegerProperty velocidade = new SimpleIntegerProperty();

    public String getMarca() {
        return marca.get();
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }
    
    // NOVO MÉTODO: devolve a propiedade observable
    public StringProperty marcaProperty() {
        return marca;
    }

    public int getVelocidade() {
        return velocidade.get();
    }

    public void setVelocidade(int velocidade) {
        this.velocidade.set(velocidade);
    }
    
    // NOVO MÉTODO: devolve a propiedade observable
    public IntegerProperty velocidadeProperty() {
        return velocidade;
    }
    
    public void acelerar(int aumento) {
        this.velocidade.set(getVelocidade() + aumento);
    }
}
