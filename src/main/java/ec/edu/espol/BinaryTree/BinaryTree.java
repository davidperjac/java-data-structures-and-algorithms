package ec.edu.espol.BinaryTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author davidperez
 */
public class BinaryTree<T> {

    private BinaryNode<T> root;

    public BinaryTree() {
        this.root = new BinaryNode<>();
    }

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    public BinaryTree(T content) {
        this.root = new BinaryNode<>(content);
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }

    public void setLeft(BinaryTree<T> tree) {
        this.root.setLeft(tree);
    }

    public void setRight(BinaryTree<T> tree) {
        this.root.setRight(tree);
    }

    public BinaryTree<T> getLeft() {
        return this.root.getLeft();
    }

    public BinaryTree<T> getRight() {
        return this.root.getRight();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isLeaf() {
        return this.root.getLeft() == null && this.root.getRight() == null;
    }

    /**
     * * FUNCIONES EXTRAS.
     */
    public void recorrerPreOrden() {
        if (!this.isEmpty()) {
            System.out.println(this.root.getContent());

            if (root.getLeft() != null) {
                root.getLeft().recorrerPreOrden();
            }

            if (root.getRight() != null) {
                root.getRight().recorrerPreOrden();
            }

        }
    }

    public void recorrerPostOrden() {
        if (!this.isEmpty()) {

            if (root.getLeft() != null) {
                root.getLeft().recorrerPreOrden();
            }

            if (root.getRight() != null) {
                root.getRight().recorrerPreOrden();
            }

            System.out.println(this.root.getContent());
        }
    }

    public void recorrerEnOrden() {
        if (!this.isEmpty()) {
            if (root.getLeft() != null) {
                root.getLeft().recorrerPreOrden();
            }

            System.out.println(this.root.getContent());

            if (root.getRight() != null) {
                root.getRight().recorrerPreOrden();
            }

        }
    }

    private boolean hasOnlyChild() {
        if (this.root.getLeft() == null && this.root.getRight() != null
                || this.root.getRight() == null && this.root.getLeft() != null) {
            return true;
        }
        return false;
    }

    private int height() {
        if (this.isEmpty()) {
            return 0;
        }
        return 1 + Math.max(this.getLeft().height(), this.getLeft().height());
    }

    /**
     * * FUNCIONES DE TALLER YA IMPLEMENTADOS.
     */
    public int countLeavesRecursive() {
        if (this.isEmpty()) {
            return 0;
        } else if (this.isLeaf()) {
            return 1;
        } else {
            int leavesLeft = 0;
            int leavesRight = 0;
            if (this.root.getLeft() != null) {
                leavesLeft = this.root.getLeft().countLeavesRecursive();
            }
            if (this.root.getRight() != null) {
                leavesRight = this.root.getRight().countLeavesRecursive();
            }
            return leavesLeft + leavesRight;
        }
    }

    public int countLeavesIterative() {
        Stack<BinaryTree<T>> stack = new Stack();
        int count = 0;
        if (this.isEmpty()) {
            return count;
        } else {
            stack.push(this);
            while (!stack.empty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }
                if (subtree.isLeaf()) {
                    count++;
                }
            }
        }
        return count;
    }

    public BinaryNode<T> recursiveSearch(T content, Comparator<T> cmp) {
        if (this.isEmpty()) {
            return null;
        } else {
            if (cmp.compare(this.root.getContent(), content) == 0) {
                return this.root;
            } else {
                BinaryNode<T> tmp = null;
                if (this.root.getLeft() != null) {
                    tmp = this.root.getLeft().recursiveSearch(content, cmp);
                }
                if (tmp == null) {
                    if (this.root.getRight() != null) {
                        return this.root.getRight().recursiveSearch(content, cmp);
                    }
                }
                return tmp;
            }
        }
    }

    /**
     * * FUNCIONES DE TALLER A IMPLEMENTAR.
     */
    public BinaryNode<T> iterativeSearch(T content, Comparator<T> cmp) {
        Stack<BinaryTree<T>> stack = new Stack();
        if (this.isEmpty()) {
            return null;
        } else {
            stack.push(this);
            while (!stack.empty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }

                if (cmp.compare(subtree.getRoot().getContent(), content) == 0) {
                    return subtree.getRoot();
                }
            }
        }
        return null;
    }

    public BinaryNode<T> getMinRecursive(Comparator<T> cmp) {
        if (this.isEmpty()) {
            return null;
        } else {
            BinaryNode<T> minimo = this.root;
            BinaryNode<T> minimoLeft = null;
            BinaryNode<T> minimoRight = null;
            if (this.root.getLeft() != null) {
                minimoLeft = this.getLeft().getMinRecursive(cmp);
                if (cmp.compare(minimoLeft.getContent(), minimo.getContent()) == -1) {
                    minimo = minimoLeft;
                }
            }
            if (this.root.getRight() != null) {
                minimoRight = this.getRight().getMinRecursive(cmp);
                if (cmp.compare(minimoRight.getContent(), minimo.getContent()) == -1) {
                    minimo = minimoRight;
                }
            }
            return minimo;
        }
    }

    public BinaryNode<T> getMinIterative(Comparator<T> cmp) {
        Stack<BinaryTree<T>> stack = new Stack();
        T minimo = null;
        BinaryNode<T> nodoMinimo = null;
        if (this.isEmpty()) {
            return null;
        } else {
            stack.push(this);
            while (!stack.empty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }
                if (minimo == null) {
                    minimo = subtree.getRoot().getContent();
                    nodoMinimo = subtree.getRoot();
                }
                if (cmp.compare(subtree.getRoot().getContent(), minimo) == -1) {
                    minimo = subtree.getRoot().getContent();
                    nodoMinimo = subtree.getRoot();
                }
            }
        }
        return nodoMinimo;
    }

    public int countDescendantsRecursive() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int descendantsLeft = 0;
            int descendantsRight = 0;
            if (this.root.getLeft() != null) {
                descendantsLeft = this.root.getLeft().countDescendantsRecursive() + 1;
            }
            if (this.root.getRight() != null) {
                descendantsRight = this.root.getRight().countDescendantsRecursive() + 1;
            }
            return descendantsLeft + descendantsRight;
        }
    }

    public int countDescendantsIterative() {
        Stack<BinaryTree<T>> stack = new Stack();
        int count = 0;
        int iteraciones = 0;
        if (this.isEmpty()) {
            return 0;
        } else {
            stack.push(this);
            while (!stack.isEmpty()) {
                BinaryTree<T> subtree = stack.pop();
                iteraciones++;
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }
                if (subtree.root != null) {
                    count++;
                }
            }
        }
        if (iteraciones == 1) {
            return 0;
        }
        return count - 1;
    }

    /**
     * * FUNCIONES DE TAREA.
     */
    public BinaryNode<T> findParentRecursive(BinaryNode<T> n, Comparator<T> cmp) {
        if (this.isEmpty() || cmp.compare(n.getContent(), this.root.getContent()) != 0) {
            return null;
        } else {
            if (this.root.getLeft() != null && cmp.compare(this.root.getLeft().root.getContent(), n.getContent()) != 0) {
                return this.root;
            }
            if (this.root.getRight() != null && cmp.compare(this.root.getRight().root.getContent(), n.getContent()) != 0) {
                return this.root;
            }
            BinaryNode<T> tmp = null;
            if (this.root.getLeft() != null) {
                tmp = this.root.getLeft().findParentRecursive(n, cmp);
            }
            if (tmp == null) {
                if (this.root.getRight() != null) {
                    return this.root.getRight().findParentRecursive(n, cmp);
                }
            }
            return tmp;
        }
    }

    public BinaryNode<T> findParentIterative(BinaryNode<T> n, Comparator<T> cmp) {
        Stack<BinaryTree<T>> stack = new Stack();
        Stack<BinaryNode<T>> parents = new Stack();
        if (this.isEmpty() || cmp.compare(n.getContent(), this.root.getContent()) != 0) {
            return null;
        } else {
            if (cmp.compare(this.root.getLeft().root.getContent(), n.getContent()) != 0
                    || cmp.compare(this.root.getRight().root.getContent(), n.getContent()) != 0) {
                return this.root;
            }
            stack.push(this);
            while (!stack.isEmpty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (cmp.compare(subtree.root.getContent(), n.getContent()) != 0) {
                    return parents.pop();
                }
                if (!subtree.isLeaf()) {
                    parents.push(subtree.root);
                }
            }
        }
        return null;
    }

    public int countLevelsRecursive() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int leftLevel = 0, rightLevel = 0;
            if (this.root.getLeft() != null) {
                leftLevel = this.root.getLeft().countLevelsRecursive();
            }
            if (this.root.getRight() != null) {
                rightLevel = this.root.getRight().countLevelsRecursive();
            }
            if (leftLevel > rightLevel) {
                return (leftLevel + 1);
            } else {
                return (rightLevel + 1);
            }
        }
    }

    public int countLevelsIterative() {
        Stack<BinaryTree<T>> levelLeft = new Stack();
        Stack<BinaryTree<T>> levelRight = new Stack();
        BinaryNode<T> originalRoot = this.root;
        if (this.isEmpty()) {
            return 0;
        } else {
            if (this.isLeaf()) {
                return 1;
            }
            while (this.root != null && this.root.getLeft() != null) {
                levelLeft.push(this.root.getLeft());
                this.root = this.root.getLeft().root;
            }
            this.root = originalRoot;
            while (this.root != null && this.root.getRight() != null) {
                levelRight.push(this.root.getRight());
                this.root = this.root.getRight().root;
            }
            if (levelLeft.size() > levelRight.size()) {
                return levelLeft.size() + 1;
            } else {
                return levelRight.size() + 1;
            }
        }
    }

    public boolean isLeftyRecursive() {
        if (this.isEmpty() || this.isLeaf()) {
            return true;
        }
        if (this.getLeft() == null || !this.getLeft().isLeftyRecursive() || (getRight() != null && !getRight().isLeftyRecursive())) {
            return false;
        }
        return getLeft().countDescendantsIterative() + 1 > countDescendantsIterative() / 2;
    }

    public boolean isLeftyIterative() {
        if (this.isEmpty() || this.isLeaf()) {
            return true;
        } else {
            Stack<BinaryTree<T>> stack = new Stack();
            stack.push(this);
            while (!stack.isEmpty()) {
                BinaryTree<T> subtree = stack.pop();
                int descendants = subtree.countDescendantsIterative();
                if (subtree.getLeft() != null) {
                    int leftDescendants = subtree.getLeft().countDescendantsIterative() + 1;
                    if (leftDescendants <= ((float) descendants / 2)) {
                        return false;
                    }
                    stack.push(subtree.getLeft());
                }
                if (subtree.getRight() != null) {
                    stack.push(subtree.getRight());
                }
            }
        }
        return true;
    }

    public boolean isIdenticalRecursive(BinaryTree<T> other, Comparator<T> cmp) {
        if (this.isEmpty() || other.isEmpty()) {
            return false;
        } else if (cmp.compare(this.root.getContent(), other.root.getContent()) != 0) {
            return false;
        } else if (this.countDescendantsIterative() != other.countDescendantsIterative()) {
            return false;
        } else {
            boolean tmp = true;
            if (this.root.getLeft() != null && other.root.getLeft() != null) {
                tmp = this.root.getLeft().isIdenticalRecursive(other.root.getLeft(), cmp);
            }
            if (tmp == true) {
                if (this.root.getRight() != null && other.root.getRight() != null) {
                    tmp = this.root.getRight().isIdenticalRecursive(other.root.getRight(), cmp);
                }
            }
            return tmp;
        }
    }

    public boolean isIdenticalIterative(BinaryTree<T> other, Comparator<T> cmp) {
        Stack<BinaryTree<T>> treesThis = new Stack();
        Stack<BinaryTree<T>> nodosThis = new Stack();

        Stack<BinaryTree<T>> treesOther = new Stack();
        Stack<BinaryTree<T>> nodosOther = new Stack();

        if (this.isEmpty() || other.isEmpty()) {
            return false;
        } else {
            if (this.countDescendantsIterative() != other.countDescendantsIterative()) {
                return false;
            }
            treesThis.push(this);
            treesOther.push(other);
            while (!treesThis.empty()) {
                BinaryTree<T> subtree = treesThis.pop();
                if (subtree.root.getLeft() != null) {
                    treesThis.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    treesThis.push(subtree.root.getRight());
                }
                nodosThis.push(subtree);
            }
            while (!treesOther.empty()) {
                BinaryTree<T> subtree = treesOther.pop();
                if (subtree.root.getLeft() != null) {
                    treesOther.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    treesOther.push(subtree.root.getRight());
                }
                nodosOther.push(subtree);
            }
            if (nodosThis.size() != nodosOther.size()) {
                return false;
            }
            while (!nodosThis.isEmpty() && !nodosOther.isEmpty()) {
                BinaryTree<T> nodoThis = nodosThis.pop();
                BinaryTree<T> nodoOther = nodosOther.pop();
                if (cmp.compare(nodoThis.root.getContent(), nodoOther.root.getContent()) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void largestValueOfEachLevelRecursive(Comparator<T> cmp, LinkedList<T> maximos, int nivel) {
        if (this.isEmpty()) {
            return;
        } else {
            if (nivel == maximos.size()) {
                maximos.addLast(this.root.getContent());
            }
            if (cmp.compare(this.root.getContent(), maximos.getLast()) == 1) {
                maximos.set(nivel, this.root.getContent());
            }
            if (this.root.getLeft() != null) {
                this.root.getLeft().largestValueOfEachLevelRecursive(cmp, maximos, nivel + 1);
            }
            if (this.root.getRight() != null) {
                this.root.getRight().largestValueOfEachLevelRecursive(cmp, maximos, nivel + 1);
            }
        }
    }

    public void largestValueOfEachLevelRecursive(Comparator<T> cmp) {
        LinkedList<T> maximos = new LinkedList<>();
        this.largestValueOfEachLevelRecursive(cmp, maximos, 0);
        System.out.println(maximos);
    }

    public void largestValueOfEachLevelIterative(Comparator<T> cmp) {
        LinkedList<T> maximos = new LinkedList<>();
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        if (this.isEmpty()) {
            return;
        } else {
            queue.offer(this);
            while (!queue.isEmpty()) {
                int stackSize = queue.size();
                T max = null;
                for (int i = 0; i < stackSize; i++) {
                    BinaryTree<T> subtree = queue.poll();
                    if (max == null) {
                        max = subtree.root.getContent();
                    }
                    if (cmp.compare(subtree.root.getContent(), max) == 1) {
                        max = subtree.root.getContent();
                    }

                    if (subtree.root.getLeft() != null) {
                        queue.offer(subtree.root.getLeft());
                    }
                    if (subtree.root.getRight() != null) {
                        queue.offer(subtree.root.getRight());
                    }
                }
                maximos.add(max);
            }
        }
        System.out.println(maximos);
    }

    public int countNodesWithOnlyChildRecursive() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int count = 0;
            if (this.root.getLeft() != null) {
                if (this.hasOnlyChild()) {
                    count++;
                }
                count += this.getLeft().countNodesWithOnlyChildRecursive();
            }
            if (this.root.getRight() != null) {
                if (this.hasOnlyChild()) {
                    count++;
                }
                count += this.getRight().countNodesWithOnlyChildRecursive();
            }
            return count;
        }
    }

    public int countNodesWithOnlyChildIterative() {
        Stack<BinaryTree<T>> stack = new Stack();
        int count = 0;
        if (this.isEmpty()) {
            return 0;
        } else {
            stack.push(this);
            while (!stack.empty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }
                if (subtree.hasOnlyChild()) {
                    count++;
                }
            }
        }
        return count;
    }

    //isHeightBalanced
    public boolean isHeightBalancedRecursive() {
        if (this.isEmpty()) {
            return true;
        } else {
            if (this.getLeft() != null && this.getRight() != null) {
                if (Math.abs((this.getLeft().countDescendantsIterative() + 1) - (this.getRight().countDescendantsIterative() + 1)) <= 1) {
                    return true;
                }
                this.getLeft().isHeightBalancedRecursive();
                this.getRight().isHeightBalancedRecursive();
            }
        }
        return false;
    }

    public boolean isHeightBalancedIterative() {
        if (this.isEmpty()) {
            return true;
        } else {
            Stack<BinaryTree<T>> stack = new Stack();
            stack.push(this);
            while (!stack.isEmpty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.getLeft() != null && subtree.getRight() != null) {
                    if (Math.abs((this.getLeft().countDescendantsIterative() + 1) - (this.getRight().countDescendantsIterative() + 1)) > 1) {
                        return false;
                    }
                }
                if (subtree.getLeft() != null) {
                    stack.push(subtree.getLeft());
                }
                if (subtree.getRight() != null) {
                    stack.push(subtree.getRight());
                }
            }
        }
        return true;
    }

    //EXAMEN 2021 1T 2P 
    //TEMA 2
    public void isBalanced() {
        boolean balanced = true;
        LinkedList<T> debalancedNodes = new LinkedList<>();
        if (isEmpty() || this.isLeaf()) {
            System.out.println("Arbol se encuentra balanceado");
        } else {
            Stack<BinaryTree<T>> stack = new Stack();
            stack.push(this);
            while (!stack.isEmpty()) {
                BinaryTree<T> subtree = stack.pop();

                if (noNulls(subtree)) {
                    if ((subtree.getLeft().countLevelsRecursive()) - (subtree.getRight().countLevelsRecursive()) > 1
                            || (subtree.getLeft().countLevelsRecursive()) - (subtree.getRight().countLevelsRecursive()) < -1) {
                        balanced = false;
                        debalancedNodes.add(subtree.root.getContent());
                    }
                } else if (leftNull(subtree)) {
                    if (subtree.getRight().countLevelsRecursive() + 1 > 2) {
                        balanced = false;
                        debalancedNodes.add(subtree.root.getContent());
                    }
                } else if (rightNull(subtree)) {
                    if (subtree.getLeft().countLevelsRecursive() + 1 > 2) {
                        balanced = false;
                        debalancedNodes.add(subtree.root.getContent());
                    }
                }

                if (subtree.getRight() != null) {
                    stack.push(subtree.getRight());
                }
                if (subtree.getLeft() != null) {
                    stack.push(subtree.getLeft());
                }
            }
        }
        printDebalancedNodes(balanced, debalancedNodes);
    }

    private void setDebalancedConditions(boolean balanced, LinkedList<T> debalancedNodes, BinaryTree<T> subtree) {
        balanced = false;
        debalancedNodes.add(subtree.root.getContent());
    }

    private boolean rightNull(BinaryTree<T> subtree) {
        return subtree.getRight() == null && subtree.getLeft() != null;
    }

    private boolean leftNull(BinaryTree<T> subtree) {
        return subtree.getLeft() == null && subtree.getRight() != null;
    }

    private boolean noNulls(BinaryTree<T> subtree) {
        return subtree.getLeft() != null && subtree.getRight() != null;
    }

    private void printDebalancedNodes(boolean balanced, LinkedList<T> debalancedNodes) {
        if (balanced) {
            System.out.println("Arbol se encuentra balanceado");
        } else {
            String message = "Arbol se encuentra desbalanceado debido a los nodos : ";
            for (T content : debalancedNodes) {
                if (content.equals(debalancedNodes.get(debalancedNodes.size() - 1))) {
                    message += content + ".";
                } else {
                    message += content + ", ";
                }
            }
            System.out.println(message);
        }
    }

    //EXAMEN 2020 2T 2P 
    //TEMA 2
    public static BinaryTree<Integer> createHeapTree(ArrayList<Integer> list) {

        BinaryTree<Integer> tree = new BinaryTree<>();
        int i = 0;
        return createHeapTree(list, i, tree);
    }

    private static BinaryTree<Integer> createHeapTree(ArrayList<Integer> list, int i, BinaryTree<Integer> tree) {
        if (i < list.size()) {
            BinaryTree<Integer> temp = new BinaryTree(list.get(i));
            tree = temp;
            if (2 * i + 1 < list.size()) {
                if (list.get(2 * i + 1) == null) {
                    tree.setLeft(null);
                } else {
                    tree.setLeft(createHeapTree(list, 2 * i + 1, tree));
                }
            }
            if (2 * i + 2 < list.size()) {
                if (list.get(2 * i + 2) == null) {
                    tree.setRight(null);
                } else {
                    tree.setRight(createHeapTree(list, 2 * i + 2, tree));
                }
            }
        }
        return tree;
    }

    //TEMA 3 
    public BinaryTree<Integer> findIntersection(BinaryTree<T> root) {
        return findIntersection(this, root);
    }

    private BinaryTree<Integer> findIntersection(BinaryTree<T> root1, BinaryTree<T> root2) {
        if (root == null) {
            return null;
        }

//        Integer sum = (Integer) (root1.getRoot().getContent()) + (Integer) (root2.getRoot().getContent());

        BinaryTree<Integer> newNode = new BinaryTree<>(3);

        if (root1.getLeft() != null && root2.getLeft() != null) {
            newNode.getRoot().setLeft(findIntersection(root1.getLeft(), root2.getLeft()));
        }
        if (root1.getRight() != null && root2.getRight() != null) {
            newNode.getRoot().setRight(findIntersection(root1.getRight(), root2.getRight()));
        }
        return newNode;
    }

    //EXAMEN FINAL 2T 2019
    //TEMA 3 
    private void maxLevel(Comparator<T> cmp , LinkedList<T> maximos, int nivel) {
        if (this.isEmpty()) {
            return;
        } else {
            if (nivel == maximos.size()) {
                maximos.addLast(this.root.getContent());
            }
            if (cmp.compare(this.root.getContent(), maximos.getLast()) == 1) {
                maximos.set(nivel, this.root.getContent());
            }
            if (this.root.getLeft() != null) {
                this.root.getLeft().maxLevel(cmp, maximos, nivel + 1);
            }
            if (this.root.getRight() != null) {
                this.root.getRight().maxLevel(cmp, maximos, nivel + 1);
            }
        }
    }

    public T maxLevel(int nivel, Comparator<T> cmp) {
        LinkedList<T> maximos = new LinkedList<>();
        this.maxLevel(cmp, maximos, 0);
        return maximos.get(nivel);
    }

    @Override
    public String toString() {
        return "BinaryTree{" + "root=" + root + '}';
    }

}

/*
    public void largestValueOfEachLevelRecursive(Comparator<T> cmp, LinkedList<T> maximos, int nivel) {
        if (this.isEmpty()) {
            return;
        } else {
            if (nivel == maximos.size()) {
                maximos.addLast(this.root.getContent());
            }
            if (cmp.compare(this.root.getContent(), maximos.getLast()) == 1) {
                maximos.set(nivel, this.root.getContent());
            }
            if (this.root.getLeft() != null) {
                this.root.getLeft().largestValueOfEachLevelRecursive(cmp, maximos, nivel + 1);
            }
            if (this.root.getRight() != null) {
                this.root.getRight().largestValueOfEachLevelRecursive(cmp, maximos, nivel + 1);
            }
        }
    }

    public void largestValueOfEachLevelRecursive(Comparator<T> cmp) {
        LinkedList<T> maximos = new LinkedList<>();
        this.largestValueOfEachLevelRecursive(cmp, maximos, 0);
        System.out.println(maximos);
    }
 */
