package com.jdojo.fxmlExercicios.Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Ex2Controller implements Initializable{

    @FXML
    private Button BtnLimpar;

    @FXML
    private Button BtnOperar;

    @FXML
    private RadioButton Division;

    @FXML
    private Label LblOp1;

    @FXML
    private Label LblOp2;

    @FXML
    private Label LblResultado;

    @FXML
    private RadioButton Multiplicacion;

    @FXML
    private TextField Operando1;

    @FXML
    private TextField Operando2;

    @FXML
    private RadioButton Resta;

    @FXML
    private TextField Resultado;

    @FXML
    private RadioButton Suma;

    @FXML
    void Operar(ActionEvent event) {

    }

    @FXML
    void limpar(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

