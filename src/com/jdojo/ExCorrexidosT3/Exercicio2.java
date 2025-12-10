package com.jdojo.ExCorrexidosT3;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;

import static javafx.stage.Modality.*;

public class Exercicio2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		// 1. Dous campos de texto
		
		Label aviso = new Label();
		
		Label label = new Label ("Introduce as coordenadas X e Y");
		TextField xField = new TextField();
		xField.setPromptText("Introduce a coordenada x entre 0 - " + visualBounds.getMaxX());
		TextField yField = new TextField();
		yField.setPromptText("Introduce a coordenada y entre 0 - " + visualBounds.getMaxY());
		
		
		xField.textProperty().addListener((obs, oldVal, newVal) -> {
			try {
				double x =  Double.parseDouble(xField.getText());
				
				if(x > visualBounds.getMinX() && x < visualBounds.getMaxX() - stage.getWidth()) {
					stage.setX(x);
				} else {
					showDialog(stage, WINDOW_MODAL, "Ancho fóra do rango");
				}
				
			} catch(NumberFormatException ex) {
				showDialog(stage, WINDOW_MODAL, "Débense escribir valores numéricos");
			}
		});
		
		
		VBox root = new VBox (10, label ,xField, yField , aviso);
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.show();
		
	}
	
    private void showDialog(Window owner, Modality modality, String msg) {
        Stage stage = new Stage(); // Nova xanela
        stage.initOwner(owner);// Configuramos o propietario desta nova xanela
        stage.initModality(modality); // e a modalidade

        Label avisoLabel = new Label(msg);
        Button closeButton = new Button("Pechar");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox(10);
        root.getChildren().addAll(avisoLabel, closeButton);
        Scene scene = new Scene(root, 200, 100);

        stage.setScene(scene);
        stage.setTitle("Caixa de diálogo");
        stage.show();
    }
	
	public static void main (String[] args) {
		launch(args);
	}

}
