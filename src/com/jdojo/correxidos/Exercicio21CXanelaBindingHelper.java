package com.jdojo.correxidos;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Exercicio21CXanelaBindingHelper extends Application {
	@Override
	public void start(Stage stage) {

		// Creamos o botón e establecemos o texto
		Button btn = new Button("Click me");

		VBox root = new VBox(btn);
		// Metemos un background
		root.setBackground(Background.EMPTY);

		Scene scene = new Scene(root, 300, 250);

		ObjectBinding<Paint> objectBinding = Bindings
				.createObjectBinding(() -> btn.isPressed() ? Color.MAGENTA : Color.AQUA, btn.pressedProperty() // Dependencia
				);

		// O Binding o vinculamos á propiedade fillProperty
		scene.fillProperty().bind(objectBinding);
		// Outra opción con when-then-otherwise
		// scene.fillProperty().bind(
		// Bindings.when(btn.pressedProperty())
		// .then(Color.MAGENTA)
		// .otherwise(Color.AQUA)
		// );
		stage.setScene(scene);
		stage.setTitle("Xanela con Binding helper");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
