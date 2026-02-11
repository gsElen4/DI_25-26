package com.jdojo.fxmlExercicios.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Vehiculo {

	private String matricula;
	private String descricion;
	private String marca;
	private int km;
	private int prezo;

	public Vehiculo() {
	}

	public Vehiculo(String matricula, String descricion, String marca, int km, int prezo) {
		this.matricula = matricula;
		this.descricion = descricion;
		this.marca = marca;
		this.km = km;
		this.prezo = prezo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDescricion() {
		return descricion;
	}

	public void setDescricion(String descricion) {
		this.descricion = descricion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getPrezo() {
		return prezo;
	}

	public void setPrezo(int prezo) {
		this.prezo = prezo;
	}

	// Ex9 Este toString é porque no comboBox imos gardar obxecto Vehiculo 
	// pero comboBox non pode mostrar obxectos vehiculo cando se desprega, senón que chama a toString
	// o atributo máis identificatorio dun vehiculo é a matricula por iso so poñemos a matricula no toString()
	@Override
	public String toString() {
		return matricula;
	}

	/* Ex9.2 Engadimos a conexión */
	public ObservableList<Vehiculo> getVehiculos() {
		ObservableList<Vehiculo> obs = FXCollections.observableArrayList();

		// Creo a consulta

		String sql = "SELECT * FROM vehiculos";

		// Fago un try-with-resources para que me peche os recursos
		try (
				Connection conexion = ConexionBD.getConexion();
				PreparedStatement ps = conexion.prepareStatement(sql);
				// executo a consulta
				ResultSet rs = ps.executeQuery();
		) {

			while (rs.next()) {

				// Datos
				String matricula = rs.getString("matricula");
				String descricion = rs.getString("descricion");
				String marca = rs.getString("marca");
				int km = rs.getInt("kilometros");
				int prezo = rs.getInt("prezo");

				// Creo un vehiculo e o meto no observacle
				Vehiculo v = new Vehiculo(matricula, descricion, marca, km, prezo);

				obs.add(v);

			}

		} catch (SQLException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}
		return obs;
	}
}