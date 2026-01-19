package com.jdojo.ExCorrexidosT3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Exercicio6 extends Application {

	@Override
    public void start(Stage stage) {
    	// Botóns para abrir as diferentes ventás
        Button abrirVenta = new Button("Abrir");
        ComboBox<String> comboModality = new ComboBox<>();
        comboModality.getItems().addAll("NONE", "WINDOW_MODAL", "APPLICATION_MODAL");
        comboModality.getSelectionModel().selectFirst();
        
        abrirVenta.setOnAction(e -> {
        	String seleccionado = comboModality.getValue();
            Modality modalidade;

            switch (seleccionado) {
                case "WINDOW_MODAL":
                	modalidade = Modality.WINDOW_MODAL;
                    break;
                case "APPLICATION_MODAL":
                	modalidade = Modality.APPLICATION_MODAL;
                    break;
                default:
                	modalidade = Modality.NONE;
                    break;
            }
            
            abrirXanela(stage,modalidade,seleccionado);
        });
        
        
        VBox root = new VBox(10, comboModality, abrirVenta);
        Scene scene = new Scene(root, 300, 200);
        
        stage.setScene(scene);
        stage.setTitle("Xestor de modalidade");
        stage.show();
    }

	private void abrirXanela(Stage propietario, Modality modalidade, String titulo) {
		Stage dialog = new Stage();
		dialog.initOwner(propietario);
		dialog.initModality(modalidade);

		Label label = new Label("Modalidade: " + modalidade.toString() + "\nProba interactuar con outras xanelas.");
		Button closeBtn = new Button("Pechar");
		closeBtn.setOnAction(e -> dialog.close());

		VBox root = new VBox(10, label, closeBtn);
		Scene scene = new Scene(root, 300, 150);

		dialog.setScene(scene);
		dialog.setTitle(titulo);
		dialog.show();
	}

	public static void main(String[] args) {
		launch();
	}
}