package Logica;

public abstract class Persona {
    private String id;
    private String nombre;
    private String apellidos;
    private int edad;
    private char genero;

    public Persona(String id, String nombre, String apellidos, int edad, char genero) {
        setId(id);
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setGenero(genero);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
