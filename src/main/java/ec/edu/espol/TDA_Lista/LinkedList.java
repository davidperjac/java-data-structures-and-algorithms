package ec.edu.espol.TDA_Lista;

import ec.edu.espol.TDA_Lista.List;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {

    private NodeList<E> header;
    private NodeList<E> last;

    public LinkedList() {
        this.header = null;
        this.last = null;
    }

    public NodeList<E> getHeader() {
        return header;
    }

    public void setHeader(NodeList<E> header) {
        this.header = header;
    }

    public NodeList<E> getLast() {
        return last;
    }

    public void setLast(NodeList<E> last) {
        this.last = last;
    }

    public List<E> findIntersection(List<E> other) {
        Iterator<E> iterator = this.iterator();
        List<E> intersection = new LinkedList<E>();

        while (iterator.hasNext()) {
            E next = iterator.next();
            Iterator<E> iteratorOther = other.iterator();
            while (iteratorOther.hasNext()) {
                E nextO = iteratorOther.next();
                if (next.equals(nextO)) {
                    intersection.addFirst(next);
                }
            }
        }
        return intersection;
    }

    @Override
    public boolean addFirst(E e) {
        if (e != null) {
            NodeList<E> newNode = new NodeList<>(e);
            newNode.setNext(header);
            this.setHeader(newNode);
            return true;
        } else {
            return false;
        }
    }

    private void recorrerHaciaAtras() {
        NodeList<E> n;
        for (n = last; n != header; n = this.getPrevious(n)) {

        }
    }

    NodeList<E> getPrevious(NodeList<E> node) {
        NodeList<E> previous = null;
        NodeList<E> n;
        for (n = header; n != node; n = n.getNext()) {
            previous = n;
        }
        return previous;
    }

    @Override
    public boolean addLast(E e) {
        if (e != null) {
            NodeList<E> newNode = new NodeList<>(e);
            if (header == null) {
                this.setHeader(newNode);
                return true;
            }
            if (last == null) {
                this.setLast(newNode);
                this.header.setNext(last);
            }
            
            this.last.setNext(newNode);
            newNode.setNext(null);
            this.setLast(newNode);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public int size() {
        // return size; // O(1)

        // O(n)
        int size = 0;
        NodeList<E> n;
        for (n = header; n != null; n = n.getNext()) {
            size++;
        }
        return size;

    }

    @Override
    public boolean isEmpty() {
        return header == null && last == null;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String s = "[";
        for (NodeList<E> n = header; n != null; n = n.getNext()) {
            s += n.getContent();
            if (n != last) {
                 s+= ",";
            }
        }
        s+="]";
        return s;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            NodeList<E> cursor = header;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                E content = header.getContent();
                cursor = cursor.getNext();
                
                return content;
            }
        };
        return it;
    }
}