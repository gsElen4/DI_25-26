package com.jdojo.ExCorrexidosT3;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Exercicio10 extends Application {

	// Declaramos os controis nivel de clase para poder empregalos nos diferentes métodos
	
	private Label puntuacionLbl;
	private Label tempoLbl;
	
	// Botóns
	private Button iniciarBtn;
	private Button pararBtn;
	
	private Slider velocidadeSld;
	
	// Utilizacion do Timeline
	private Timeline xogoTimeline, tempoTimeline;
	
	// declaramos tamén a lista de xanelas
	private List<Stage> xanelasFillas;
	private int puntuacion;
	private int tempoTranscorrido;
	
	@Override
	public void start (Stage stage) {
		
		//Iniciamos as variables e lle damos algo de estilo
		puntuacionLbl = new Label("Puntuación: 0");
        puntuacionLbl.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        iniciarBtn = new Button("Iniciar Xogo");
        pararBtn = new Button("Parar Xogo");
        tempoLbl = new Label("Tempo: 00:00");
        xanelasFillas = new ArrayList<>();
        velocidadeSld = new Slider(1, 4, 1);
        puntuacion = 0;
        
		// Dámoslle acción aos botóns
        iniciarBtn.setOnAction(e->iniciarXogo(stage));
        pararBtn.setOnAction(e->pararXogo());
        pararBtn.setDisable(true);

              
		// Aquí imos colocar os elementos nun VBox
		VBox root = new VBox (10,
				new Label("XOGO DAS XANELAS"),
				puntuacionLbl,
				tempoLbl,
				new Separator(),
				iniciarBtn,
				pararBtn,
				new Separator(),
				new Label("Tempo aparición entre ventás"),
				velocidadeSld
				);
		root.setStyle("-fx-padding:20; -fx-alignment:center");
		
		// Creamos a escena e asociamos ao Stage
		Scene scene = new Scene(root,300,250);
		stage.setScene(scene);
		stage.setTitle("Xogo de xanelas");
		stage.show();
	}
	
	// Método para arrincar o xogo
	
	private void iniciarXogo(Stage stage) {
		// Reiniciamos os valores de puntuacion e tempo
		puntuacionLbl.setText("Puntuacion: 0");
		tempoLbl.setText("Tempo: 00:00");
		puntuacion = 0;
		tempoTranscorrido = 0;
		
		
		// Ademáis temos que habilitar o botón de parar e deshabilitar o botón de iniciar
		iniciarBtn.setDisable(true);
		pararBtn.setDisable(false);
		
		// O xogo creará ventás segundo o tempo marcado polo slider
		
		// Timeline para crear xanelas
        xogoTimeline = new Timeline(
            new KeyFrame(Duration.seconds(velocidadeSld.getValue()), 
            e -> abrirXanela(stage))
        );
        xogoTimeline.setCycleCount(Animation.INDEFINITE);
        xogoTimeline.play();
        
        // Inicializamos o timeLine do tempo
        tempoTimeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
        	 tempoTranscorrido++;
             int minutos = tempoTranscorrido / 60;
             int segundos = tempoTranscorrido % 60;
             tempoLbl.setText(String.format("Tempo: %02d:%02d", minutos, segundos));
        }));
        tempoTimeline.setCycleCount(Animation.INDEFINITE);
        tempoTimeline.play();
		
	}

	// Método para parar o xogo
	private void pararXogo() {
		// Paramos o Timeline
		xogoTimeline.stop();
		tempoTimeline.stop();
		
		
		// Cando paramos a habilitación dos botón estará ao revés
		iniciarBtn.setDisable(false);
		pararBtn.setDisable(true);
		
	/*	
		// cando paramos o xogo pechamos todas as ventás 
<<<<<<< HEAD
		for (Stage xanela : xanelasFillas) {
=======
		for (Stage xanela : xanellasFillas) {
>>>>>>> main
            xanela.close();
        }
		// Borras a referencia ás ventás no Array
		xanelasFillas.clear();
	}
	*/
	}
	private void abrirXanela(Stage stage) {
		// Creamos valores aleatorios para a nova posición da xanela tendo en conta 
		// non debe sairse dos límites.
		Random random = new Random();
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		
		double x = random.nextDouble() * (screenBounds.getWidth() - 150);
		double y = random.nextDouble() * (screenBounds.getHeight() - 100);
		
		
		// Novo stage
		Stage xanela = new Stage();
		xanela.initOwner(stage);
		// Engadimos á lista para levar a conta
		xanela.setX(x);
		xanela.setY(y);
		xanelasFillas.add(xanela);
		
		Button aceptarBtn = new Button("Cázame");
		aceptarBtn.setOnAction(e -> {
			puntuacion += 10;
            puntuacionLbl.setText("Puntuación: " + puntuacion);
            xanelasFillas.remove(xanela);
			xanela.close();
		});
		 
		// Aqui teremos a seguinte información
		VBox contido = new VBox(10,
				new Label("Cázame"),
				aceptarBtn
				);
		contido.setStyle("-fx-alignment:center; -fx-background-color: #FFE082;");
		

		Scene scene = new Scene(contido, 150, 100);
		xanela.setScene(scene);
		
		xanela.show();				
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}