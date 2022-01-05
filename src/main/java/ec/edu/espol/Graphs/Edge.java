package ec.edu.espol.Graphs;

class Edge<E, V> {

    private Vertex<V, E> source;
    private Vertex<V, E> target;
    private E data;
    private int weight;

    public Edge(Vertex<V, E> source, Vertex<V, E> target, E data, int weight) {
        this.source = source;
        this.target = target;
        this.data = data;
        this.weight = weight;
    }

    public Edge(Vertex<V, E> source, Vertex<V, E> target, int weight) {
        this.source = source;
        this.target = target;
        this.data = null;
        this.weight = weight;
    }

    public Vertex<V, E> getSource() {
        return source;
    }

    public void setSource(Vertex<V, E> source) {
        this.source = source;
    }

    public Vertex<V, E> getTarget() {
        return target;
    }

    public void setTarget(Vertex<V, E> target) {
        this.target = target;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
