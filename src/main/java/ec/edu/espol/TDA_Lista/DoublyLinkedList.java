
package ec.edu.espol.TDA_Lista;

import ec.edu.espol.TDA_Lista.List;

import java.util.Iterator;


public class DoublyLinkedList<E> implements List<E>{
    
    private DoublyNodeList<E> header;
    private DoublyNodeList<E> last;    

    public DoublyLinkedList() {
        this.header = null;
        this.last = null;
    }
    
    public DoublyNodeList<E> getHeader() {
        return header;
    }

    public void setHeader(DoublyNodeList<E> header) {
        this.header = header;
    }

    public DoublyNodeList<E> getLast() {
        return last;
    }

    public void setLast(DoublyNodeList<E> last) {
        this.last = last;
    }
    
    
    private void recorrerHaciaAtras () {        
        DoublyNodeList<E> n;
        for (n = last; n != header; n = n.getPrevious()) {
        
        }
    }
    

    @Override
    public boolean addFirst(E e) {
        if (e != null) {
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            newNode.setNext(header);
            header.setPrevious(newNode);
            this.setHeader(newNode);
            return true;
        }
        return false;
    }

    @Override
    public boolean addLast(E e) {
        if (e != null) {
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            newNode.setPrevious(last);
            last.setNext(newNode);
            this.setLast(newNode);
            return true;
        }
        return false;
    }
    
    public E removeElement (int pos) {
        DoublyNodeList<E> p = header; 

        for (int i=0; i<pos; i++) {
            p = p.getNext();
        }
        
        p.setNext(p.getPrevious());
        
        
        return p.getContent();
        
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
