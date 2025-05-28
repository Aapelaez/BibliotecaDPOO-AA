package Util;

import java.util.regex.Pattern;

public class Validaciones {
    private static final Pattern PATRON_TEXTO_VALIDO =
            Pattern.compile("^[\\p{L} .'-]+$");

    public static boolean validarCarnet(String cadena) {
        boolean valido = true;
        if(cadena!=null) {
            int longitud = cadena.length();

            if (!cadena.matches("\\d{11}")) {
                valido= false;
            }

            String siglo = cadena.substring(7, 8);
            int compSiglo = Integer.parseInt(siglo);

            if (compSiglo == 9 && valido) {
                valido = false; // Siglo XIX
            }

            String anno = cadena.substring(0, 2);
            int compAnno = Integer.parseInt(anno);
            int annoCompleto = 0;
            if (valido && ((compSiglo >= 6 && compSiglo < 9) && compAnno > 25)) {
                valido = false; // Siglo XXI y año mayor que el actual (inválido).
            }

            if (valido && ((compSiglo >= 0 && compSiglo < 6) && compAnno < 25)) {
                valido = false; // Siglo XX y mayor que 100 años.
            }

            if (valido) {
                if (compSiglo >= 0 && compSiglo <= 5) {
                    annoCompleto = 1900 + compAnno;
                } else if (compSiglo >= 6 && compSiglo <= 8) {
                    annoCompleto = 2000 + compAnno;
                }
            }

            String mes = cadena.substring(2, 4);
            int compMes = Integer.parseInt(mes);

            if (compMes < 1 || compMes > 12) {
                valido = false; // Solo 12 meses.
            }

            String dia = cadena.substring(4, 6);
            int compDia = Integer.parseInt(dia);

            if (valido && compDia < 1) {
                valido = false;
            }
            if (valido && compDia > 31) {
                valido = false;
            }
            if (valido && ((compMes < 8 && compMes != 2 && compMes % 2 == 0) && compDia > 30)) {
                valido = false;
            }
            if (valido && ((compMes > 7 && compMes != 2 && compMes % 2 != 0) && compDia > 30)) {
                valido = false;
            }

            // Año bisiesto y validación de febrero
            if (compMes == 2 && valido && annoCompleto > 0) {
                boolean bisiesto = (annoCompleto % 4 == 0 && (annoCompleto % 100 != 0 || annoCompleto % 400 == 0));
                if (bisiesto && compDia > 29) {
                    valido = false;
                }
                if (!bisiesto && compDia > 28) {
                    valido = false;
                }
            }
        }else{
            valido = false;
        }
        return valido;
    }

    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.isEmpty() && PATRON_TEXTO_VALIDO.matcher(texto).matches();
    }
}
