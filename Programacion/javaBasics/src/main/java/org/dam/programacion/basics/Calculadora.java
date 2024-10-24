package org.dam.programacion.basics;

public class Calculadora {
    public static void main(String[] args) {
        double numeroA = Math.random() * 100;
        double numeroB = Math.random() * 100;
        System.out.println("La suma de los numeros es " + suma(numeroA, numeroB));
        System.out.println("La resta de los numeros es " + resta(numeroA, numeroB));
        System.out.println("La multiplicacion de los numeros es " + multiplicacion(numeroA, numeroB));
        System.out.println("La division de los numeros es " + division(numeroA, numeroB));
    }

    private static double suma(double a, double b){
        return a + b;
    }

    private static double resta(double a, double b){
        return a - b;
    }

    private static double multiplicacion(double a, double b){
        return a * b;
    }

    private static double division(double a, double b){
        return a / b;
    }
}
