package com.jdojo.correxidos;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;


public class Exercicio13CStudent {
	
	// En JavaFX, cando declaras propiedades como
		// StringProperty name;
		// IntegerProperty age;
		// DoubleProperty averageGrade;
		// debes inicializalas con implementacións concretas, como SimpleStringProperty, SimpleIntegerProperty o SimpleDoubleProperty.

		private ReadOnlyStringWrapper id = new ReadOnlyStringWrapper(this, "id");
		private StringProperty name = new SimpleStringProperty(this,"name");
		private DoubleProperty averageGrade = new SimpleDoubleProperty(this,"averageGrade");
		
		// Constructor baleiro por convención JavaBeans
		public Exercicio13CStudent() {	
		}
		// Constructor con parámetros
		public Exercicio13CStudent(String id, String name, double averageGrade) {
			this.id.set(id);
			this.name.set(name);
			this.averageGrade.set(averageGrade);
		}
		// Getters e setter estilo JavaBeans para garantizar retrocompatibilidade.
		// Marcamos como final para evitar sobreescrituras 
		
		// No caso do id a propiedade é de so lectura, de xeito que só se pode modificar dentro da clase.
		// Na práctica traducese a que ReadOnlyStringProperty non oferta métodos de modificación
		public final String getId() {
			return id.get();
		}
		
		public final ReadOnlyStringProperty idProperty() {
			return id.getReadOnlyProperty();
		}
		
		public final String getName() {
			return name.get();
		}

		public final void setName(String name) {
			this.name.set(name);
		}
		
		// Acceso á propiedade name
		public final StringProperty nameProperty() {
			return this.name;
		}
		
		public final double getAverageGrade() {
			return averageGrade.get();
		}

		public final void setAverageGrade(double averageGrade) {
			this.averageGrade.set(averageGrade);
		}
		
		// Acceso á propiedade averageGrade
		public final DoubleProperty averageGradeProperty() {
			return this.averageGrade;
		}
}
