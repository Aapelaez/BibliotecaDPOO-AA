package Logica;

import java.util.Date;

public class Trabajador extends Persona{
    private NivelEscolar nivelEscolar;
    private String cargo;
    private Date fechaContratacion;

    public Trabajador(String id, String nombre, String apellidos, char genero, NivelEscolar nivelEscolar, String cargo, Date fechaContratacion) {
        super(id, nombre, apellidos, genero);
        setNivelEscolar(nivelEscolar);
        setCargo(cargo);
        setFechaContratacion(fechaContratacion);
    }

    public NivelEscolar getNivelEscolar() {
        return nivelEscolar;
    }

    public boolean compareTo(String id) {
        return this.getId().equals(id);
    }

    public void setNivelEscolar(NivelEscolar nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
