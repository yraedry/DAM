package org.dam.programacion.basics;

public class AritmeticaBasica {
    public static void main(String[] args) {
        int numeroA = 8;
        int numeroB = 3;
        System.out.println("La suma de los numeros "+numeroA+" y "+numeroB+" es " + suma(numeroA, numeroB));
        System.out.println("La resta de los numeros "+numeroA+" y "+numeroB+" es " +  resta(numeroA, numeroB));
        System.out.println("La multiplicacion de los numeros "+numeroA+" y "+numeroB+" es " + multiplicacion(numeroA, numeroB));
        System.out.println("La division de los numeros "+numeroA+" y "+numeroB+" es " +  division(numeroA, numeroB));
        System.out.println("El modulo de los numeros "+numeroA+" y "+numeroB+" es " +  modulo(numeroA, numeroB));
    }

    private static int suma(int a, int b){
        return a + b;
    }

    private static int resta(int a, int b){
        return a - b;
    }

    private static int multiplicacion(int a, int b){
        return a * b;
    }

    private static int division(int a, int b){
        return a / b;
    }

    private static int modulo(int a, int b){
        return a %  b;
    }
}
