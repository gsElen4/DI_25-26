package com.jdojo.correxidos;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Exercicio20CParOuImpar extends Application{

	@Override
	public void start(Stage stage) {
		// Comezamos coas propiedades
		IntegerProperty numero = new SimpleIntegerProperty();

		// IU TextField e Label
		TextField numeroField = new TextField();
		Label paridadeLbl = new Label();

		// Como non temos un Binding axeitado para discernir se un número é par ou impar
		// creamos un propio
		StringBinding paridadeBinding = new StringBinding() {
			{
				// Ligamos a propiedade numero como dependencia.
				this.bind(numero);
			}

			@Override
			protected String computeValue() {
				// Escibimos a lóxica
				int valor = numero.get();
				return valor % 2 == 0 ? "PAR" : "IMPAR";
			}
		};

		// Enlazamos os datos coa interface gráfica.
		// O Binding creado o ligamos ao label
		paridadeLbl.textProperty().bind(paridadeBinding);
		// E o numero e TextField cun bind bidireccional
		numeroField.textProperty().bindBidirectional(numero, new NumberStringConverter());

		VBox root = new VBox(new Label("Introduce número:"), numeroField, paridadeLbl);

		Scene scene = new Scene(root, 300, 250);
		stage.setScene(scene);
		stage.setTitle("Indicador Par/Impar b");
		stage.show();

	}

}
