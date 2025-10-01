package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercicio5TamanhoXanela extends Application{
	public static void main(String[]args) {
		Application.launch(args);
	}
	
public void start(Stage stage) {
	
	Button btnRedim = new Button("Redimensionar");
	
	VBox root = new VBox();
	
	HBox root2 = new HBox();
	
	Label msgAnch = new Label();
	msgAnch.setText("Novo ancho");
	TextField txtAnch = new TextField();
	txtAnch.setPromptText("Indica o novo ancho");
	
	Label msgAlt = new Label();
	msgAlt.setText("Nova altura");
	TextField txtAlt = new TextField();
	txtAlt.setPromptText("Indica a nova altura");
	
	btnRedim.setOnAction(e ->{
		
	});
		
	
	root.setSpacing(5);
	root.getChildren().addAll(); 
	root2.getChildren().addAll(txtAnch,txtAlt);
	
	Scene scene = new Scene(root, 300, 200);
	stage.setScene(scene);
	stage.setTitle("Cambiar tamaño da xanela1");
	stage.show();
}
}
