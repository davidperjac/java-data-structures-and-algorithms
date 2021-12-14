package ec.edu.espol.TDA_Pila;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        
        //pruebas de los ejercicios 4 ,5 y 6
        
        //prueba conversion infija a posfija con parentesis ejercicio 4
        
        // ( ( A - ( B + C ) ) * D ) ^ ( E + F ) EJEMPLO DEL DEBER
        /*
        String infixParentesis = "( ( A - ( B + C ) ) * D ) ^ ( E + F )";
        String postFixParentesis = toPostFixParentesis(infixParentesis);
        
        System.out.println(postFixParentesis);
        */

        //prueba StackCopyTo ejercicio 5
        
        /*        
        //p1 lleno 
        
        Stack p1 = new Stack();
        
        for (int i = 0 ; i < 5 ; i++) {
            p1.push(i);
        }
        
        //p2 vacio
        
        Stack p2 = new Stack();
        
        // llamamos al metodo
        
        System.out.println(p1);
        System.out.println(p2);
        
        System.out.println("--------------------");
        
        stackCopyTo(p1,p2);
        
        System.out.println(p1);
        System.out.println(p2);
         */
        
        //prueba eliminarPrimerosK ejercicio 6
        
        // arreglo del deber {20,10,25,30,40}
        /*
        int[] array = {20,10,25,30,40};
        
        Stack prueba = eliminarPrimerosK(array,2);
        
        System.out.println(prueba);
        */
        

        
        
        
    }

    //  1. Conversión de expresiones infijas a posfijas
    public static String toPostFix(String infix) {
        String postFix = "";
        Stack<String> s = new Stack();

        String[] split = infix.split(" ");

        for (int i = 0; i < split.length; i++) {
            String c = split[i];
            if (isOperand(c)) {
                postFix += " ";
                postFix += c;
            } else {
                if (s.isEmpty()) {
                    s.push(c);
                } else {
                    String operatorPila = s.peek();
                    if (getPriority(c) > getPriority(operatorPila)) {
                        s.push(c);
                    } else {
                        while (!s.isEmpty() && !(getPriority(c) > getPriority(s.peek()))) {
                            operatorPila = s.pop();
                            postFix += " ";
                            postFix += operatorPila;
                        }
                        s.push(c);
                    }
                }
            }
        }
        while (!s.isEmpty()) {
            postFix += " ";
            postFix += s.pop();
        }
        return postFix;
    }

    // funciones de utilidad para el ejercicio 1
    private static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^") || c.equals("(") || c.equals(")");
    }

    private static boolean isOperand(String c) {
        return !isOperator(c);
    }

    private static int getPriority(String operator) {
        switch (operator) {
            case ")" :
                return 6;
            case "^" :
                return 5;
            case "*":
                return 4;
            case "/":
                return 4;
            case "+":
                return 3;
            case "-":
                return 3;
            case "(":
                return 2;
            default:
                return 0;
        }
    }

    // 2. Evaluación de expresiones posfijas
    public static double evaluarPostFix(String postfix) {
        Stack<Double> s = new Stack();
        String[] split = postfix.split(" ");

        for (String c : split) {
            if (isOperand(c)) {
                s.push(Double.parseDouble(c));
            } else {
                double operand1 = s.pop();
                double operand2 = s.pop();
                double resultado = operate(operand1, operand2, c);
                s.push(resultado);
            }
        }
        return s.pop();
    }
    
    //funciones de utilidad para el ejercicio 2
    private static double operate(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand2 - operand1;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand2 / operand1;
            case "^":
                return Math.pow(operand2, operand1);
            default:
                return 0;
        }
    }

    // 4. Conversión Infija a Posfija con paréntesis
    public static String toPostFixParentesis(String infix) {
        String postFix = "";
        Stack<String> s = new Stack();

        String[] split = infix.split(" ");

        for (int i = 0; i < split.length; i++) {
            String c = split[i];
            if (isOperand(c)) {
                postFix += " ";
                postFix += c;
            } else {
                if (s.isEmpty()) {
                    s.push(c);
                } else {
                    String operatorPila = s.peek();
                    //si es un parentesis de apertura siempre se agrega a la pila
                    if (isApertura(c)) {
                        s.push(c);
                    }
                    //si la prioridad de c es mayor que del operador de la pila y no es un parentesis de cierre
                    //se agrega a la pila
                    else if (getPriority(c) > getPriority(operatorPila) && !(c.equals(")"))) {
                        s.push(c);
                    }else {
                        //si la pila no esta vacia, se saca el ultimo elemento de la pila
                        if (!s.isEmpty() ) {
                            operatorPila = s.pop();
                            //si c es un parentesis de cierre agrega el operador de la pila a la expresion
                            //y elimina el operador anterior a el, en este caso un parentesis de apertura
                            if (isCierre(c)) {
                                postFix += " ";
                                postFix += operatorPila;                            
                                s.pop();
                            }
                        }
                    }
                }
            }
        }
        //agrega a la expresion los operadores que queden en la pila
        while (!s.isEmpty()) {
            postFix += " ";
            postFix += s.pop();
        }
        return postFix;
    }
    
    //funciones de utilidad de la ejercicio 4
    
    public static boolean isApertura(String operador) {
        return operador.equals("(");
    }
    
    public static boolean isCierre (String operador) {
        return operador.equals(")");
    }
    
    // 5. stackCopyTo
    public static void stackCopyTo(Stack p1, Stack p2) {
        Stack buffer = new Stack();
        Stack copiap1 = p1;

        //sacamos elementos de la pila llena a la pila "buffer"
        while (!copiap1.isEmpty()) {
            buffer.push(p1.pop());
        }

        //metemos elementos a la pila p1 y p2
        while (!buffer.isEmpty()) {
            p1.push(buffer.peek());
            p2.push(buffer.peek());
            buffer.pop();
        }

    }
    

    // 6. eliminarPrimerosK
    public static Stack<Integer> eliminarPrimerosK(int[] array, int k) {
        //pila de salida
        Stack<Integer> salida = new Stack();
        //creamos una pila para poder recordar a los mayores
        Stack<Integer> mayores = new Stack();
        //contador de eliminaciones
        int eliminaciones = 0;
        //recorremos el arreglo al revez para ingresarlo en la pila de salida
        for (int i = array.length - 1; i >= 0; i--) {
            salida.push(array[i]);
        }
        //recorremos la pila hasta que las eliminaciones alcancen el numero que ingresa en la funcion
        while (eliminaciones != k || salida.isEmpty()) {   
            Integer ultimo = salida.pop();
            // por si es que ya no hay mas elementos en la pila de salida
            // o si es que ya no se pueden hacer mas eliminaciones porque solo queda un elemento
            if (salida.isEmpty()) {
                mayores.push(ultimo);
                return mayores;
                // si es que no se hizo ninguna eliminacion retorna una pila igual al arreglo que ingreso
                // ejemplo del arreglo : {40,30,20,10}
            }
            Integer penultimo = salida.peek();
            if (ultimo < penultimo) {
                //si ultimo es menor aumenta las eliminaciones y no lo agrega a la pila
                eliminaciones += 1;
                //si la pila mayores no esta vacia, actualiza la pila con el numero mayor que fue recordado
                if (!mayores.isEmpty()) {
                    salida.push(mayores.pop());
                }
            // si ultimo es mayor lo recuerda
            }else {
                mayores.push(ultimo);
            }
        }
        //cambiamos el formato de salida de la pila para que este en el orden correcto
        Stack salidaCambiada = new Stack();
        while (!salida.isEmpty()) {
            salidaCambiada.push(salida.pop());
        }
        return salidaCambiada;
    }
    
}
