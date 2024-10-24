package org.dam.programacion.basics;

public class OperadoresComparacion {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        esIgual(x, y);
        esDiferente(x,y);
        esMayor(x,y);
        esMenor(x,y);
        esMayorIgual(x,y);
        esMenorIgual(x,y);
    }

    private static void esIgual(int x, int y){
        boolean comparacion = x == y;
        System.out.println(comparacion);
    }
    private static void esDiferente(int x, int y){
        boolean comparacion = x != y;
        System.out.println(comparacion);
    }
    private static void esMayor(int x, int y){
        boolean comparacion = x > y;
        System.out.println(comparacion);
    }
    private static void esMenor(int x, int y){
        boolean comparacion = x < y;
        System.out.println(comparacion);
    }
    private static void esMayorIgual(int x, int y){
        boolean comparacion = x >= y;
        System.out.println(comparacion);
    }
    private static void esMenorIgual(int x, int y){
        boolean comparacion = x <= y;
        System.out.println(comparacion);
    }
}
