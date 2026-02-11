package com.jdojo.fxmlExercicios.Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Ex9ControllerMenu implements Initializable {

	@FXML
	private Button btnIntroducir;
	
	@FXML
	private Button btnConsultar;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void introducirServicios (ActionEvent event) {
		// Cargamos a vista de Insertar Servizos
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jdojo/fxmlexercicios/Vista/Ex9InsertarServiciosVista.fxml"));
		try {
			Parent root = loader.load();
			Ex9ControllerInsertarServicio controlador = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			// Aquí non temos que darle a showAndWait.
			stage.show();
			
			// cuando peche a ventana fará isto
			stage.setOnCloseRequest(e -> controlador.closeWindow());
			
			Stage myStage = (Stage) this.btnIntroducir.getScene().getWindow();
			myStage.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	@FXML
	private void consultarServicios (ActionEvent event) {
		// Cargamos a vista de Consultar Servizos
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jdojo/fxmlexercicios/Vista/Ex9ConsultaServiciosVista.fxml"));
		try {
			Parent root = loader.load();
			Ex9ControllerConsultaServicios controlador = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			// Aquí non temos que darle a showAndWait.
			stage.show();
			
			// cuando peche a ventana a ventana que creamos para as novas vistas fará isto
			stage.setOnCloseRequest(e -> controlador.closeWindow());
			
			Stage myStage = (Stage) this.btnIntroducir.getScene().getWindow();
			myStage.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}