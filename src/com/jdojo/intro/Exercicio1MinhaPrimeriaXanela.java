package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercicio1MinhaPrimeriaXanela extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage stage) throws Exception {
		String tit1 = "Miña primeira Xanela";
		String tit2 = "Título cambiado";

		VBox group = new VBox();
		group.getChildren();

		Button btnTit = new Button("Cambiar Título");

		group.getChildren().addAll(btnTit);

		Scene scene = new Scene(group, 400, 300);
		stage.setScene(scene);
		stage.setTitle(tit1);
		stage.show();

		btnTit.setOnAction(e -> {
			if (stage.getTitle().equals(tit1)) {
				stage.setTitle(tit2);
			} else {
				stage.setTitle(tit1);
			}
		});
	}


}
