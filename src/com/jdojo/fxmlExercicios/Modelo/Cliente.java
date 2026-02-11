package com.jdojo.fxmlExercicios.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cliente {

    private String NIF;
    private String NeA;
    private String direccion;
    private String poboacion;

    public Cliente() {
    }

    public Cliente(String NIF, String NeA, String direccion, String poboacion) {
        this.NIF = NIF;
        this.NeA = NeA;
        this.direccion = direccion;
        this.poboacion = poboacion;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNeA() {
        return NeA;
    }

    public void setNeA(String NeA) {
        this.NeA = NeA;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoboacion() {
        return poboacion;
    }

    public void setPoboacion(String poboacion) {
        this.poboacion = poboacion;
    }

	// Ex9 Este toString é porque no comboBox imos gardar obxecto Cliente 
	// pero comboBox non pode mostrar obxectos cliente cando se desprega, senón que chama a toString
	// imos poler o nome e Apelidos como identificador no comboBox
    @Override
    public String toString() {
        return NeA;
    }

    /* Ex9. 1 Engadimos isto*/
    public ObservableList<Cliente> getClientes() {
        ObservableList<Cliente> obs = FXCollections.observableArrayList();

        String sql = "SELECT * FROM clientes";

        /* try-with-resources pecha automáticamente os recursos cando acaba o bloque */
        try (
        		// emprego a miña conexion
            Connection con = ConexionBD.getConexion();
        		// preparo a consulta
            PreparedStatement ps = con.prepareStatement(sql);
        		// executo a consulta
            ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {
                String NIF = rs.getString("NIF");
                String nome = rs.getString("NeA");
                String direccion = rs.getString("direccion");
                String poboacion = rs.getString("poboacion");

                // Creamos un cliente
                Cliente c = new Cliente(NIF, nome, direccion, poboacion);
                // Engadimos este cliente no observable que devolverá
                obs.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obs;
    }

}