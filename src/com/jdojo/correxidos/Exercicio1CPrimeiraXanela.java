package com.jdojo.correxidos;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Exercicio1CPrimeiraXanela extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Miña primera xanela");
		
		Button btn = new Button("Cambiar título");
		
		btn.setOnAction(e ->  {
			if(stage.getTitle().equals("Miña primera xanela")) {
				stage.setTitle("Título cambiado");
			} else {
				stage.setTitle("Miña primera xanela");
			}
		});
		
		Group root = new Group(); 
		root.getChildren().add(btn);
		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
