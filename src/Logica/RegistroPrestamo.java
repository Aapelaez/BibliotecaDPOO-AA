package Logica;

public class RegistroPrestamo {
    private int mes;
    private int anno;
    private int cantidad;
    private String idPublicacion;

    public RegistroPrestamo(int mes, int anno, String idPublicacion) {
        setMes(mes);
        setAnno(anno);
        setCantidad(1);
        setIdPublicacion(idPublicacion);
    }

    public boolean compareTo(int mes, int anno, String idPublicacion) {
        return (this.mes == mes && this.anno == anno && this.idPublicacion.equals(idPublicacion));
    }

    public void incrementarCantidad() {
        this.cantidad++;
    }
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(String idPublicacion) {
        this.idPublicacion = idPublicacion;
    }
}
