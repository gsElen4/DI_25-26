package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Ex8_DialogosPers extends Application {
	public static void main(String[]args) {
		launch();
	}
	Label resultadoLbl = new Label();
	@Override
	public void start(Stage stage) throws Exception {
		Button BtnInfo = new Button("Diálogo info");
		Button BtnAdv = new Button("Diálogo aviso");
		Button BtnErro = new Button("Diálogo erro");
		Button BtnConf = new Button("Diálogo confirmación");

	

		BtnInfo.setOnAction(e-> {
			resultadoLbl.setText("Diálogo info: Aceptado");
			mostrarDialogo("Información", "Esta é unha mensaxe informativa", "Ⓘ", "-fx-background-color: lightblue");
		});
		
		VBox root = new VBox(10, new Label ("Sistema de diálogos "));
		Scene scene = new Scene(root,400,300);
		stage.setScene(scene);
		stage.setTitle("Exercicio 8");
		stage.show();
	}
	
	private void mostrarDialogo(String titulo, String mensaxe, String icono, String estilo) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(titulo);
		
		Label MsgLbl = new Label(mensaxe);
		Label IconLbl = new  Label(icono);
		
		HBox mensaxeLayout = new HBox(10, IconLbl, MsgLbl);
		HBox BotonLayout = new HBox();
		if(titulo.equals("confirmacion")) {
			
			Button siBtn = new Button("Si");
			Button noBtn = new Button("No ");
			siBtn.setOnAction(e->{
				resultadoLbl.setText("Diálogo confirmación : Si");
				stage.close();
			});
				stage.close();
		} else {
			Button aceptarBtn = new Button("Aceptar");
			aceptarBtn.setOnAction(e->{
				stage.close();
		});
		}

		VBox root = new VBox(10, mensaxeLayout, BotonLayout);
		root.setStyle(estilo);
		Scene scene = new Scene(root, 200,100);
		stage.setScene(scene);
		stage.showAndWait();
	}
}
