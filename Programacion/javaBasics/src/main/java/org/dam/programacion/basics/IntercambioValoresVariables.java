package org.dam.programacion.basics;

public class IntercambioValoresVariables {
    /*
    * Ejercicio 9: Intercambio de valores entre dos variables
    * Objetivo: Practicar el intercambio de valores entre dos variables sin usar una tercera variable.
    * Instrucciones:
    * 1. Declara dos variables int llamadas a y b con los valores 7 y 9 respectivamente.
    * 2. Intercambia los valores de a y b sin usar una variable temporal.
    * 3. Imprime los valores de a y b después del intercambio.
    */
    public static void main(String[] args) {
        int a = 7;
        int b = 9;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("El valor de a es " + a);
        System.out.println("El valor de b es " + b);
    }
}
