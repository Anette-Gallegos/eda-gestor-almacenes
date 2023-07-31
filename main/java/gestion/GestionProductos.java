package gestion;

import models.Producto;
import models.Almacen;

public class GestionProductos {
    private GestionAlmacenes gestionAlmacenes;
    
    public GestionProductos(GestionAlmacenes gestionAlmacenes) {
        this.gestionAlmacenes = gestionAlmacenes;
    }
    
    // Metodo para agregar un producto nuevo a un almacen
    public void agregarProductoAlmacen(int codigoAlmacen, int codigoProducto, String descripcion, int stock) {
        // obtener el almacen que corresponde al codigo
        Almacen almacen = gestionAlmacenes.findAlmacenByCodigo(codigoAlmacen);
        if (almacen == null) {
            System.out.println("No se encontro el almacen con codigo: " + codigoAlmacen);
            return;
        }
        
        // verificar si el producto ya existe en el almacen
        Producto productoExistente = almacen.buscarProductoPorCodigo(codigoProducto);
        if (productoExistente != null) {
            System.out.println("El producto con codigo: " + codigoProducto + " ya existe en el almacen");
            return;
        }
        
        // agregar el nuevo producto al almacen
        Producto nuevoProducto = new Producto(codigoProducto, descripcion, stock);
        almacen.getProductos().add(nuevoProducto);
        System.out.println("Producto agregado al almacen con exito");
    }

    // Metodo para agregar productos a un almacen desde un archivo
    public void agregarProductosAlmacenDesdeArchivo(int codigoAlmacen, String filePath) {
        // Implementación para cargar productos desde un archivo y agregarlos a un almacen especifico
    }

    // Metodo para dar de baja un producto de un almacen
    public void darDeBajaProductoAlmacen(int codigoAlmacen, int codigoProducto) {

    }

    // Metodo para buscar un producto en un almacen
    public Producto buscarProductoEnAlmacen(int codigoAlmacen, int codigoProducto) {
        // implementación para buscar un producto en un almacen especifico
        // devuelve el producto encontrado o null si no existe
    }

    // Metodo para mostrar los productos de un almacen
    public void mostrarProductosAlmacen(int codigoAlmacen) {
        // Implementación para mostrar los productos de un almacen especifico
    }
}
