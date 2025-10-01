package com.jdojo.intro;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio4Adivinhaonum extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	int contador = 0;
	int i;
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.getChildren();

		Label nameLbl = new Label("Adiviña o número comprendido entre 0 a 100");
		

		Button btnProba = new Button("Probar");
		Button btnRein = new Button("Reiniciar Xogo");
		Button btnRendir = new Button("Rendirse");

		Random generador = new Random(); // generador del número random
		 i = generador.nextInt(100);

		Label msg = new Label();
		msg.setStyle("-fx-text-fill: black;");// mensaje
		
		TextField nameFld = new TextField();
		
		Label msg2 = new Label();

		// Botones
		btnProba.setOnAction(e -> {
			try {
				int n = Integer.parseInt(nameFld.getText());
				if (n > i && n<=100) {
					msg.setStyle("-fx-background-color: transparent");
					msg.setText("O número é mais baixo");
					contador++;
				} else if (n < i) {
					msg.setStyle("-fx-background-color: transparent");
					msg.setText("O número é mais alto");
					contador++;
				}
				else if (n == i) {
					msg.setStyle("-fx-background-color: lightgreen");
					msg.setText("Correcto o número é: " + i);
					contador++;
				}
				msg2.setText("Intentos: " + contador);
			
		} catch(NumberFormatException ex) {
			msg.setText("O caracter introducido non é un número");
		}
		});
		
		

		btnRein.setOnAction(e -> {
			contador= 0;
			i = generador.nextInt(100);
			msg2.setText("Intentos: " + contador);
            msg.setText("");
            nameFld.clear();
		});

		btnRendir.setOnAction(e -> {
			msg.setStyle("-fx-background-color: lightcoral");
			msg.setText("O número secreto era: " + i);
		});
			
		
		msg2.setText("Intentos: "+ contador);
		root.getChildren().addAll(nameLbl, nameFld, btnProba, btnRein, btnRendir, msg, msg2);

		root.setSpacing(5);
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.setTitle("Adiviña o número");
		stage.show();
	}
}
