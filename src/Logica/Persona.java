package Logica;

public abstract class Persona {
    private String id;
    private String nombre;
    private String apellidos;
    private char genero;

    public Persona(String id, String nombre, String apellidos, char genero) {
        setId(id);
        setNombre(nombre);
        setApellidos(apellidos);
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

    public int getEdad() {return Util.TrabajarFechas.calcularEdad(id);}

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
