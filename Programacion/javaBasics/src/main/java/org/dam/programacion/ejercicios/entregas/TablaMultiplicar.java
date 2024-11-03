package org.dam.programacion.ejercicios.entregas;

import java.util.Scanner;
/*
 * Tabla de multiplicar
 * @author adrian nuñez sanchez
 *
 * Escribe un programa que solicite al usuario un número entero y luego muestre la tabla de multiplicar de ese número, del 1 al 10.
 * Cada línea de la salida debe mostrar la operación en el formato X * i = resultado.
 */
public class TablaMultiplicar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tablaMultiplicaciones(scanner);
        scanner.close();
    }
    /**
     * metodo para realizar la tabla de multiplicacion del numero introducido por el usuario
     * @param scanner inicalizacion del objeto Scanner
     */
    private static void tablaMultiplicaciones(Scanner scanner){
        System.out.println("introduce un numero entero para sacar su tabla de multiplicar del 1 al 10: ");
        int numero = scanner.nextInt();
        for(int i= 1; i <=10; i++){
            System.out.println(numero + " * " + i + " = " + numero*i);
        }
    }
}
