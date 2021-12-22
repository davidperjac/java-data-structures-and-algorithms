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

        //HEAPS
        //HEAPMIN
        Integer[] heapArrayMin = {10, 15, 20, 17, 25};

        Heap<Integer> heapMin = new Heap<>(heapArrayMin, cmp1, false);

        //heapMin.offer(4);
        //heapMin.poll();
        System.out.println(heapMin);
        //HEAPMAX
        Integer[] heapArrayMax = {100, 40, 65, 36, 25, 50};
        Heap<Integer> heapMax = new Heap<>(heapArrayMax, cmp1, true);

        //heapMax.offer(90);
        //heapMax.poll();
        System.out.println(heapMax);
    }

}
