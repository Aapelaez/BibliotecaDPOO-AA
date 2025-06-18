package Logica;

import Util.TrabajarFechas;

import java.util.ArrayList;

import static Util.TrabajarFechas.obtenerAnno;
import static Util.TrabajarFechas.obtenerMes;

public class TorpedoUsuario {
    private String idUsuario;
    private int mes;
    private int anno;
    private ArrayList<Prestamo> prestamos;

    public TorpedoUsuario(String idUsuario, int mes, int anno, Prestamo p){
        setIdUsuario(idUsuario);
        setMes(mes);
        setAnno(anno);
        this.prestamos = new ArrayList<Prestamo>();
        agregarPrestamo(p);
    }

    public TorpedoUsuario(String idUsuario, int mes, int anno){
        setIdUsuario(idUsuario);
        setMes(mes);
        setAnno(anno);
        this.prestamos = new ArrayList<Prestamo>();
    }

    public void agregarPrestamo(Prestamo p) {
        if ((p != null) && (p.getUsuario().getNumUsuario().equals(this.idUsuario))) {
            if (obtenerMes(p.getFechaConcepcion()) == this.mes) {
                if (obtenerAnno(p.getFechaConcepcion()) == this.anno) {
                    if (buscarPrestamo(p) == null) {
                        this.prestamos.add(p);
                    }
                }
            }
        }
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

    public Prestamo buscarPrestamo(Prestamo prestamo) {
        Prestamo salida = null;
        if (prestamo != null) {
            int i=0;
            while (salida == null && i < prestamos.size()) {
                if (prestamos.get(i).compareTo(prestamo)) {
                    salida = prestamos.get(i);
                }
                i++;
            }
        }
        return salida;
    }
}
