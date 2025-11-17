package com.jdojo.correxidos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercicio23CControlarCirculoSliders extends Application {
	@Override
	public void start(Stage stage) {
		Pane root = new Pane();
		
		// Dámoslle ao círuclo unha posición inicial, un radio inicial e un recheo e borde
	    Circle circulo = new Circle(150, 150, 40, Color.ANTIQUEWHITE);
	    circulo.setStroke(Color.BLACK);
        
        // Creamos un slider para o radio o posicionamos e configuramos as súas características
	    Slider sliderRadio = new Slider(0,100,40);
	    sliderRadio.setShowTickLabels(true);
	    sliderRadio.setMajorTickUnit(20);
	    sliderRadio.relocate(85, 50);
	    
	    // Este slider o vinculamos á propiedade radius do circulo
	    circulo.radiusProperty().bind(sliderRadio.valueProperty());
	    
		// Agora facemos o mesmo pero para un slider para o grosor strokeWidth
	    Slider sliderGrosor = new Slider(0, 10, 2);
	    sliderGrosor.setShowTickLabels(true);
	    sliderGrosor.setMajorTickUnit(2);
	    sliderGrosor.relocate(85, 20);
	    
	    circulo.strokeWidthProperty().bind(sliderGrosor.valueProperty());
	    
	    root.getChildren().addAll(sliderRadio,sliderGrosor,circulo);
	    Scene scene = new Scene(root, 300, 250);
	    stage.setScene(scene);
	    stage.setTitle("Controlar un círculo con sliders");
	    stage.show();
	}
	
	public static void main (String[] args) {
		launch();
	}
}
