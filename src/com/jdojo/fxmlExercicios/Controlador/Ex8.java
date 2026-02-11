package com.jdojo.fxmlExercicios.Controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Ex8 extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Ex8.class.getResource("/com/jdojo/fxmlExercicios/Vista/Ex8VistaMenu.fxml"));

		// Crear unha ventá

		Pane ventana = loader.load();

		Scene scene = new Scene(ventana);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
