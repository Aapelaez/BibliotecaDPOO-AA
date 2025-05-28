package Logica;

public class Revista extends Publicacion {
    private int anno;
    private int numero;

    public Revista(String id, String titulo, String materia, String numPaginas, int anno, int numero) {
        super(id, titulo, materia, numPaginas);
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
        return 7; // Ejemplo de plazo máximo para una revista
    }
}
