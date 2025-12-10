package com.jdojo.exerciciosT3;


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Ex7_PantallaCompleta extends Application {
	public static void main(String[]args) {
		launch();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Button ActDesactBtn = new Button ("Activar/Desactivar pantalla completa");
		Button MaxBtn = new Button ("Maximizar");
		Button RestBtn = new Button ("Restaurar");
		
		Label LblEstado = new Label("Estado de pantalla completa");
		Label LblDim = new Label("Dimensións");
		Label LblPos = new Label("Posición");
		
		ActDesactBtn.setOnAction(e ->{
			boolean isFullScreen  = stage.isFullScreen();
			stage.setFullScreen(!isFullScreen);
			if(stage.isFullScreen()) {
				LblEstado.setText("Modo completo");
			} else {
				LblEstado.setText("Non modo completo");
			}
		});
		
		MaxBtn.setOnAction(e ->{
			Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

	        // Configurar posición e tamaño da xanela para ocupar toda a pantalla
	        //stage.setX(visualBounds.getMinX());
	        //stage.setY(visualBounds.getMinY());
	        //stage.setWidth(visualBounds.getWidth());
	        //stage.setHeight(visualBounds.getHeight());
	        stage.setMaximized(true);
		});
		
		RestBtn.setOnAction(e ->{
			stage.centerOnScreen();
			stage.setWidth(300);
			stage.setHeight(200);
		});
		
		//Vinculacions
		LblDim.textProperty().bind(Bindings.concat("Ancho: ", stage.widthProperty(), "\nAlto: ", stage.heightProperty()));
		LblPos.textProperty().bind(Bindings.concat("Coordenada x: ", stage.xProperty(), "\nCoordenada y: ", stage.yProperty()));
		VBox root = new VBox (10, ActDesactBtn,MaxBtn, RestBtn, LblDim, LblPos );
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.show();
	}

}
