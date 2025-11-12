package com.jdojo.exercicios;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Exercicio18CalConBindings extends Application {
	@Override
	public void start(Stage stage) {
		// Propiedades do modelo
		DoubleProperty prezoUnitario = new SimpleDoubleProperty();
		IntegerProperty cantidade = new SimpleIntegerProperty();
		DoubleProperty desconto = new SimpleDoubleProperty();

		// Campos da IU
		TextField prezoUnitarioField = new TextField();
		TextField cantidadeField = new TextField();
		TextField descontoField = new TextField();

		// Seguimos empregando Listeners para actualizar as propiedades segundo a
		// entrada de texto
		prezoUnitarioField.textProperty().addListener((obs, oldVal, newVal) -> {
			try {
				prezoUnitario.set(newVal.isEmpty() ? 0.0 : Double.parseDouble(newVal));
			} catch (NumberFormatException e) {
				// Ignorar valores inválidos
			}
		});

		cantidadeField.textProperty().addListener((obs, oldVal, newVal) -> {
			try {
				cantidade.set(newVal.isEmpty() ? 0 : Integer.parseInt(newVal));
			} catch (NumberFormatException e) {
				// Ignorar valores inválidos
			}
		});

		descontoField.textProperty().addListener((obs, oldVal, newVal) -> {
			try {
				desconto.set(newVal.isEmpty() ? 0 : Integer.parseInt(newVal));
			} catch (NumberFormatException e) {
				// Ignorar valores inválidos
			}
		});

		// Seguimos coas vinculacións
		DoubleBinding total = prezoUnitario.multiply(cantidade);
		DoubleBinding totalConDesconto = total.multiply(Bindings.subtract(1, Bindings.divide(desconto, 100)));

		// Se o queremos formatear seria:
		StringBinding totalFormatado = (StringBinding) Bindings.format("Total: %.2f", totalConDesconto);

		// Creamos un binding ligado ao prezo para a mensaxe de Prezo algo
		StringBinding alertaPrezo = Bindings.when(totalConDesconto.greaterThan(100)).then("Prezo alto").otherwise("");

		// Creamos as etiquetas tanto para o total como para a alerta
		Label alertaLbl = new Label();
		Label totalConDescontoLbl = new Label();

		// Vinculamos a propiedade texto do elementos Label á
		alertaLbl.textProperty().bind(alertaPrezo);
		totalConDescontoLbl.textProperty().bind(totalFormatado);

		// Layout
		VBox root = new VBox(new Label("Prezo unitario (€):"), prezoUnitarioField, new Label("Cantidade:"),
				cantidadeField, new Label("Desconto (%):"), descontoField, totalConDescontoLbl, alertaLbl);
		root.setSpacing(8);

		Scene scene = new Scene(root, 300, 250);
		stage.setScene(scene);
		stage.setTitle("Calculadora de prezo total (Bindings)");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}