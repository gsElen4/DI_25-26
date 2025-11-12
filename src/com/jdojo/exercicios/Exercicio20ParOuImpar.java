package com.jdojo.exercicios;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Exercicio20ParOuImpar extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		IntegerProperty enteiro = new SimpleIntegerProperty();

		TextField numEnteiro = new TextField();
		numEnteiro.textProperty().bindBidirectional(enteiro, new NumberStringConverter());

		//label
		
		
		StringBinding pariedadeNumero = new StringBinding() {
			{
			this.bind(enteiro);
		}
			@Override
			protected String computeValue() {
				int ent = enteiro.get();
				return ent %2 == 0? "Par":"Impar";
			}
		};
		Label pariedadeLbl = new Label();
		
		pariedadeLbl.textProperty().bind(pariedadeNumero);

		
		VBox root = new VBox(new Label("Número: "), numEnteiro, pariedadeLbl );
		root.setSpacing(5);
		
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.setTitle("Indicador Par/Impar");
		stage.show();
		
	}
	public static void main(String[] args) {
		launch();
	}

}
