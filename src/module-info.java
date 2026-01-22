module HolaFX {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.swing;
	requires javafx.media;
	requires javafx.web;
	requires javafx.fxml;
	requires jdk.jsobject;
	requires javafx.base;

	opens com.jdojo.intro to javafx.graphics, javafx.base;
	opens com.jdojo.binding to javafx.graphics, javafx.base;
	opens com.jdojo.exercicios to javafx.graphics, javafx.base;
	opens com.jdojo.correxidos to javafx.graphics, javafx.base;
	opens com.jdojo.stage to javafx.graphics, javafx.base;
	opens GonzalezSeguel_Elena to javafx.graphics, javafx.base;
	opens com.jdojo.exerciciosT3 to javafx.graphics, javafx.base;
	opens com.jdojo.ExCorrexidosT3 to javafx.graphics, javafx.base;

	opens com.jdojo.fxmlExercicios.Controlador to javafx.graphics, javafx.base, javafx.fxml;

	opens com.jdojo.fxmlExercicios.Modelo to javafx.graphics, javafx.base, javafx.fxml;

}