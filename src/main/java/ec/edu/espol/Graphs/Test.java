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

        Comparator<String> cmp2 = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };

        //GRAPH
        /*
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
         */
        //****************PRACTICA_EXAMEN*******************//
        GraphAL graph = new GraphAL(cmp2, true);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.connect("A", "B", "", 8);
        graph.connect("A", "C", "", 2);
        graph.connect("A", "F", "", 1);
        graph.connect("A", "G", "", 1);
        
        graph.connect("B", "C", "", 3);
        graph.connect("B", "D", "", 1);
        
        graph.connect("D", "E", "", 2);

        graph.connect("F", "G", "", 4);

        graph.printBFS("A");

    }

}
