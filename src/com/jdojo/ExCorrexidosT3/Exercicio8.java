package com.jdojo.ExCorrexidosT3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Exercicio8 extends Application {

    private Label resultadoLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
    	
    	// Creamos os botóns coas súas accións
    	Button infoBtn = new Button("Diálogo info");
        infoBtn.setOnAction(e -> {
        	mostrarDialogo("Información", "Esta é unha mensaxe informativa.",
        			"ℹ", "-fx-background-color: lightblue;");
        	resultadoLabel.setText("Diálogo Info: Aceptado");
        });

        Button avisoBtn = new Button("Diálogo aviso");
        avisoBtn.setOnAction(e -> {
        	mostrarDialogo("Advertencia", "Atención! Esta acción pode ter consecuencias.",
        			"！", "-fx-background-color: orange;");
        	resultadoLabel.setText("Diálogo Aviso: Aceptado");
        });

        Button erroBtn = new Button("Diálogo erro");
        erroBtn.setOnAction(e -> {
        	mostrarDialogo("Erro", "Ocorreu un erro inesperado na aplicación.",
        			"✖", "-fx-background-color: lightcoral;");
        	resultadoLabel.setText("Diálogo Erro: Aceptado");
        });

        Button confirmacionBtn = new Button("Diálogo confirmación");
        confirmacionBtn.setOnAction(e -> {
        	mostrarDialogo("Confirmación", "Estás seguro de que queres continuar?",
        			"？", "-fx-background-color: lightgreen;");
        });

        VBox root = new VBox(15);
        root.getChildren().addAll(
            new Label("Sistema de diálogos personalizados"),
            infoBtn, avisoBtn, erroBtn, confirmacionBtn, resultadoLabel
        );
        root.setStyle("-fx-padding: 30; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sistema de diálogos");
        primaryStage.show();
    }

    
    private void mostrarDialogo(String titulo, String mensaxe, String icono, String estilo) {
        Stage dialogo = new Stage();
        dialogo.initModality(Modality.APPLICATION_MODAL);
        
        // Creamos a mensaxe 
        Label iconLabel = new Label(icono);
        iconLabel.setStyle("-fx-alignment: center; -fx-font-size: 24;");
        Label mensaxeLbl = new Label(mensaxe);
        mensaxeLbl.setStyle("-fx-alignment: center; -fx-font-size: 12;");
            
        HBox mensaxeLayout = new HBox(10, iconLabel, mensaxeLbl);
        mensaxeLayout.setStyle("-fx-alignment: center;");
        
        HBox botonsLayout = new HBox(10);
        botonsLayout.setStyle("-fx-alignment: center;");

        // Creamos un botón de aceptar, no caso da confirmación crearemos dous botóns
        if(titulo.equals("Confirmación")) {
        	Button siBtn = new Button ("Si");
        	siBtn.setOnAction(e -> {
        		resultadoLabel.setText("Diálogo confirmación: Si");
        		dialogo.close();
        	});
        	Button nonBtn = new Button ("Non");
        	nonBtn.setOnAction(e -> {
        		resultadoLabel.setText("Diálogo confirmación: Non");
        		dialogo.close();
        	});
        	botonsLayout.getChildren().addAll(siBtn,nonBtn);
        } else {
        	Button aceptarBtn = new Button ("Aceptar");
        	aceptarBtn.setOnAction(e -> {
        		dialogo.close();
        	});
        	botonsLayout.getChildren().add(aceptarBtn);
        }
        
        
        VBox root = new VBox(mensaxeLayout, botonsLayout);
        root.setStyle("-fx-alignment: center;" + estilo);
        
        Scene scene = new Scene(root, 300, 100);
        dialogo.setScene(scene);
        dialogo.setTitle(titulo);
        dialogo.showAndWait();
  
    }

    public static void main(String[] args) {
        launch(args);
    }
}