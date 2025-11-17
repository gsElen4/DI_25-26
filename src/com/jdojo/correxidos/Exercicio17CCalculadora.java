package com.jdojo.correxidos;

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

public class Exercicio17CCalculadora extends Application{
	 @Override
	    public void start(Stage stage) {
	        // Modelo de datos
	        DoubleProperty prezo_unitario = new SimpleDoubleProperty();
	        IntegerProperty cantidade = new SimpleIntegerProperty();

	        // Campos de entrada
	        TextField prezo_unitarioField = new TextField();
	        TextField cantidadeField = new TextField();

	        // Etiqueta para o prezo total
	        Label prezoTotalField = new Label("Total: 0.00€");

	        // Listener manual para actualizar o total cando cambia o prezo_unitario
	        prezo_unitario.addListener((obs, oldVal, newVal) -> {
	            double total = newVal.doubleValue() * cantidade.get();
	            prezoTotalField.setText(String.format("Total: %.2f€", total));
	        });

	        // Listener para actualizar o total cando cambia a cantidade
	        cantidade.addListener((obs, oldVal, newVal) -> {
	            double total = prezo_unitario.get() * newVal.intValue();
	            prezoTotalField.setText(String.format("Total: %.2f€", total));
	        });

	        // Listener para entrada de texto no campo prezo_unitario
	        prezo_unitarioField.textProperty().addListener((obs, oldVal, newVal) -> {
	            try {
	                if (!newVal.isEmpty()) {
	                    prezo_unitario.set(Double.parseDouble(newVal));
	                }
	            } catch (NumberFormatException e) {
	                // Ignorar valores inválidos
	            }
	        });

	        // Listener para entrada de texto no campo cantidade
	        cantidadeField.textProperty().addListener((obs, oldVal, newVal) -> {
	            try {
	                if (!newVal.isEmpty()) {
	                    cantidade.set(Integer.parseInt(newVal));
	                }
	            } catch (NumberFormatException e) {
	                // Ignorar valores inválidos
	            }
	        });

	        VBox root = new VBox(
	            new Label("Precio unitario:"), prezo_unitarioField,
	            new Label("Cantidade:"), cantidadeField,
	            prezoTotalField
	        );

	        Scene scene = new Scene(root, 300, 200);
	        stage.setScene(scene);
	        stage.setTitle("Calculadora de prezo total (listeners manuais)");
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch();
	    }
}
