package com.udr.dao;

import com.udr.db.Conexion;
import com.udr.model.Municipio;
import com.udr.model.Ruta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RutaDAO {
    private Connection con = Conexion.getConexion();

    public List<Ruta> listarTodos() {
        List<Ruta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ruta";

        try (Statement consulta = con.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)) {

            while (resultado.next()) {
                Ruta r = new Ruta(
                        resultado.getInt("id_municipio"),
                        resultado.getInt("id_unidadMovil"),
                        resultado.getString("fecha")

                );
                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de rutas: " + e.getMessage());
        }

        return lista;
    }
    public List<Ruta> listarRutasHoy() {
        List<Ruta> lista = new ArrayList<>();
        String sql = "SELECT r.id_municipio, r.id_unidadMovil, r.fecha, m.nombre FROM ruta r " +
                "JOIN municipio m ON m.id_municipio = r.id_municipio WHERE r.fecha = ?";

        try (PreparedStatement consulta = con.prepareStatement(sql)) {
            consulta.setString(1, "2026-03-26");
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                Ruta r = new Ruta(
                        resultado.getInt("id_municipio"),
                        resultado.getInt("id_unidadMovil"),
                        resultado.getString("fecha")
                );
                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener rutas de hoy: " + e.getMessage());

        }
        return lista;
        }
    }


