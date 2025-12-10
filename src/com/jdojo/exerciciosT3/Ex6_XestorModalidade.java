package com.jdojo.exerciciosT3;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Ex6_XestorModalidade extends Application{
	public static void main(String[]args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Button BtnPechar = new Button("Pechar");
		
		ComboBox<String> comboModality = new ComboBox<>();
		comboModality.getItems().addAll("NONE", "WINDOW_MODAL","APPLICATION_MODAL");
		Button BtnAbrir = new Button("Abrir");
		
		BtnAbrir.setOnAction(e->{
			String seleccion = comboModality.getValue();
			Modality modalidade;
			switch(seleccion) {
			
			case "WINDOWS MODAL": 
				 modalidade = Modality.WINDOW_MODAL;
				break;
				
			case "APLICATION MODAL":
				 modalidade = Modality.APPLICATION_MODAL;
				 break;
				 
			default :
				 modalidade = Modality.NONE;
				 break;
			}
			abrirXanela(stage, modalidade, seleccion);
		});
		
		VBox root = new VBox(10, comboModality, BtnAbrir);
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.setTitle("Xestor de Modalidade");
		stage.show();		
		
	}
	
	private void abrirXanela(Window owner, Modality modality, String seleccion){
		Stage stage = new Stage(); // Nova xanela
        stage.initOwner(owner);// Configuramos o propietario desta nova xanela
        stage.initModality(modality); // e a modalidade

        Label modalityLabel = new Label(modality.toString());
        Button closeButton = new Button("Pechar");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox(10);
        root.getChildren().addAll(modalityLabel, closeButton);
        Scene scene = new Scene(root, 200, 100);

        stage.setScene(scene);
        stage.setTitle("Caixa de diálogo");
        stage.show();
	}
	
	
	

}
