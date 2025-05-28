package Logica;

import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private String provincia;
    private String municipio;
    private String horario;
    private String nombAdmin;
    private int annosCargo;
    private ArrayList <Publicacion> publicaciones;
    private ArrayList <Trabajador> trabajadores;
    private ArrayList <TorpedoUsuario> torpedosUsuarios;
    private ArrayList <Usuario> usuarios;
    private ArrayList <Prestamo> prestamos;
    private ArrayList <RegistroPrestamo> registroPrestamos;

    public Biblioteca(String nombre, String provincia, String municipio, String horario, String nombAdmin, int annosCargo) {
        setNombre(nombre);
        setProvincia(provincia);
        setMunicipio(municipio);
        setHorario(horario);
        setNombAdmin(nombAdmin);
        setAnnosCargo(annosCargo);
        this.publicaciones = new ArrayList<Publicacion>();
        this.trabajadores = new ArrayList<Trabajador>();
        this.torpedosUsuarios = new ArrayList<TorpedoUsuario>();
        this.usuarios = new ArrayList<Usuario>();
        this.prestamos = new ArrayList<Prestamo>();
        this.registroPrestamos = new ArrayList<RegistroPrestamo>();
    }

    /*public Object buscarPublicacion(String id) {
        Object p; //QUE HAGO SI PUBLICACION ES ABSTRACTA NO SE PUEDE INSTANCIAR
        boolean found=false;
        if(!publicaciones.isEmpty()) {
            int i = 0;
            while (i < publicaciones.size() && !found) {
                p = publicaciones.get(i);
                if (((Logica.Publicacion) p).compareTo(id)) {//Estoy usando object pero casteo a public que tiene compareTo
                    p= publicaciones.get(i);
                    found = true;
                }
                i++;
            }

        }
        return p;
    }*/

    public String getBibliotecaID() {
        return nombre + "_" + provincia + "_" + municipio;
    }
    //public void agregarPublicacion como se hace

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombAdmin() {
        return nombAdmin;
    }

    public void setNombAdmin(String nombAdmin) {
        this.nombAdmin = nombAdmin;
    }

    public int getAnnosCargo() {
        return annosCargo;
    }

    public void setAnnosCargo(int annosCargo) {
        this.annosCargo = annosCargo;
    }
}
