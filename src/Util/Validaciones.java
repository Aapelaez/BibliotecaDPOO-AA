package Util;

import Logica.Libro;
import Logica.Publicacion;
import Logica.Revista;


import java.util.regex.Pattern;

public class Validaciones {
    private static final Pattern PATRON_TEXTO_VALIDO =
            Pattern.compile("^[\\p{L} .'-]+$");

    public static boolean validarCarnet(String cadena, char genero) {
        boolean valido = true;
        if(cadena!=null) {
            int longitud = cadena.length();

            if (!cadena.matches("\\d{11}")) {
                valido= false;
            }

            String generoCadena = cadena.substring(10, 11);
            //El dígito 10 es para el género. Es par cuando es masculino e impar cuando es femenino.
            int compGenero = Integer.parseInt(generoCadena);
            if(valido && compGenero%2==0 && genero == 'F') {
                valido = false;
            } else if (valido && compGenero%2==1 && genero == 'M') {
                valido = false;
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
                valido = false; // Siglo XXI y año mayor que el actual (invalido).
            }

            if (valido && ((compSiglo >= 0 && compSiglo < 6) && compAnno < 25)) {
                valido = false; // Siglo XX y mayor que 100 annos.
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

            // Año bisiesto y validacion de febrero
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

    public static String clasificarPublicacion(Publicacion p){
        String clasificado = "";
        if (p!=null){
            if(p instanceof Libro){
                clasificado = "Libro";
            } else if (p instanceof Revista) {
                clasificado = "Revista";
            }else{
                clasificado="Artículo";
            }
        }
        return clasificado;
    }

    public static boolean validarCodigo(String codigo, String tipoPublicacion) {
        boolean valido = true;
        if(codigo==null|| codigo.isEmpty() ||tipoPublicacion==null|| tipoPublicacion.isEmpty()) {
            valido = false;
        }
        // Validar el formato general (L, R o A + 5 dígitos)
        if (valido&&!Pattern.matches("^[LRA]\\d{5}$", codigo)) {
            valido= false;
        }
        //Verificar que la letra coincida con el tipo de publicación
        char tipo = codigo.charAt(0);
        if(valido&&tipo=='L' && !tipoPublicacion.equalsIgnoreCase("Libro")) {
            valido = false;
        } else if (valido && tipo == 'R' && !tipoPublicacion.equalsIgnoreCase("Revista")) {
            valido = false;
        } else if (valido && tipo == 'A' && !tipoPublicacion.equalsIgnoreCase("Artículo")) {
            valido = false;
        }
        return valido;
    }

    public static boolean validarEmail(String email) {
        boolean valido = true;
        String regex = "^[A-Za-z0-9+_-](?:[A-Za-z0-9+_.-]*[A-Za-z0-9+_-])?@[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$";
        if (!Pattern.matches(regex, email)){
            valido =false;
        }
        // No permitir dos puntos consecutivos en el usuario
        String usuario = email.substring(0, email.indexOf('@'));
        if(usuario.contains("..")){
            valido = false;
        }
        return valido;
    }
}
