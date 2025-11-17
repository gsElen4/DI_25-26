package com.jdojo.correxidos;

import javafx.beans.property.ReadOnlyProperty;

public class Exercicio13CStudentTest {
	public static void main(String[]args) {
			Exercicio13CStudent student = new Exercicio13CStudent("S000", "Descoñecido", 0.0);

			// Imprimimos o valor inicial das propiedades
			System.out.println("------Valores iniciais------");
			printDetails(student.idProperty());
			printDetails(student.nameProperty());
			printDetails(student.averageGradeProperty());

			// Cambiamos o nome a idade e a nota
			student.nameProperty().set("Ana");
			student.averageGradeProperty().set(10.0);
			// Probamos que mediante as propiedades JavaFx o id non se pode modificar dende
			// fora
			// student.idProperty().set("S001");

			// Imprimimos o valor cambiado das propiedades
			System.out.println("------Valores cambiados------");
			printDetails(student.idProperty());
			printDetails(student.nameProperty());
			printDetails(student.averageGradeProperty());

		}

		// Método que imprime detalles dunha propiedade
		public static void printDetails(ReadOnlyProperty<?> property) {
			String name = property.getName();
			Object value = property.getValue();
			Object bean = property.getBean();
			String beanClassName = (bean == null) ? "null" : bean.getClass().getSimpleName();
			String propClassName = property.getClass().getSimpleName();

			System.out.println(propClassName);
			System.out.print("[Nome da propiedade:" + name);
			System.out.print(", Bean Class:" + beanClassName);
			System.out.println(", Valor da propiedade:" + value + "]");
		}
}
