package com.jdojo.correxidos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercicio6CMiniCuestionario extends Application {
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Mini Cuestionario");
		
		//Os controis serán catro Label para a pregunta e opcións, un TextField para a resposta, un botón para enviar a resposta
		Label pregunta = new Label("Cal é a capital de Galicia?");
		Label lblOption1 = new Label ("- A Coruña");
		Label lblOption2 = new Label ("- Santiago de Compostela");
		Label lblOption3 = new Label ("- Vigo");
		TextField resposta = new TextField();
		Button btnEnviar = new Button("Enviar resposta");
		
		// Preparamos un Vertical Box para os elementos
		VBox root = new VBox();
		root.getChildren().addAll(pregunta,lblOption1,lblOption2,lblOption3,resposta,btnEnviar);
		
		//Programamos o comportamento do botón
		
		btnEnviar.setOnAction(e -> {
			resposta.setStyle("-fx-text-fill: black;");
			if(resposta.getText().trim().length()>0) {
				switch(resposta.getText().toLowerCase()) {
				case "a coruña" : root.setBackground(new Background(new BackgroundFill(Color.RED, null, null))); break;
				case "santiago de compostela" : root.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null))); break;
				case "vigo" : root.setBackground(new Background(new BackgroundFill(Color.RED, null, null))); break;
				default: root.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
				}
	
			} else {
				resposta.setText("Campo obrigatorio");
				resposta.setStyle("-fx-text-fill: red;");
			}
		});
		
	
        Scene scene = new Scene(root,300,200);
        stage.setScene(scene);
        stage.show();
	}
	
	public static void main (String[] args) {
		Application.launch(args);
	}
}

