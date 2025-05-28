package Logica;

import java.util.ArrayList;

public class Articulo extends Publicacion{
    private ArrayList<String> arbitros;

    public Articulo(String id, String titulo, String materia, int numPaginas) {
        super(id, titulo, materia, numPaginas);
        this.arbitros = new ArrayList<String>();
    }

    @Override
    public int calcularPlazoMax() {
        int salida=30;
        int calculo=(Integer)(getNumPaginas()/30)+cantTotalEjemp;
        if(calculo<salida){
            salida=calculo;
        }
        return salida;
    }

    public ArrayList<String> getArbitros() {
        return arbitros;
    }

}
