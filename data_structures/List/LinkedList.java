package List;

import List.List;
import java.util.HashMap;

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
            if (n.getContent().equals(e)) {
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
            if (this.size() == 1) {
                this.header = null;
            }
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

            if (this.size() == 1) {
                this.last = null;
            }

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
            if (index == contador + 1) {
                NodeList<E> previousNext = n.getNext();
                NodeList<E> newNode = new NodeList(e);
                n.setNext(newNode);
                newNode.setNext(previousNext);
                return true;
            }
            contador++;
        }
        return false;
    }

    @Override
    public boolean set(int index, E e) {
        if (e == null) {
            return false;
        }
        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }

        int contador = 0;
        for (NodeList<E> n = header; n != null; n = n.getNext()) {
            if (index == contador + 1) {
                NodeList<E> previousNext = n.getNext().getNext();
                NodeList<E> newNode = new NodeList(e);
                n.setNext(newNode);
                newNode.setNext(previousNext);
                return true;
            }
            contador++;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return header == null && last == null;
    }

    @Override
    public E get(int index) {
        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }

        int contador = 0;
        for (NodeList<E> n = header; n != null; n = n.getNext()) {
            if (index == contador) {
                return n.getContent();
            }
            contador++;
        }
        return null;
    }

    @Override
    public boolean contains(E e) {
        for (NodeList<E> n = header; n != null; n = n.getNext()) {
            if (n.getContent().equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }

        int contador = 0;
        for (NodeList<E> n = header; n != null; n = n.getNext()) {
            if (index == contador + 1) {
                NodeList<E> previousNext = n.getNext().getNext();
                n.setNext(previousNext);
                return true;
            }
            contador++;
        }
        return false;
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
        Iterator<E> it = new Iterator<E>() {
            NodeList<E> cursor = header;

            @Override
            public boolean hasNext() {
                return cursor.getNext() != null;
            }

            @Override
            public E next() {
                NodeList<E> previousCursor = cursor;
                cursor = cursor.getNext();
                return previousCursor.getContent();
            }
        };
        return it;
    }

    /*EXAMEN*/
    public Iterator<E> getReverseIterator() {

        NodeList<E> prev = null;
        NodeList<E> current = header;
        NodeList<E> next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        
        NodeList<E> reverseHeader = current;

        Iterator<E> it = new Iterator<E>() {
            NodeList<E> cursor = reverseHeader;
            @Override
            public boolean hasNext() {
                return cursor.getNext() != null;
            }

            @Override
            public E next() {
                NodeList<E> previousCursor = cursor;
                cursor = cursor.getNext();
                return previousCursor.getContent();
            }
        };

        return it;
    }

    public HashMap<LinkedList<E>, Integer> contarDistintosEnSubListas(int k) {

        HashMap<LinkedList<E>, Integer> mapaSubListas = new HashMap<>();

        NodeList<E> punteroSubLista = this.header;
        NodeList<E> puntero = this.header;
        int subListas = 0;

        while (subListas != this.size() - k + 1) {
            LinkedList<E> sublista = new LinkedList();
            for (int i = 0; i < k; i++) {
                sublista.addLast(puntero.getContent());
                puntero = puntero.getNext();
            }
            mapaSubListas.put(sublista, contarUnicos(sublista));
            subListas++;

            punteroSubLista = punteroSubLista.getNext();
            puntero = punteroSubLista;
        }
        return mapaSubListas;
    }

    private int contarUnicos(LinkedList<E> lista) {
        ArrayList<E> listaUnicos = new ArrayList<E>();
        for (NodeList<E> n = lista.getHeader(); n != null; n = n.getNext()) {
            if (!listaUnicos.contains(n.getContent())) {
                listaUnicos.addFirst(n.getContent());
            }
        }
        return listaUnicos.size();
    }
}
