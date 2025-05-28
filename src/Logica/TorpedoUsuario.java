package Logica;

import Util.TrabajarFechas;

import java.util.ArrayList;

public class TorpedoUsuario {
    private String idUsuario;
    private int mes;
    private int anno;
    private ArrayList<Prestamo> prestamos;

    public TorpedoUsuario(String idUsuario, int mes, int anno){
        setIdUsuario(idUsuario);
        setMes(mes);
        setAnno(anno);
        this.prestamos = new ArrayList<Prestamo>();
    }

    public boolean compareTo(String idUsuario, int mes, int anno) {
        return this.idUsuario.equals(idUsuario);
    }
    public boolean torpedoVigente() {
        return (this.mes == TrabajarFechas.getMesActual() && this.anno == TrabajarFechas.getAnnoActual());
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void addPrestamo(Prestamo prestamo) {
        if (prestamo != null) {
            this.prestamos.add(prestamo);
        }
    }
}
