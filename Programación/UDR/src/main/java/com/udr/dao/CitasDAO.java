package com.udr.dao;

import com.udr.db.Conexion;
import com.udr.model.Citas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitasDAO {

    private Connection con = Conexion.getConexion();

    public List<Citas> listarCitas (){
     List<Citas> lista = new ArrayList<>();
     String sql = "SELECT * FROM citas";

        try (Statement consulta = con.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)){
            while (resultado.next()) {
                Citas c = new Citas(
                        resultado.getInt("id_cita"),
                        resultado.getString("hora"),
                        resultado.getString("estado"),
                        resultado.getString("fecha"),
                        resultado.getInt("id_paciente"),
                        resultado.getInt("id_especialista"),
                        resultado.getInt("id_municipio"),
                        resultado.getInt("id_tipoPrueba"),
                        resultado.getInt("id_unidadMovil")
                );
                lista.add(c);
            }
        }
        catch (SQLException e) {
            System.out.println("Error al obtener la lista de cita: " + e.getMessage());
        }
        return lista;
 }
    public List<Citas> listarPendientes() {
        List<Citas> lista = new ArrayList<>();
        String sql = "SELECT * FROM citas WHERE estado = 'pendiente'";

        try (Statement consulta = con.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)) {

            while (resultado.next()) {
                Citas c = new Citas(
                        resultado.getInt("id_cita"),
                        resultado.getString("hora"),
                        resultado.getString("estado"),
                        resultado.getString("fecha"),
                        resultado.getInt("id_paciente"),
                        resultado.getInt("id_especialista"),
                        resultado.getInt("id_municipio"),
                        resultado.getInt("id_tipoPrueba"),
                        resultado.getInt("id_unidadMovil")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener citas pendientes: " + e.getMessage());
        }

        return lista;
    }
    public boolean insertar(Citas c) {
        String sql = "INSERT INTO citas (hora, estado, fecha, id_pacientes, id_tipoPrueba, id_especialista, id_unidadMovil, id_municipio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement consulta = con.prepareStatement(sql)) {
            consulta.setString(1, c.getHora());
            consulta.setString(2, c.getEstado());
            consulta.setString(3, c.getFecha());
            consulta.setInt(4, c.getIdPacientes());
            consulta.setInt(5, c.getIdtipoPrueba());
            consulta.setInt(6, c.getIdEspecialista());
            consulta.setInt(7, c.getIdUnidadMovil());
            consulta.setInt(8, c.getIdMunicipio());

            return consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar cita: " + e.getMessage());
            return false;
        }
    }
    public boolean cancelar(int idCita) {
        String sql = "UPDATE citas SET estado = 'cancelada' WHERE id_citas = ?";

        try (PreparedStatement consulta = con.prepareStatement(sql)) {
            consulta.setInt(1, idCita);
            return consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al cancelar la cita: " + e.getMessage());
            return false;
        }
    }
    public boolean crearCitaResonancia(int idPaciente, int idMunicipio, String fecha, String hora) {

        // Comprobar que el paciente existe
        PacienteDAO pacienteDAO = new PacienteDAO();
        if (pacienteDAO.listarTodos().isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return false;
        }

        // Comprobar que hay unidades activas
        UnidadMovilDAO unidadDAO = new UnidadMovilDAO();
        if (unidadDAO.listarActivas().isEmpty()) {
            System.out.println("No hay unidades moviles activas.");
            return false;
        }

        // Si  todo está bien, insertar la cita
        String sql = "INSERT INTO citas (hora, estado, fecha, id_pacientes, id_tipoPrueba, id_especialista, id_unidadMovil, id_municipio) " +
                "VALUES (?, 'pendiente', ?, ?, 1, 1, ?, ?)";

        try (PreparedStatement consulta = con.prepareStatement(sql)) {
            consulta.setString(1, hora);
            consulta.setString(2, fecha);
            consulta.setInt(3, idPaciente);
            consulta.setInt(4, unidadDAO.listarActivas().get(0).getIdUnidadMovil());
            consulta.setInt(5, idMunicipio);

            return consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al crear la cita: " + e.getMessage());
            return false;
        }
    }

}
