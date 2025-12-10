package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex3_LeerPropXanela extends Application{
	public static void main(String[]args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Label lblX = new Label();
		Label lblY = new Label();
		Label lblAncho = new Label();
		Label lblAlto = new Label();
		
		lblX.textProperty().bind(
                Bindings.concat("Posición X: ", stage.xProperty())
        );

        lblY.textProperty().bind(
                Bindings.concat("Posición Y: ", stage.yProperty())
        );

        lblAncho.textProperty().bind(
                Bindings.concat("Ancho: ", stage.widthProperty())
        );

        lblAlto.textProperty().bind(
                Bindings.concat("Alto: ", stage.heightProperty())
        );

        VBox root = new VBox(10, lblX, lblY, lblAncho, lblAlto);

        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Propiedades da xanela");
        stage.setScene(scene);
        stage.show();
    }

		
	
	
	
}
