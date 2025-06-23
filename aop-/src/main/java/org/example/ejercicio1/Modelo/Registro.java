package org.example.ejercicio1.Modelo;

import java.util.ArrayList;

public interface Registro {
    @Log
    void guardar(String apellido, String nombre, String telefono, String email, String idPersona, String idConcurso);

    @Log
    ArrayList<Concurso> todosLosConcursos();
}
