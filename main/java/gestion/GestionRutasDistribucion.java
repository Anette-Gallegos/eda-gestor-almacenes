package gestion;

import estructura.Edge;
import java.util.List;
import estructura.GraphLink;
import estructura.ListLinked;
import estructura.Vertex;
import java.util.ArrayList;
import models.Almacen;
import java.util.PriorityQueue;

public class GestionRutasDistribucion {
    private GraphLink<Almacen> almacenesGraph;

    public GestionRutasDistribucion(GraphLink<Almacen> almacenesGraph) {
        this.almacenesGraph = almacenesGraph;
    }

    // metodo para agregar vías de distribución desde un archivo
    public void agregarViasDistribucionDesdeArchivo(String filePath) {
        // implementacion para cargar las vias de distribución desde un archivo y agregarlas al grafo
    }

    // Método para obtener la ruta de distribución más corta entre dos almacenes
    public List<Almacen> obtenerRutaDistribucionMasCorta(int codigoAlmacenOrigen, int codigoAlmacenDestino) {
        // Obtener los vertices de los almacenes desde el grafo
        ListLinked<Vertex<Almacen>> vertices = almacenesGraph.getListVertex();

        // encontrar el vertice correspondiente al almacen de origen y destino
        Vertex<Almacen> origen = null;
        Vertex<Almacen> destino = null;
        for (Vertex<Almacen> vertex : vertices) {
            if (vertex.getData().getCodigo() == codigoAlmacenOrigen) {
                origen = vertex;
            } else if (vertex.getData().getCodigo() == codigoAlmacenDestino) {
                destino = vertex;
            }
        }

        if (origen == null || destino == null) {
            System.out.println("No se encontró uno o ambos almacenes en el grafo.");
            return null;
        }

        // se aplica el algoritmo de Dijkstra
        List<Almacen> rutaMasCorta = new ArrayList<>();
        PriorityQueue<Vertex<Almacen>> queue = new PriorityQueue<>((v1, v2) -> v1.getDistancia() - v2.getDistancia());

        origen.setDistancia(0);
        queue.add(origen);

        while (!queue.isEmpty()) {
            Vertex<Almacen> actual = queue.poll();
            if (actual == destino) {
                // llegamos al destino, construir la ruta hacia atras
                while (actual != null) {
                    rutaMasCorta.add(0, actual.getData());
                    actual = actual.getPrevio();
                }
                break;
            }

            for (Edge<Almacen> edge : actual.getListAdj()) {
                Vertex<Almacen> vecino = edge.getRefdest();
                int distanciaNueva = actual.getDistancia() + edge.getWeight();
                if (distanciaNueva < vecino.getDistancia()) {
                    queue.remove(vecino);
                    vecino.setDistancia(distanciaNueva);
                    vecino.setPrevio(actual);
                    queue.add(vecino);
                }
            }
        }

        // se reinicia las distancias y previos para futuras consultas
        for (Vertex<Almacen> vertex : vertices) {
            vertex.setDistancia(Integer.MAX_VALUE);
            vertex.setPrevio(null);
        }

        return rutaMasCorta;
    }
}