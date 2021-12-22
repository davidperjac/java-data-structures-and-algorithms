package ec.edu.espol.ADT_List;

import ec.edu.espol.ADT_List.List;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private E[] elements = null;
    private int capacity = 100;
    private int effectiveSize;

    public ArrayList() {
        // elements = new E[100]; NO FUNCIONA
        elements = (E[])(new Object[capacity]); // ESTO SÍ FUNCIONA
        effectiveSize = 0;
    }

    @Override
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        } else if (isEmpty()) {
            // elements[0] = e; effectiveSize++;
            elements[effectiveSize++] = e;
            return true;
        } else if (isFull()) {
            addCapacity();
        }
        // bit shifting
        // (desplazamiento de valores hacia la derecha)
        // debe empezar de atrás hacia adelante
        for (int i = effectiveSize - 1; i >= 0; i--) {
            elements[i+1] = elements[i];
        }
        elements[0] = e;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        } else if (isFull()) {
            addCapacity();
            return true;
        }
        elements[effectiveSize++] = e;
        return true;
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
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    private boolean isFull() {
        return effectiveSize == capacity;
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
                E e = elements[cursor] ;
                cursor++;
                return e;
            }  
        };
    return it;
    }

}

/*
//1

public List<E> insertarOrdenado(List<E> lista , Comparator<E> cmp  )  {  List<E> resultado = new LinkedList<E>();  if (this.getHeader() == null) {     this =   }else {     for (E nodo1 : this) {       for (E nodo2 : lista){         if (cmp.compare(nodo1,nodo2) == -1) {           resultado.addLast(nodo1);         }       }      }  }  return resultado;}

//2

public boolean removerElementos (ArrayList<Integer> indices) {  List<E> resultado = new ArrayList<E>();  for (int i = 0 ; i < this.size() ; i++)   {    if (indices.get(i) <= this.size() )  {      if (i != indices.get(i) ){        resultado.addFirst(this.elements[i]);      }          }else {      return false;    }      }  return true;}

//3

public static List<E> sumarNumerosGrandes (ArrayList<Integer> lista1, ArrayList<Integer> lista2) {  String numero1;  String numero2;    //conversion  for (int i = lista1.size() - 1; i == 0 ; i -- ) {    numero1 += lista1[i];  }  for (int i = lista2.size() - 1; i == 0 ; i -- ) {    numero2 += lista2[i];  }    int num1 = Integer.parseInt(numero1);  int num2 = Integer.parseInt(numero2);  //operacion   int suma = num1 + num2;  String sumaString = suma +"";  //retorno de lista  ArrayList<Integer> resultado = new ArrayList<Integer>();     for (int i = 0; i < sumaString.length() ; i++) {      resultado.addLast(sumaString.charAt(i));    }    return resultado;} 
*/