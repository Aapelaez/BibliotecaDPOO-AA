package Logica;

import java.util.ArrayList;
import java.util.Date;

public class Usuario extends Persona{
    private String numUsuario;
    private Date fechaAcreditacion;
    private ArrayList<TorpedoUsuario> torpedos;
    private ArrayList<Prestamo> prestamos;

    public Usuario(String id, String nombre, String apellidos, int edad, char genero, String numUsuario, Date fechaAcreditacion) {
        super(id, nombre, apellidos, edad, genero);
        setNumUsuario(numUsuario);
        setFechaAcreditacion(fechaAcreditacion);
        this.torpedos = new ArrayList<TorpedoUsuario>();
        this.prestamos = new ArrayList<Prestamo>();
    }

    public ArrayList<TorpedoUsuario> getTorpedos() {
        return torpedos;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    private void setNumUsuario(String numUsuario) {
        this.numUsuario = numUsuario;
    }

    public String getNumUsuario() {
        return numUsuario;
    }

    public Date getFechaAcreditacion() {
        return fechaAcreditacion;
    }

    public void setFechaAcreditacion(Date fechaAcreditacion) {
        this.fechaAcreditacion = fechaAcreditacion;
    }

    public void solicitarPrestamo(String idPublicacion){
        //Aqui se le solicita a la biblioteca el préstamo de una publicación
    }

    public void devolverEjemplar(String idPublicacion){
        //Aqui se le devuelve a la biblioteca una publicación y ella la recibe
    }

    public void solicitarProrroga(Prestamo prestamo){
        //Aqui se le solicita a la biblioteca una prórroga de una publicación y ella revisa
    }
}
