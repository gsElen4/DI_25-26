package com.jdojo.intro;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio7CicloVidaConsola extends Application {

	TextArea textTA = new TextArea();
	String fecha = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

	public Exercicio7CicloVidaConsola() {

		String name = Thread.currentThread().getName();
		System.out.println("Fio do constructor: " + name + "\n");
		textTA.appendText("[" + fecha + "]" + " Fio do constructor: " + name + "\n");
	}

	public void init() {
		String name = Thread.currentThread().getName();
		System.out.println("Fio do init(): " + name + "\n");
		textTA.appendText("[" + fecha + "]" + " Fio do init(): " + name + "\n");
	}

	@Override
	public void start(Stage stage) throws Exception {
		VBox group = new VBox();
		group.getChildren();

		Button btn = new Button("Pechar aplicación");

		// mensaje
		Label msgComp = new Label();
		msgComp.setStyle("-fx-text-fill: red");
		msgComp.setText("Pecha a aplicación e comproba na consola a mensaxe");

		String name = Thread.currentThread().getName();
		System.out.println("Fio do start(): " + name + "\n");
		textTA.appendText("[" + fecha + "]"+" Fio do start(): " + name + "\n");
		
		btn.setOnAction(e ->{
			Platform.exit();
			
		});
		VBox root = new VBox();
		root.setSpacing(5);
		root.getChildren().addAll(textTA, msgComp, btn);

		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.setTitle("Ciclo de vida con consola");
		stage.show();
	}

}
