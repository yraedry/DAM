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
    /**
     * metodo para comprobar si las variables son iguales
     * @param x primer valor a comprobar
     * @param y segundo valor a comprobar
     */
    private static void esIgual(int x, int y){
        boolean comparacion = x == y;
        System.out.println(comparacion);
    }
    /**
     * metodo para comprobar si las variables son diferentes
     * @param x primer valor a comprobar
     * @param y segundo valor a comprobar
     */
    private static void esDiferente(int x, int y){
        boolean comparacion = x != y;
        System.out.println(comparacion);
    }
    /**
     * metodo para comprobar si una variable es mayor que otra
     * @param x primer valor a comprobar
     * @param y segundo valor a comprobar
     */
    private static void esMayor(int x, int y){
        boolean comparacion = x > y;
        System.out.println(comparacion);
    }
    /**
     * metodo para comprobar si una variable es menor que otra
     * @param x primer valor a comprobar
     * @param y segundo valor a comprobar
     */
    private static void esMenor(int x, int y){
        boolean comparacion = x < y;
        System.out.println(comparacion);
    }
    /**
     * metodo para comprobar si una variable es mayor igual que otra
     * @param x primer valor a comprobar
     * @param y segundo valor a comprobar
     */
    private static void esMayorIgual(int x, int y){
        boolean comparacion = x >= y;
        System.out.println(comparacion);
    }
    /**
     * metodo para comprobar si una variable es menor igual que otra
     * @param x primer valor a comprobar
     * @param y segundo valor a comprobar
     */
    private static void esMenorIgual(int x, int y){
        boolean comparacion = x <= y;
        System.out.println(comparacion);
    }
}
