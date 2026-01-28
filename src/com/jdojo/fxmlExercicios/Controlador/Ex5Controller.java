package com.jdojo.fxmlExercicios.Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jdojo.fxmlExercicios.Modelo.Persona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Ex5Controller implements Initializable {

	@FXML
	private Button btnAgregar;

	@FXML
	private TableColumn<?, ?> columnApelidos;

	@FXML
	private TableColumn<?, ?> columnIdade;

	@FXML
	private TableColumn<?, ?> columnNome;

	@FXML
	private TableView<Persona> tablaPersona;

	@FXML
	void agregar(ActionEvent event) {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jdojo/fxmlExercicios/Vista/Ex5VistaPersoa.fxml"));
		
		try {
		Parent root = loader.load();
		
		Ex5ControllerTaboa controlador = loader.getController();
		controlador.cargarDatos(persoas);
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.showAndWait();
		
		Persona p  = controlador.getPersoa();
		
		
		persoas.add(p);
		tablaPersona.refresh();
		
	}catch(IOException e ) {
		e.printStackTrace();
	}
	}
	

	ObservableList<Persona> persoas;

	public void initialize(URL arg0, ResourceBundle arg1) {
		persoas = FXCollections.observableArrayList();

		this.tablaPersona.setItems(persoas);

		this.columnNome.setCellValueFactory(new PropertyValueFactory("nome"));
		this.columnApelidos.setCellValueFactory(new PropertyValueFactory("apelidos"));
		this.columnIdade.setCellValueFactory(new PropertyValueFactory("idade"));
	}

}
