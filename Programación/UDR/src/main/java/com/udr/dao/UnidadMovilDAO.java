package com.udr.dao;

import com.udr.db.Conexion;
import com.udr.model.Citas;
import com.udr.model.Informe;
import com.udr.model.UnidadMovil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UnidadMovilDAO {
    private Connection con = Conexion.getConexion();

    public List<UnidadMovil> listarTodos() {
        List<UnidadMovil> lista = new ArrayList<>();
        String sql = "SELECT * FROM unidadMovil";

        try (Statement consulta = con.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)) {

            while (resultado.next()) {
                UnidadMovil um = new UnidadMovil(
                        resultado.getInt("id_unidadMovil"),
                        resultado.getString("estado"),
                        resultado.getString("matricula"),
                        resultado.getString("modelo")

                );
                lista.add(um);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de unidades móviles: " + e.getMessage());
        }

        return lista;
    }
    public List<UnidadMovil> listarActivas() {
        List<UnidadMovil> lista = new ArrayList<>();
        String sql = "SELECT * FROM unidadMovil WHERE estado = 'activa'";

        try (Statement consulta = con.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)) {

            while (resultado.next()) {
                UnidadMovil um = new UnidadMovil(
                        resultado.getInt("id_unidadMovil"),
                        resultado.getString("estado"),
                        resultado.getString("matricula"),
                        resultado.getString("modelo")
                );
                lista.add(um);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener unidades móviles activas: " + e.getMessage());
        }

        return lista;
    }
}
