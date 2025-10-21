package com.jdojo.binding;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class fluentTest {
	public static void main(String[] args) {
		// Crear unha propiedade para o radio
		DoubleProperty radius = new SimpleDoubleProperty(5);

		// Crear un binding que concatene método multiply() para a formula r.r.PI
		DoubleBinding area = radius.multiply(radius).multiply(Math.PI);
		// Mostrar o resultado
		System.out.println(" Valor inicial " + area.get());
		// Cambiar o radio
		radius.set(10);
		// Mostrar o resultado
		System.out.println(" Valor inicial " + area.get());
	}
}
