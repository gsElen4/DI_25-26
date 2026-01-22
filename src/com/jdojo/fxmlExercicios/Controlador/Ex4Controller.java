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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Ex4Controller implements Initializable {

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
	private Label lblApelidos;

	@FXML
	private Label lblIdade;

	@FXML
	private Label lblNome;

	@FXML
	private TableView<Persona> tablaPersona;

	@FXML
	private TextField txtApelidos;

	@FXML
	private TextField txtIdade;

	@FXML
	private TextField txtNome;

	ObservableList<Persona> persoas;

	@FXML
	void agregarPersona(ActionEvent event) {
		try {
			String nome = this.txtNome.getText();
			String apelidos = this.txtApelidos.getText();
			int idade = Integer.parseInt(this.txtIdade.getText());

			Persona p = new Persona(nome, apelidos, idade);

			if (!this.persoas.contains(p)) {
				this.persoas.add(p);

				// Refrescar a taboa
				this.tablaPersona.refresh();

			} else {
				Alert alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText(null);
				alerta.setTitle("Erro");
				alerta.setContentText("Persoa xa existe na táboa");
				alerta.showAndWait();
			}
		} catch (NumberFormatException e) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setHeaderText(null);
			alerta.setTitle("Erro");
			alerta.setContentText("O fomrato da idade non é correcto");
			alerta.showAndWait();
		}
	}

	@FXML
	void borrarPersona(ActionEvent event) {

	}

	@FXML
	void modificarPersona(ActionEvent event) {
		Persona p = this.tablaPersona.getSelectionModel().getSelectedItem();

		if (p != null) {
			try {
				String nome = this.txtNome.getText();
				String apelidos = this.txtApelidos.getText();
				int idade = Integer.parseInt(this.txtIdade.getText());
				
				Persona aux = new Persona(nome, apelidos, idade);
				if(!this.persoas.contains(aux)) {
					p.setNome(aux.getNome());
					p.setApelidos(aux.getApelidos());
					p.setIdade(aux.getIdade());
					//INFORMATION éxito
					amosarAlerta(AlertType.INFORMATION, "A persoa se mdificou correctamente");
				}else {
					//ERRO non se modificaron datos
					amosarAlerta(AlertType.ERROR, "Non hai datos que modificar");
				}
			
			} catch(NumberFormatException e) {
				//ERRO Formato de idade incorrecto
				amosarAlerta(AlertType.ERROR, "Formato de idade incorrecto");

			}
		} else {
			//ERRO debes seleccionar unha persoa para modificar
			amosarAlerta(AlertType.ERROR, "Debes seleccionar unha persoa para modificar");

		}
	}

	@FXML
	void seleccionar(MouseEvent event) {
		Persona p = this.tablaPersona.getSelectionModel().getSelectedItem();

		if (p != null) {
			this.txtNome.setText(p.getNome());
			this.txtApelidos.setText(p.getApelidos());
			this.txtIdade.setText(String.valueOf(p.getIdade()));

		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		persoas = FXCollections.observableArrayList();

		// Ex3 6.Sincronizar taboa con la lista persoas
		this.tablaPersona.setItems(persoas);

		// Ex3 5.Vincular cada colmna da taboa con un atributo dunha clase, no noso caso
		// persoa
		// Este método traballa por reflexion, é dicir, inspeccion nos paquetes se
		// existe
		// 1.Busca algún nomeProperty()
		// 2.getNome
		this.columnNome.setCellValueFactory(new PropertyValueFactory("nome"));
		this.columnApelidos.setCellValueFactory(new PropertyValueFactory("apelidos"));
		this.columnIdade.setCellValueFactory(new PropertyValueFactory("idade"));

	}
	
	private void amosarAlerta(AlertType tipo, String msg) {
		Alert alerta = new Alert(Alert.AlertType.ERROR);
		alerta.setHeaderText(null);
		alerta.setTitle(tipo.toString());
		alerta.setContentText(msg);
		alerta.showAndWait();
	}

}
