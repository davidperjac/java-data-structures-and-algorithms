package ec.edu.espol.Graphs;

import ec.edu.espol.ADT_List.List;
import java.util.LinkedList;


public class Vertex<V,E> {
    private V content;
    private LinkedList<Edge<E,V>> edges;
    private boolean visited;

    public Vertex(V content) {
        this.content = content;
        this.edges = new LinkedList<Edge<E,V>>();
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
        
}
