package com.jdojo.fxmlExercicios.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	private static Connection conn = null;

	public static Connection getConexion() throws SQLException {
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/aluguer_vehiculos",
					"root", 
					"1234");
		}
		return conn;
	}
}
