package List;


class NodeList<T>{
    private T content;
    private NodeList<T> next;

    public NodeList(T content) {
        this.content = content;
        this.next = null;
    }    

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public NodeList<T> getNext() {
        return next;
    }

    public void setNext(NodeList<T> next) {
        this.next = next;
    }


    
}
