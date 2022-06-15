package ec.edu.espol.BinaryTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        /**
         * * ARBOLES.
         */

        //arbol enteros
        BinaryTree<Integer> tree = new BinaryTree(0);
        tree.setLeft(new BinaryTree(1));
        tree.setRight(new BinaryTree(2));
        tree.getLeft().setLeft(new BinaryTree(3));
        tree.getLeft().setRight(new BinaryTree(4));
        tree.getRight().setLeft(new BinaryTree(5));
        tree.getRight().setRight(new BinaryTree(6));
        tree.getRight().getRight().setRight(new BinaryTree(7));

        //arbol identico para prueba Identical
        BinaryTree<Integer> tree2 = new BinaryTree(0);
        tree2.setLeft(new BinaryTree(1));
        tree2.setRight(new BinaryTree(2));
        tree2.getLeft().setLeft(new BinaryTree(3));
        tree2.getLeft().setRight(new BinaryTree(4));
        tree2.getRight().setLeft(new BinaryTree(5));
        tree2.getRight().setRight(new BinaryTree(6));
        tree2.getRight().getRight().setRight(new BinaryTree(7));

        //arbol strings
        BinaryTree<String> treeString = new BinaryTree("Zero");
        treeString.setLeft(new BinaryTree("One"));
        treeString.setRight(new BinaryTree("Two"));
        treeString.getLeft().setLeft(new BinaryTree("Three"));
        treeString.getLeft().setRight(new BinaryTree("Four"));
        treeString.getRight().setRight(new BinaryTree("Five"));

        //arbol para countNodesWithOnlyChild
        BinaryTree<String> treeChild = new BinaryTree("Two");
        treeChild.setLeft(new BinaryTree("Seven"));
        treeChild.setRight(new BinaryTree("Five"));
        treeChild.getLeft().setRight(new BinaryTree("Six"));
        treeChild.getRight().setRight(new BinaryTree("Nine"));
        treeChild.getLeft().getRight().setLeft(new BinaryTree("One"));
        treeChild.getLeft().getRight().setRight(new BinaryTree("Three"));
        treeChild.getRight().getRight().setLeft(new BinaryTree("Four"));

        //arbol para largestValueOfEachLevel
        BinaryTree<Integer> treeLargestV = new BinaryTree(4);
        treeLargestV.setLeft(new BinaryTree(9));
        treeLargestV.setRight(new BinaryTree(2));
        treeLargestV.getLeft().setLeft(new BinaryTree(3));
        treeLargestV.getLeft().setRight(new BinaryTree(5));
        treeLargestV.getRight().setRight(new BinaryTree(7));

        //arboles para isHeightBalanced
        BinaryTree<Integer> treeBalanced = new BinaryTree(0);
        treeBalanced.setLeft(new BinaryTree(1));
        treeBalanced.setRight(new BinaryTree(2));
        treeBalanced.getLeft().setLeft(new BinaryTree(4));

        BinaryTree<Integer> treeNotBalanced = new BinaryTree(0);
        treeNotBalanced.setLeft(new BinaryTree(1));
        treeNotBalanced.setRight(new BinaryTree(2));
        treeNotBalanced.getLeft().setLeft(new BinaryTree(4));
        treeNotBalanced.getLeft().getLeft().setRight(new BinaryTree(4));

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
         * * PRUEBAS.
         */
        //****************TALLER*******************//
        //search        
        //recursiveSearch
//        System.out.println(tree.recursiveSearch(1, cmp1));
//        //iterativeSearch 
//        System.out.println(tree.iterativeSearch(1, cmp1));
//        //getMin
//        //recursive
//        System.out.println(tree.getMinRecursive(cmp1));
//        //iterative
//        System.out.println(tree.getMinIterative(cmp1));
//        // countdescendants
//        //recursive
//        System.out.println(tree.countDescendantsRecursive());
//        //iterative
//        System.out.println(tree.countDescendantsIterative());
//        //****************TAREA*******************//
//        // 1) findparent ****************************
//        //recursive
//        System.out.println(tree.findParentRecursive(new BinaryNode(7), cmp1));
//        //iterative 
//        System.out.println(tree.findParentIterative(new BinaryNode(7), cmp1));
//        // 2) countlevels ****************************
//        //recursive 
//        System.out.println(treeString.countLevelsRecursive());
//        //iterative
//        System.out.println(treeString.countLevelsIterative());
//        // 3) isLefty ********************************
//        //recursive 
//        System.out.println(tree.isLeftyRecursive());
//        //iterative
//        System.out.println(tree.isLeftyIterative());
//        // 4) isIdenticall ****************************
//        //recursive
//        System.out.println(tree.isIdenticalRecursive(tree2, cmp1));
//        //iterative
//        System.out.println(tree.isIdenticalIterative(tree2, cmp1));
//        // 5)  largestValueOfEachLevel ****************************
//        // recursive
//        treeLargestV.largestValueOfEachLevelRecursive(cmp1);
//        // iterative
//        treeLargestV.largestValueOfEachLevelIterative(cmp1);
//        // 6) countNodesWithOnlyChild ****************************
//        //recursive
//        System.out.println(treeChild.countNodesWithOnlyChildRecursive());
//        //iterative
//        System.out.println(treeChild.countNodesWithOnlyChildIterative());
//        // 7) isHeightBalanced ****************************
//        //recursive
//        System.out.println(treeBalanced.isHeightBalancedRecursive());
//        System.out.println(treeNotBalanced.isHeightBalancedRecursive());
//        //iterative
//        System.out.println(treeBalanced.isHeightBalancedIterative());
//        System.out.println(treeNotBalanced.isHeightBalancedIterative());
        //****************PRACTICA_EXAMEN*******************//
//        BinaryTree<Integer> balancedTree = new BinaryTree(5);
//        
//        balancedTree.setLeft(new BinaryTree(1));
//        balancedTree.setRight(new BinaryTree(8));
//        balancedTree.getRight().setLeft(new BinaryTree(6));
//        balancedTree.getRight().setRight(new BinaryTree(9));
//
//        BinaryTree<Integer> notBalancedTree = new BinaryTree(5);
//        
//        notBalancedTree.setLeft(new BinaryTree(1));
//        notBalancedTree.setRight(new BinaryTree(8));
//        
//        notBalancedTree.getLeft().setRight(new BinaryTree(3));
//        notBalancedTree.getLeft().getRight().setLeft(new BinaryTree(2));
//        
//        notBalancedTree.getRight().setRight(new BinaryTree(9));
//        notBalancedTree.getRight().getRight().setRight(new BinaryTree(10));
//        
//        balancedTree.isBalanced();
//        System.out.println("----------------------------");
//        notBalancedTree.isBalanced();
        // 2
//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        numbers.add(1);
//        numbers.add(8);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(9);
//        numbers.add(6);
//
//        BinaryTree<Integer> heapTree = BinaryTree.createHeapTree(numbers);
//        heapTree.recorrerPreOrden();
        //3
        BinaryTree<String> leftTree = new BinaryTree(new BinaryTree<>("A"));
        leftTree.setLeft(new BinaryTree<>("B"));
        leftTree.setRight(new BinaryTree<>("C"));
        leftTree.getLeft().setLeft(new BinaryTree<>("D"));
        leftTree.getRight().setLeft(new BinaryTree<>("E"));
        leftTree.getRight().setRight(new BinaryTree<>("F"));
        leftTree.getRight().getLeft().setLeft(new BinaryTree<>("G"));
        leftTree.getRight().getLeft().setLeft(new BinaryTree<>("H"));
//        
//        BinaryTree<Integer> rightTree = new BinaryTree(new BinaryTree(2));
//        rightTree.setLeft(new BinaryTree<Integer>(1));
//        rightTree.setRight(new BinaryTree<Integer>(4));
//        rightTree.getLeft().setLeft(new BinaryTree<Integer>(3));
//        rightTree.getLeft().setRight(new BinaryTree<Integer>(8));
//        
//        BinaryTree<Integer> intersectedTree = leftTree.findIntersection(rightTree);
//        intersectedTree.recorrerPreOrden();

        //4 
        
        leftTree.maxLevel(2, cmp2);
        
        

    }

    //CLASE ARBOL DE EXPRESION ********IGNORAR************//
    public static BinaryTree<String> buildExpressionTree(String expression) {

        Stack<BinaryTree<String>> s = new Stack<>();
        String[] tokens = expression.split("");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (isOperand(token)) {
                BinaryTree<String> t = new BinaryTree<>(token);
                s.push(t);
            } else {
                BinaryTree<String> t = new BinaryTree<>(token);
                if (!s.isEmpty()) {
                    t.getRoot().setRight(s.pop());
                    t.getRoot().setLeft(s.pop());
                }
                s.push(t);
            }
        }
        return s.pop();
    }

    public Integer evaluateExpressionTree(BinaryTree<String> tree) {
        if (tree.isLeaf() && isOperand(tree.getRoot().getContent())) {
            return Integer.parseInt(tree.getRoot().getContent());
        } else {
            Integer leftValue = 0, rightValue = 0;
            if (tree.getRoot().getLeft() != null) {
                leftValue = evaluateExpressionTree(tree.getLeft());

            }
            if (tree.getRoot().getRight() != null) {
                rightValue = evaluateExpressionTree(tree.getRight());
            }

            String operator = tree.getRoot().getContent();

            return operate(leftValue, rightValue, operator);
        }
    }

    private static boolean isOperand(String token) {
        return !isOperator(token);
    }

    private static boolean isOperator(String token) {
        return token.equalsIgnoreCase("+")
                || token.equalsIgnoreCase("-")
                || token.equalsIgnoreCase("*")
                || token.equalsIgnoreCase("/");
    }

    private Integer operate(Integer res1, Integer res2, String operator) {
        switch (operator) {
            case "+":
                return res1 + res2;
            case "-":
                return res1 - res2;
            case "*":
                return res1 * res2;
            case "/":
                return res1 / res2;
            default:
                return 0;
        }
    }
}
