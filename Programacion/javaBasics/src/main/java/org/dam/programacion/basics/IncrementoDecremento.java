package org.dam.programacion.basics;

public class IncrementoDecremento {
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
