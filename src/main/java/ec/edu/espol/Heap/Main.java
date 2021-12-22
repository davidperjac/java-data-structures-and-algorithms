package ec.edu.espol.Heap;

import java.util.Comparator;

/**
 *
 * @author davidperez
 */
public class Main {

    public static void main(String[] args) {
        //TEST
        
        //COMPARATOR DE INTEGERS
        Comparator<Integer> cmp1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        };
        
        //HEAP
        Integer[] unsortedArrayMin = {10,15,20,17,25};
        Integer[] unsortedArrayMax = {200,150,180,90,70,100,91,30,40};

        Heap<Integer> heap = new Heap<>(unsortedArrayMax,cmp1,true);
        
        //heap.offer(4);
        heap.poll();
        System.out.println(heap);
    }

}
