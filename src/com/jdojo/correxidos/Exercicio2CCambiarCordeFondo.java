package com.jdojo.correxidos;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercicio2CCambiarCordeFondo extends Application{

	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Cambiar cor de fondo");
		
		Button btnVermello = new Button("Vermello");
		Button btnVerde = new Button("Verde");
		Button btnAzul = new Button("Azul");
		
		VBox root = new VBox();
		root.getChildren().addAll(btnVermello,btnVerde,btnAzul);
		
		btnVermello.setOnAction(e -> root.setBackground(new Background(new BackgroundFill(Color.RED, null, null))));
        btnVerde.setOnAction(e -> root.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null))));
        btnAzul.setOnAction(e -> root.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null))));
		
        Scene scene = new Scene(root,300,200);
        stage.setScene(scene);
        stage.show();
	}
	
	public static void main (String[] args) {
		Application.launch(args);
	}

}
