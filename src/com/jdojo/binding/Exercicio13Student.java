package com.jdojo.binding;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyProperty;


public class Exercicio13Student {
	
	
	private ReadOnlyStringWrapper id = new ReadOnlyStringWrapper(this, "id");
	private StringProperty name = new SimpleStringProperty(this, "name");
	private DoubleProperty averageGrade = new SimpleDoubleProperty(this, "averageGrade");

	public Exercicio13Student() {
		
	}
	
	public Exercicio13Student(String id, String name, double averageGrade) {
		this.id.set(id);
        this.name.set(name);
        this.averageGrade.set(averageGrade);
	}
	
	//ID
	public String getId() {
		return id.get();
	}
	public final ReadOnlyStringProperty IdProperty() {
		return id;
	}
	
	public ReadOnlyStringProperty idProperty() {
		return id.getReadOnlyProperty();
	}
	
	//Nombre
	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	public StringProperty nameProperty() {
		return this.nameProperty();
	}
	
	//Nota media
	public Double getAverageGrade() {
		return averageGrade.get();
	}
	
	public void setAverageGrade(double averageGrade) {
		this.averageGrade.set(averageGrade);
	}
	
	public DoubleProperty averageGradeProperty() {
		return this.averageGradeProperty();
	}
}
