package com.jdojo.fxmlExercicios.Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdojo.fxmlExercicios.Modelo.Operaciones;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
    	try {
			int op1 = Integer.parseInt(this.Operando1.getText());
			int op2 = Integer.parseInt(this.Operando2.getText());
			
			Operaciones Op = new Operaciones(op1,op2);
			
			if(Suma.isSelected()) {
				this.Resultado.setText(String.valueOf(Op.suma()));
			} else if (Resta.isSelected()) {
				this.Resultado.setText(String.valueOf(Op.resta()));
			} else if(Multiplicacion.isSelected()) {
				this.Resultado.setText(String.valueOf(Op.multiplicacion()));
			} else if(Division.isSelected()) {
				if(op2 == 0) {
					throw new ArithmeticException("Non se pode dividir entre 0");
				}
				this.Resultado.setText(String.valueOf(Op.division()));
			}
			

		} catch (NumberFormatException e) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setHeaderText(null);
			alerta.setTitle("Erro");
			alerta.setContentText("Formato incorrecto");
			alerta.showAndWait();
		}catch (ArithmeticException e) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setHeaderText(null);
			alerta.setTitle("Erro");
			alerta.setContentText(e.getMessage());
			alerta.showAndWait();
		}
    }

    @FXML
    void limpar(ActionEvent event) {
    	this.Operando1.clear();
    	this.Operando2.clear();
    	this.Resultado.clear();
    	this.tg.selectToggle(null);


    }
    ToggleGroup tg;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// EX2.1 Crear un ToggleGroup que aseguta seleccion excluinte
		//Neste método os controis xa están cargados e podes traballar con eles
		tg = new ToggleGroup();
		this.Suma.setToggleGroup(tg);
		this.Resta.setToggleGroup(tg);
		this.Multiplicacion.setToggleGroup(tg);
		this.Division.setToggleGroup(tg);



	}

}

