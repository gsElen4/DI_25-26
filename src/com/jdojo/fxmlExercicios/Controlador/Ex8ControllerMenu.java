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


public class Ex8ControllerMenu implements Initializable {

	@FXML
	private Button btnIntroducir;
	
	@FXML
	private Button btnConsultar;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
		
	// Ex8 1. Cando damos ao botón introducir cargamos a vista de Introducir
	@FXML
	private void introducirServicios (ActionEvent event) {
		// Ex8 1.1 Cargamos a vista de Insertar Servizos
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jdojo/fxmlexercicios/Vista/Ex8InsertarServiciosVista.fxml"));
		try {
			Parent root = loader.load();
			// Preciso o controlador porque no controlador está o método que saber qué facer
			// cando se peche a ventá.
			Ex8ControllerInsertarServicio controlador = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			// Aquí non temos que darle a showAndWait.
			stage.show();
			
			// Aquí damos un comportamento a cando se peche a ventana. É dicir
			// cando se peche esta ventá que estamos creando fará closeWindow
			// que o teño que crear.
			stage.setOnCloseRequest(e -> controlador.closeWindow());
			
			// Isto é para pechar a ventá actual e nunca haxa dúas ventás abertas á vez
			Stage myStage = (Stage) this.btnIntroducir.getScene().getWindow();
			myStage.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	// Ex8 2. O mesmo para o botón de consulta pero cambiando a vista

	@FXML
	private void consultarServicios (ActionEvent event) {
		// Cargamos a vista de Consultar Servizos
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jdojo/fxmlexercicios/Vista/Ex8ConsultaServiciosVista.fxml"));
		try {
			Parent root = loader.load();
			Ex8ControllerConsultaServicios controlador = loader.getController();

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