package com.udr.dao;

import com.udr.db.Conexion;
import com.udr.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    private Connection con = Conexion.getConexion();

    public List<Paciente> listarTodos() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";

        try (Statement consulta = con.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)) {

            while (resultado.next()) {
                Paciente p = new Paciente(
                        resultado.getInt("id_pacientes"),
                        resultado.getString("nombre"),
                        resultado.getString("apellidos"),
                        resultado.getString("dni"),
                        resultado.getString("fecha_nacimiento"),
                        resultado.getString("telefono"),
                        resultado.getInt("id_municipio")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de pacientes: " + e.getMessage());
        }

        return lista;
    }
    public Paciente buscarPorDni(String dni) {
        String sql = "SELECT * FROM pacientes WHERE DNI = ?";

        try (PreparedStatement consulta = con.prepareStatement(sql)) {
            consulta.setString(1, dni);
            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                return new Paciente(
                        resultado.getInt("id_pacientes"),
                        resultado.getString("nombre"),
                        resultado.getString("apellidos"),
                        resultado.getString("dni"),
                        resultado.getString("fecha_nacimiento"),
                        resultado.getString("telefono"),
                        resultado.getInt("id_municipio")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar paciente: " + e.getMessage());
        }

        return null;
    }
    public boolean insertar(Paciente p) {
        String sql = "INSERT INTO pacientes (DNI, nombre, apellidos, fecha_nacimiento, telefono, id_municipio) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement consulta = con.prepareStatement(sql)) {
            consulta.setString(1, p.getDni());
            consulta.setString(2, p.getNombre());
            consulta.setString(3, p.getApellidos());
            consulta.setString(4, p.getFechaNacimiento());
            consulta.setString(5, p.getTelefono());
            consulta.setInt(6, p.getIdMunicipio());

            return consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar paciente: " + e.getMessage());
            return false;
        }
    }
    public boolean actualizar(String dni, String nuevoTelefono) {
        String sql = "UPDATE pacientes SET telefono = ? WHERE DNI = ?";

        try (PreparedStatement consulta = con.prepareStatement(sql)) {
            consulta.setString(1, nuevoTelefono);
            consulta.setString(2, dni);

            return consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar paciente: " + e.getMessage());
            return false;
        }
    }
    public boolean eliminar(String dni) {
        String sql = "DELETE FROM pacientes WHERE DNI = ?";

        try (PreparedStatement consulta = con.prepareStatement(sql)) {
            consulta.setString(1, dni);
            return consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar paciente: " + e.getMessage());
            return false;
        }
    }
}
