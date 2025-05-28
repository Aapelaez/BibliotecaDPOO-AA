package Logica;

public class Ejemplar {
    private String idEjemplar;
    private Estado estadoEjemplar;

    public boolean estaDisponible() {
        return estadoEjemplar == Estado.Disponible;
    }
    public Ejemplar(String idEjemplar, Estado estadoEjemplar) {
        setIdEjemplar(idEjemplar);
        setEstadoEjemplar(estadoEjemplar);
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }

    private void setIdEjemplar(String idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Estado getEstadoEjemplar() {
        return estadoEjemplar;
    }

    public void setEstadoEjemplar(Estado estadoEjemplar) {
        this.estadoEjemplar = estadoEjemplar;
    }
}