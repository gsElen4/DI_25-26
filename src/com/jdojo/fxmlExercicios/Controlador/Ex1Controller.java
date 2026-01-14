package com.jdojo.fxmlExercicios.Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdojo.fxmlExercicios.Modelo.Suma;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Ex1Controller implements Initializable {

	@FXML
	private Label LblOp1;

	@FXML
	private Label LblOp2;

	@FXML
	private Label LblResultado;

	@FXML
	private TextField Operando1;

	@FXML
	private TextField Operando2;

	@FXML
	private TextField Resultado;

	@FXML
	private Button btnSumar;

	@FXML
	void sumar(ActionEvent event) {
		try {
			int op1 = Integer.parseInt(this.Operando1.getText());
			int op2 = Integer.parseInt(this.Operando2.getText());
			
			Suma s = new Suma(op1, op2);
			
			this.Resultado.setText(String.valueOf(s.suma()));

		} catch (NumberFormatException e) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setHeaderText(null);
			alerta.setTitle("Erro");
			alerta.setContentText("Formato incorrecto");
			alerta.showAndWait();
		}
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
