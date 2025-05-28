package Logica;

import java.util.Date;
import static Util.TrabajarFechas.*;

public class Prestamo {
    private Date fechaConcepcion;
    private Date fechaLimite;
    private Date fechaEntregado;
    private Usuario usuario;
    private Publicacion publicacion;
    private String idTrabajador;
    private boolean prorrogado;
    private EstadoPrestamo estado;


    public Prestamo(Date fechaConcepcion, Date fechaLimite, Usuario usuario, String idTrabajador, Publicacion publicacion) {
        setFechaConcepcion(fechaConcepcion);
        setFechaLimite(fechaLimite);
        setPublicacion(publicacion);
        setUsuario(usuario);
        setIdTrabajador(idTrabajador);
        setProrrogado(false);
        setFechaEntregado(null);
        setEstado(EstadoPrestamo.NoEntregado);
    }

    public boolean compareTo(String idPublicacion) {
        return this.publicacion.compareTo(idPublicacion);
    }
    public void actualizarFechaEntregado(Date fechaEntregado) {
        if (fechaEntregado != null) {
            if (!fechaEntregado.before(fechaConcepcion)) {
                setFechaEntregado(fechaEntregado);
                if (fechaEntregado.after(fechaLimite)) {
                    setEstado(EstadoPrestamo.EntregadoFueraDeTiempo);
                } else {
                    setEstado(EstadoPrestamo.EntregadoEnTiempo);
                }
            }//Excepcion la fecha de entrega no puede ser anterior a la fecha de concepción del préstamo
        }
    }

    public Date finPenalizacion() {
        Date salida=null;
        if (fechaEntregado != null && estado == EstadoPrestamo.EntregadoFueraDeTiempo) {
            int demora = cantDiasEntreFechas(fechaLimite, fechaEntregado);
            salida= sumarDias(fechaEntregado, demora);
        }
            return salida;
    }

    public Date getFechaConcepcion() {
        return fechaConcepcion;
    }

    private void setFechaConcepcion(Date fechaConcepcion) {
        this.fechaConcepcion = fechaConcepcion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    private void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public boolean esProrrogable(){
        boolean salida= false;
        if(!prorrogado&&getEstado() == EstadoPrestamo.NoEntregado)){
        salida=true;
    }
    return salida;
    }
    public void actualizarProrroga(){
        if(esProrrogable()) {
            setProrrogado(true);
            setFechaLimite(aumentarFechaFinEnMitadDelIntervalo(fechaConcepcion, fechaLimite));
        }/* Excepcion no se puede prorrogar un préstamo que ya ha sido prorrogado
        o que ya ha sido entregado, o este fuera de tiempo */
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

    private void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Date getFechaEntregado() {
        return fechaEntregado;
    }

    private void setFechaEntregado(Date fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }

    public EstadoPrestamo getEstado() {
        if(getFechaActual().after(fechaLimite) && estado == EstadoPrestamo.NoEntregado) {
            setEstado(EstadoPrestamo.NoEntregadoFueraDeTiempo);
        }
        return estado;
    }

    private void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }
}
