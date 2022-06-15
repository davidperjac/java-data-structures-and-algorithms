package ec.edu.espol.Graphs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class GraphAL<V, E> {

    private LinkedList<Vertex<V, E>> vertices;
    private boolean isDirected;
    private Comparator<V> cmp;

    public GraphAL(Comparator<V> cmp, boolean isDirected) {
        this.isDirected = isDirected;
        this.cmp = cmp;
        this.vertices = new LinkedList<>();
    }

    public LinkedList<Vertex<V, E>> getVertices() {
        return vertices;
    }

    public boolean addVertex(V content) {
        if (content != null && !existsVertexWithContent(content)) {
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
        if (!isDirected) {
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

    //EXAMEN 2021 1T 2P 
    //TEMA 4
    public void reduce(int n) {
        if (vertices.isEmpty() || vertices.size() <= n || n <= 0) {
            return;
        }
        while (vertices.size() != n) {
            Random rand = new Random();
            Vertex<V, E> source;

            do {
                source = vertices.get(rand.nextInt(vertices.size()));
            } while (source.getEdges().isEmpty());

            Edge<E, V> edge = source.getEdges().get(rand.nextInt(source.getEdges().size()));
            Vertex<V, E> target = edge.getTarget();

            Vertex<V, E> mixedVertex = getMixedContent(source, target, edge.getWeight());

            for (Edge<E, V> e : source.getEdges()) {
                mixedVertex.addEdge(target, e.getWeight());
            }

//            for (Edge<E, V> e : target.getEdges()) {
//                Edge<E,V> mixedEdge = mixedVertex.searchEdge(e.getTarget());
//                if (mixedEdge == null) {
//                    mixedVertex.addEdge(e.getTarget(), e.getWeight());
//                } else {
//                    mixedEdge.getWeight() = mixedEdge.getWeight() += e.getWeight();
//                }
//            }

        }

    }

    private Vertex<V, E> getMixedContent(Vertex<V, E> source, Vertex<V, E> target, int peso) {
        String contenido = String.valueOf(source.getContent()) + String.valueOf(target.getContent()) + String.valueOf(peso);
        return new Vertex<>((V) contenido);
    }

//    public void reduce(int n) {
//        if (vertices.isEmpty() || vertices.size() <= n || n <= 0) {
//            return;
//        }
//
//        while (vertices.size() > n) {
//            Random rand = new Random();
//            Vertex<E> vo;
//            do {
//                vo = vertices.get(rand.nextInt(vertices.size()));
//            } while (vo.edges.isEmpty());
//            Edge<E> arco = vo.edges.get(rand.nextInt(vo.edges.size()));
//            Vertex<E> vd = arco.destino;
//
//            Vertex<E> vFusionado = fusionar(vo, vd, arco.peso);
//
//            for (Edge<E> a : vo.edges) {
//                vFusionado.agregarArco(a.destino, a.peso);
//            }
//
//            for (Edge<E> a : vd.edges) {
//                Edge<E> aFusionado = vFusionado.buscarArco(a.destino);
//                if (aFusionado == null) {
//                    vFusionado.agregarArco(a.destino, a.peso);
//                } else {
//                    aFusionado.peso += a.peso;
//                }
//            }
//
//            for (Vertex<E> v : vertices) {
//                Edge<E> haciaOrigen = v.buscarArco(vo);
//                Edge<E> haciaDestino = v.buscarArco(vd);
//                if (haciaOrigen != null && haciaDestino != null) {
//                    v.agregarArco(vFusionado, haciaOrigen.peso + haciaDestino.peso);
//                }
//                if (haciaOrigen != null && haciaDestino == null) {
//                    v.agregarArco(vFusionado, haciaOrigen.peso);
//                }
//                if (haciaOrigen == null && haciaDestino != null) {
//                    v.agregarArco(vFusionado, haciaDestino.peso);
//                }
//            }
//
//            vertices.add(vFusionado);
//            this.removerVertice(vo.element);
//            this.removerVertice(vd.element);
//        }
//    }
//
//    private Vertex<E> fusionar(Vertex<E> vo, Vertex<E> vd, int peso) {
//        String contenido = String.valueOf(vo.element) + String.valueOf(vd.element) + String.valueOf(peso);
//        Vertex<E> vFusionado = new Vertex<>((E) contenido);
//        return vFusionado;
//    }
}
