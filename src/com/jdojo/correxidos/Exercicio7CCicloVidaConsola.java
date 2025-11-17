package com.jdojo.correxidos;

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

public class Exercicio7CCicloVidaConsola extends Application {

	// O TextField e a Lista de mensaxes
		// decláranse como atributo da clase para que poidan ser vistos dende o método
		// meulog()
		private TextArea consola = new TextArea();
		private final List<String> bufferMensaxes = new ArrayList<>();

		// Facemos explícito o constructor para mandar o log
		public Exercicio7CCicloVidaConsola() {
			meulog("Fío do constructor: ");
		}

		@Override
		public void init() {
			meulog("Fío do init()");
		}

		@Override
		public void start(Stage stage) {
			stage.setTitle("Ciclo de vida con log");
			
			meulog("Fío do start()");
			stage.setTitle("Ciclo de vida con consola");

			// Como controis precisamos un botón e o label da instrucción
			Button sairBtn = new Button("Pechar aplicación");
			Label msg = new Label("Pecha a aplicación e comproba na consola a mensaxe");
			msg.setStyle("-fx-text-fill: red;");
			

			// Indicamos o que debe realizar a apliación ao pulsar o botón
			sairBtn.setOnAction(e -> Platform.exit());
			// Como nó raíz imos colocar un VBox cunha cor e un padding dado
			VBox root = new VBox();
			root.setStyle("-fx-padding: 5px; -fx-background-color:#eef;");

			// Enlazamos o Botón e o TextArea ao nó raíz
			root.getChildren().addAll(consola, msg, sairBtn);

			Scene scene = new Scene(root, 300, 200);
			stage.setScene(scene);
			stage.show();

		}

		@Override
		public void stop() {
			System.out.println("Fío do stop: " + Thread.currentThread().getName());
		}

		private void meulog(String mensaxe) {
			// Meu log comeza cunha hora
			String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			// Cada método init(),start(),stop() chama a función meulog co seu propio fío
			String fio = Thread.currentThread().getName();
			String msgConsola = String.format("[%s] %s (%s) ", hora, mensaxe, fio);
			bufferMensaxes.add(msgConsola);

			if (consola != null) {
				consola.clear();
				for (String line : bufferMensaxes) {
					consola.appendText(line + "\n");
				}
			}

		}

		public static void main(String[] args) {
			launch(args);
		}

}
