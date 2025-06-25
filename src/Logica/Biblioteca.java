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
    private static Biblioteca biblioteca;

    private Biblioteca(String nombre, String provincia, String municipio, String horario, String nombAdmin, int annosCargo) {
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

    public static Biblioteca getInstance(){
        if(biblioteca==null){
            biblioteca = new Biblioteca("Mariana Grajales","Granma","Manzanillo","10:00am - 16:00pm","Pepe Antonio",20);
        }
        return biblioteca;
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
            i++;
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

    public TorpedoUsuario crearTorpedoUsuario(String numUsuario, Prestamo p) {
        TorpedoUsuario torpedo=null;
        if (numUsuario!= null) {
            torpedo = new TorpedoUsuario(numUsuario, TrabajarFechas.getMesActual(), TrabajarFechas.getAnnoActual(), p);
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

    public void agregarLibro(String id,String titulo, String materia, int pag, boolean estado, String editorial, int ejemplares){
        if (buscarPublicacion(id)==null){
        publicaciones.add(new Libro(id,titulo,materia,pag,editorial, ejemplares, estado));
        }
    }

    public void agregrarRevista(String id,String titulo, String materia, int pag, boolean estado, int anno, int numero, int ejemplares){
        if(buscarPublicacion(id)==null){
            publicaciones.add(new Revista(id,titulo,materia,pag,anno,numero, ejemplares, estado));
        }
    }

    public void agregrarArticulo(String id,String titulo, String materia, int pag, int ejemp, boolean estado, ArrayList<String> arbitros){
        if(buscarPublicacion(id)==null) {
                publicaciones.add(new Articulo(id, titulo, materia, pag, ejemp, estado, arbitros));
        }
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
                        torpedo = crearTorpedoUsuario(usuario.getNumUsuario(), prestamo);
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

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    private void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    private void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getHorario() {
        return horario;
    }

    private void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombAdmin() {
        return nombAdmin;
    }

    private void setNombAdmin(String nombAdmin) {
        this.nombAdmin = nombAdmin;
    }

    public int getAnnosCargo() {
        return annosCargo;
    }

    private void setAnnosCargo(int annosCargo) {
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

    public void recibirDevolucion(Prestamo p) {
        if (p != null) {
            p.actualizarFechaEntregado(TrabajarFechas.getFechaActual());
        }
    }

    public void procesarProrroga(Prestamo prestamo, Date fechaProrroga) {
        if (prestamo != null && fechaProrroga != null) {
            int cantDias=cantDiasEntreFechas(prestamo.getFechaLimite(), fechaProrroga);
            prestamo.actualizarProrroga(cantDias);
        }
    }

    //REPORTES
    //Para mostrar datos de préstamo de ejemplares prestados de una publicación en un mes
    public ArrayList<Prestamo> datosPrestamosPublMes(String idPublicacion, int mes, int anno) {
    ArrayList<Prestamo> prestamosPublicacion = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getPublicacion().compareTo(idPublicacion) && compararMesAnno(mes, anno, prestamo.getFechaConcepcion())) {
                prestamosPublicacion.add(prestamo);
            }
        }
        return prestamosPublicacion;
    }

    //Prestamos proximos a vencer
    public ArrayList<Prestamo> proximosVencer(){
        int d= 7; // Días para considerar un préstamo próximo a vencer
        ArrayList<Prestamo> proximos = new ArrayList<>();
        Date fechaActual = getFechaActual();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaLimite() != null && prestamo.getFechaLimite().after(fechaActual) &&
                cantDiasEntreFechas(fechaActual, prestamo.getFechaLimite()) <= d) {
                proximos.add(prestamo);
            }
        }
        return proximos;
    }
    public int estadisticaReporte1(){
        return proximosVencer().size();
    }

    //Prestamos vencidos
    public int prestamosVencidos() {
        int count=0;
        Date fechaActual = getFechaActual();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaLimite() != null && prestamo.getFechaLimite().before(fechaActual) &&
                prestamo.getEstado() == EstadoPrestamo.NoEntregadoFueraDeTiempo) {
                count++;
            }
        }
        return count;
    }

    //Usuarios acreditados en un mes
    public ArrayList<Usuario> usuariosAcreditadosMes(int mes, int anno) {
        ArrayList<Usuario> usuariosAcreditados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if(compararMesAnno(mes,anno,usuario.getFechaAcreditacion())){
                usuariosAcreditados.add(usuario);
            }
        }
        return usuariosAcreditados;
    }

    //Usuarios penalizados
    public ArrayList<Usuario> usuariosPenalizados() {
        ArrayList<Usuario> penalizados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.estaPenalizado() != null) {
                penalizados.add(usuario);
            }
        }
        return penalizados;
    }
    public int estadisticaReporte3() {
        return usuariosPenalizados().size();
    }

    //Prestamos activos
    public int prestamosActivos() {
        int count = 0;
        for (Prestamo p : prestamos) {
            if(p.getEstado() == EstadoPrestamo.NoEntregado ||
            p.getEstado() == EstadoPrestamo.NoEntregadoFueraDeTiempo) {
                 count++;
                    }
                }
        return count;
    }

    //Cantidad de prestamos aprobados por trabajador en un mes
    public ArrayList<Trabajador> prestamosAprobadosPorTrabajador(int mes, int anno) {
        ArrayList<Trabajador> trabajadoresConPrestamos = new ArrayList<>();
        for (Trabajador trabajador : trabajadores) {
            int count = 0;
            for (Prestamo prestamo : prestamos) {
                if (prestamo.getIdTrabajador().equals(trabajador.getId()) &&
                    compararMesAnno(mes, anno, prestamo.getFechaConcepcion())) {
                    count++;
                }
            }
            if (count > 0) {
                trabajadoresConPrestamos.add(trabajador);
            }
        }
        return trabajadoresConPrestamos;
    }

    public ArrayList<Publicacion> publicacionesMasPrestadas() {
        ArrayList<Publicacion> masPrestadas = new ArrayList<Publicacion>();
        int maxCount = 0;
        for (RegistroPrestamo registroPrestamo : registroPrestamos) {
            if (registroPrestamo.getMes() == getMesActual() && registroPrestamo.getAnno() == getAnnoActual()) {
                for (Publicacion publicacion : publicaciones) {
                    if (publicacion.compareTo(registroPrestamo.getIdPublicacion())) {
                        int count = registroPrestamo.getCantidad();
                        if (count > maxCount) {
                            masPrestadas.clear();
                            masPrestadas.add(publicacion);
                            maxCount = count;
                        } else if (count == maxCount) {
                            masPrestadas.add(publicacion);
                        }
                    }
                }
            }
        }

            return masPrestadas;
    }
    public int estadisticaReporte2() {
        return publicacionesMasPrestadas().size();
    }

    public Trabajador buscarTrabajador(String id) {
        Trabajador trabajador = null;
        int i = 0;
        while (trabajador == null && i < trabajadores.size()) {
            if (trabajadores.get(i).compareTo(id)) {
                trabajador = trabajadores.get(i);
            }
            i++;
        }
        return trabajador;
    }

    public void contratarTrabajador(String id, String nombre, String apellido, String cargo, char genero, String telefono, String email, NivelEscolar nivelEscolar) {
        if (buscarTrabajador(id) == null) {
            Trabajador t = new Trabajador(id, nombre, apellido, genero, nivelEscolar, cargo, getFechaActual());
            trabajadores.add(t);
        }
    }

    public Usuario buscarUsuario(String numUsuario) {
        Usuario usuario = null;
        int i = 0;
        while (usuario == null && i < usuarios.size()) {
            if (usuarios.get(i).getNumUsuario().equals(numUsuario)) {
                usuario = usuarios.get(i);
            }
            i++;
        }
        return usuario;
    }

    public void registrarUsuario(String id, String nombre, String apellido, char genero, String numUsuario) {
        if (buscarUsuario(numUsuario) == null) {
            Usuario usuario = new Usuario(id, nombre, apellido, genero, numUsuario, getFechaActual());
            usuarios.add(usuario);
        }
    }
}
