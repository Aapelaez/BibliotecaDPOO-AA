package Logica;

import java.util.ArrayList;

public class Libro extends Publicacion {
    private ArrayList<String> autores;
    private String editorial;

    public Libro(String id, String titulo, String materia, int numPaginas, String editorial) {
        super(id, titulo, materia, numPaginas);
        this.autores = new ArrayList<String>();
        this.editorial = editorial;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int calcularPlazoMax() {
        int salida=30;
        int calculo=(Integer)(getNumPaginas()/50)+(cantTotalEjemp*2);
        if(calculo<salida){
            salida=calculo;
        }
        return salida;
    }
}
