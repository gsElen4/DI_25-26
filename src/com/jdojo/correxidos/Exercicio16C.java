package com.jdojo.correxidos;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Exercicio16C extends Application {
	 @Override
	    public void start(Stage stage) {
	        // 1. Crear a propiedade nome
	        StringProperty nome = new SimpleStringProperty("Usuario");

	        // 2. Crear o campo de texto
	        TextField campoTexto = new TextField();

	        // 3. Vincular bidireccionalmente o campo de texto coa propiedade nome
	        campoTexto.textProperty().bindBidirectional(nome);

	        // 4. Crear un botón para cambiar o valor de nome a "Invitado"
	        Button botonCambiar = new Button("Cambiar a Invitado");
	        botonCambiar.setOnAction(e -> {
	            nome.set("Invitado");
	        });

	        VBox root = new VBox(10, campoTexto, botonCambiar);
	        Scene scene = new Scene(root, 300, 100);

	        stage.setScene(scene);
	        stage.setTitle("Exercicio Vinculación Bidireccional");
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch();
	    }
}
