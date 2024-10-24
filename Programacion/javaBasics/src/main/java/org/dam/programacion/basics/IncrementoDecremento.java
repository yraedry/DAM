package org.dam.programacion.basics;

public class IncrementoDecremento {
     /*
     * Ejercicio 4: Operadores de incremento y decremento
     * Objetivo: Practicar los operadores de incremento (++) y decremento (--).
     * Instrucciones:
     * 1. Declara una variable int llamada contador con el valor 5.
     * 2. Incrementa contador en 1 usando el operador ++.
     * 3. Imprime el valor de contador después del incremento.
     * 4. Decrementa contador en 1 usando el operador --.
     * 5. Imprime el valor de contador después del decremento.
     */
    public static void main(String[] args) {
        int contador = 5;
        incrementador(contador);
        decrementador(contador);
    }
    /**
     * metodo para incrementar el valor de un numero
     * @param numero numero a incrementar
     */
    private static void incrementador(int numero){
        numero++;
        System.out.println(numero);
    }
    /**
     * metodo para decrementar el valor de un numero
     * @param numero numero a decrementar
     */
    private static void decrementador(int numero){
        numero--;
        System.out.println(numero);
    }

}
