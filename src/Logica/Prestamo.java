package Logica;

import java.util.Date;

public class Prestamo {
    private Date fechaConcepcion;
    private Date fechaLimite;
    //boolean de prorrogado?
    /*problema a la hora de conocer de que tipo de publicación es el ejemplar para
    conceder la prórroga, ya que cada tipo de publicación tiene un plazo máximo diferente*/
    private Ejemplar ejemplar;

    public Prestamo(Date fechaConcepcion, Date fechaLimite, Ejemplar ejemplar) {
        setFechaConcepcion(fechaConcepcion);
        setFechaLimite(fechaLimite);
        setEjemplar(ejemplar);
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

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }
}
