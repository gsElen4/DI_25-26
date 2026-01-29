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
import javafx.scene.control.TextField;

public class Ex6ControllerCrear implements Initializable{

    @FXML
    private TextField TxtFieldApelidos;

    @FXML
    private TextField TxtFieldIdade;

    @FXML
    private TextField TxtFieldNome;

    @FXML
    private Button btnCrearpersoa;

    @FXML
    private Button btnSair;
    
    private Persona persoa;

	private ObservableList<Persona> persoas;

    @FXML
    void crearpersoa(ActionEvent event) {
    	try {
			String nome = this.TxtFieldNome.getText();
			String apelidos = this.TxtFieldApelidos.getText();
			int idade = Integer.parseInt(this.TxtFieldIdade.getText());

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

    @FXML
    void sair(ActionEvent event) {

    }
    
    void cargarDatos(ObservableList<Persona> persoas) {
		this.persoas = persoas;
	}

    void cargarDatos(ObservableList<Persona> persoas, Persona p) {
		this.persoas = persoas;
		this.persoa= p;
		
		TxtFieldNome.setText(p.getNome());
		TxtFieldApelidos.setText(p.getApelidos());
		TxtFieldIdade.setText(String.valueOf(p.getIdade()));
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
