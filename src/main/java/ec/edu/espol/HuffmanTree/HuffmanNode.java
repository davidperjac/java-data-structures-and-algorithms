package ec.edu.espol.HuffmanTree;

/**
 *
 * @author davidperez
 */
public class HuffmanNode<T> {

    private T content;
    private HuffmanTree<T> left;
    private HuffmanTree<T> right;

    public HuffmanNode() {
        this(null, null, null);
    }

    public HuffmanNode(T content) {
        this(content, null, null);
    }

    public HuffmanNode(T content, HuffmanTree<T> left, HuffmanTree<T> right) {
        this.content = content;
        this.left = left;
        this.right = right;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public HuffmanTree<T> getLeft() {
        return left;
    }

    public void setLeft(HuffmanTree<T> left) {
        this.left = left;
    }

    public HuffmanTree<T> getRight() {
        return right;
    }

    public void setRight(HuffmanTree<T> right) {
        this.right = right;
    }

    //tostring
    @Override
    public String toString() {
        return "HuffmanNode [ " + "content=" + content + " ]";
    }
}
