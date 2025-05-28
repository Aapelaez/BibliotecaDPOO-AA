package Logica;

import java.util.ArrayList;
import java.util.Date;

public class Prestamo {
    private Date fechaConcepcion;
    private Date fechaLimite;
    private Usuario usuario;
    private Publicacion publicacion;
    private String idTrabajador;
    private boolean prorrogado;

    public Prestamo(Date fechaConcepcion, Date fechaLimite, Usuario usuario, String idTrabajador, Publicacion publicacion) {
        setFechaConcepcion(fechaConcepcion);
        setFechaLimite(fechaLimite);
        setPublicacion(publicacion);
        setUsuario(usuario);
        setIdTrabajador(idTrabajador);
        setProrrogado(false);
    }

    public Date getFechaConcepcion() {
        return fechaConcepcion;
    }

    public void setFechaConcepcion(Date fechaConcepcion) {
        this.fechaConcepcion = fechaConcepcion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public void actualizarProrroga(){
        prorrogado= true;
        setFechaLimite(aumentarFechaFinEnMitadDelIntervalo(fechaConcepcion, fechaLimite));
    }

    public static Date aumentarFechaFinEnMitadDelIntervalo(Date fechaInicio, Date fechaFin) {
        long diffMillis = fechaFin.getTime() - fechaInicio.getTime();
        long mitadIntervalo = diffMillis / 2;
        // Nueva fecha fin es la fecha fin + la mitad del intervalo
        return new Date(fechaFin.getTime() + mitadIntervalo);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public boolean isProrrogado() {
        return prorrogado;
    }

    public void setProrrogado(boolean prorrogado) {
        this.prorrogado = prorrogado;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
}
