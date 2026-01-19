package com.jdojo.fxmlExercicios.Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Ex3Controller implements Initializable{

    @FXML
    private Button BtnAgregar;

    @FXML
    private Label LblApelidos;

    @FXML
    private Label LblIdade;

    @FXML
    private Label LblNome;

    @FXML
    private TableView<?> Tabla;

    @FXML
    private TableColumn<?, ?> TablaApelidos;

    @FXML
    private TableColumn<?, ?> TablaIdade;

    @FXML
    private TableColumn<?, ?> TablaNome;

    @FXML
    private TextField TxtApelidos;

    @FXML
    private TextField TxtIdade;

    @FXML
    private TextField TxtNome;

    @FXML
    void agregarPersona(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
    

}
