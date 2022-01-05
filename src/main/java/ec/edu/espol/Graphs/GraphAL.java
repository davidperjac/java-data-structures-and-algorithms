package ec.edu.espol.Graphs;

import ec.edu.espol.ADT_List.List;
import java.util.Comparator;
import java.util.LinkedList;

public class GraphAL<V, E> {

    private LinkedList<Vertex<V, E>> vertices;
    private boolean isDirected;
    private Comparator<V> cmp;

    public GraphAL(boolean isDirected, Comparator<V> cmp) {
        this.isDirected = isDirected;
        this.cmp = cmp;
    }

    public boolean addVertex(V content) {
        if (content != null && existsVertexWithContent(content)) {
            Vertex newVertex = new Vertex(content);
            vertices.add(newVertex);
            return true;
        }
        return false;
    }

    public boolean connect(V content1, V content2, E data, int weight) {
        if (!validateExistance(content1,content2)) return false;
        Vertex vert1 = getVertexByContent(content1);
        Vertex vert2 = getVertexByContent(content2);
        Edge<E, V> newEdge = new Edge(vert1, vert2, data, weight);
        vert1.getEdges().add(newEdge);
        if (isDirected) {
            Edge<E, V> notDirectedEdge = new Edge(vert2, vert1, data, weight);
            vert2.getEdges().add(notDirectedEdge);
        }
        return true;
    }

    private boolean validateExistance(V content1, V content2) {
        boolean checkNull = content1 != null && content2 != null;
        boolean checkExistance = existsVertexWithContent(content1) && existsVertexWithContent(content2);
        
        if (checkNull && checkExistance) return true;
        return false;
    }

    private Vertex getVertexByContent(V content) {
        for (Vertex<V, E> vertex : vertices) {
            if (cmp.compare(vertex.getContent(), content) == 0) {
                return vertex;
            }
        }
        return null;
    }

    private boolean existsVertexWithContent(V content) {
        for (Vertex<V, E> vertex : vertices) {
            if (cmp.compare(vertex.getContent(), content) == 0) {
                return true;
            }
        }
        return false;
    }

}
