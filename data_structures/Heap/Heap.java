package Heap;

import java.util.Comparator;

/**
 *
 * @author davidperez
 */
public class Heap<E> {

    //atributos
    private Comparator<E> cmp;
    private E[] elements;
    private int capacity = 100;
    private int effectiveSize;
    private boolean isMax;

    //constructores
    public Heap(E[] data, Comparator<E> cmp, boolean isMax) {
        if (data.length < capacity) {
            elements = (E[]) new Object[capacity];
        } else {
            elements = (E[]) new Comparable[data.length];
            capacity = data.length;
        }
        System.arraycopy(data, 0, elements, 0, data.length);
        this.isMax = isMax;
        effectiveSize = data.length;
        this.cmp = cmp;
        if (!isMax) {
            this.cmp = cmp.reversed();
        }
    }
    
    public Heap(Comparator<E> cmp, boolean isMax) {
        elements = (E[]) (new Object[capacity]);
        effectiveSize = 0;
        this.isMax = isMax;
        this.cmp = cmp;
        if (!isMax) {
            this.cmp = cmp.reversed();
        }
    }
    
    //metodos auxiliares
    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < effectiveSize;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < effectiveSize;
    }

    private boolean hasParent(int index) {
        return getLeftChildIndex(index) >= 0;
    }

    private E getLeftChild(int index) {
        return elements[getLeftChildIndex(index)];
    }

    private E getRightChild(int index) {
        return elements[getRightChildIndex(index)];
    }

    private E getParent(int index) {
        return elements[getParentIndex(index)];
    }

    private void addCapacity() {
        if (effectiveSize == capacity) {
            E[] tmp = (E[]) new Object[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                tmp[i] = elements[i];
            }
            elements = tmp;
            capacity = capacity * 2;
        }
    }

    private void swap(int idx1, int idx2) {
        E tmp = elements[idx1];
        elements[idx1] = elements[idx2];
        elements[idx2] = tmp;
    }
    
    private void adjustDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            if (isMax) {
                int biggerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && cmp.compare(getRightChild(index), getLeftChild(index)) > 0) {
                    biggerChildIndex = getRightChildIndex(index);
                }
                if (cmp.compare(elements[index], elements[biggerChildIndex]) > 0) {
                    break;
                } else {
                    swap(index, biggerChildIndex);
                }
                index = biggerChildIndex;
            } else {
                int smallerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && cmp.compare(getRightChild(index), getLeftChild(index)) < 0) {
                    smallerChildIndex = getRightChildIndex(index);
                }
                if (cmp.compare(elements[index], elements[smallerChildIndex]) < 0) {
                    break;
                } else {
                    swap(index, smallerChildIndex);
                }
                index = smallerChildIndex;
            }
        }
    }   
    
    private void adjustUp() {
        int index = effectiveSize - 1;
        if (isMax) {
            while (hasParent(index) && cmp.compare(getParent(index), elements[index]) > 0) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        } else {
            while (hasParent(index) && cmp.compare(getParent(index), elements[index]) < 0) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }
    }
    
    //metodos de heap
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    public boolean isFull() {
        return effectiveSize == capacity;
    }

    public int getSize() {
        return effectiveSize;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[0];
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E root = elements[0];
        swap(0, effectiveSize - 1);
        effectiveSize--;
        adjustDown();
        return root;
    }

    public void offer(E element) {
        addCapacity();
        elements[effectiveSize] = element;
        effectiveSize++;
        adjustUp();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < effectiveSize; i++) {
            sb.append(elements[i]);
            if (i != effectiveSize - 1) {
                sb.append(",");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

}
