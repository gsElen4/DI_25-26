package com.jdojo.exercicios;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio15 extends Application{
	public static void main(String[]args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Exercicio15CocheFX meuCoche = new Exercicio15CocheFX();
		meuCoche.setMarca("McLaren");
		meuCoche.setVelocidade(100);

		Label marcaLabel = new Label();
		Label velocidadeLabel = new Label();
		
		//Vinculamos propiedades
		
		marcaLabel.textProperty().bind(meuCoche.marcaProperty());
		velocidadeLabel.textProperty().bind(meuCoche.velocidadeProperty().asString("Velocidade: %d km/h: "));
		
		Button botonAcelerar =  new Button("Acelerar +25km/h");
		
		botonAcelerar.setOnAction( e->{ 
			meuCoche.acelerar(25);
		});
		
		VBox root = new VBox(15, marcaLabel, velocidadeLabel, botonAcelerar);
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.show();
	}
	
	
}
		