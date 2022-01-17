package ec.edu.espol.Graphs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
        if (!validateExistance(content1, content2)) {
            return false;
        }
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

    private List<Vertex<V, E>> breathFirstSearch(V start, boolean isConnectedSearch) {
        List<Vertex<V, E>> output = new LinkedList<>();
        Queue<Vertex<V, E>> q = new LinkedList<>();
        
        Vertex<V, E> vertex = getVertexByContent(start);
        q.add(vertex);
        vertex.setVisited(true);
        
        while (!q.isEmpty()) {
            Vertex<V, E> v = q.remove();
            output.add(v);
            LinkedList<Edge<E, V>> edges = v.getEdges();
            for (Edge<E, V> e : edges) {
                Vertex<V, E> target = e.getTarget();
                if (!target.isVisited()) {
                    target.setVisited(true);
                    q.add(target);
                }
            }
        }
        if (!isConnectedSearch) {
            for (Vertex<V, E> v : output) {
                v.setVisited(false);
            }
        }

        return output;
    }

    public void printBFS(V start) {
        System.out.println(breathFirstSearch(start, false));
    }

    private List<Vertex<V, E>> depthFirstSearch(V start, boolean isConnectedSearch) {
        List<Vertex<V, E>> output = new LinkedList<>();
        Stack<Vertex<V, E>> s = new Stack<>();
        
        Vertex<V, E> vertex = getVertexByContent(start);
        s.push(vertex);
        vertex.setVisited(true);
        
        while (!s.isEmpty()) {
            Vertex<V, E> v = s.pop();
            output.add(v);
            LinkedList<Edge<E, V>> edges = v.getEdges();
            for (Edge<E, V> e : edges) {
                Vertex<V, E> target = e.getTarget();
                if (!target.isVisited()) {
                    target.setVisited(true);
                    s.push(target);
                }
            }
        }
        if (!isConnectedSearch) {
            for (Vertex<V, E> v : output) {
                v.setVisited(false);
            }
        }
        return output;
    }

    public void printDFS(V start) {
        System.out.println(depthFirstSearch(start, false));
    }

    private List<List<Vertex<V, E>>> getConnectedComponents() {
        List<List<Vertex<V, E>>> result = new LinkedList<>();

        List<Vertex<V, E>> recorrido;
        while (true) {

            Vertex<V, E> vertexNoVisitado = searchVisitedVertex();

            if (vertexNoVisitado == null) {
                break;
            }

            recorrido = this.breathFirstSearch(vertexNoVisitado.getContent(), true);
            result.add(recorrido);
        }
        return result;
    }

    public void printConnectedComponents() {
        System.out.println(getConnectedComponents());
    }

    public Vertex<V, E> searchVisitedVertex() {
        for (Vertex<V, E> v : vertices) {
            if (!v.isVisited()) {
                return v;
            }
        }
        return null;
    }

    private void invertDirections() {

    }

    private void resetGraph() {

    }

    private boolean validateExistance(V content1, V content2) {
        boolean checkNull = content1 != null && content2 != null;
        boolean checkExistance = existsVertexWithContent(content1) && existsVertexWithContent(content2);

        if (checkNull && checkExistance) {
            return true;
        }
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
