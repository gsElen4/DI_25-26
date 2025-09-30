package com.jdojo.intro;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImprovedHelloFXApp extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start (Stage stage) {
	//Elementos da UI
		Label nameLbl = new Label("Introduce o teu nome");
		TextField nameFld = new TextField();
		
	//Esta vai ser a etiqueta do mensaxe do boton
		Label msg = new Label();
		msg.setStyle("-fx-text-fill: blue;");
		
	//Creamos os botons
		Button btnOla = new Button("Dicir Ola");
		Button btnSair = new Button("Sair");
		
	//Crear controlador para manexar o evento do boton Dicir Ola
		btnOla.setOnAction(e -> {
            String name = nameFld.getText();
            if (name.trim().length() > 0) {
                msg.setText("Ola " + name);
            } else {
                msg.setText("Ola descoñecido");
            }
        });
		//Crear controlador para manexar o evento do boton Sair
				btnSair.setOnAction(e -> Platform.exit());
		
		VBox root = new VBox();
		 root.setSpacing(5);
		root.getChildren().addAll(nameLbl, nameFld, msg, btnOla, btnSair); 
		
		Scene scene = new Scene(root, 350, 150);
		stage.setScene(scene);
		
 	//Mostramos o escenario
		stage.show();
	}
}
