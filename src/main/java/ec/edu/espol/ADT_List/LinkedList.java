package ec.edu.espol.ADT_List;

import ec.edu.espol.ADT_List.List;

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

    public void setLast(NodeList<E> last) {
        this.last = last;
    }

    @Override
    public boolean addFirst(E e) {
        if (e != null) {
            NodeList<E> newNode = new NodeList<>(e);

            if (isEmpty()) {
                this.setHeader(newNode);
                this.setLast(newNode);
                return true;
            }

            newNode.setNext(header);
            this.setHeader(newNode);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addLast(E e) {
        if (e != null) {
            NodeList<E> newNode = new NodeList<>(e);

            if (isEmpty()) {
                this.setHeader(newNode);
                this.setLast(newNode);
                return true;
            }

            this.last.setNext(newNode);
            this.setLast(newNode);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E getFirst() {
        return header.getContent();
    }

    @Override
    public E getLast() {
        return last.getContent();
    }

    @Override
    public int indexOf(E e) {
        int index = 0;

        for (NodeList<E> n = header; n != null; n = n.getNext()) {
            if (n.equals(e)) {
                return index;
            }
            index++;
        }

        return -1;
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
    public boolean removeLast() {
        if (isEmpty()) {
            return false;
        } else {
            for (NodeList<E> n = header; n != null; n = n.getNext()) {
                if (n.getNext().equals(last)) {
                    n.setNext(null);
                    this.setLast(n);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()) {
            return false;
        } else {
            NodeList<E> newFirst = header.getNext();
            this.header.setNext(null);
            this.setHeader(newFirst);
            return true;
        }
    }

    @Override
    public boolean insert(int index, E e) {
        if (e == null) {
            return false;
        }
        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }

        int contador = 0;
        for (NodeList<E> n = header; n != null; n = n.getNext()) {
            if (index == contador) {

            }
            contador++;
        }
        return false;
    }

    @Override
    public boolean set(int index, E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        return header == null && last == null;
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        String s = "[";
        for (NodeList<E> n = header; n != null; n = n.getNext()) {
            s += n.getContent();
            if (n != last) {
                s += ",";
            }
        }
        s += "]";
        return s;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
