package com.jdojo.correxidos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercicio5CTamanhoXanela extends Application{
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Cambiar tamaño da xanela");

		// Controis: dous TextField, dous label e un botón
		Label anchoLbl = new Label("Novo ancho");
		TextField ancho = new TextField();
		ancho.setPromptText("Indica o novo ancho..");

		HBox anchoBox = new HBox();
		anchoBox.getChildren().addAll(anchoLbl, ancho);

		Label altoLbl = new Label("Nova altura");
		TextField altura = new TextField();
		altura.setPromptText("Indica a nova altura..");

		HBox alturaBox = new HBox();
		alturaBox.getChildren().addAll(altoLbl, altura);

		Button btnRedimensionar = new Button("Redimensionar");

		// Configuramos o comportamento ao clicar o botón
		btnRedimensionar.setOnAction(e -> {
			try {
				Double novoAncho = Double.parseDouble(ancho.getText());
				Double novaAltura = Double.parseDouble(altura.getText());
				if (novoAncho > 0 && novaAltura > 0) {
					stage.setWidth(novoAncho);
					stage.setHeight(novaAltura);
				} else {
					System.out.println("Por favor, introduce valores positivos.");
				}

			} catch (NumberFormatException ex) {
				System.out.println("Por favor, introduce números válidos.");
			}

		});

		VBox root = new VBox();
		root.getChildren().addAll(anchoBox, alturaBox, btnRedimensionar);

		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
