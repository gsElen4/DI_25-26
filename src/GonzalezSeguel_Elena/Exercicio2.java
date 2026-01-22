package GonzalezSeguel_Elena;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Exercicio2 extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		Label titulo = new Label("Control de opacidade e límites");
		Label limitT = new Label("Limites de tamaño");
		//Opacidade
		Slider opacidadeSlider = new Slider(0.0, 1.0, 1.0);
		Label opacidadeLbl = new Label("%.2f");
		
		opacidadeSlider.setShowTickLabels(true);
		HBox opacidadeLayout = new HBox(10, new Label("Opacidade: "), opacidadeSlider, opacidadeLbl);

		stage.opacityProperty().bind(opacidadeSlider.valueProperty());
		opacidadeLbl.textProperty().bind(Bindings.createStringBinding(
				() -> String.format("Opacidade: %.2f", opacidadeSlider.getValue()), opacidadeSlider.valueProperty())
		);
		
		
		Label resultadoLbl = new Label();
		
		TextField anchoMin= new TextField();
		TextField altoMin= new TextField();
		TextField anchoMax= new TextField();
		TextField altoMax= new TextField();

		Button btnAplicar = new Button("Aplicar Límites");		
		
		
		btnAplicar.setOnAction(e -> {
			try {
				double minWidth = Double.parseDouble(anchoMin.getText());
				double minHeight = Double.parseDouble(altoMin.getText());
				double maxWidth = Double.parseDouble(anchoMax.getText());
				double maxHeight = Double.parseDouble(altoMax.getText());

				// Validamos que os valores teñan lóxica
				if (minWidth > maxWidth || minHeight > maxHeight) {
					abrirXanela("Erro", "Os valores mínimos non poden ser maiores que os máximos", "-fx-background-color: red");
					return;
				}

				stage.setMinWidth(minWidth);
				stage.setMinHeight(minHeight);
				stage.setMaxWidth(maxWidth);
				stage.setMaxHeight(maxHeight);

				resultadoLbl.setText("Límites aplicados correctamente");
				resultadoLbl.setStyle("-fx-text-fill: green;");

			} catch (NumberFormatException ex) {
				abrirXanela2("Erro", "Os valores introducidos deben ser números","-fx-background-color: red");
				return;
			}
		});
		HBox anchoLayout = new HBox(10, new Label("Ancho: "), anchoMin, new Label("-"), anchoMax);
		HBox altoLayout = new HBox(10, new Label("Alto:"), altoMin, new Label("-"), altoMax);
		
		
		VBox root = new VBox(15);
        root.getChildren().addAll(titulo,opacidadeLayout,limitT,anchoLayout,altoLayout, btnAplicar, resultadoLbl );
          
        root.setStyle("-fx-padding: 30; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Exercicio 2");
        stage.show();
    }
	
	private void abrirXanela(String titulo, String erro, String color) {
		Stage dialog = new Stage();
		Button closeBtn = new Button("Aceptar");
		closeBtn.setStyle("-fx-alignment: center;");
		closeBtn.setOnAction(e -> dialog.close());
		
		Label mensaxeLbl = new Label(erro);
		mensaxeLbl.setStyle("-fx-alignment: center;");
		
		VBox root = new VBox(10,mensaxeLbl,closeBtn);
		root.setStyle(color);
		Scene scene = new Scene(root, 300, 150);

		dialog.setScene(scene);
		dialog.setTitle(titulo);
		dialog.show();
	}
	private void abrirXanela2(String titulo2, String erro2, String color2) {
		Stage dialog = new Stage();
		Button closeBtn = new Button("Aceptar");
		closeBtn.setStyle("-fx-alignment: center;");
		closeBtn.setOnAction(e -> dialog.close());
		
		Label mensaxeLbl = new Label(erro2);
		mensaxeLbl.setStyle("-fx-alignment: center;");
		
		VBox root = new VBox(10,mensaxeLbl,closeBtn);
		root.setStyle(color2);
		Scene scene = new Scene(root, 300, 150);

		dialog.setScene(scene);
		dialog.setTitle(titulo2);
		dialog.show();
	}
	public static void main(String[] args) {
		launch();
	}
}
