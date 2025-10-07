package com.jdojo.intro;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio7CicloVidaConsola extends Application{
	
	TextArea textTA = new TextArea();
	public Exercicio7CicloVidaConsola() {
	        String name = Thread.currentThread().getName();
	        System.out.println("Fio do constructor: " + name + "\n");
	        textTA.appendText("Fio do constructor: " + name + "\n");
	        textTA.setPadding("-fx-padding: 5px;-fx-background-color:#eef;");
	}

	public void init() {
		String name = Thread.currentThread().getName();
        System.out.println("Fio do init(): " + name);
	}
	@Override
		public void start(Stage stage) throws Exception{
		VBox group = new VBox();
		group.getChildren();
		
		Button btn = new Button("Pechar aplicación");
		
		//mensaje
		Label msgComp = new Label();
		msgComp.setStyle("-fx-text-fill: red");
		msgComp.setText("Pecha a aplicación e comproba na consola a mensaxe");
		
		String name = Thread.currentThread().getName();
        System.out.println("Fio do start(): " + name);
		
        
		
		
		VBox root = new VBox();
		 root.setSpacing(10);
		root.getChildren().addAll(textTA,msgComp,btn); 
		
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.setTitle("Ciclo de vida con consola");
		stage.show();
	}
	
	
	
}
