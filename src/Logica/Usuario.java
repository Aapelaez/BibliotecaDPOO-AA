package Logica;

import Util.TrabajarFechas;

import java.util.ArrayList;
import java.util.Date;

import static Util.TrabajarFechas.*;

public class Usuario extends Persona {
    private String numUsuario;
    private Date fechaAcreditacion;
    private ArrayList<TorpedoUsuario> torpedos;

    public Usuario(String id, String nombre, String apellidos, int edad, char genero, String numUsuario, Date fechaAcreditacion) {
        super(id, nombre, apellidos, edad, genero);
        setNumUsuario(numUsuario);
        setFechaAcreditacion(fechaAcreditacion);
        this.torpedos = new ArrayList<TorpedoUsuario>();
    }

    public ArrayList<TorpedoUsuario> getTorpedos() {
        return torpedos;
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

    public void solicitarPrestamo(String idPublicacion) {
        //Aqui se le solicita a la biblioteca el préstamo de una publicación
    }

    public void devolverEjemplar(String idPublicacion) {
        //Aqui se le devuelve a la biblioteca una publicación y ella la recibe
    }

    public void solicitarProrroga(Prestamo prestamo) {
        //Aqui se le solicita a la biblioteca una prórroga de una publicación y ella revisa
    }

    public boolean verificarCondicPrestamo(String idPublicacion) {
        TorpedoUsuario torpedo =null;
        boolean posible=true;
        if(estaPenalizado()==null) {
            if (idPublicacion != null) {
                torpedo = buscarTorpedoPersonal(new TorpedoUsuario(numUsuario, getMesActual(), getAnnoActual()));
                if (torpedo!=null) {
                    int i = 0;
                    Prestamo prestamo = null;
                    while (i < torpedo.getPrestamos().size() && posible) {
                        if (torpedo.getPrestamos().get(i).compareTo(idPublicacion)) {
                            prestamo=torpedo.getPrestamos().get(i);
                            if (prestamo.getEstado() == EstadoPrestamo.NoEntregado) {
                                posible = false;
                            } else if (prestamo.getEstado() == EstadoPrestamo.EntregadoEnTiempo||
                                    prestamo.getEstado() == EstadoPrestamo.EntregadoFueraDeTiempo) {
                                if(cantDiasEntreFechas(prestamo.getFechaLimite(), getFechaActual()) < 15) {
                                    posible = false;
                                }
                            }
                        }
                        ++i;
                    }
                }
            }
        }
        return posible;
    }

    public Date estaPenalizado() {
        Date salida = null;
        for (TorpedoUsuario torpedo : torpedos) {
            if (torpedo.torpedoVigente()) {
                for (Prestamo prestamo : torpedo.getPrestamos()) {
                    if (prestamo.getEstado() == EstadoPrestamo.EntregadoFueraDeTiempo) {
                        if (salida != null) {
                            if (prestamo.finPenalizacion().after(salida)) {
                                salida = prestamo.finPenalizacion();
                            }
                        } else if (salida == null) {
                            salida = prestamo.finPenalizacion();
                        }

                    }
                }
            }
        }
        return salida;
    }

    public void addTorpedo(TorpedoUsuario torpedo) {
        if (torpedo != null) {
            this.torpedos.add(torpedo);
        }
    }

    public TorpedoUsuario buscarTorpedoPersonal(TorpedoUsuario torpedo) {
        int i = 0;
        while (i < torpedos.size()) {
            if (torpedos.get(i).compareTo(numUsuario, getMesActual(), getAnnoActual())) {
                torpedo = torpedos.get(i);
            }
            i++;
        }
        return torpedo;
    }


}
