package com.udr.dao;

import com.udr.db.Conexion;
import com.udr.model.Especialista;
import com.udr.model.Informe;
import com.udr.model.TipoPrueba;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoPruebaDAO {
    private Connection con = Conexion.getConexion();

    public List<TipoPrueba> listarTodos() {
        List<TipoPrueba> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipoPrueba";

        try (Statement consulta = con.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)) {

            while (resultado.next()) {
                TipoPrueba tp = new TipoPrueba(
                        resultado.getInt("id_tipoPrueba"),
                        resultado.getString("categoria"),
                        resultado.getString("duracion"),
                        resultado.getString("preparacion"),
                        resultado.getString("zona")
                );
                lista.add(tp);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de tipos de prueba: " + e.getMessage());
        }

        return lista;
    }
    public List<TipoPrueba> buscarPorCategoria(String tipoPrueba) {
        List<TipoPrueba> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipoPrueba WHERE categoria = ?";

        try (PreparedStatement consulta = con.prepareStatement(sql)) {
            consulta.setString(1, tipoPrueba);
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                TipoPrueba tp = new TipoPrueba(
                        resultado.getInt("id_tipoPrueba"),
                        resultado.getString("categoria"),
                        resultado.getString("duracion"),
                        resultado.getString("preparacion"),
                        resultado.getString("zona")
                );
                lista.add(tp);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar categoría: " + e.getMessage());
        }

        return lista;
    }
}
