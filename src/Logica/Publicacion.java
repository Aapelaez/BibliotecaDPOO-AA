package Logica;


public abstract class Publicacion {
    protected String id;
    protected String titulo;
    protected String materia;
    protected int numPaginas;
    protected int cantTotalEjemp;

    public boolean compareTo(String id) {
        return this.id.equals(id);
    }
    public abstract int calcularPlazoMax();

    private void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return this.id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    public int getCantTotalEjemp() {
        return cantTotalEjemp;
    }
    public void setCantTotalEjemp(int cantTotalEjemp) {
        this.cantTotalEjemp = cantTotalEjemp;
    }

    public Publicacion (String id, String titulo, String materia, int numPaginas, int cantTotalEjemp) {
        setId(id);
        setTitulo(titulo);
        setMateria(materia);
        setNumPaginas(numPaginas);
        setCantTotalEjemp(cantTotalEjemp);
    }


    public Publicacion() {}
}
