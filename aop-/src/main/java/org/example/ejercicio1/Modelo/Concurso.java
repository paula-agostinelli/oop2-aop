package org.example.ejercicio1.Modelo;

import java.time.LocalDate;


public record Concurso (int id, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {

        public static final String LABEL_NOMBRE_VACIO = "El nombre no puede estar vacio";
        public static final String LABEL_ID = "El número del concurso debe ser igual o mayor a uno";
        public static final String LABEL_FECHA_INCORRECTA = "La fecha de inicio del concurso no puede ser posterior a la fecha de fin";

        public Concurso {

            if (id < 1) {
                throw new RuntimeException(LABEL_ID);
            }

            if (nombre == null || nombre.isBlank()) {
                throw new RuntimeException(LABEL_NOMBRE_VACIO);
            }

            if (fechaInicioInscripcion.isAfter(fechaFinInscripcion)) {
                throw new RuntimeException(LABEL_FECHA_INCORRECTA);
            }
        }

        public String obtenerNombre() {
            return this.nombre;
        }

        public String obtenerIDComoString() {
            return String.valueOf(this.id);
        }
}
