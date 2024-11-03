package org.dam.programacion.ejercicios.entregas;

import java.util.Scanner;

/*
 * Calculadora Basica
 * @author adrian nuñez sanchez
 *
 * Crea un programa que solicite al usuario ingresar dos números y un símbolo de operación (+, -, *, /).
 * El programa debe realizar la operación especificada entre los dos números y mostrar el resultado. Si el usuario ingresa un símbolo que no sea válido, el programa debe mostrar un mensaje de error.
 */
public class CalculadoraBasica {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        iniciarCalculadora(scan);
        scan.close();
    }
    /**
     * metodo para inicializar la calculadora
     * @param scan inicalizacion del objeto Scanner
     */
    private static void iniciarCalculadora(Scanner scan){
        System.out.println("Bienvenido a una calculadora basica");
        System.out.println("Introduce el primer numero");
        int primerNumero = scan.nextInt();
        System.out.println("Introduce el segundo numero");
        int segundoNumero = scan.nextInt();
        System.out.println("Que operacion desea realizar, porfavor introduzca uno de los siguiente simbolos en funcion de la operacion que desea realizar:");
        System.out.println("Si desea una suma introduzca el simbolo: +");
        System.out.println("Si desea una resta introduzca el simbolo: -");
        System.out.println("Si desea una multiplicacion introduzca el simbolo: *");
        System.out.println("Si desea una division introduzca  el simbolo: /");
        scan.nextLine();
        realizarOperacion(scan.nextLine(), primerNumero, segundoNumero);
    }
    /**
     * metodo para saber la operacion que debemos realizar y poder llamar al metodo que la realiza
     * @param simbolo simbolo para saber la operacion que debemos realizar
     * @param primerNumero primer numero
     * @param segundoNumero segundo numero
     */
    private static void realizarOperacion(String simbolo, int primerNumero, int segundoNumero){
        switch (simbolo){
            case "+":
                System.out.println("Has elegido sumar");
                System.out.println("La suma total de los numeros es igual a "+ suma(primerNumero, segundoNumero));
                break;
            case "-":
                System.out.println("Has elegido restar");
                System.out.println("La resta total de los numeros es igual a "+ resta(primerNumero, segundoNumero));
                break;
            case "*":
                System.out.println("Has elegido multiplicar");
                System.out.println("La multiplicacion total de los numeros es igual a "+ multiplicacion(primerNumero, segundoNumero));
                break;
            case "/":
                System.out.println("Has elegido dividir");
                System.out.println("La division total de los numeros es igual a "+ division(primerNumero, segundoNumero));
                break;
            default:
                System.out.println("Has introducido una operacion que no es valida");
                break;

        }
    }
    /**
     * metodo para sumar dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return retorna la suma en int
     */
    private static int suma(int a, int b){
        return a + b;
    }
    /**
     * metodo para restar dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return retorna la resta en int
     */
    private static int resta(int a, int b){
        return a - b;
    }
    /**
     * metodo para multiplicar dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return retorna la multiplicacion en int
     */
    private static int multiplicacion(int a, int b){
        return a * b;
    }
    /**
     * metodo para dividir dos numeros
     * @param a primer numero
     * @param b segundo numero
     * @return retorna la division en int
     */
    private static int division(int a, int b){
        return a / b;
    }
}
