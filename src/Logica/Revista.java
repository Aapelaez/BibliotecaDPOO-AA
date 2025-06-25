package Logica;

public class Revista extends Publicacion {
    private int anno;
    private int numero;

    public Revista(String id, String titulo, String materia, int numPaginas, int anno, int numero, int ejemplares, boolean estado) {
        super(id, titulo, materia, numPaginas,ejemplares, estado);
        setAnno(anno);
        setNumero(numero);
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int calcularPlazoMax() {
        int salida=30;
        int calculo=cantTotalEjemp*2;
        if(calculo<salida){
            salida=calculo;
        }
        return salida;
    }
}
