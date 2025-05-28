package Logica;

import java.util.ArrayList;

public class Articulo extends Publicacion{
    private ArrayList<String> arbitros;

    public Articulo(String id, String titulo, String materia, String numPaginas) {
        super(id, titulo, materia, numPaginas);
        this.arbitros = new ArrayList<String>();
    }

    @Override
    public int calcularPlazoMax() {
        return 68;
    }

    public ArrayList<String> getArbitros() {
        return arbitros;
    }

}
