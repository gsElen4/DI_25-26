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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Ex6ControllerTaboa implements Initializable {

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnModificar;

    @FXML
    private TableColumn<?, ?> columnApelidos;

    @FXML
    private TableColumn<?, ?> columnIdade;

    @FXML
    private TableColumn<?, ?> columnNome;

    @FXML
    private TableView<Persona> tablaPersoa;
    
    ObservableList<Persona> persoas;

    @FXML
    void agregarPersoa(ActionEvent event) {
		
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
		tablaPersoa.refresh();
		
	}catch(IOException e ) {
		e.printStackTrace();
	}
	}

    @FXML
    void borrarPersoa(ActionEvent event) {
    	//Paso 1 coller persoa da táboa e quitala da lista
    	
    	Persona p = this.tablaPersoa.getSelectionModel().getSelectedItem();
    	if(p!= null) {
    		this.persoas.remove(p);
    		this.tablaPersoa.refresh();
    		amosarAlerta(Alert.AlertType.INFORMATION,"A persoa foi eliminada");
    	} else {
    		amosarAlerta(Alert.AlertType.ERROR, "Debes seleccionar unha persoa");
    	}
    }

    @FXML
    void modificarPersoa(ActionEvent event) {
/*FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jdojo/fxmlExercicios/Vista/Ex5VistaPersoa.fxml"));
	*/	Persona per =  this.tablaPersoa.getSelectionModel().getSelectedItem();
		
		if(per == null) {
			amosarAlerta(Alert.AlertType.ERROR, "Debes seleccionar unha persoa");
		} else {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jdojo/fxmlExercicios/Vista/Ex5VistaPersoa.fxml"));

		try {
		Parent root = loader.load();
		
		Ex6ControllerCrear controlador = loader.getController();
		controlador.cargarDatos(persoas, per);
		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.showAndWait();
		
		Persona p  = controlador.getPersoa();
		
		
		persoas.add(p);
		tablaPersoa.refresh();
		
	}catch(IOException e ) {
		e.printStackTrace();
	}
    }
    }
    
    void amosarAlerta(AlertType tipo, String msg) {
    	Alert alerta = new Alert(tipo);
    	alerta.setHeaderText(null);
    	alerta.setTitle(tipo.toString());
    	alerta.setContentText(msg);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		persoas = FXCollections.observableArrayList();

		this.tablaPersoa.setItems(persoas);

		this.columnNome.setCellValueFactory(new PropertyValueFactory("nome"));
		this.columnApelidos.setCellValueFactory(new PropertyValueFactory("apelidos"));
		this.columnIdade.setCellValueFactory(new PropertyValueFactory("idade"));
	}

}
