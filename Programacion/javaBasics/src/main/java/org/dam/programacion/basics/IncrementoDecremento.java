package org.dam.programacion.basics;

public class IncrementoDecremento {
    public static void main(String[] args) {
        int contador = 5;
        incrementador(contador);
        decrementador(contador);
    }

    private static void incrementador(int numero){
        numero++;
        System.out.println(numero);
    }
    private static void decrementador(int numero){
        numero--;
        System.out.println(numero);
    }

}
