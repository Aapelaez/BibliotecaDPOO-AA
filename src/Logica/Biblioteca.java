package Logica;

import java.util.ArrayList;
import java.util.Date;

import Util.TrabajarFechas;

import static Util.TrabajarFechas.*;

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

    public int cantEjempPrestados(String idPublicacion) {
        int cant = 0;
        for (Prestamo p : prestamos) {
            if (p.getPublicacion().compareTo(idPublicacion)) {
                ++cant;
            }
        }
        return cant;
    }

    public int cantEjempDisponibles(String idPublicacion) {
        Publicacion publicacion = buscarPublicacion(idPublicacion);
        int salida = 0;
        if (publicacion != null) {
            salida = publicacion.getCantTotalEjemp() - cantEjempPrestados(idPublicacion);
        }
        return salida;
    }

    public RegistroPrestamo buscarRegistroPrestamo(String idPublicacion) {
        RegistroPrestamo registro = null;
        int i = 0;
        while (registro == null && i<registroPrestamos.size()) {
            if (registroPrestamos.get(i).compareTo(getMesActual(), getAnnoActual(), idPublicacion)) {
                registro = registroPrestamos.get(i);
            }
        }
        return registro;
    }

    public TorpedoUsuario buscarTorpedo(String numUsuario){
        TorpedoUsuario torpedo = null;
        int i = 0;
        while (torpedo == null && i < torpedosUsuarios.size()) {
            if (torpedosUsuarios.get(i).compareTo(numUsuario, getMesActual(), getAnnoActual())) {
                torpedo = torpedosUsuarios.get(i);
            }
            i++;
        }
        return torpedo;
    }

    public TorpedoUsuario crearTorpedoUsuario(String idUsuario) {
        TorpedoUsuario torpedo=null;
        if (idUsuario!= null) {
            torpedo = new TorpedoUsuario(idUsuario, TrabajarFechas.getMesActual(), TrabajarFechas.getAnnoActual());
            torpedosUsuarios.add(torpedo);
        }
        return torpedo;
    }

    public RegistroPrestamo crearRegistroPrestamo(String idPublicacion) {
        RegistroPrestamo registro = null;
        if (idPublicacion != null) {
            registro = new RegistroPrestamo(TrabajarFechas.getMesActual(), TrabajarFechas.getAnnoActual(), idPublicacion);
            registroPrestamos.add(registro);
        }
        return registro;
    }

    public boolean puedePrestarCant(String idPublicacion, Usuario usuario) {
        boolean salida=false;
        Publicacion publicacion = buscarPublicacion(idPublicacion);
        if (publicacion != null) {
            if(cantEjempDisponibles(idPublicacion) > 2) {
                salida = true;
            }
        }
        return salida;
    }

    public void atenderPrestamo(String idPublicacion, Usuario usuario, String idTrabajador) {
        Publicacion publicacion = buscarPublicacion(idPublicacion);
        if (publicacion != null && usuario != null && idTrabajador != null) {
            if (puedePrestarCant(idPublicacion, usuario)) {
                if (usuario.verificarCondicPrestamo(idPublicacion)) {
                    Date fechaConcepcion = TrabajarFechas.getFechaActual();
                    Date fechaLimite;
                    if(publicacion.getClass().getSimpleName().equals("Libro")) {
                        fechaLimite =sumarDias(fechaConcepcion, ((Libro)publicacion).calcularPlazoMax());
                    } else if (publicacion.getClass().getSimpleName().equals("Articulo")) {
                        fechaLimite =sumarDias(fechaConcepcion, ((Articulo)publicacion).calcularPlazoMax());
                    }else{
                        fechaLimite =sumarDias(fechaConcepcion, ((Revista)publicacion).calcularPlazoMax());
                    }

                    Prestamo prestamo = new Prestamo(fechaConcepcion, fechaLimite, usuario, idTrabajador, publicacion);
                    prestamos.add(prestamo);
                    RegistroPrestamo registro = buscarRegistroPrestamo(idPublicacion);
                    if (registro == null) {
                        registro = crearRegistroPrestamo(idPublicacion);
                        registroPrestamos.add(registro);
                    } else {
                        registro.incrementarCantidad();
                    }
                    TorpedoUsuario torpedo = buscarTorpedo(usuario.getNumUsuario());
                    if (torpedo == null) {
                        torpedo = crearTorpedoUsuario(usuario.getId());
                        torpedosUsuarios.add(torpedo);
                        usuario.addTorpedo(torpedo);
                    }else {
                            torpedo.addPrestamo(prestamo);
                        }
                }
            }
        }
    }

    public Publicacion buscarPublicacion(String id) {
        Publicacion publicacion = null;
        boolean found = false;

        if (!publicaciones.isEmpty()) {
            int i = 0;
            while (i < publicaciones.size() && !found) {
                Publicacion p = publicaciones.get(i);
                if (p.compareTo(id)) {
                    publicacion = p;
                    found = true;
                }
                i++;
            }
        }

        return publicacion;
    }

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

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public ArrayList<TorpedoUsuario> getTorpedosUsuarios() {
        return torpedosUsuarios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public ArrayList<RegistroPrestamo> getRegistroPrestamos() {
        return registroPrestamos;
    }
}
