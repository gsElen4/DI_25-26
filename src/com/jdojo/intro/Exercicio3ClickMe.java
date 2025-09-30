package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio3ClickMe extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	private int contador=0;
	@Override
	public void start(Stage stage) throws Exception {
		
		VBox group = new VBox();
		group.getChildren();
		 
		
		Label nameLbl = new Label("0");
		Button btnIncr = new Button("Incrementar");
		
		btnIncr.setOnAction(e -> {
			contador++;
			nameLbl.setText(String.valueOf(contador));	
		});
		
		VBox root = new VBox();
		 root.setSpacing(10);
		root.getChildren().addAll(nameLbl,btnIncr); 
		
		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
		stage.setTitle("Click me!");
		stage.show();
	}
	

}
