package com.jdojo.ExCorrexidosT3;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio3 extends Application {

	//Leer propiedades da xanela
	/*Non se deben usar botóns nin accións manuais; toda a actualización 
	 * debe facerse mediante bindings de JavaFX.
	 */
	
	@Override
	public void start(Stage stage) {

		Label xLabel = new Label();
		Label yLabel = new Label();
		Label widthLabel = new Label();
		Label heightLabel = new Label();

		/*As etiquetas deben actualizarse automáticamente cando o usuario 
		  move ou redimensiona a xanela.*/
		 
		
		// Vinculamos as etiquetas co estado das propiedades do Stage
		/*Mostrar a coordenada X e Y da xanela.*/
		xLabel.textProperty().bind(Bindings.concat("X: ", stage.xProperty()));
		yLabel.textProperty().bind(Bindings.concat("Y: ", stage.yProperty()));
	//Mostrar o ancho e alto actuais da xanela.
		widthLabel.textProperty().bind(Bindings.concat("Ancho: ", stage.widthProperty()));
		heightLabel.textProperty().bind(Bindings.concat("Alto: ", stage.heightProperty()));

		VBox root = new VBox(10, xLabel, yLabel, widthLabel, heightLabel);
		Scene scene = new Scene(root, 300, 150);

		stage.setScene(scene);
		stage.setTitle("Propiedades de só lectura do Stage");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}