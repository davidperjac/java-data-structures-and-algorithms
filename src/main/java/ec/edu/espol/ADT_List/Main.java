package ec.edu.espol.ADT_List;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // PRACTICA EXAMEN

        // 2019 - 1T -1P
        // TEMA 4
        //        
        //        Duo<Integer> duo = new Duo();
        //        
        //        duo.addTo(23,1);
        //        duo.addTo(45,1);
        //        
        //        duo.addTo(56,2);
        //        duo.addTo(56,2);
        //        
        //        System.out.println(duo.c1);
        //        System.out.println(duo.c2);
        //        
        //        System.out.println("----------------------------");
        //        
        //        duo.addTo(23,2);
        //        duo.addTo(45,2);
        //        
        //        System.out.println(duo.c1);
        //        System.out.println(duo.c2);
        //        
        //        System.out.println("----------------------------");
        //        
        //        List<Integer> duplicados = duo.getDuplicates();
        //        
        //        System.out.println(duplicados);
        //        
        //        
        //        System.out.println("----------------------------");
        //        
        //        duo.deleteFrom(56, 2);
        //        duo.deleteFrom(23, 1);
        //        
        //        System.out.println(duo.c1);
        //        System.out.println(duo.c2);
        // EXAMEN 1P
        //4
        /*
    public Map<LinkedList<T>, Integer numUnicos> contarDistintosEnSubListas(int k) {

        HashMap<LinkedList<T>, Integer numUnicos> salida = new HashMap<>();

        NodeList<T> puntero = this.header;

        while (puntero != null) {
            int vecesUnicos = 0;
            LinkedList<T> subLista = new LinkedList<>();
            Set<T> unicos = new Set<>();
            for (int i = 0; i < k; i++) {
                subLista.addLast(puntero);
                puntero = puntero.next;
                if (unicos.add()) {
                    vecesUnicos++;
                }
            }
            puntero = this.header.next;
            salida.put(subLista, vecesUnicos);
        }
        return salida;
    }

    //5
    public void empujar(int n) {
        //aqui recordaremos elementos que sacaremos
        Stack<T> buffer = new Stack<>();
        //pila final de salida
        Stack<T> salida = new Stack<>();
        //empuje de elementos al buffer
        int empuje = 0;
        while (empuje != n || !this.isEmpty()) {
            buffer.push(this.pop());
            empuje += 1;
        }
        // llevamos elementos a la pila de salida, que faltaron en 
        // el this, con esto ya tenemos la parte de abajo completa
        while (!this.isEmpty()) {
            salida.push(this.pop());
        }
        Stack<T> bufferOrdenado = new Stack<>();
        //le damos la vuelta al buffer para que esten en el orden correcto
        while (!buffer.isEmpty()) {
            bufferOrdenado.push(buffer.pop());
        }
        //agregamos los elementos empujados a la salida
        while (!bufferOrdenado.isEmpty())   {
            salida.push(bufferOrdenado.pop());
        }
        //reemplazamos la salida en el this
        while (!salida.isEmpty()) {
            this.push(salida.pop())
        }
    }

    //6
    //7
    //en este ejercicio inicializamos con linkedlist
    //asumimos que los tipos de datos que implementen la cola tienen un orden natural
    //las colas de prioridad son colas, no es otro TDA 
    //igualmente el ejercicio no prohibe usar otros TDA
    //no prohibe utilizar colas de prioridad , ademas estas usan 
    //las mismas funciones de las colas sin prioridad
    public void eliminarEnesimoMasGrande(int n) {
        //cambiamos la pila por una de prioridad descendente
        PriorityQueue<T> ordenados = new PriorityQueue<>( { (s1, s2) ->{
            return s2.compareTo(s1);
            }
        });
        while (!this.isEmpty()) {
            ordenados.offer(this.poll());
        }
        //sacamos los elementos mayores,en este caso los mas prioritarios
        //y los recordamos
        Queue<T> mayores = new LinkedList<>();
        int eliminaciones = 0;
        while (n != eliminaciones) {
            T ultimo = ordenados.poll();
            mayores.offer(ultimo);
            //se asegura de borrar elementos repetidos
            while (ordenados.peek().equals(ultimo)) {
                ordenados.poll();
            }
            eliminaciones += 1;
        }
        //regresamos n - 1 elementos de la pila
        for (int i = 0; i < n - 1; i++) {
            ordenados.offer(mayores.poll());
        }
        //regresamos los elementos al this 
        while (!ordenados.isEmpty()) {
            this.offer(ordenados.poll());
        }
        //el ejercicio no indica que no se pueda modificar el this
    }

    //8
         */
    }
}
