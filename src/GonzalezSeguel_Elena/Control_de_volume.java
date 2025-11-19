package GonzalezSeguel_Elena;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Control_de_volume extends Application {
	@Override
	public void start(Stage stage) {
		
		
		Slider slider1 = new Slider(0, 100, 50);
		
		
		int perc = slider1.getMinorTickCount();
		
		Label VolumeLbl = new Label("Volume: +X%");
		Label NivelLbl = new Label();
		
	//slider1.valueProperty().bindBidirectional(nivel.);
		
		slider1.setOrientation(Orientation.HORIZONTAL);
		try {
		if(perc<30) {
			NivelLbl.setText("Baixo");
		} else if(perc>=30 && perc<=70) {
			NivelLbl.setText("Medio");
		} else {
			NivelLbl.setText("Alto");
		}
		
		VBox root = new VBox(15,VolumeLbl,NivelLbl,slider1);
		
		Scene scene = new Scene(root, 200, 150);
		
		stage.setScene(scene);
		stage.setTitle("Control de volume");
		stage.show();	
		
        // keep in mind that isBound() doesn't work for bidirectional binding
      //  System.out.println(slider1.valueProperty().isBound()); 
        // false
        
	} Finally
	}
}
    public static void main(String[] args) {
        launch(args);
    }

}
