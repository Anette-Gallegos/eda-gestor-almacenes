package gestion;

import estructura.GraphLink;
import estructura.Vertex;
import models.Almacen;
import models.Producto;

public class GestionProductos {
    private GraphLink<Almacen> almacenesGraph;

    public GestionProductos() {
        this.almacenesGraph = new GraphLink<>();
    }

    // Método para establecer el grafo de almacenes
    public void setAlmacenesGraph(GraphLink<Almacen> almacenesGraph) {
        this.almacenesGraph = almacenesGraph;
    }

    // Metodo para agregar un producto nuevo a un almacen
    public void agregarProductoAlmacen(int codigoAlmacen, int codigoProducto, String descripcion, int stock) {
        // Implementación para agregar un producto a un almacen especifico
    }

    // Metodo para agregar productos a un almacen desde un archivo
    public void agregarProductosAlmacenDesdeArchivo(int codigoAlmacen, String filePath) {
        // Implementación para cargar productos desde un archivo y agregarlos a un almacen especifico
    }

    // Metodo para dar de baja un producto de un almacen
    public void darDeBajaProductoAlmacen(int codigoAlmacen, int codigoProducto) {
        // Implementación para eliminar un producto de un almacen especifico
    }

    // Metodo para buscar un producto en un almacen
    public Producto buscarProductoEnAlmacen(int codigoAlmacen, int codigoProducto) {
        // implementación para buscar un producto en un almacen especifico
        // devuelve el producto encontrado o null si no existe
    }

    // Metodo para mostrar los productos de un almacen
    public void mostrarProductosAlmacen(int codigoAlmacen) {
        // Implementación para mostrar los productos de un almacen especifico
        Almacen almacenEncontrado = null;
        // Se obtiene el almacén contenido en el vértice actual y se almacena en la variable 'almacen'.
        for (Vertex<Almacen> vertex : almacenesGraph.getListVertex()) {
            Almacen almacen = vertex.getData();
            if (almacen.getCodigo() == codigoAlmacen) {
                //Se verifica si el codigo es igual al buscado
                almacenEncontrado = almacen;
                break;
            }
        }

        if (almacenEncontrado != null) {
            // Se verifica si se encontró algún almacén con el código buscado.
            System.out.println("Productos en el almacén " + almacenEncontrado.getNombre() + ":");
            for (Producto producto : almacenEncontrado.getProductos()) {
                // Se usa el for-each para recorrer todos los productos contenidos en el almacén encontrado.
                System.out.println(producto);
            }
        } else {
            System.out.println("No se encontró ningún almacén con el código " + codigoAlmacen);
        }
    }
}
