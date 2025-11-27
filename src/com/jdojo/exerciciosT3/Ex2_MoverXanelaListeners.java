package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Ex2_MoverXanelaListeners extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {

		Screen screen = Screen.getPrimary();
		double maxWidth = screen.getVisualBounds().getWidth();
		double maxHeight = screen.getVisualBounds().getHeight();

		TextField XTF = new TextField();
		XTF.setPromptText("Introduce coordenada X");
		TextField YTF = new TextField();
		YTF.setPromptText("Introduce coordenada Y");

		Label infoLabel = new Label();

		XTF.textProperty().addListener((obs, oldValue, newValue) -> {
			moverXanela(stage, XTF, YTF, maxWidth, maxHeight);
		});

		YTF.textProperty().addListener((obs, oldValue, newValue) -> {
			moverXanela(stage, XTF, YTF, maxWidth, maxHeight);
		});

		VBox root = new VBox(10);
		root.getChildren().addAll(XTF, YTF, infoLabel);

		Scene scene = new Scene(root, 250, 150);
		stage.setScene(scene);
		stage.setTitle("Mover a xanela con Listeners");
		stage.show();
	}

	private void moverXanela(Stage stage, TextField XTF, TextField YTF, double maxWidth, double maxHeight) {
		String xs = XTF.getText();
		String ys = YTF.getText();

		if (xs.isEmpty() || ys.isEmpty()) {
			return;
		}

		double x, y;

		try {
			x = Double.parseDouble(xs);
			y = Double.parseDouble(ys);
		} catch (NumberFormatException ex) {
			mostrarDialogo("Erro: Introduce números válidos.", stage);
			return;
		}

		if (x < 0 || x > maxWidth || y < 0 || y > maxHeight) {
			mostrarDialogo("Erro: Coordenadas fóra de rango.", stage);
			return;
		}

		stage.setX(x);
		stage.setY(y);
	}

	private void mostrarDialogo(String mensaxe, Stage owner) {
		Alert alert = new Alert(AlertType.WARNING, mensaxe, ButtonType.CLOSE);
		alert.initOwner(owner);
		alert.initModality(Modality.WINDOW_MODAL);
		alert.setTitle("Aviso");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
}
