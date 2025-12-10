package com.jdojo.ExCorrexidosT3;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Exercicio1 extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		// 1. Dous campos de texto
		
		Label aviso = new Label();
		
		Label label = new Label ("Introduce as coordenadas X e Y");
		TextField xField = new TextField();
		xField.setPromptText("Introduce a coordenada x");
		TextField yField = new TextField();
		yField.setPromptText("Introduce a coordenada y");
		
		// 2. Boton para mover o Stage
		
		Button btnMover = new Button("Mover xanela");
		
		btnMover.setOnAction(e -> {
			
			System.out.println("Max x " +  visualBounds.getMaxX() + "Max y " +  visualBounds.getMaxY());
			System.out.println("Tamaño ancho ventá " + stage.getWidth() + "Max y " +  "Tamaño altura ventá " + stage.getHeight());
			try {
				double x = Double.parseDouble(xField.getText());
				double y = Double.parseDouble(yField.getText());
				
				// 4. Comprobar coordenadas dentro dos límites
				if(x > visualBounds.getMinX() && x < visualBounds.getMaxX() - stage.getWidth() && 
						y > visualBounds.getMinY() && y < visualBounds.getMaxY() - stage.getHeight()) {
					stage.setX(x);
					stage.setY(y);
				}
				else{
					aviso.setText("Valores fóra dos límites");
				}
			}catch(NumberFormatException ex) {
				// 3. Comprobar que valores válidos
				aviso.setText("Introduce número válidos");
			}
		});
		
		VBox root = new VBox (10, label ,xField, yField , btnMover, aviso);
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main (String[] args) {
		launch(args);
	}

}
