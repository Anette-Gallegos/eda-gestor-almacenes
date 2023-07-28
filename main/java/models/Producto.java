package models;

public class Producto {
    private int codigo;
    private String descripcion;
    private int stock;

    // constructor
    public Producto(int codigo, String descripcion, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    // getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", stock=" + stock + "]";
    }
}
