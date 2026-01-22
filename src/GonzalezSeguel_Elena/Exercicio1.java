package GonzalezSeguel_Elena;

import static javafx.stage.StageStyle.DECORATED;
import static javafx.stage.StageStyle.TRANSPARENT;
import static javafx.stage.StageStyle.UNDECORATED;
import static javafx.stage.StageStyle.UNIFIED;
import static javafx.stage.StageStyle.UTILITY;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Exercicio1 extends Application {

	private List<Stage> xanelasFillas = new ArrayList<>();

	@Override
	public void start(Stage stage) throws Exception {
		Label titulo1 = new Label("Configuración dunha nova xanela");
		
		Label tituloLbl = new Label("Título:");
		TextField titulo = new TextField();

		Slider anchoSlider = new Slider(0.0, 1.0, 1.0);
		Label anchoLbl = new Label(" ");
		
		anchoSlider.setShowTickLabels(true);
		HBox anchoLayout = new HBox(10, new Label("Ancho: "), anchoSlider, anchoLbl, new Label("valor:"+ anchoLbl+"px"));
		
		anchoLbl.textProperty().bind(Bindings.createStringBinding(
				() -> String.format("valor: ", anchoSlider.getValue()), anchoSlider.valueProperty())
		);
		
		Slider altoSlider = new Slider(0.0, 1.0, 1.0);
		Label altoLbl = new Label();
		
		altoSlider.setShowTickLabels(true);
		HBox altoLayout = new HBox(10, new Label("Alto: "), altoSlider, altoLbl, new Label(" px"));
		altoLbl.textProperty().bind(Bindings.createStringBinding(() -> String.format("Valor: ", altoSlider.getValue()),
				altoSlider.valueProperty()));
		
		
		ComboBox<StageStyle> estiloCombo = new ComboBox<>(
				FXCollections.observableArrayList(DECORATED, UNDECORATED, UTILITY));
		HBox estiloLayout = new HBox(10, new Label("Estilo: "), estiloCombo);

		CheckBox redimensionableCheck = new CheckBox("Maximizar ao abrir");
		redimensionableCheck.setSelected(false);
	if(redimensionableCheck.isSelected()) {
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		 stage.setMaximized(true);
	}
		Button crearBtn = new Button("Crear xanela");
		crearBtn.setOnAction(e -> {
			abrirXanela(titulo.getText(), anchoSlider.getValue(), altoSlider.getValue(), estiloCombo.getValue(),
					redimensionableCheck.isSelected());
		});
		Button pecharBtn = new Button("Pechar todas");
		pecharBtn.setOnAction(e -> {
			for (Stage filla : xanelasFillas) {
				filla.close();
			}
		});
		HBox botonsLayout = new HBox(10, crearBtn, pecharBtn);

		VBox root = new VBox(10, titulo1, tituloLbl, titulo, anchoLayout, altoLayout, estiloLayout, redimensionableCheck,
				botonsLayout);
		Scene scene = new Scene(root, 600, 500);
		stage.setTitle("Xestor de múltiples xanelas");
		stage.setScene(scene);
		stage.show();

	}


	private void abrirXanela(String titulo, double ancho,double alto, StageStyle estilo, boolean redimensionable) {
		Stage xanela = new Stage();
		xanela.initStyle(estilo);
		xanela.setResizable(redimensionable);
		
		Label tituloLbl = new Label(titulo);
		
		Label titLbl =  new Label ("Título: " +titulo);
		
		Label dimensions = new Label("Dimensións: "+ alto +" x "+ ancho);
		
		Button pecharBtn  = new Button("Pechar");
		pecharBtn.setOnAction(e-> xanela.close());
		
		Label LblPos= new Label();
		LblPos.textProperty().bind(Bindings.concat("Posición: (", xanela.xProperty(), ", ", xanela.yProperty(),")"));
		
		if(redimensionable == true) {
			Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
			 xanela.setMaximized(true);
		}
		VBox info = new VBox(titLbl, dimensions,LblPos, pecharBtn);
			info.setStyle("-fx-background-color: lightgreen");
		if(estilo.equals(UNDECORATED)) {
			info.getChildren().add(pecharBtn);
		}
		Scene scene = new Scene(info,250,150);
		xanela.setScene(scene);
		xanela.show();
		}

	public static void main(String[] args) {
		launch(args);
	}

}
