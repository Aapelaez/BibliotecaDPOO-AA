package Util;

import java.util.Calendar;
import java.util.Date;

public class TrabajarFechas {
    public static Date sumarDias(Date inicio, int cantidadDias) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inicio);
            calendar.add(Calendar.DATE, cantidadDias);
            Date nuevaFecha = calendar.getTime();
            return nuevaFecha;
    }

    public static int restarDias(Date inicio, Date fin) {
        long diferencia = fin.getTime() - inicio.getTime();
        return (int) (diferencia / (1000 * 60 * 60 * 24)); // Convertir milisegundos a días
    }

    public static int cantDiasEntreFechas(Date inicio, Date fin) {
        long diferencia = fin.getTime() - inicio.getTime();
        return (int) (diferencia / (1000 * 60 * 60 * 24)); // Convertir milisegundos a días
    }

    public static int getMesActual() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1; // Los meses en Calendar son 0-11
    }
    public static int getAnnoActual() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static Date getFechaActual() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public static Date aumentarFechaFinEnMitadDelIntervalo(Date fechaInicio, Date fechaFin) {
        int cantidad =cantDiasEntreFechas(fechaInicio, fechaFin);
        return sumarDias(fechaInicio, cantidad / 2);
    }

    public static Date calcLimitePenalizacion(Date fechaInicio, Date fechaFin) {
        int cantidad = cantDiasEntreFechas(fechaInicio, fechaFin);
        return sumarDias(fechaFin, cantidad*3);
    }

    public static boolean compararMesAnno(int mes, int anno, Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        int mesFecha = calendar.get(Calendar.MONTH) + 1; // Los meses en Calendar son 0-11
        int annoFecha = calendar.get(Calendar.YEAR);
        return (mes == mesFecha && anno == annoFecha);
    }
}
