package org.example.ejercicio1.Modelo;

import java.util.ArrayList;

public class Concursos {
    private ArrayList<Concurso> listaConcursos;
    private Registro unRegistro;

    public Concursos(Registro unRegistro) {
        listaConcursos = new ArrayList<>();
        this.unRegistro = unRegistro;
    }

    public void saveInscription(String apellido, String nombre, String telefono, String email, String idPersona, String idConcurso) {
       Persona persona= new Persona(apellido, nombre, telefono, email, idPersona);
        unRegistro.guardar(apellido, nombre, telefono, email, idPersona, idConcurso);
    }

    public ArrayList<Concurso> todosLosConcursos() {
        listaConcursos = unRegistro.todosLosConcursos();
        return listaConcursos;
    }
}
