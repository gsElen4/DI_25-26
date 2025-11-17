package com.jdojo.correxidos;


import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio22CSliderseBindingBidi extends Application{
	@Override
	public void start(Stage stage) {
		Slider slider1 = new Slider(0, 100, 40);
		Slider slider2 = new Slider(0, 100, 40);
		
		//Sincronizamos os sliders
		slider1.valueProperty().bindBidirectional(slider2.valueProperty());
		
		slider1.setOrientation(Orientation.VERTICAL);
		
		VBox root = new VBox(slider1,slider2);
		
		Scene scene = new Scene(root, 200, 150);
		
		stage.setScene(scene);
		stage.setTitle("Sliders e binding");
		stage.show();	
		
        // keep in mind that isBound() doesn't work for bidirectional binding
        System.out.println(slider1.valueProperty().isBound()); // false
        System.out.println(slider2.valueProperty().isBound()); // false
	}
    public static void main(String[] args) {
        launch(args);
    }

}
