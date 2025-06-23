package org.example.ejercicio1.Persistencia;

import org.example.ejercicio1.Modelo.Concurso;
import org.example.ejercicio1.Modelo.Registro;

import java.sql.*;
import java.util.ArrayList;

public class RepositorioInscriptos implements Registro {
    public static final String QUERY_INSERT_INSCRIPTOS = "Insert into inscriptos (apellido, nombre, telefono, email, idConcurso) values (?, ?, ?,?,?)";
    public static final String LABEL_ERROR = "Error al guardar la inscripción";
    public static final String QUERY_FINDALL = "SELECT * FROM concursos";


    @Override
    public void guardar(String apellido, String nombre, String telefono, String email, String idPersona, String idConcurso) {
        try {
            Connection connection = ConnectionManager
                    .getConnection();
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT_INSCRIPTOS);
            int cantidad = statement.executeUpdate();
            if (cantidad < 0) {
                throw new RuntimeException(LABEL_ERROR);
            }
            statement.setString(1, apellido);
            statement.setString(2, nombre);
            statement.setString(3, telefono);
            statement.setString(4, email);
            statement.setInt(5, Integer.parseInt(idConcurso));
        } catch (Exception e) {
            throw new RuntimeException(LABEL_ERROR, e);
        } finally {
            ConnectionManager.disconnect();
        }
    }

    @Override
    public ArrayList<Concurso> todosLosConcursos() {
        ArrayList<Concurso> listaConcursos = new ArrayList<>();
        try {
            Connection connection = ConnectionManager
                    .getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_FINDALL);
            while (resultSet.next()) {
                int idConcurso = resultSet.getInt("idConcurso");
                String nombreConcurso = resultSet.getString("nombre");
                Date fechaInicio = resultSet.getDate("fechaInicioInscripcion");
                Date fechaFin = resultSet.getDate("fechaFinInscripcion");
                listaConcursos.add(new Concurso(idConcurso, nombreConcurso, fechaInicio.toLocalDate(), fechaFin.toLocalDate()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionManager.disconnect();
        }
        return listaConcursos;
    }
}
