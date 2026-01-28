package com.jdojo.fxmlExercicios.Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdojo.fxmlExercicios.Modelo.Persona;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Ex5ControllerTaboa implements Initializable {

	@FXML
	private Button btnCrear;

	@FXML
	private Button btnSair;

	@FXML
	private Label lblApelidos;

	@FXML
	private Label lblIdade;

	@FXML
	private Label lblNome;

	@FXML
	private TextField txtFieldApelidos;

	@FXML
	private TextField txtFieldIdade;

	@FXML
	private TextField txtFieldNome;

	private Persona persoa;

	private ObservableList<Persona> persoas;

	@FXML
	void crear(ActionEvent event) {
		try {
			String nome = this.txtFieldNome.getText();
			String apelidos = this.txtFieldApelidos.getText();
			int idade = Integer.parseInt(this.txtFieldIdade.getText());

			if (nome == null || nome.trim().isEmpty() || apelidos == null || apelidos.trim().isEmpty()) {
				throw new IllegalArgumentException("O nome e os apelidos son obrigatorios");
			}

			Persona p = new Persona(nome, apelidos, idade);

			if (!persoas.contains(p)) {
				this.persoa = p;

				Alert alerta = new Alert(Alert.AlertType.INFORMATION);
				alerta.setHeaderText(null);
				alerta.setTitle("Información");
				alerta.setContentText("Persoa engadida");
				alerta.showAndWait();
			} else {
				Alert alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText(null);
				alerta.setTitle("Error");
				alerta.setContentText("A persoa xa existe");
				alerta.showAndWait();
			}

		} catch (NumberFormatException e) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setHeaderText(null);
			alerta.setTitle("Error");
			alerta.setContentText("O formato da idade é incorrecto");
			alerta.showAndWait();

		} catch (IllegalArgumentException e) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setHeaderText(null);
			alerta.setTitle("Error");
			alerta.setContentText(e.getMessage());
			alerta.showAndWait();
		}
	}

	void cargarDatos(ObservableList<Persona> persoas) {
		this.persoas = persoas;
	}

	@FXML
	void sair(ActionEvent event) {
		this.persoa = null;
		Stage stage = (Stage)this.btnSair.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public Persona getPersoa() {
		return persoa;
	}

	public void setPersoa(Persona persoa) {
		this.persoa = persoa;
	}

}
