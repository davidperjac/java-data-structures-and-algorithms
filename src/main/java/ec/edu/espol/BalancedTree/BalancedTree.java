package ec.edu.espol.BalancedTree;

import java.util.Comparator;
import java.util.Stack;

/**
 *
 * @author davidperez
 */
public class BalancedTree<E, K> {

    private BalancedTreeNode<E, K> root;
    private Comparator<K> cmp;

    public BalancedTree() {
        this.root = new BalancedTreeNode<E, K>();
    }

    public BalancedTree(BalancedTreeNode<E, K> root, Comparator<K> cmp) {
        this.root = root;
        this.cmp = cmp;
    }

    public BalancedTree(E content, K key) {
        this.root = new BalancedTreeNode<>(content, key);
    }

    public BalancedTreeNode<E, K> getRoot() {
        return root;
    }

    public void setRoot(BalancedTreeNode<E, K> root) {
        this.root = root;
    }

    public void setLeft(BalancedTree<E, K> tree) {
        this.root.setLeft(tree);
    }

    public void setRight(BalancedTree<E, K> tree) {
        this.root.setRight(tree);
    }

    public BalancedTree<E, K> getLeft() {
        return this.root.getLeft();
    }

    public BalancedTree<E, K> getRight() {
        return this.root.getRight();
    }

    public Comparator<K> getCmp() {
        return cmp;
    }

    public void setCmp(Comparator<K> cmp) {
        this.cmp = cmp;
    }

    /* *METODOS AUXILIARES QUE NO SON PARTE DE LA SOLUCION* */
    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isLeaf() {
        return this.root.getLeft() == null && this.root.getRight() == null;
    }

    public int getHeight() {
        return countLevelsRecursive() - 1;
    }

    private int countLevelsRecursive() {
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

    private BalancedTree<E, K> rotate() {
        int balanceFactor = getBalancedFactor();
        int balanceLeft = getLeft().getBalancedFactor();
        int balanceRight = getRight().getBalancedFactor();
        //rompe el balance del arbol
        if (balanceFactor > 1) {
            //si al arbol le faltan nodos a la derecha
            if (balanceLeft < 0) {
                //reemplazamos el izquierdo por uno nuevo
                setLeft(getLeft().leftRotation());
            } else {
                return rightRotation();
            }
        } else if (balanceFactor < -1) {
            //si al arbol le faltan nodos a la izquierda
            if (balanceRight > 0) {
                //reemplazamos el izquierdo por uno nuevo
                setRight(getRight().rightRotation());
            } else {
                return leftRotation();
            }
        }
        return null;
    }

    private BalancedTree<E, K> leftRotation() {
        //n es el this , n1 el derecho
        BalancedTree<E, K> n1 = getRight();
        setRight(n1.getLeft());
        n1.setLeft(this);
        updateHeight();
        n1.updateHeight();
        return n1;
    }

    private BalancedTree<E, K> rightRotation() {
        //n es el this, n1 el izquierdo
        BalancedTree<E, K> n1 = getLeft();
        setLeft(n1.getRight());
        n1.setRight(this);
        updateHeight();
        n1.updateHeight();
        return n1;
    }

    private void updateHeight() {
        final int leftHeight = getLeft().getHeight();
        final int rightHeight = getRight().getHeight();
        root.setHeight(Math.max(leftHeight, rightHeight) + 1);
    }

    private int getBalancedFactor() {
        if (isLeaf()) {
            return 0;
        } else if (!isLeaf()) {
            return getLeft().getHeight() - getRight().getHeight();
        } else if (getLeft() != null) {
            return getLeft().getHeight();
        } else {
            return -getRight().getHeight();
        }
    }

    /* *METODOS DEL TALLER* */
    //1
    public void insert(E content, K key) {
        Stack<BalancedTree<E, K>> stack = new Stack();
        if (isEmpty()) {
            root = new BalancedTreeNode<E, K>(content, key);
            return;
        } else {
            stack.push(this);
            while (!stack.empty()) {
                BalancedTree<E, K> subtree = stack.pop();

                if (cmp.compare(subtree.getRoot().getKey(), key) > 0) {
                    if (subtree.root.getLeft() != null) {
                        stack.push(subtree.root.getLeft());
                    }
                } else {
                    if (subtree.root.getRight() != null) {
                        stack.push(subtree.root.getRight());
                    }
                }
            }
            Stack<BalancedTree<E, K>> stackBalanced = new Stack();
            stackBalanced.push(this);
            while (!stackBalanced.empty()) {
                BalancedTree<E, K> subtree = stack.pop();

                if (subtree.getBalancedFactor() != 1 && subtree.getBalancedFactor() != -1 && subtree.getBalancedFactor() != 0) {
                    rotate();
                    updateHeight();
                }

                if (subtree.root.getLeft() != null) {
                    stackBalanced.push(subtree.root.getLeft());
                }

                if (subtree.root.getRight() != null) {
                    stackBalanced.push(subtree.root.getRight());
                }

            }

        }
    }

    //2
    public BalancedTreeNode<E, K> search(K key, Comparator<K> cmp) {
        if (isEmpty()) {
            return null;
        }
        if (cmp.compare(key, this.root.getKey()) == 0) {
            return root;
        }
        if (cmp.compare(key, this.root.getKey()) > 0) {
            return getLeft().search(key, cmp);
        } else {
            return getRight().search(key, cmp);
        }
    }
    
    //3
    public void print() {
        if (!this.isEmpty()) {
            System.out.println(this.root.getContent());

            if (root.getLeft() != null) {
                root.getLeft().print();
            }

            if (root.getRight() != null) {
                root.getRight().print();
            }

        }
    }

    @Override
    public String toString() {
        return "BalancedTree [" + "root = " + root + ", cmp = " + cmp + ']';
    }

}
