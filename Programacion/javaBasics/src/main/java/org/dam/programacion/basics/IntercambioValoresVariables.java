package org.dam.programacion.basics;

public class IntercambioValoresVariables {
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
