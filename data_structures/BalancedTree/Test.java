package BalancedTree;

import java.util.Comparator;

public class Test {

    public static void main(String[] args) {
        
        /**
         * * COMPARADORES.
         */
        Comparator<Integer> cmp1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        };

        Comparator<String> cmp2 = new Comparator<String>() {
            @Override
            public int compare(String n1, String n2) {
                return n1.compareTo(n2);
            }
        };
        
        /**
         * * ARBOL DE ENTEROS.
         */
        BalancedTree<Integer,Integer> tree = new BalancedTree<>(new BalancedTreeNode(0,0) , cmp1);
        
        /**
         * * TEST DE METODOS.
         */
        //insert
        tree.insert(1,1);
        tree.insert(2,2);
        tree.insert(3,3);
        tree.insert(4,4);
        tree.insert(5,5);
        tree.insert(6,6);
        //search
        tree.search(3, cmp1);
        //print
        tree.print();
        
    }
    
}
