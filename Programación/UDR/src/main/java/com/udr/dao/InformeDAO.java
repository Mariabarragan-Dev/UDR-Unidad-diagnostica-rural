package com.udr.dao;

import com.udr.db.Conexion;
import com.udr.model.Informe;
import com.udr.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InformeDAO {

    private Connection con = Conexion.getConexion();

    public List<Informe> listarTodos() {
        List<Informe> lista = new ArrayList<>();
        String sql = "SELECT * FROM informe";

        try (Statement consulta = con.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)) {

            while (resultado.next()) {
                Informe i = new Informe(
                        resultado.getInt("id_informe"),
                        resultado.getString("resultado"),
                        resultado.getString("fecha"),
                        resultado.getInt("id_citas"),
                        resultado.getInt("id_especialista"),
                        resultado.getInt("id_pacientes")

                );
                lista.add(i);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de informes: " + e.getMessage());
        }

        return lista;
    }
    public boolean insertar(Informe i) {
        String sql = "INSERT INTO informe (resultado, fecha, id_citas, id_especialista, id_pacientes) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement consulta = con.prepareStatement(sql)) {

            consulta.setString(1, i.getResultado());
            consulta.setString(2, i.getFecha());
            consulta.setInt(3, i.getIdCitas());
            consulta.setInt(4, i.getIdEspecialista());
            consulta.setInt(5, i.getIdPacientes());


            return consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar informe: " + e.getMessage());
            return false;
        }
    }
}
