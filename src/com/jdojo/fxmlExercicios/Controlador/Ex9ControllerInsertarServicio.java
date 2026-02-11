package com.jdojo.fxmlExercicios.Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jdojo.fxmlExercicios.Modelo.Cliente;
import com.jdojo.fxmlExercicios.Modelo.Vehiculo;

import javafx.collections.ObservableList;
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

public class Ex9ControllerInsertarServicio implements Initializable {

	@FXML
	private Button btnGrabar;

	// Ex9 3. Indicamos que o comboBox é de Clientes, do modelo que acabamo
	// de crear
	@FXML
	private ComboBox<Cliente> cmbClientes;
	// Ex9 4. indicamos que o comboBox é de Vehiculos, do modelo que
	// acabamo de crear

	@FXML
	private ComboBox<Vehiculo> cmbVehiculos;

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
		// Ex9 5. Tamén imos inicializar os combos agora que xa temos os observables

		iniciarCombos();
	}

	public void iniciarCombos() {
		// Creamos un cliente para poder chamar á base de datos
		Cliente c = new Cliente();
		// getCliente xa conecta coa base de datos.
		ObservableList<Cliente> obsClientes = c.getClientes();
		
		this.cmbClientes.setItems(obsClientes);
		
		Vehiculo v = new Vehiculo();
		// getCliente xa conecta coa base de datos.
		ObservableList<Vehiculo> obsVehiculo = v.getVehiculos();
		
		this.cmbVehiculos.setItems(obsVehiculo);
	}
	
	public void closeWindow() {
		// Cargamos a vista de Insertar Servizos
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jdojo/fxmlexercicios/Vista/Ex9MenuVista.fxml"));
		try {
			Parent root = loader.load();
			Ex9ControllerMenu controlador = loader.getController();

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