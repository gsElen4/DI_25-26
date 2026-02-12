package com.jdojo.fxmlExercicios.Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Ex9ControllerConsultaServicios implements Initializable {

	@FXML
	private ComboBox<?> cmbClientes;

	@FXML
	private TableColumn<?, ?> colFechaAlquiler;

	@FXML
	private TableColumn<?, ?> colFechaEntrega;

	@FXML
	private TableColumn<?, ?> colMarca;

	@FXML
	private TableColumn<?, ?> colMatricula;

	@FXML
	private TableColumn<?, ?> colPrecio;

	@FXML
	private TableColumn<?, ?> colTotal;

	@FXML
	private DatePicker dtpDataFinal;

	@FXML
	private DatePicker dtpDataInicial;

	@FXML
	private TableView<?> tblServicios;

	public void closeWindow() {
		// Cargamos a vista de Consultar Servizos
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jdojo/fxmlexercicios/Vista/Ex9MenuVista.fxml"));
		try {
			Parent root = loader.load();
			Ex9ControllerMenu controlador = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			// Aquí non temos que darle a showAndWait.
			stage.show();

			Stage myStage = (Stage) this.cmbClientes.getScene().getWindow();
			myStage.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

}