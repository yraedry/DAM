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
    /**
     * metodo para sumar dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return retorna la suma en double
     */
    private static double suma(double a, double b){
        return a + b;
    }
    /**
     * metodo para restar dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return retorna la resta en double
     */
    private static double resta(double a, double b){
        return a - b;
    }
    /**
     * metodo para multiplicar dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return retorna la multiplicacion en double
     */
    private static double multiplicacion(double a, double b){
        return a * b;
    }
    /**
     * metodo para dividir dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return retorna la division en double
     */
    private static double division(double a, double b){
        return a / b;
    }
}
