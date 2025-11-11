package com.jdojo.exercicios;

import javafx.beans.property.ReadOnlyProperty;

public class Exercicio13StudentTest {
	public static void main(String[]args) {
		Exercicio13Student estudiante = new Exercicio13Student("S000","Descoñecido", 0.0);
		System.out.println("== Valores orixinais ==");
		printDetails(estudiante.idProperty());
		printDetails(estudiante.nameProperty());
		printDetails(estudiante.averageGradeProperty());
		
		estudiante.nameProperty().set("Ana");
		estudiante.averageGradeProperty().set(5.0);
		//estudiante.idProperty().set("S001");
		
		System.out.println("== Valores cambiados ==");
		printDetails(estudiante.idProperty());
		printDetails(estudiante.nameProperty());
		printDetails(estudiante.averageGradeProperty());
		
		
	}
		public static void printDetails(ReadOnlyProperty<?> p) {
	        String name = p.getName();
	        Object value = p.getValue();
	        Object bean = p.getBean();
	        String beanClassName = (bean == null) ? "null" : bean.getClass().getSimpleName();
	        String propClassName = p.getClass().getSimpleName();

	        System.out.print(propClassName);
	        System.out.print("[Name:" + name);
	        System.out.print(", Bean Class:" + beanClassName);
	        System.out.println(", Value:" + value + "]");
	    
	}
}
