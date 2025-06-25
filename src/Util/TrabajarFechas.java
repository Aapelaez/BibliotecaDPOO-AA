package Util;

import java.time.LocalDate;
import java.time.Period;
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

    public static int obtenerMes (Date d){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.MONTH) + 1; // Los meses en Calendar son 0-11
    }

    public static int obtenerAnno(Date d){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.YEAR);
    }

    public static int calcularEdad(String carnet) {
        String anno = carnet.substring(0, 2);
        String siglo = carnet.substring(7, 8);
        int annoCompleto = 0;

        if (Integer.parseInt(siglo) >= 0 && Integer.parseInt(siglo) <= 5) {
            annoCompleto = 1900 + Integer.parseInt(anno);
        } else if (Integer.parseInt(siglo) >= 6 && Integer.parseInt(siglo) <= 8) {
            annoCompleto = 2000 + Integer.parseInt(anno);
        }
        String mes = carnet.substring(2, 4);
        String dia = carnet.substring(4, 6);

        LocalDate nacimiento = LocalDate.of(annoCompleto, Integer.parseInt(mes), Integer.parseInt(dia));
        LocalDate actual = LocalDate.now();

        return Period.between(nacimiento, actual).getYears();
    }

    public static String formatearFecha(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH) + 1; // Los meses en Calendar son 0-11
        int anno = calendar.get(Calendar.YEAR);
        return String.format("%02d/%02d/%04d", dia, mes, anno);
    }
}
