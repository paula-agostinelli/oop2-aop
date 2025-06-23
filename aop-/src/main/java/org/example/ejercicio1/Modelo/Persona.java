package org.example.ejercicio1.Modelo;

public class Persona {
    public static final String LABEL_NOMBRE = "Nombre no puede ser vacio";
    public static final String LABEL_APELLIDO = "apellido no puede ser vacio";
    public static final String LABEL_DNI = "dni no puede ser vacio";
    public static final String LABEL_EMAIL = "email debe ser válido";
    public static final String LABEL_TELEFONO = "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN";
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;

    public Persona(String nombre, String apellido, String dni, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;

        assertNombre();
        assertApellido();
        assertDni();
        assertEmail();
        assertTelefono();
    }

    private void assertTelefono() {
        if (telefono == null || telefono.isBlank() || checkPhone(telefono)) {
            throw new RuntimeException(LABEL_TELEFONO);
        }
    }

    private void assertEmail() {
        if (email == null || email.isBlank() || !checkEmail(email)) {
            throw new RuntimeException(LABEL_EMAIL);
        }
    }

    private void assertDni() {
        if (dni == null || dni.isBlank()) {
            throw new RuntimeException(LABEL_DNI);
        }
    }

    private void assertApellido() {
        if (apellido == null || apellido.isBlank()) {
            throw new RuntimeException(LABEL_NOMBRE);
        }
    }

    private void assertNombre() {
        if (nombre == null || nombre.isBlank()) {
            throw new RuntimeException(LABEL_APELLIDO);
        }
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }
}
