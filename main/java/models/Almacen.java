package models;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private int codigo;
    private String nombre;
    private String direccion;
    private List<Producto> productos;

    public Almacen(int codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.productos = new ArrayList<>();
    }

    // getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    public Producto buscarProductoPorCodigo(int codigoProducto) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigoProducto) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Almacen [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + "]";
    }
}
