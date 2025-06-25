package Logica;


public abstract class Publicacion {
    protected String id;
    protected String titulo;
    protected String materia;
    protected int numPaginas;
    protected int cantTotalEjemp;
    protected boolean estado; // true: disponible, false: reservado por la biblioteca

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

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMateria() {
        return materia;
    }

    private void setMateria(String materia) {
        this.materia = materia;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    private void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    public int getCantTotalEjemp() {
        return cantTotalEjemp;
    }
    public void setCantTotalEjemp(int cantTotalEjemp) {
        if(cantTotalEjemp>=2){
        this.cantTotalEjemp = cantTotalEjemp;
        }
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Publicacion (String id, String titulo, String materia, int numPaginas, int cantTotalEjemp, boolean estado) {
        setId(id);
        setTitulo(titulo);
        setMateria(materia);
        setNumPaginas(numPaginas);
        setCantTotalEjemp(cantTotalEjemp);
        setEstado(estado);
    }


    public Publicacion() {}
}
