package com.udr.dao;

import com.udr.db.Conexion;
import com.udr.model.Citas;
import com.udr.model.Especialista;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialistaDAO {
    private Connection con = Conexion.getConexion();

    public List<Especialista> listarEspecialista (){
        List<Especialista> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialista";

        try (Statement consulta = con.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)){
            while (resultado.next()) {
                Especialista e = new Especialista(
                        resultado.getInt("id_especialista"),
                        resultado.getString("nombre"),
                        resultado.getString("apellidos"),
                        resultado.getString("especialidad"),
                        resultado.getString("hospital"),
                        resultado.getString("telefono"),
                        resultado.getString("provincia")
                );
                lista.add(e);
            }
        }
        catch (SQLException e) {
            System.out.println("Error al obtener la lista de especialistas: " + e.getMessage());
        }
        return lista;
    }
    public List<Especialista> buscarPorEspecialidad(String especialidad) {
        List<Especialista> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialista WHERE especialidad = ?";

        try (PreparedStatement consulta = con.prepareStatement(sql)) {
            consulta.setString(1, especialidad);
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                Especialista e = new Especialista(
                        resultado.getInt("id_especialista"),
                        resultado.getString("nombre"),
                        resultado.getString("apellidos"),
                        resultado.getString("especialidad"),
                        resultado.getString("hospital"),
                        resultado.getString("telefono"),
                        resultado.getString("provincia")
                );
                lista.add(e);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar especialista: " + e.getMessage());
        }

        return lista;
    }
}
