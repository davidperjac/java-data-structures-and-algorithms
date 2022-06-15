package Graphs;

import List.List;
import java.util.LinkedList;

public class Vertex<V, E> {

    private V content;
    private LinkedList<Edge<E, V>> edges;
    private boolean visited;

    public Vertex(V content) {
        this.content = content;
        this.edges = new LinkedList<Edge<E, V>>();
    }

    public V getContent() {
        return content;
    }

    public void setContent(V content) {
        this.content = content;
    }

    public LinkedList<Edge<E, V>> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge<E, V>> edges) {
        this.edges = edges;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addEdge(Vertex<V, E> target, int peso) {
        if (searchEdge(target) == null) {
            edges.add(new Edge(this,target,peso));
        }
    }

    public void removeEdge(Vertex<V,E> target) {
        Edge<E,V> arco = searchEdge(target);
        if (arco != null) {
            edges.remove(arco);
        }
    }

    public Edge<E,V> searchEdge(Vertex<V,E> target) {
        for (Edge<E,V> e : edges) {
            if (e.getTarget().equals(target)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "{ Vertex : " + content + " - Edges : " + edges + "}";
    }

}
