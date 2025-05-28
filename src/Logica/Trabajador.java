package Logica;

import java.util.Date;

public class Trabajador extends Persona{
    private String nivelEscolar;
    private String cargo;
    private Date fechaContratacion;

    public Trabajador(String id, String nombre, String apellidos, int edad, char genero, String nivelEscolar, String cargo, Date fechaContratacion) {
        super(id, nombre, apellidos, edad, genero);
        setNivelEscolar(nivelEscolar);
        setCargo(cargo);
        setFechaContratacion(fechaContratacion);
    }

    public String getNivelEscolar() {
        return nivelEscolar;
    }

    public boolean compareTo(String id) {
        return this.getId().equals(id);
    }

    public void setNivelEscolar(String nivelEscolar) {
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
