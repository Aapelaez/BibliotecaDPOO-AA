package Logica;

import Util.TrabajarFechas;

import java.util.ArrayList;
import java.util.Date;

import static Util.TrabajarFechas.*;

public class Usuario extends Persona {
    private String numUsuario;
    private Date fechaAcreditacion;
    private ArrayList<Prestamo> prestamos;

    public Usuario(String id, String nombre, String apellidos, char genero, String numUsuario, Date fechaAcreditacion) {
        super(id, nombre, apellidos, genero);
        setNumUsuario(numUsuario);
        setFechaAcreditacion(fechaAcreditacion);
        this.prestamos = new ArrayList<Prestamo>();
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

    public boolean compareTo(String numUsuario) {
        return this.getNumUsuario().equals(numUsuario);
    }

    public void addPrestamo(Prestamo prestamo) {
        if (prestamo != null) {
            this.prestamos.add(prestamo);
        }
    }

    public boolean verificarCondicPrestamo(String idPublicacion) {
        TorpedoUsuario torpedo =null;
        boolean posible=true;
        if(estaPenalizado()==null) {
            if(prestamos.size()<3) {
                if (idPublicacion != null) {
                    torpedo = Biblioteca.getInstance().buscarTorpedo(numUsuario);
                    if (torpedo != null) {
                        int i = 0;

                        while (i < torpedo.getPrestamos().size() && posible) {
                            Prestamo prestamo = torpedo.getPrestamos().get(i);
                            if (prestamo.PrestNoEntregado(idPublicacion, getNumUsuario()) != null) {
                                posible = false;
                            } else if (prestamo.getEstado() == EstadoPrestamo.EntregadoEnTiempo ||
                                    prestamo.getEstado() == EstadoPrestamo.EntregadoFueraDeTiempo) {
                                if (cantDiasEntreFechas(prestamo.getFechaEntregado(), getFechaActual()) < 15) {
                                    posible = false;
                                }
                            }
                            ++i;
                        }
                    }
                }
            }
        }

        return posible;
    }

    public Date estaPenalizado() {
        Date salida = null;
                  for (Prestamo prestamo : prestamos) {
                    if (prestamo.getEstado() == EstadoPrestamo.EntregadoFueraDeTiempo) {
                        if (salida != null) {
                            if (prestamo.finPenalizacion().after(salida)) {
                                salida = prestamo.finPenalizacion();
                            }
                        } else {
                            salida = prestamo.finPenalizacion();
                        }

                    }
                }
        return salida;
    }



}
