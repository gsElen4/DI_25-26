package com.jdojo.intro;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Exercicio8MiniCalc extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		// opciones
		TextField Op1 = new TextField("Operando 1");
		TextField Op2 = new TextField("Operando 2");

		Label lblRes = new Label("Resultado");
		Label lblResNum = new Label();
		Label msg = new Label();

		// Botones
		Button btnSuma = new Button("+");
		Button btnResta = new Button("-");
		Button btnMult = new Button("x");
		Button btnDiv = new Button("/");
		try {
		if() {
		btnSuma.setOnAction(e -> {

		});

		btnResta.setOnAction(e -> {

		});
		btnMult.setOnAction(e -> {

		});

		btnDiv.setOnAction(e -> {

		});
		}
		}catch (NumberFormatException e){
			msg.setText("Introduce un numero valido");
		}

		HBox root = new HBox();
		root.setSpacing(5);
		root.getChildren();
		root.getChildren().addAll(Op1, Op2, lblRes, btnSuma, btnResta, btnMult, btnDiv);
		Scene scene = new Scene(root, 600, 50);

		stage.setScene(scene);
		stage.setTitle("Mini Calculadora");
		stage.show();
	
		
	}

	public boolean isNumeric(String str) {
		if (str == null || str.trim().isEmpty()) {
			return false;
		}
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}
}
