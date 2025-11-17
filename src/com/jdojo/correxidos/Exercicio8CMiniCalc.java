package com.jdojo.correxidos;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Exercicio8CMiniCalc extends Application {
	// Esta función a metemos para verificar que o que se mete nos TextField son
	// números.

	private boolean isNumeric(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public void start(Stage stage) {

		stage.setTitle("Mini Calculadora");

		// Precisamos dous TextField e un Label para o resultado

		TextField txtFld1 = new TextField("Operando 1");
		TextField txtFld2 = new TextField("Operando 2");

		Label result = new Label("Resultado: ");

		// Precisamos os botóns das operacións

		Button sumarBtn = new Button("+");
		Button restarBtn = new Button("-");
		Button multiplicaBtn = new Button("x");
		Button divideBtn = new Button("/");

		// Accións para os botóns

		sumarBtn.setOnAction(e -> {
			if (isNumeric(txtFld1.getText()) && isNumeric(txtFld2.getText())) {
				result.setText(
						String.valueOf(Double.parseDouble(txtFld1.getText()) + Double.parseDouble(txtFld2.getText())));
			} else {
				result.setText("Falta algún operando");
			}
		});
		restarBtn.setOnAction(e -> {
			if (isNumeric(txtFld1.getText()) && isNumeric(txtFld2.getText())) {
				result.setText(
						String.valueOf(Double.parseDouble(txtFld1.getText()) - Double.parseDouble(txtFld2.getText())));
			} else {
				result.setText("Falta algún operando");
			}
		});
		multiplicaBtn.setOnAction(e -> {
			if (isNumeric(txtFld1.getText()) && isNumeric(txtFld2.getText())) {
				result.setText(
						String.valueOf(Double.parseDouble(txtFld1.getText()) * Double.parseDouble(txtFld2.getText())));
			} else {
				result.setText("Falta algún operando");
			}
		});
		divideBtn.setOnAction(e -> {
			if (isNumeric(txtFld1.getText()) && isNumeric(txtFld2.getText())) {
				result.setText(
						String.valueOf(Double.parseDouble(txtFld1.getText()) / Double.parseDouble(txtFld2.getText())));
			} else {
				result.setText("Falta algún operando");
			}
		});

		HBox root = new HBox();
		root.getChildren().addAll(txtFld1, txtFld2, result, sumarBtn, restarBtn, multiplicaBtn, divideBtn);

		Scene scene = new Scene(root, 600, 50);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
