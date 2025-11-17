package com.jdojo.correxidos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio9CToDoList extends Application {
	private int numeroTarefa = 1;

	@Override
	public void start(Stage stage) {

		stage.setTitle("To-Do List");

		// Neste exercicio precisamos un TextField para introducir cada tarefa e un
		// botón para engadila
		TextField tarefa = new TextField();
		Button btnEngadir = new Button("Nova tarefa");

		// Precisamos o nó raíz
		VBox root = new VBox();
		root.getChildren().addAll(tarefa, btnEngadir);

		// Neste caso cada vez que introduzamos unha tarefa deberemos vincular un novo
		// label a root.

		/*
		 * Imos crear un método engadirTarefa(TextField, VBox) en vez de
		 * btnEngadir.setOnAction(e -> {
		 * 
		 * Label lblTarefa = new Label(tarefa.getText());
		 * root.getChildren().add(lblTarefa); listaTarefas.add(tarefa.getText()); });
		 */
		btnEngadir.setOnAction(e -> engadirTarefa(tarefa, root));

		Scene scene = new Scene(root, 300, 400);
		stage.setScene(scene);
		stage.show();

	}

	private void engadirTarefa(TextField novaTarefa, VBox root) {
		novaTarefa.setStyle("-fx-text-fill: black;");
		if (novaTarefa.getText().trim().length() > 0) {
			Label lblTarefa = new Label("Tarefa_" + numeroTarefa + ": " + novaTarefa.getText());
			lblTarefa.setStyle("-fx-padding: 6;");
			root.getChildren().add(lblTarefa);
			numeroTarefa++;
		} else {
			novaTarefa.setText("Campo obrigatorio");
			novaTarefa.setStyle("-fx-text-fill: red;");
		}

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
