package BalancedTree;

/**
 *
 * @author davidperez
 */
public class BalancedTreeNode<E,K> {
    private E content;
    private K key;
    private int height;
    private BalancedTree<E,K> left;
    private BalancedTree<E,K> right;

    public BalancedTreeNode(E content, K key, BalancedTree<E, K> left, BalancedTree<E, K> right) {
        this.content = content;
        this.height = 1;
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public BalancedTreeNode(E content, K key) {
        this.height = 1;
        this.content = content;
        this.key = key;
    }
    
    public BalancedTreeNode() {
        this(null,null,null,null);
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public BalancedTree<E, K> getLeft() {
        return left;
    }

    public void setLeft(BalancedTree<E, K> left) {
        this.left = left;
    }

    public BalancedTree<E, K> getRight() {
        return right;
    }

    public void setRight(BalancedTree<E, K> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BalancedTreeNode {" + "content = " + content + ", key = " + key + ", left = " + left + ", right = " + right + '}';
    }
    
    
    
    
    
    
           
            
}
