package estructura;

public class Vertex<E> {
    protected E data;
    protected ListLinked<Edge<E>> listAdj;
    
    // Atributos para el algoritmo de Dijkstra
    private int distancia;
    private Vertex<E> previo;
    private boolean visitado;
    
    public Vertex(E data) {
        this.data = data;
        this.listAdj = new ListLinked<Edge<E>>();
        this.distancia = Integer.MAX_VALUE;
        this.previo = null;
        this.visitado = false;
    }

    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            Vertex<E> v = (Vertex<E>) o;
            return this.data.equals(v.data);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.data + " -->\t " + this.listAdj.toString() + "\n";
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public ListLinked<Edge<E>> getListAdj() {
        return listAdj;
    }
    
    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Vertex<E> getPrevio() {
        return previo;
    }

    public void setPrevio(Vertex<E> previo) {
        this.previo = previo;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}
