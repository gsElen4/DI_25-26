package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio6MiniCuestionario extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		VBox root = new VBox();
		//pregunta
		Label lbl = new Label();
		lbl.setText("Cal é a capital de Galicia?" +
		"\n" + "- A Coruña" + "\n" + "- Santiago de Compostela"+ "\n" + "- Vigo");
		 //Boton
		Button btn = new Button("Enviar resposta");
		
		//Cuadro de texto
		TextField nameFld = new TextField();
	btn.setOnAction(e ->{
		if(nameFld.getText().isEmpty()){
			nameFld.setPromptText("Campo obrigatorio");
			
		}else {
			switch(nameFld.getText().toLowerCase().trim()) {
				case "a coruña": 
					root.setStyle("-fx-background-color: red");
					break;
				case "santiago de compostela": 
					root.setStyle("-fx-background-color: green");
					break;
				case "vigo": 
					root.setStyle("-fx-background-color: red");
					break;
			
				default:
					root.setStyle("-fx-background-color: orange");
					break;
			}
		}
	});
		root.getChildren().addAll(lbl, nameFld,btn);

		root.setSpacing(5);
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.setTitle("Mini Cuestionario");
		stage.show();
	

	}
}

