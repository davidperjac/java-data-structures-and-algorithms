package ec.edu.espol.Graphs;

import java.util.Comparator;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //COMPARATOR DE INTEGERS

        Comparator<Integer> cmp1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        };
        //GRAPH

        GraphAM graph = new GraphAM(cmp1, false);
        graph.add(2);
        graph.add(5);
        graph.add(12);
        graph.add(44);
        System.out.println(graph);
        graph.connect(5, 12);
        graph.connect(2, 12);
        graph.connect(44, 2);
        graph.connect(2, 5);
        System.out.println("\n");
        System.out.println(graph.printAdjMatrix());
        graph.remove(12);
        System.out.println("\n");
        System.out.println(graph.printAdjMatrix());

    }

}
