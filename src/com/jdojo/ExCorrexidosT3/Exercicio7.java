package com.jdojo.ExCorrexidosT3;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Exercicio7 extends Application {

	@Override
	public void start(Stage stage) {

		// botóns precisos
		Button pantCompletaBtn = new Button("Activar/Desactivar pantalla completa");
		Button maximizarBtn = new Button("Maximizar");
		Button centrarBtn = new Button("Centrar");
		Button restaurarBtn = new Button("Restaurar");

		// etiquetas precisas
		Label pantallaCompletaLbl = new Label();
		Label dimesionsLbl = new Label();
		Label posicionLbl = new Label();

		pantCompletaBtn.setOnAction(e -> {
			// Creamos un boolean que teña o valor contrario ao estado
			// no que estea a pantalla para que cada vez o botón active ou desactiva

			boolean fullscreen = !stage.isFullScreen();
			stage.setFullScreen(fullscreen);

			if (fullscreen) {
				pantallaCompletaLbl.setText("Desactivar Pantalla Completa");
			} else {
				pantallaCompletaLbl.setText("Activar Pantalla Completa");
			}
		});

		// Para maximizar debemos conseguir os límites visuais
		maximizarBtn.setOnAction(e -> {
			Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
			stage.setX(visualBounds.getMinX());
			stage.setWidth(visualBounds.getMaxX());
			stage.setY(visualBounds.getMinY());
			stage.setHeight(visualBounds.getMaxY());
		});

		restaurarBtn.setOnAction(e -> {
			if (stage.isFullScreen()) {
				stage.setFullScreen(false); // Sae de pantalla completa
			} else {
				stage.setWidth(400);
				stage.setHeight(300);
				stage.centerOnScreen();
			}

		});

		
		// Vinculacións cos Labels de dimesión e posición
		dimesionsLbl.textProperty()
				.bind(Bindings.concat("Ancho: ", stage.widthProperty(), "\nAlto: ", stage.heightProperty()));
		posicionLbl.textProperty()
				.bind(Bindings.createStringBinding(
						() -> String.format("Coordenada x: %.2f\nCoordenada y: %.2f", stage.getX(), stage.getY()),
						stage.xProperty(), stage.yProperty()));

		VBox root = new VBox(10, pantCompletaBtn, maximizarBtn, restaurarBtn, pantallaCompletaLbl, dimesionsLbl,
				posicionLbl);
		stage.setWidth(400);
		stage.setHeight(300);
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setTitle("Modo pantalla completa");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}