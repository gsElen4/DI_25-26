package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex5_ControladorPropStage extends Application{
	public static void main(String[]args) {
		launch();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Slider sliderOpacidade = new Slider(0.0, 1.0, 1.0);
        sliderOpacidade.setShowTickLabels(true);
        sliderOpacidade.setShowTickMarks(true);

        Label labelOpacidade = new Label();

        labelOpacidade.textProperty().bind(
                Bindings.createStringBinding(
                    () -> String.format("Opacidade: %.2f", sliderOpacidade.getValue()),
                    sliderOpacidade.valueProperty()
                )
            );
        stage.opacityProperty().bind(sliderOpacidade.valueProperty());

        CheckBox checkResizable = new CheckBox("Permitir redimensionar");
        checkResizable.setSelected(true);

        // Listener para activar/desactivar o tamaño cambiable
        checkResizable.selectedProperty().addListener((obs, oldVal, newVal) -> {
            stage.setResizable(newVal);
        });
        
        TextField txtMinWidth = new TextField();
        TextField txtMinHeight = new TextField();
        TextField txtMaxWidth = new TextField();
        TextField txtMaxHeight = new TextField();

        txtMinWidth.setPromptText("Min Width");
        txtMinHeight.setPromptText("Min Height");
        txtMaxWidth.setPromptText("Max Width");
        txtMaxHeight.setPromptText("Max Height");
        
        HBox filaMin = new HBox(10, new Label("Mínimos:"), txtMinWidth, txtMinHeight);
        HBox filaMax = new HBox(10, new Label("Máximos:"), txtMaxWidth, txtMaxHeight);

        
        Button btnAplicar = new Button("Aplicar Límites");
        Label msgEstado = new Label();

        btnAplicar.setOnAction(e -> {
            try {
                double minW = Double.parseDouble(txtMinWidth.getText());
                double minH = Double.parseDouble(txtMinHeight.getText());
                double maxW = Double.parseDouble(txtMaxWidth.getText());
                double maxH = Double.parseDouble(txtMaxHeight.getText());

                // Validacións
                if (minW > maxW || minH > maxH) {
                    msgEstado.setText("Erro: os valores mínimos non poden ser maiores cós máximos.");
                    msgEstado.setStyle("-fx-text-fill: red;");
                    return;
                }

                // Aplicar límites
                stage.setMinWidth(minW);
                stage.setMinHeight(minH);
                stage.setMaxWidth(maxW);
                stage.setMaxHeight(maxH);

                msgEstado.setText("Límites aplicados correctamente.");

            } catch (NumberFormatException ex) {
                msgEstado.setText("Erro: introduce só números válidos.");
            }
        });
        VBox root = new VBox(15);
        root.getChildren().addAll(labelOpacidade,sliderOpacidade,checkResizable,
                filaMin,filaMax,btnAplicar, msgEstado
        );
        root.setStyle("-fx-padding: 15;");

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Exercicio 5 - Control de Propiedades do Stage");
        stage.show();
	}
	
	
}
	

