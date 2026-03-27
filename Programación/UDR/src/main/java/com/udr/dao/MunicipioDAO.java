package com.udr.dao;

import com.udr.db.Conexion;
import com.udr.model.Municipio;
import com.udr.model.TipoPrueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MunicipioDAO {
    private Connection con = Conexion.getConexion();

    public List<Municipio> listarTodos() {
        List<Municipio> lista = new ArrayList<>();
        String sql = "SELECT * FROM municipio";

        try (Statement consulta = con.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)) {

            while (resultado.next()) {
                Municipio m = new Municipio(
                        resultado.getInt("id_municipio"),
                        resultado.getString("c_autonoma"),
                        resultado.getString("nombre"),
                        resultado.getString("provincia")
                );
                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de municipios: " + e.getMessage());
        }

        return lista;
    }
}
