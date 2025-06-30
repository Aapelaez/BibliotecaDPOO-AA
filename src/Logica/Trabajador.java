package Logica;

import java.util.Date;

import javax.swing.JOptionPane;

public class Trabajador extends Persona{
    private NivelEscolar nivelEscolar;
    private String cargo;
    private int edad;
    private Date fechaContratacion;

    public Trabajador(String id, String nombre, String apellidos, char genero, NivelEscolar nivelEscolar, String cargo, Date fechaContratacion,int edad) {
        super(id, nombre, apellidos, genero);
        setNivelEscolar(nivelEscolar);
        setCargo(cargo);
        setFechaContratacion(fechaContratacion);
        setEdad(edad);
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
    public int getEdad(){
    	return this.edad;
    }
    private void setEdad(int edad){
    	if(edad>=18){
    		this.edad=edad;
    	}else{
    		throw new IllegalArgumentException("La edad de los trabajadores debe ser mayor de 18");
    	}
    }
}
