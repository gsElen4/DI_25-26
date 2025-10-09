package com.jdojo.intro;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio9ToDoList extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	private int contador = 1;
	 public void start(Stage stage) {
	      
	        TextField OPC = new TextField();
	        Button btn = new Button("Nova tarefa");

	        
	        VBox root = new VBox(6); 
	        root.getChildren().addAll(OPC, btn);

	     
	        btn.setOnAction(e -> engadirTarefa(OPC, root));

	        Scene scene = new Scene(root, 300, 400);
	        stage.setScene(scene);
	        stage.setTitle("To-Do List");
	        stage.show();
	    }

	    private void engadirTarefa(TextField opcion, VBox root) {
	        String texto = opcion.getText().trim();

	        if (texto.isEmpty()) {
	            opcion.setText("Campo obrigatorio");
	            opcion.setStyle("-fx-text-fill: red;");
	        } else {
	            
	            Label tarefa = new Label("Tarefa_" + contador + ": " + texto);
	            tarefa.setStyle("-fx-padding: 6;");

	            root.getChildren().add(tarefa);
	           
	            opcion.clear();
	            opcion.setStyle("-fx-text-fill: black;");

	            contador++;
	        }
	    }
}
