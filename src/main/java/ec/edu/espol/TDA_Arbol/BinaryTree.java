package tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> {

    private BinaryNode<T> root;

    public BinaryTree() {
        this.root = new BinaryNode<>();
    }

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    public BinaryTree(T content) {
        this.root = new BinaryNode<>(content);
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }

    public void setLeft(BinaryTree<T> tree) {
        this.root.setLeft(tree);
    }

    public void setRight(BinaryTree<T> tree) {
        this.root.setRight(tree);
    }

    public BinaryTree<T> getLeft() {
        return this.root.getLeft();
    }

    public BinaryTree<T> getRight() {
        return this.root.getRight();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isLeaf() {
        return this.root.getLeft() == null && this.root.getRight() == null;
    }

    /**
     * * FUNCIONES EXTRAS.
     */
    public void recorrerPreOrden() {
        if (!this.isEmpty()) {
            System.out.println(this.root.getContent());

            if (root.getLeft() != null) {
                root.getLeft().recorrerPreOrden();
            }

            if (root.getRight() != null) {
                root.getRight().recorrerPreOrden();
            }

        }
    }

    public void recorrerPostOrden() {
        if (!this.isEmpty()) {

            if (root.getLeft() != null) {
                root.getLeft().recorrerPreOrden();
            }

            if (root.getRight() != null) {
                root.getRight().recorrerPreOrden();
            }

            System.out.println(this.root.getContent());
        }
    }

    public void recorrerEnOrden() {
        if (!this.isEmpty()) {
            if (root.getLeft() != null) {
                root.getLeft().recorrerPreOrden();
            }

            System.out.println(this.root.getContent());

            if (root.getRight() != null) {
                root.getRight().recorrerPreOrden();
            }

        }
    }

    public boolean hasOnlyChild() {
        if (this.root.getLeft() == null && this.root.getRight() != null
                || this.root.getRight() == null && this.root.getLeft() != null) {
            return true;
        }
        return false;
    }

    public int height() {
        if (this.isEmpty()) {
            return 0;
        }
        return 1 + Math.max(this.getLeft().height(), this.getLeft().height());
    }

    /**
     * * FUNCIONES DE TALLER YA IMPLEMENTADOS.
     */
    public int countLeavesRecursive() {
        if (this.isEmpty()) {
            return 0;
        } else if (this.isLeaf()) {
            return 1;
        } else {
            int leavesLeft = 0;
            int leavesRight = 0;
            if (this.root.getLeft() != null) {
                leavesLeft = this.root.getLeft().countLeavesRecursive();
            }
            if (this.root.getRight() != null) {
                leavesRight = this.root.getRight().countLeavesRecursive();
            }
            return leavesLeft + leavesRight;
        }
    }

    public int countLeavesIterative() {
        Stack<BinaryTree<T>> stack = new Stack();
        int count = 0;
        if (this.isEmpty()) {
            return count;
        } else {
            stack.push(this);
            while (!stack.empty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }
                if (subtree.isLeaf()) {
                    count++;
                }
            }
        }
        return count;
    }

    public BinaryNode<T> recursiveSearch(T content, Comparator<T> cmp) {
        if (this.isEmpty()) {
            return null;
        } else {
            if (cmp.compare(this.root.getContent(), content) == 0) {
                return this.root;
            } else {
                BinaryNode<T> tmp = null;
                if (this.root.getLeft() != null) {
                    tmp = this.root.getLeft().recursiveSearch(content, cmp);
                }
                if (tmp == null) {
                    if (this.root.getRight() != null) {
                        return this.root.getRight().recursiveSearch(content, cmp);
                    }
                }
                return tmp;
            }
        }
    }

    /**
     * * FUNCIONES DE TALLER A IMPLEMENTAR.
     */
    public BinaryNode<T> iterativeSearch(T content, Comparator<T> cmp) {
        Stack<BinaryTree<T>> stack = new Stack();
        if (this.isEmpty()) {
            return null;
        } else {
            stack.push(this);
            while (!stack.empty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }

                if (cmp.compare(subtree.getRoot().getContent(), content) == 0) {
                    return subtree.getRoot();
                }
            }
        }
        return null;
    }

    public BinaryNode<T> getMinRecursive(Comparator<T> cmp) {
        if (this.isEmpty()) {
            return null;
        } else {
            BinaryNode<T> minimo = this.root;
            BinaryNode<T> minimoLeft = null;
            BinaryNode<T> minimoRight = null;

            if (this.root.getLeft() != null) {
                minimoLeft = this.getLeft().getMinRecursive(cmp);
                if (cmp.compare(minimoLeft.getContent(), minimo.getContent()) == -1) {
                    minimo = minimoLeft;
                }
            }
            if (this.root.getRight() != null) {
                minimoRight = this.getRight().getMinRecursive(cmp);
                if (cmp.compare(minimoRight.getContent(), minimo.getContent()) == -1) {
                    minimo = minimoRight;
                }
            }
            return minimo;
        }
    }

    public BinaryNode<T> getMinIterative(Comparator<T> cmp) {
        Stack<BinaryTree<T>> stack = new Stack();
        T minimo = null;
        BinaryNode<T> nodoMinimo = null;
        if (this.isEmpty()) {
            return null;
        } else {
            stack.push(this);
            while (!stack.empty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }

                if (minimo == null) {
                    minimo = subtree.getRoot().getContent();
                    nodoMinimo = subtree.getRoot();
                }

                if (cmp.compare(subtree.getRoot().getContent(), minimo) == -1) {
                    minimo = subtree.getRoot().getContent();
                    nodoMinimo = subtree.getRoot();
                }

            }
        }
        return nodoMinimo;
    }

    public int countDescendantsRecursive() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int descendantsLeft = 0;
            int descendantsRight = 0;

            if (this.root.getLeft() != null) {
                descendantsLeft = this.root.getLeft().countDescendantsRecursive() + 1;
            }
            if (this.root.getRight() != null) {
                descendantsRight = this.root.getRight().countDescendantsRecursive() + 1;
            }
            return descendantsLeft + descendantsRight;
        }
    }

    public int countDescendantsIterative() {
        Stack<BinaryTree<T>> stack = new Stack();
        int count = 0;
        int iteraciones = 0;
        if (this.isEmpty()) {
            return 0;
        } else {
            stack.push(this);
            while (!stack.isEmpty()) {
                BinaryTree<T> subtree = stack.pop();
                iteraciones++;
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }
                if (subtree.root != null) {
                    count++;
                }
            }
        }
        if (iteraciones == 1) {
            return 0;
        }
        return count - 1;
    }

    /**
     * * FUNCIONES DE TAREA.
     */
    //findParentRecursive
    public BinaryNode<T> findParentRecursive(BinaryNode<T> n, Comparator<T> cmp) {
        //recorre recursivamente cada nodo hasta encontrar uno que tenga el mismo contenido 
        //que el pasado por parametros, si lo encuentra devuelve su padre
        if (this.isEmpty() || cmp.compare(n.getContent(), this.root.getContent()) != 0) {
            return null;
        } else {
            //
            if (this.root.getLeft() != null && cmp.compare(this.root.getLeft().root.getContent(), n.getContent()) != 0) {
                return this.root;
            }

            if (this.root.getRight() != null && cmp.compare(this.root.getRight().root.getContent(), n.getContent()) != 0) {
                return this.root;
            }

            BinaryNode<T> tmp = null;
            if (this.root.getLeft() != null) {
                tmp = this.root.getLeft().findParentRecursive(n, cmp);
            }
            if (tmp == null) {
                if (this.root.getRight() != null) {
                    return this.root.getRight().findParentRecursive(n, cmp);
                }
            }
            return tmp;
        }
    }

    public BinaryNode<T> findParentIterative(BinaryNode<T> n, Comparator<T> cmp) {
        //recorre iterativamente cada arbol  , recuerda todos los padres guardados en una pila
        //cuando encuentra un nodo que tenga el mismo contenido hace pop del ultimo padre guardado de la pila
        //no recuerda a hojas, porque estas no son padre de nadie.
        //es importante agregar a la pila primero el hijo derecho, asi el primero en salir es el izquierdo
        //y recorre en preorden
        Stack<BinaryTree<T>> stack = new Stack();
        Stack<BinaryNode<T>> parents = new Stack();

        if (this.isEmpty() || cmp.compare(n.getContent(), this.root.getContent()) != 0) {
            return null;
        } else {
            if (cmp.compare(this.root.getLeft().root.getContent(), n.getContent()) != 0
                    || cmp.compare(this.root.getRight().root.getContent(), n.getContent()) != 0) {
                return this.root;
            }
            stack.push(this);
            while (!stack.isEmpty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }

                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }

                if (cmp.compare(subtree.root.getContent(), n.getContent()) != 0) {
                    return parents.pop();
                }

                if (!subtree.isLeaf()) {
                    parents.push(subtree.root);
                }

            }
        }
        return null;
    }

    //countlevels
    public int countLevelsRecursive() {
        //cuenta los niveles que tiene un arbol recursivamente, recorre los nodos del hijo de la izq
        //y los de la derecha , y devuelve aquel que sea mayor, en este caso este seria el maximo nivel 
        //del arbol
        if (this.isEmpty()) {
            return 0;
        } else {
            int leftLevel = 0, rightLevel = 0;

            if (this.root.getLeft() != null) {
                leftLevel = this.root.getLeft().countLevelsRecursive();
            }

            if (this.root.getRight() != null) {
                rightLevel = this.root.getRight().countLevelsRecursive();
            }

            if (leftLevel > rightLevel) {
                return (leftLevel + 1);
            } else {
                return (rightLevel + 1);
            }
        }
    }

    public int countLevelsIterative() {
        //cuenta los niveles de un arbol de manera iterativa, crea 2 pilas de niveles izq y der
        //recuerda el root original para luego regresarlo y poder iterar por derecha
        //al final pregunta cual pila tiene mayor tamaño, y devuelve esa + 1 debido a que cuenta tambien
        //el nodo root
        Stack<BinaryTree<T>> levelLeft = new Stack();
        Stack<BinaryTree<T>> levelRight = new Stack();

        BinaryNode<T> originalRoot = this.root;

        if (this.isEmpty()) {
            return 0;
        } else {
            if (this.isLeaf()) {
                return 1;
            }

            while (this.root != null && this.root.getLeft() != null) {
                levelLeft.push(this.root.getLeft());
                this.root = this.root.getLeft().root;
            }
            this.root = originalRoot;
            while (this.root != null && this.root.getRight() != null) {
                levelRight.push(this.root.getRight());
                this.root = this.root.getRight().root;
            }

            if (levelLeft.size() > levelRight.size()) {
                return levelLeft.size() + 1;
            } else {
                return levelRight.size() + 1;
            }
        }
    }

    //islefty
    public boolean isLeftyRecursive() {
        //si esta vacio o es una hoja es zurdo
        if (this.isEmpty() || this.isLeaf()) {
            return true;
        }
        //si su izquierdo es nulo o su izquierdo no es zurdo o su derecho no es zurdo tampoco, no es zurdo
        if (this.getLeft() == null || !this.getLeft().isLeftyRecursive() || (getRight() != null && !getRight().isLeftyRecursive())) {
            return false;
        }
        //retornamos un booleano preguntando si los descendientes del hijo izquierdo son mayores 
        //que la mitad de todos los descendientes, si es asi el arbol es zurdo
        return getLeft().countDescendantsIterative() + 1 > countDescendantsIterative() / 2;
    }

    public boolean isLeftyIterative() {
        //si es hoja o esta vacio es zurdo
        if (this.isEmpty() || this.isLeaf()) {
            return true;
            //si no itera
        } else {
            Stack<BinaryTree<T>> stack = new Stack();
            stack.push(this);
            while (!stack.isEmpty()) {
                BinaryTree<T> subtree = stack.pop();
                int descendants = subtree.countDescendantsIterative();
                if (subtree.getLeft() != null) {
                    int leftDescendants = subtree.getLeft().countDescendantsIterative() + 1;
                    //lo convertimos a flotante para hacer la division con decimales y saber exactamente
                    //el valor sin que lo redondee
                    //solo por eso se hace el cast no para cambiar algun tipo de dato
                    if (leftDescendants <= ((float) descendants / 2)) {
                        return false;
                    }
                    stack.push(subtree.getLeft());
                }
                if (subtree.getRight() != null) {
                    stack.push(subtree.getRight());
                }
            }
        }
        return true;
    }

    //isidentical
    public boolean isIdenticalRecursive(BinaryTree<T> other, Comparator<T> cmp) {
        //metodo recursivo que recibe un arbol binario
        //y retorna true si es identico al del metodo que lo invoca
        //recorre recursivamente todos los nodos, y si llega a haber un nodo que no es igual 
        //inmediatamente retorna false, si esto no pasa entonces retornaria true;
        if (this.isEmpty() || other.isEmpty()) {
            return false;
        } else if (cmp.compare(this.root.getContent(), other.root.getContent()) != 0) {
            return false;
        } else if (this.countDescendantsIterative() != other.countDescendantsIterative()) {
            return false;
        } else {
            boolean tmp = true;
            if (this.root.getLeft() != null && other.root.getLeft() != null) {
                tmp = this.root.getLeft().isIdenticalRecursive(other.root.getLeft(), cmp);
            }
            if (tmp == true) {
                if (this.root.getRight() != null && other.root.getRight() != null) {
                    tmp = this.root.getRight().isIdenticalRecursive(other.root.getRight(), cmp);
                }
            }
            return tmp;
        }
    }

    public boolean isIdenticalIterative(BinaryTree<T> other, Comparator<T> cmp) {
        //metodo iterativo que recorre 2 arboles 
        //guarda todos los nodos en 2 pilas , una para cada arbol
        //al final saca los elementos de las pilas y los compara , si alguno de ellos no 
        //llega a ser igual entonces retorna false inmediatamente 
        //si son identicos se van a guardar igual en las pilas
        Stack<BinaryTree<T>> treesThis = new Stack();
        Stack<BinaryTree<T>> nodosThis = new Stack();

        Stack<BinaryTree<T>> treesOther = new Stack();
        Stack<BinaryTree<T>> nodosOther = new Stack();

        if (this.isEmpty() || other.isEmpty()) {
            return false;
        } else {
            if (this.countDescendantsIterative() != other.countDescendantsIterative()) {
                return false;
            }
            treesThis.push(this);
            treesOther.push(other);
            while (!treesThis.empty()) {
                BinaryTree<T> subtree = treesThis.pop();
                if (subtree.root.getLeft() != null) {
                    treesThis.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    treesThis.push(subtree.root.getRight());
                }
                nodosThis.push(subtree);
            }
            while (!treesOther.empty()) {
                BinaryTree<T> subtree = treesOther.pop();
                if (subtree.root.getLeft() != null) {
                    treesOther.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    treesOther.push(subtree.root.getRight());
                }
                nodosOther.push(subtree);
            }

            if (nodosThis.size() != nodosOther.size()) {
                return false;
            }

            while (!nodosThis.isEmpty() && !nodosOther.isEmpty()) {
                BinaryTree<T> nodoThis = nodosThis.pop();
                BinaryTree<T> nodoOther = nodosOther.pop();

                if (cmp.compare(nodoThis.root.getContent(), nodoOther.root.getContent()) != 0) {
                    return false;
                }
            }

        }
        return true;
    }

    //largestvalueofeachlevel
    public void largestValueOfEachLevelRecursive(Comparator<T> cmp, LinkedList<T> maximos, int nivel) {
        //esta funcion hace uso de una funcion auxiliar para poder guardar los mayores por nivel
        //su nombre es exactamente la misma por lo que existe una sobrecarga
        //este metodo recorre recursivamente todos los nodos y si es que el nodo es mayor que el maximo
        //por nivel entonces lo reemplaza, si no nunca lo reeemplaza y se retorna el ultimo cambio que hubo
        //de maximo
        if (this.isEmpty()) {
            return;
        } else {
            //si no hay ninguno, agrega el primero en este caso el root
            if (nivel == maximos.size()) {
                maximos.addLast(this.root.getContent());
            }

            if (cmp.compare(this.root.getContent(), maximos.getLast()) == 1) {
                maximos.set(nivel, this.root.getContent());
            }

            if (this.root.getLeft() != null) {
                this.root.getLeft().largestValueOfEachLevelRecursive(cmp, maximos, nivel + 1);
            }
            if (this.root.getRight() != null) {
                this.root.getRight().largestValueOfEachLevelRecursive(cmp, maximos, nivel + 1);
            }
        }
    }

    public void largestValueOfEachLevelRecursive(Comparator<T> cmp) {
        LinkedList<T> maximos = new LinkedList<>();
        this.largestValueOfEachLevelRecursive(cmp, maximos, 0);
        System.out.println(maximos);
    }

    public void largestValueOfEachLevelIterative(Comparator<T> cmp) {
        //metodo iterativo que guarda los mayores por nivel en una linkedlist
        //en vez de usar pilas utiliza colas para poder obtener el primer elemento añadido
        //recorre con un lazo for todos los arboles que se encuentren en la pila en ese momento
        //y cambia el max constantemente por nivel reseteandolo, de esa forma obtenemos los 
        //mayores por nivel y los almacenamos para al final imprimirlos por pantalla.
        LinkedList<T> maximos = new LinkedList<>();
        Queue<BinaryTree<T>> queue = new LinkedList<>();

        if (this.isEmpty()) {
            System.out.println("ARBOL VACIO!");
        } else {
            queue.offer(this);
            while (!queue.isEmpty()) {
                int stackSize = queue.size();
                T max = null;

                for (int i = 0; i < stackSize; i++) {
                    BinaryTree<T> subtree = queue.poll();
                    if (max == null) {
                        max = subtree.root.getContent();
                    }

                    if (cmp.compare(subtree.root.getContent(), max) == 1) {
                        max = subtree.root.getContent();
                    }

                    if (subtree.root.getLeft() != null) {
                        queue.offer(subtree.root.getLeft());
                    }
                    if (subtree.root.getRight() != null) {
                        queue.offer(subtree.root.getRight());
                    }
                }
                maximos.add(max);
            }
        }
        System.out.println(maximos);
    }

    //countnodeswithonlychild
    public int countNodesWithOnlyChildRecursive() {
        //funciona que recorre recursivamente los nodos del arbol y cuenta aquellos que solo tienen
        //1 hijo, ya sea a la izq o derecha, cuando un nodo tiene solo un hijo agrega un contador que
        //se va actualizando recursivamente. se hace uso de una funcion auxiliar hasonlychild que 
        //valida si el nodo tiene un solo hijo
        if (this.isEmpty()) {
            return 0;
        } else {
            int count = 0;
            if (this.root.getLeft() != null) {
                if (this.hasOnlyChild()) {
                    count++;
                }
                count += this.getLeft().countNodesWithOnlyChildRecursive();
            }

            if (this.root.getRight() != null) {
                if (this.hasOnlyChild()) {
                    count++;
                }
                count += this.getRight().countNodesWithOnlyChildRecursive();
            }

            return count;
        }
    }

    public int countNodesWithOnlyChildIterative() {
        //funcion iterativa que recorre un arbol usando pilas
        //y si un arbol tiene un solo hijo , usando una funcion auxiliar para validar
        //entonces actualiza un contador que devuelve al final
        Stack<BinaryTree<T>> stack = new Stack();
        int count = 0;
        if (this.isEmpty()) {
            return 0;
        } else {
            stack.push(this);
            while (!stack.empty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }
                if (subtree.hasOnlyChild()) {
                    count++;
                }
            }
        }

        return count;
    }

    //isHeightBalanced
    public boolean isHeightBalancedRecursive() {
        //funcion recursiva que pregunta constantemente si un arbol esta balanceado
        //este lo esta si esta vacio y su hijo izquierdo y derecho tambien lo estan
        //recorre cada nodo y se pregunta si la diferncia de alturas entre su hijo izquierdo y derecho
        //es menor o igual a uno, si es asi entonces retorna true, si nunca entra entonces retorna false
        if (this.isEmpty()) {
            return true;
        } else {
            if (this.getLeft() != null && this.getRight() != null) {
                if (Math.abs((this.getLeft().countDescendantsIterative() + 1) - (this.getRight().countDescendantsIterative() + 1)) <= 1) {
                    return true;
                }
                this.getLeft().isHeightBalancedRecursive();
                this.getRight().isHeightBalancedRecursive();
            }
        }
        return false;
    }

    public boolean isHeightBalancedIterative() {
        //si esta vacio esta balanceado
        if (this.isEmpty()) {
            return true;
            //si no itera en cada nodo del arbol
        } else {
            Stack<BinaryTree<T>> stack = new Stack();
            stack.push(this);
            while (!stack.isEmpty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.getLeft() != null && subtree.getRight() != null) {
                    //calculamos la diferencia de altura con math.abs si la diferencia de altura
                    //del izquierdo y del derecho es menor o igual a uno entonces si esta balanceado
                    //si no entra es porque el arbol izquierdo y derecho esta balanceado
                    if (Math.abs((this.getLeft().countDescendantsIterative() + 1) - (this.getRight().countDescendantsIterative() + 1)) > 1) {
                        return false;
                    }
                }
                //agrega a la pila luego sus hijos izq y derecho para luego analizarlos
                if (subtree.getRight() != null) {
                    stack.push(subtree.getLeft());
                }
                if (subtree.getRight() != null) {
                    stack.push(subtree.getRight());
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "BinaryTree{" + "root=" + root + '}';
    }

}
