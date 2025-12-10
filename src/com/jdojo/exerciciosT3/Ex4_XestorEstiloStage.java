package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Ex4_XestorEstiloStage extends Application {
	
	public static void main(String[]args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Button DecoBtn = new Button("DECORATED");
		Button UnDecoBtn = new Button("UNDECORATED");
		Button TranspBtn = new Button("TRANSPARENT");
		Button UtilityBtn = new Button("UTILITY");
		Button UnifBtn = new Button("UNIFIED");
		
		DecoBtn.setOnAction(e -> abrirXanela(StageStyle.DECORATED));
		UnDecoBtn.setOnAction(e -> abrirXanela(StageStyle.UNDECORATED));
		TranspBtn.setOnAction(e -> abrirXanela(StageStyle.TRANSPARENT));
		UtilityBtn.setOnAction(e -> abrirXanela(StageStyle.UTILITY));
		UnifBtn.setOnAction(e -> abrirXanela(StageStyle.UNIFIED));

        VBox root = new VBox(10, DecoBtn, UnDecoBtn, TranspBtn, UtilityBtn, UnifBtn);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void abrirXanela(StageStyle style) {
        Stage stage = new Stage();
        stage.initStyle(style);

        Label lbl = new Label("Estilo: " + style.toString());
        Button btnPechar = new Button("Pechar");
        btnPechar.setOnAction(e -> stage.close());

        VBox root = new VBox(15, lbl, btnPechar);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20;");

        Scene scene;

        // Caso especial TRANSPARENT → escena totalmente transparente
        if (style == StageStyle.TRANSPARENT) {
            scene = new Scene(root, 250, 150, Color.TRANSPARENT);
            root.setStyle("-fx-background-color: rgba(255,255,255,0.4); -fx-padding: 20; -fx-border-radius: 10; -fx-background-radius: 10;");
            stage.initStyle(StageStyle.TRANSPARENT);
        }
        // Caso especial UNIFIED → fondo transparente pero barra de título visible
        else if (style == StageStyle.UNIFIED) {
            scene = new Scene(root, 250, 150);
            // Fondo transparente, pero mantendo controls da xanela
            root.setStyle("-fx-background-color: transparent; -fx-padding: 20;");
        }
        else {
            scene = new Scene(root, 250, 150);
        }

        // Necesario para permitir transparencia
        if (style == StageStyle.TRANSPARENT || style == StageStyle.UNIFIED) {
            scene.setFill(Color.TRANSPARENT);
        }

        stage.setScene(scene);
        stage.show();
    
		
	}
}
