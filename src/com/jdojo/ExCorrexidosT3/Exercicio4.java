package com.jdojo.ExCorrexidosT3;

import static javafx.stage.StageStyle.DECORATED;
import static javafx.stage.StageStyle.TRANSPARENT;
import static javafx.stage.StageStyle.UNDECORATED;
import static javafx.stage.StageStyle.UNIFIED;
import static javafx.stage.StageStyle.UTILITY;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Exercicio4 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        Button btnDecorated = new Button("DECORATED");  
        Button btnUndecorated = new Button("UNDECORATED");  
        Button btnTransparent = new Button("TRANSPARENT");  
        Button btnUtility = new Button("UTILITY");  
        Button btnUnified = new Button("UNIFIED"); 
        
        
    btnDecorated.setOnAction(e -> abrirVenta(DECORATED));
    btnUndecorated.setOnAction(e -> abrirVenta(UNDECORATED));
    btnTransparent.setOnAction(e -> abrirVenta(TRANSPARENT));
    btnUtility.setOnAction(e -> abrirVenta(UTILITY));
    btnUnified.setOnAction(e -> abrirVenta(UNIFIED));


    VBox root = new VBox (10, btnDecorated ,btnUndecorated, btnTransparent , btnUtility, btnUnified);
	Scene scene = new Scene(root, 300, 200);
	stage.setScene(scene);
	stage.show();
    }

    private void abrirVenta(StageStyle estilo) {
        Stage secundario = new Stage();
        //secundario.show();
        secundario.initStyle(estilo); // chamalo antes de show()

        Label estiloLbl = new Label();
        estiloLbl.setText(estilo.toString());
        Button btnPechar = new Button("Pechar");
        btnPechar.setOnAction(e-> secundario.close());

        VBox layout = new VBox(10,estiloLbl,btnPechar);
        Scene escena = new Scene(layout, 300, 200);

        if (estilo == TRANSPARENT) {
            // Facer a escena transparente
            escena.setFill(null);
            // Aplicar estilo CSS transparente ao nodo raíz
            layout.setStyle(
                "-fx-background-color: transparent");
        } else if (estilo == UNIFIED) {
            escena.setFill(Color.TRANSPARENT);
        }
       
        secundario.setScene(escena);
        secundario.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
