package com.jdojo.correxidos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio15C extends Application{
	 @Override
	    public void start(Stage stage) {
		 Exercicio15CCocheFX meuCoche = new Exercicio15CCocheFX();
	        meuCoche.setMarca("McLaren");
	        meuCoche.setVelocidade(100);
	        
	        Label marcaLabel = new Label();
	        Label velocidadeLabel = new Label();
	        
	        // VINCULACIÓN: o texto dos labels está ligado ás propiedades do coche.
	        marcaLabel.textProperty().bind(meuCoche.marcaProperty());
	        velocidadeLabel.textProperty().bind(meuCoche.velocidadeProperty().asString("Velocidade: %d km/h"));
	        
	        Button botonAcelerar = new Button("Acelerar (+25 km/h)");
	        botonAcelerar.setOnAction(event -> meuCoche.acelerar(25));
	        
	        VBox root = new VBox(15, marcaLabel, velocidadeLabel, botonAcelerar);
	        root.setAlignment(Pos.CENTER);
	        
	        Scene scene = new Scene(root, 300, 200);
	        stage.setScene(scene);
	        stage.setTitle("Coche Dinámico");
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
		