package Logica;

import java.util.ArrayList;

public class Articulo extends Publicacion{
    private ArrayList<String> arbitros;

    public Articulo(String id, String titulo, String materia, int numPaginas, int cantTotalEjemp) {
        super(id, titulo, materia, numPaginas, cantTotalEjemp);
        this.arbitros = new ArrayList<String>();
    }

    public Articulo(String id, String titulo, String materia, int numPaginas, int cantTotalEjemp, ArrayList<String> arbitros) {
        super(id, titulo, materia, numPaginas, cantTotalEjemp);
        setArbitros(arbitros);
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

    private void setArbitros(ArrayList<String> ar){
        if(ar.size()>0)
            this.arbitros=ar;
    }
}
