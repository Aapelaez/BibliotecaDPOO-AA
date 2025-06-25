package Logica;

import java.util.ArrayList;

public class Articulo extends Publicacion{
    private ArrayList<String> arbitros;

    public Articulo(String id, String titulo, String materia, int numPaginas, int cantTotalEjemp, boolean estado, ArrayList<String> arbitros) {
        super(id, titulo, materia, numPaginas, cantTotalEjemp, estado);
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
