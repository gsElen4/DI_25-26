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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Ex8ControllerInsertarServicio implements Initializable {

	   @FXML
	    private Button btnGrabar;

	    @FXML
	    private ComboBox<?> cmbClientes;

	    @FXML
	    private ComboBox<?> cmbVehiculos;

	    @FXML
	    private DatePicker dtpDataAlguer;

	    @FXML
	    private DatePicker dtpDataEntrega;

	    @FXML
	    private TextField txtDescripcionVeh;

	    @FXML
	    private TextField txtDirCli;

	    @FXML
	    private TextField txtKmVeh;

	    @FXML
	    private TextField txtMarcaVeh;

	    @FXML
	    private TextField txtNIFCli;

	    @FXML
	    private TextField txtPobCli;

	    @FXML
	    private TextField txtPrecioVeh;
	    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	// Ex8 . 3 Agora cando peche a ventá volverei ao menu Principal
	public void closeWindow() {
		// Cargamos a vista de Insertar Servizos
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jdojo/fxmlexercicios/Vista/Ex8VistaMenu.fxml"));
				try {
					Parent root = loader.load();
					Ex8ControllerMenu controlador = loader.getController();

					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setScene(scene);
					// Aquí non temos que darle a showAndWait.
					stage.show();
					
								
					Stage myStage = (Stage) this.btnGrabar.getScene().getWindow();
					myStage.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

}