package com.jdojo.exercicios;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio18CalConBindings extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
	DoubleProperty prezo_unitario = new SimpleDoubleProperty();
	IntegerProperty cantidade = new SimpleIntegerProperty();
	DoubleProperty desconto = new SimpleDoubleProperty();
	//Campos de entrada
	TextField prezo_unitarioField = new TextField();
	TextField cantidadeField = new TextField();
	TextField descontoField = new TextField();
	
	//Etiqueta
	Label prezoTotalLbl = new Label();
	Label alertaLbl = new Label();
	
/*
	cantidade.addListener((obs,oldVal,newVal)->{
		double total = newVal.doubleValue() * prezo_unitario.get();
		prezoTotalLbl.setText(String.format("Total: %.2f €", total));
	});
	
	cantidadeField.textProperty().addListener((obs, oldVal, newVal)->{
		try{
			if(!newVal.isEmpty()) {
			cantidade.set(Integer.parseInt(newVal));
			}
		}catch (NumberFormatException e) {
			
		}
		});
	*/
	desconto.addListener((obs,oldVal,newVal)->{
		double total = newVal.doubleValue() * prezo_unitario.get();
		prezoTotalLbl.setText(String.format("Total: %.2f €", total));
	});
	
	descontoField.textProperty().addListener((obs, oldVal, newVal)->{
		try{
			if(!newVal.isEmpty()) {
			desconto.set(Double.parseDouble(newVal));
			}
		}catch (NumberFormatException e) {
			
		}
	});
	
	DoubleBinding total = prezo_unitario.multiply(cantidade)
            .subtract(prezo_unitario.multiply(cantidade).multiply(desconto.divide(100)));
	
	StringBinding alertaPrezo = Bindings.when(total.greaterThan(100)).then("Prezo alto").otherwise("");
	
	
	StringBinding totalFormatado = (StringBinding)Bindings.format("Total: %.2f€", total);
	
	prezoTotalLbl.textProperty().bind(totalFormatado);
	alertaLbl.textProperty().bind(alertaPrezo);
	
	VBox root = new VBox(new Label("Precio unitario:"),prezo_unitarioField,
						new Label("Precio cantidade: "), cantidadeField,
						new Label("Descuento: "), descontoField, alertaLbl,prezoTotalLbl);
	Scene scene = new Scene(root, 300, 200);
	stage.setScene(scene);
	stage.setTitle("Calculadora");
	stage.show();
	}
	
	public static void main(String[]args) {
		launch();
	}
}
