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

    public static int getMesActual() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1; // Los meses en Calendar son 0-11
    }
    public static int getAnnoActual() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
}
