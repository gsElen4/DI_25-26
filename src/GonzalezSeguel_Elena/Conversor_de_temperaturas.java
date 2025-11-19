package GonzalezSeguel_Elena;

import java.util.List;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Conversor_de_temperaturas extends Application {

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

		// textFields
		TextField Celsius = new TextField("Introduce ºC");
		TextField Farenheit = new TextField("Introduce ºF");
		// Etiquetas
		Label CLbl = new Label("Celsius: ");
		Label FLbl = new Label("Farenheit: ");
		Label resultado = new Label();
		Label resultadoOp = new Label();

		// Botons (van en HBox)
		Button CaFbtn = new Button("C a F");
		Button FaCbtn = new Button("F a C");
		Button Limparbtn = new Button("Limpar");

		CaFbtn.setOnAction(e -> {
			double C = Double.parseDouble(Celsius.getText());
			try {
				if (isNumeric(Celsius.getText())) {
					resultadoOp.setText(String.valueOf((C * 9 / 5) + 32));
					Farenheit.setText(resultadoOp.getText());
					resultado.setText(C + "ºC" + " = " + resultadoOp.getText() + "%2ºF");
					resultado.setStyle("-fx-background-color: #BDFFC2;");
					
				} else {
					resultado.setText("Introduce un valor válido");
					resultado.setStyle("-fx-background-color: #FFD3BD;");
				}
			} catch (NumberFormatException n) {
			}
		});

		FaCbtn.setOnAction(e -> {
			double F = Double.parseDouble(Farenheit.getText());
			try {
				if (isNumeric(Farenheit.getText())) {
					resultadoOp.setText(String.valueOf((F * 9 / 5) + 32));
					Celsius.setText(resultadoOp.getText());
					resultado.setText(F + "ºF" + " = " + resultadoOp.getText() + "ºC");
					resultado.setStyle("-fx-background-color: #BDFFC2;");
				} else {
					resultado.setText("Introduce un valor válido");
					resultado.setStyle("-fx-background-color: #FFD3BD;");
				}
			} catch (NumberFormatException n) {
			}
		});

		Limparbtn.setOnAction(e -> {
			Celsius.clear();
			Farenheit.clear();
		
		});
		
		// HBox
		HBox CelsiusBox = new HBox(5);
		CelsiusBox.getChildren().addAll(CLbl, Celsius);

		HBox FarenheitBox = new HBox(5);
		FarenheitBox.getChildren().addAll(FLbl, Farenheit);

		HBox BtnBox = new HBox(5);
		BtnBox.getChildren().addAll(CaFbtn, FaCbtn, Limparbtn);

		VBox root = new VBox(10, CelsiusBox, FarenheitBox, BtnBox, resultado);
		Scene scene = new Scene(root, 300, 200);
		stage.setTitle("Conversor de temperaturas");
		stage.setScene(scene);
		stage.show();

		

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
