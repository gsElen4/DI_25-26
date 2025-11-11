package com.jdojo.exercicios;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio17Calculadora extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		
	DoubleProperty prezo_unitario = new SimpleDoubleProperty();
	IntegerProperty cantidade = new SimpleIntegerProperty();
	
	//Campos de entrada
	TextField prezo_unitarioField = new TextField();
	TextField cantidadeField = new TextField();
	
	//Etiqueta
	Label precioTotalLbl = new Label();
	
	prezo_unitario.addListener((obs,oldVal,newVal)->{
		double total = newVal.doubleValue() * cantidade.get();
		precioTotalLbl.setText(String.format("Total: %.2f €", total));
		
	});
	prezo_unitarioField.textProperty().addListener((obs, oldVal, newVal)->{
		try{
			if(!newVal.isEmpty()) {
				prezo_unitario.set(Double.parseDouble(newVal));
			}
			
		}catch (NumberFormatException e) {
			
		}
		});
	cantidade.addListener((obs,oldVal,newVal)->{
		double total = newVal.doubleValue() * prezo_unitario.get();
		precioTotalLbl.setText(String.format("Total: %.2f €", total));
	});
	cantidadeField.textProperty().addListener((obs, oldVal, newVal)->{
		try{
			if(!newVal.isEmpty()) {
			cantidade.set(Integer.parseInt(newVal));
			}
		}catch (NumberFormatException e) {
			
		}
		});
	
		
	
	VBox root = new VBox(new Label("Precio unitario:"),prezo_unitarioField,new Label("Precio cantidade: "), cantidadeField,precioTotalLbl);
	Scene scene = new Scene(root, 300, 200);
	stage.setScene(scene);
	stage.setTitle("Calculadora");
	stage.show();
	}
	
	public static void main(String[]args) {
		launch();
	}
}
