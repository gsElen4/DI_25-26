package com.jdojo.correxidos;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio3CClickMe extends Application {
	
	//Precisamos unha propiedade para almacenar o valor do contador
	private int clickCount = 0;
	
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Click Me!");
		
		// Agora temos que crear os controis un Label para amosar o número e un botón para incremetar
		
		Label count = new Label();
		count.setText(String.valueOf(clickCount));
		Button btnIncrement = new Button("Incrementar");
		
		// Agora indicamos que facer cando clicamos
		btnIncrement.setOnAction(e -> {
			clickCount++;
			count.setText(String.valueOf(clickCount));
		});
		
		//Creamos o elemento root a escena e adxuntamos os elementos
		VBox root = new VBox();
		root.getChildren().addAll(count,btnIncrement);
		root.setSpacing(10);
		
		Scene scene = new Scene(root,300,300);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main (String[] args) {
		Application.launch(args);
	}

}
