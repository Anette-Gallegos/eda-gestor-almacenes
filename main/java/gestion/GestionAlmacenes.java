package gestion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import estructura.Edge;
import estructura.GraphLink;
import estructura.Vertex;
import models.Almacen;
import models.Producto;

public class GestionAlmacenes  {
    private GraphLink<Almacen> grafo;

    public GestionAlmacenes() {
        this.grafo = new GraphLink<>();
    }

    // metodo para agregar un almacen nuevo
    public void addAlmacen(int codigo, String nombre, String direccion) {
        // implementacion para agregar un almacen al grafo
        Almacen nuevoAlmacen = new Almacen(codigo, nombre, direccion);

        // Insertar el nuevo almacén en el grafo
        grafo.insertVertex(nuevoAlmacen);

        // Mostrar mensaje de éxito (esto es opcional, solo para indicar que se agregó correctamente)
        System.out.println("Se ha agregado un nuevo almacén: " + nuevoAlmacen);
    }

    // Metodo para agregar almacenes desde un archivo
    public void addAlmacenesFromFile(String filePath) {
        // Implementacion para cargar almacenes desde un archivo y agregarlos al grafo
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Suponemos que cada línea del archivo contiene los datos de un almacén en formato CSV (código, nombre, dirección)
                String[] data = line.split(",");

                if (data.length == 3) {
                    int codigo = Integer.parseInt(data[0].trim());
                    String nombre = data[1].trim();
                    String direccion = data[2].trim();

                    // Agregar el almacén al grafo utilizando el método addAlmacen
                    addAlmacen(codigo, nombre, direccion);
                } else {
                    // Si la línea no tiene el formato esperado, se ignora y se muestra un mensaje de error
                    System.err.println("Error al leer línea del archivo: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Metodo para dar de baja un almacen
    public void removeAlmacenByCodigo(int codigo) {
        Vertex<Almacen> vertexToRemove = null;
    for (Vertex<Almacen> vertex : grafo.getListVertex()) {
        if (vertex.getData().getCodigo() == codigo) {
            vertexToRemove = vertex;
            break;
        }
    }

    if (vertexToRemove != null) {
        grafo.removeVertex(vertexToRemove);
        System.out.println("Se ha eliminado el almacén con código " + codigo);
    } else {
        System.out.println("No se encontró ningún almacén con el código " + codigo);
    }
    
    
    }

    // Metodo para buscar un almacen por su codigo
    public Almacen findAlmacenByCodigo(int codigo) {
        // Implementacion para buscar un almacen en el grafo por su codigo
        // Devuelve el almacen encontrado o null si no existe
        for (Vertex<Almacen> vertex : grafo.getListVertex()) {
            if (vertex.getData().getCodigo() == codigo) {
                return vertex.getData();
            }
        }
        return null; // Si no se encuentra ningún almacén con el código especificado
    }

    // Metodo para buscar un producto en todos los almacenes
    public List<Almacen> buscarProductoEnAlmacenes(int codigoProducto) {
        // Implementacion para buscar un producto en todos los almacenes del grafo
        // Devuelve una lista de almacenes donde se encontro el producto
    }

    // Metodo para mostrar todos los almacenes
    public void showAllAlmacenes() {
        // Implementacion para mostrar todos los almacenes del grafo
    }

    // Metodo para agregar un producto a un almacen
    public void agregarProductoAlmacen(int codigoAlmacen, int codigoProducto, String descripcion, int stock) {
        // Implementacion para agregar un producto a un almacen especifico
        Almacen almacenEncontrado = null;
        for (Vertex<Almacen> vertex : grafo.getListVertex()) {
            // Se inicia un bucle 'for' que itera a través de todos los vértices (nodos) del grafo 'grafo'.
            Almacen almacen = vertex.getData();
            if (almacen.getCodigo() == codigoAlmacen) {
                // Se verifica si el código del almacén actual es igual al código del almacén buscado ('codigoAlmacen').
                almacenEncontrado = almacen;
                break;
            }
        }

        if (almacenEncontrado != null) {
            // Se verifica si se encontró algún almacén con el código buscado.
            Producto nuevoProducto = new Producto(codigoProducto, descripcion, stock);
            almacenEncontrado.getProductos().add(nuevoProducto);
            System.out.println("Se ha agregado el producto al almacén con código " + codigoAlmacen);
        } else {
            System.out.println("No se encontró ningún almacén con el código " + codigoAlmacen);
        }
    }

    // Metodo para agregar productos a un almacen desde un archivo
    public void agregarProductosAlmacenFromFile(int codigoAlmacen, String filePath) {
        // Implementacion para cargar productos de un archivo y agregarlos a un almacen especifico
    }

    // Metodo para dar de baja un producto de un almacen
    public void darDeBajaProductoAlmacen(int codigoAlmacen, int codigoProducto) {
        // Implementacion para eliminar un producto de un almacen especifico
    }

    // Metodo para buscar un producto en un almacen
    public Producto buscarProductoEnAlmacen(int codigoAlmacen, int codigoProducto) {
        // Implementacion para buscar un producto en un almacen especifico
        // Devuelve el producto encontrado o null si no existe
        // Verificamos si el código del almacén coincide con el código proporcionado
        for (Vertex<Almacen> vertex : grafo.getListVertex()) {
            Almacen almacen = vertex.getData();
            if (almacen.getCodigo() == codigoAlmacen) {
                // Si encontramos el almacén, buscamos el producto dentro de sus productos
                for (Producto producto : almacen.getProductos()) {
                    // Verificamos si el código del producto coincide con el código proporcionado
                    if (producto.getCodigo() == codigoProducto) {
                        return producto;
                    }
                }
                // no se encontró el producto en el almacén.
                break;
            }
        }
        return null;
    }

    // Metodo para mostrar los productos de un almacen
    public void mostrarProductosAlmacen(int codigoAlmacen) {
        // Implementacion para mostrar los productos de un almacen especifico
    }
}
