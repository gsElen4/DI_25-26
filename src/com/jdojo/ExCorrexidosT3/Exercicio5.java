package com.jdojo.ExCorrexidosT3;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio5 extends Application {

	@Override
	public void start(Stage stage) {
		// O primeiro é crear os controis
		Label opacityLabel = new Label("Opacidade: 1.0");
		Slider opacitySlider = new Slider(0.0, 1.0, 1.0);

		CheckBox resizableBox = new CheckBox("Redimensionable");
		resizableBox.setSelected(true);

		TextField minWidthField = new TextField("200");
		TextField minHeightField = new TextField("150");
		TextField maxWidthField = new TextField("800");
		TextField maxHeightField = new TextField("600");

		Button aplicarLimitesBtn = new Button("Aplicar Límites");
		Label avisoLabel = new Label();

		// Ligamos a propiedade de opacidade ao valor do slider
		stage.opacityProperty().bind(opacitySlider.valueProperty());

		// O Label está ligado a un texto personalizado que dependerá do valor do slider.
		// Bindings.createStringBinding(lambda, propiedade)
		opacityLabel.textProperty().bind(Bindings.createStringBinding(
				() -> String.format("Opacidade: %.2f", opacitySlider.getValue()), opacitySlider.valueProperty())
		);
		// Con Bindings.format
		// opacityLabel.textProperty().bind(Bindings.format("Opacidade: %.2f", opacitySlider.valueProperty()));
		// A propiedade do checkbox tamén terá un oínte que cambiará a propiedade do
		// stage setResizable()
		 resizableBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
			stage.setResizable(newVal);
		});
		/* Isto non funciona porque se vinculamos o checkBox á propiedade logo non poderemos
		 * modificar o checkBox clicando sobre él.
		resizableBox.selectedProperty().bind(stage.resizableProperty());
		*/
		

		aplicarLimitesBtn.setOnAction(e -> {
			try {
				double minWidth = Double.parseDouble(minWidthField.getText());
				double minHeight = Double.parseDouble(minHeightField.getText());
				double maxWidth = Double.parseDouble(maxWidthField.getText());
				double maxHeight = Double.parseDouble(maxHeightField.getText());

				// Validamos que os valores teñan lóxica
				if (minWidth > maxWidth || minHeight > maxHeight) {
					avisoLabel.setText("Os valores mínimos non poden ser maiores que os máximos!");
					avisoLabel.setStyle("-fx-text-fill: red;");
					return;
				}

				stage.setMinWidth(minWidth);
				stage.setMinHeight(minHeight);
				stage.setMaxWidth(maxWidth);
				stage.setMaxHeight(maxHeight);

				avisoLabel.setText("Límites aplicados correctamente!");
				avisoLabel.setStyle("-fx-text-fill: green;");

			} catch (NumberFormatException ex) {
				avisoLabel.setText("Introduce valores numéricos válidos!");
				avisoLabel.setStyle("-fx-text-fill: red;");
			}
		});

			
		// Creo primeiro os HBox
		
		HBox opacidadeLayout = new HBox(opacityLabel, opacitySlider);
		HBox anchoMinLayout = new HBox(10, new Label("Ancho mín:"), minWidthField);
		HBox altoMinLayout = new HBox(10, new Label("Alto mín:"), minHeightField);
		HBox anchoMaxLayout = new HBox(10, new Label("Ancho máx:"), maxWidthField);
		HBox altoMaxLayout = new HBox(10, new Label("Alto máx:"), maxHeightField);

		
		VBox root = new VBox(10, new Label("Control de opacidade"),
				opacidadeLayout,
				resizableBox,
				new Label("Límites de tamaño:"),
				anchoMinLayout,
				altoMinLayout,
				anchoMaxLayout,
				altoMaxLayout,
				aplicarLimitesBtn,
				avisoLabel				
				);
		
		
		Scene scene = new Scene(root, 400, 350);
		stage.setScene(scene);
		stage.setTitle("Controlador de propiedades do Stage");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}