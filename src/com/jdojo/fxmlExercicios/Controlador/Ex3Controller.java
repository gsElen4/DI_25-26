package com.jdojo.fxmlExercicios.Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdojo.fxmlExercicios.Modelo.Persona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Ex3Controller implements Initializable {

	@FXML
	private Button BtnAgregar;

	@FXML
	private Label LblApelidos;

	@FXML
	private Label LblIdade;

	@FXML
	private Label LblNome;

	@FXML
	private TableView<Persona> Tabla;

	@FXML
	private TableColumn TablaApelidos; //columna apelidos

	@FXML
	private TableColumn TablaIdade; //columna idade

	@FXML
	private TableColumn TablaNome; //columna nome

	@FXML
	private TextField TxtApelidos;

	@FXML
	private TextField TxtIdade;

	@FXML
	private TextField TxtNome;

	// Exercicio 3 4.Debemos crear un ObservableList para vincular este á tabla
	ObservableList<Persona> persoas;

	@FXML
	void agregarPersona(ActionEvent event) {
		//Ex3 Paso 7. Coller datos do TextField e gardalos na lista persoas
	try {	
		String nome = this.TxtNome.getText();
		String apelidos = this.TxtApelidos.getText();
		int idade = Integer.parseInt(this.TxtIdade.getText());

		Persona p = new Persona(nome, apelidos, idade);
		
		if(!this.persoas.contains(p)) {
			this.persoas.add(p);
			
			
			
			//Refrescar a taboa
			
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setHeaderText(null);
			alerta.setTitle("Erro");
			alerta.setContentText("Persoa xa existe na táboa");
			alerta.showAndWait();
		}
	}catch (NumberFormatException e) {
		Alert alerta = new Alert(Alert.AlertType.ERROR);
		alerta.setHeaderText(null);
		alerta.setTitle("Erro");
		alerta.setContentText("O fomrato da idade non é correcto");
		alerta.showAndWait();
	}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		persoas = FXCollections.observableArrayList();
		
		//Ex3 6.Sincronizar taboa con la lista persoas
		this.Tabla.setItems(persoas);
		
		//Ex3 5.Vincular cada colmna da taboa con un atributo dunha clase, no noso caso persoa
		//Este método traballa por reflexion, é dicir, inspeccion nos paquetes se existe
		//1.Busca algún nomeProperty()
		//2.getNome
		this.TablaNome.setCellValueFactory(new PropertyValueFactory("nome"));
		this.TablaApelidos.setCellValueFactory(new PropertyValueFactory("apelidos"));
		this.TablaIdade.setCellValueFactory(new PropertyValueFactory("idade"));
	}

}
