package Graphs;

import java.util.Comparator;

public class GraphAM<V,E> {

    private V[] vertices;
    private int capacity = 20;
    private int effectiveSize;
    private int[][] adyacencyMatrix;
    private  E[][] dataMatrix;
    private final boolean isDirected;
    private final Comparator<V> cmp;

    public GraphAM(Comparator<V> cmp, boolean isDirected) {
        this.isDirected = isDirected;
        this.cmp = cmp;
        vertices = (V[]) (new Object[capacity]); // ESTO SÍ FUNCIONA
        effectiveSize = 0;
        adyacencyMatrix = new int[capacity][capacity];
        initAdjMatrix();
    }

    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    public boolean add(V content) {
        if (content != null && !existsVertexWithContent(content)) {
            if (isFull()) {
                addCapacity();
            }
            vertices[effectiveSize++] = content;
            //update en la matriz de adyacencia
            fixAddConnections();
            return true;
        }
        return false;
    }

    public boolean remove(V content) {
        if (content != null && existsVertexWithContent(content)) {
            int deletedIdx = getIndex(content);
            fixRemoveConnections(deletedIdx);
            deleteVertex(content);
            return true;
        }
        return false;
    }

    public boolean connect(V content1, V content2) {
        boolean checkNull = content1 != null && content2 != null;
        boolean checkExistance = existsVertexWithContent(content1) && existsVertexWithContent(content2);
        if (checkNull && checkExistance) {
            int idxVert1 = getIndex(content1);
            int idxVert2 = getIndex(content2);
            adyacencyMatrix[idxVert1][idxVert2] = 1;
            if (!isDirected) {
                adyacencyMatrix[idxVert2][idxVert1] = 1;
            }
            return true;
        }
        return false;
    }

    private void fixRemoveConnections(int deletedIdx) {
        for (int i = 0; i < effectiveSize; i++) {
            for (int j = 0; j < effectiveSize; j++) {
                if (i == deletedIdx || j == deletedIdx) {
                    adyacencyMatrix[i][j] = -1;
//                    swap(i, j);
                }
            }
        }
    }

    private void swap(int i, int j) {
        if (adyacencyMatrix[i][j + 1] != -1) { //derecha
            adyacencyMatrix[i][j] = adyacencyMatrix[i][j + 1];
            adyacencyMatrix[i][j + 1] = -1;
        } else if (adyacencyMatrix[i + 1][j + 1] != -1 && !(adyacencyMatrix[i + 1][j] != -1) ) { //diagonal
            adyacencyMatrix[i][j] = adyacencyMatrix[i+1][j + 1];
            adyacencyMatrix[i+1][j + 1] = -1;
        } else if (adyacencyMatrix[i + 1][j] != -1) { //abajo
            adyacencyMatrix[i][j] = adyacencyMatrix[i + 1][j];
            adyacencyMatrix[i + 1][j] = -1;
        }
    }

    private void fixAddConnections() {
        for (int i = 0; i < effectiveSize; i++) {
            for (int j = 0; j < effectiveSize; j++) {
                if (adyacencyMatrix[i][j] == -1) {
                    adyacencyMatrix[i][j] = 0;
                }
            }
        }

    }

    private int getIndex(V content) {
        for (int i = 0; i < effectiveSize; i++) {
            if (cmp.compare(vertices[i], content) == 0) {
                return i;
            }
        }
        return 0;
    }

    private void deleteVertex(V content) {
        for (int i = 0; i < effectiveSize; i++) {
            if (vertices[i] != null) {
                if (cmp.compare(vertices[i], content) == 0) {
                    vertices[i] = null;
                    fixArray();
                }
            }
        }
    }

    private void fixArray() {
        for (int i = 0; i < effectiveSize - 1; i++) {
            if (vertices[i] == null) {
                vertices[i] = vertices[i + 1];
                vertices[i + 1] = null;
            }
        }
        effectiveSize--;
    }

    private boolean existsVertexWithContent(V content) {
        for (int i = 0; i < effectiveSize; i++) {
            if (cmp.compare(vertices[i], content) == 0) {
                return true;
            }
        }
        return false;
    }

    private void addCapacity() {
        growVertexCapacity();
        growMatrixCapacity();
    }

    private void growVertexCapacity() {
        V[] tmpVert = (V[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            tmpVert[i] = vertices[i];
        }
        vertices = tmpVert;
    }

    private void growMatrixCapacity() {
        int[][] tmpMatrix = new int[capacity * 2][capacity * 2];
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; i < capacity; i++) {
                tmpMatrix[i][j] = adyacencyMatrix[i][j];
            }
        }
        capacity = capacity * 2;
        adyacencyMatrix = tmpMatrix;
    }

    private boolean isFull() {
        return effectiveSize == capacity;
    }

    private void initAdjMatrix() {
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                adyacencyMatrix[i][j] = -1;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null) {
                sb.append(vertices[i]);
                if (vertices[i + 1] != null) {
                    sb.append(",");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String printAdjMatrix() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < adyacencyMatrix.length; i++) {
            sb.append("[ ");
            for (int j = 0; j < adyacencyMatrix[i].length; j++) {
                sb.append(adyacencyMatrix[i][j]);
                if (j != adyacencyMatrix[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            sb.append("\n");
        }
        return sb.toString();
    }

}
