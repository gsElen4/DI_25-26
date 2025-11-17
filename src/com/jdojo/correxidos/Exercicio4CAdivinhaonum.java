package com.jdojo.correxidos;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio4CAdivinhaonum extends Application {
	private int intentosCount = 0;
	private int numeroSecreto ;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Adiviña o número");
		
		// Xeramos un número aleatorio para o xogo
		Random rand = new Random();
		numeroSecreto = rand.nextInt(100);

		// Precisamos tres Label un TextField e dous botón
		Label msg = new Label("Adiviña o número comprendido entre 0 e 100");
		TextField numero = new TextField();
		Button btnEnviar = new Button("Probar");
		Label resultado = new Label();
		Label intentos = new Label("Intentos: ");
		Button btnReiniciar = new Button("Reiniciar Xogo");
		Button btnRendirse = new Button("Rendirse");

		//
		btnEnviar.setOnAction(e -> {
			try {
				int intento = Integer.parseInt(numero.getText());
				if(intento<1 || intento>100) {
					resultado.setText("O resultado debe estar entre 0 e 100");
				} else if (intento > numeroSecreto){
					intentosCount++;
					resultado.setText("O número é máis baixo.");
					intentos.setText("Intentos: " + intentosCount);
				} else if (intento < numeroSecreto) {
					intentosCount++;
					resultado.setText("O número é máis alto.");
					intentos.setText("Intentos: " + intentosCount);
				} else {
					resultado.setText("Correcto o número é: " + numeroSecreto);
					resultado.setStyle("-fx-background-color: #BDFFC2;");
				}

			} catch (NumberFormatException ex) {
				System.out.println("Introduce un número válido");
			}
		});
		
		btnReiniciar.setOnAction( e -> {
			intentosCount = 0;
			numeroSecreto = rand.nextInt(100);
			resultado.setText("");
			resultado.setStyle("-fx-background-color: transparent;");
			numero.clear();				
		});
		
		btnRendirse.setOnAction( e -> {
			resultado.setText("O número secreto era: " + numeroSecreto);
			resultado.setStyle("-fx-background-color: #FFD3BD;");
				
		});
		
		VBox root = new VBox();
		root.getChildren().addAll(msg, numero, btnEnviar, btnReiniciar, btnRendirse, resultado, intentos);
		
		Scene scene = new Scene(root,300,200);
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
