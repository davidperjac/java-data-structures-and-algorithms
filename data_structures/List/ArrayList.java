package List;

import List.List;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private E[] elements = null;
    private int capacity = 100;
    private int effectiveSize;
    
    public ArrayList() {
        // elements = new E[100]; NO FUNCIONA
        elements = (E[]) (new Object[capacity]); // ESTO SÍ FUNCIONA
        effectiveSize = 0;
    }

    @Override
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        } else if (isEmpty()) {
            elements[effectiveSize++] = e;
            return true;
        } else if (isFull()) {
            addCapacity();
        }
        // bit shifting
        // (desplazamiento de valores hacia la derecha)
        // debe empezar de atrás hacia adelante
        for (int i = effectiveSize - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
        }
        elements[0] = e;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        }

        // la lista estaba vacia
        if (effectiveSize == 0) {
            elements[0] = e;
            effectiveSize = 1;
            return true;
        }

        // si el arreglo ya está lleno o a capacidad
        if (effectiveSize == effectiveSize) {
            addCapacity();
        }

        // la insercion no debe desplazar elementos
        elements[effectiveSize] = e;
        effectiveSize++;
        return true;
    }

    @Override
    public E getFirst() {
        return elements[0];
    }

    @Override
    public E getLast() {
        return elements[effectiveSize - 1];
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < effectiveSize; i++) {
            if (e.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean removeLast() {
        if (isEmpty()) {
            return false;
        } else {
            elements[effectiveSize - 1] = null;
            effectiveSize--;
            return true;
        }
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()) {
            return false;
        } else {
            elements[0] = null;
            for (int i = 1; i < effectiveSize; i++) {
                elements[i - 1] = elements[i];
            }
            effectiveSize--;
            return true;
        }
    }

    @Override
    public boolean insert(int index, E e) {
        if (e == null) {
            return false;
        }

        if (index > capacity) {
            throw new IndexOutOfBoundsException("Fuera de rango");
        } else {

            for (int i = effectiveSize; i >= index; i--) {
                elements[i + 1] = elements[i];
            }

            elements[index] = e;
            effectiveSize++;

            return true;
        }
    }

    @Override
    public boolean set(int index, E e) {
        if (e == null) {
            return false;
        }

        if (index > capacity) {
            throw new IndexOutOfBoundsException("Fuera de rango");
        } else {
            elements[index] = e;
            return true;
        }

    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public E get(int index) {
        if (index > capacity) {
            throw new IndexOutOfBoundsException("Fuera de rango");
        } else {
            return elements[index];
        }
    }

    @Override
    public boolean contains(E e) {
        if (e == null) {
            return false;
        } else {
            for (int i = 0; i < effectiveSize; i++) {
                if (e.equals(elements[i])) {
                    return true;
                }
            }
            return false;
        }

    }

    @Override
    public boolean remove(int index) {

        if (index > capacity) {
            throw new IndexOutOfBoundsException("Fuera de rango");
        } else {

            elements[index] = null;

            for (int i = index + 1; i < effectiveSize; i++) {
                elements[i - 1] = elements[i];
            }

            effectiveSize--;

            return true;
        }
    }

    private boolean isFull() {
        return effectiveSize == capacity;
    }

    private void addCapacity() {
        E[] tmp = (E[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            tmp[i] = elements[i];
        }
        elements = tmp;
        capacity = capacity * 2;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < effectiveSize; i++) {
            s += elements[i];
            if (i != effectiveSize - 1) {
                s += ",";
            }
        }
        s += "]";
        return s;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < effectiveSize;
            }

            @Override
            public E next() {
                E e = elements[cursor];
                cursor++;
                return e;
            }
        };
        return it;
    }

}
