package Logica;

import java.util.ArrayList;

public abstract class Publicacion {
    protected String id;
    protected String titulo;
    protected String materia;
    protected int numPaginas;
    protected ArrayList<Ejemplar> ejemplares;

    public int cantTotalEjemp(){
        return ejemplares.size();
    }

    public int cantEjempPrestados() {
        int count = 0;
        for (Ejemplar ejemplar : ejemplares) {
            if (!ejemplar.estaDisponible()){
                count++;
            }
        }
        return count;
    }
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

    public ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public Publicacion (String id, String titulo, String materia, int numPaginas) {
        setId(id);
        setTitulo(titulo);
        setMateria(materia);
        setNumPaginas(numPaginas);
        this.ejemplares = new ArrayList<Ejemplar>();
    }
    public Publicacion() {
        this.ejemplares = new ArrayList<Ejemplar>();
    }
}
