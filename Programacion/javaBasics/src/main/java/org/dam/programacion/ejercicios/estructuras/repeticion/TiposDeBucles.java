package org.dam.programacion.ejercicios.estructuras.repeticion;

import java.util.Scanner;
/*
* Enunciado:
* Escribe un programa que solicite al usuario un número entero positivo.
* Luego, el programa debe imprimir todos los números del 1 hasta ese número.
* Usa un bucle for para imprimir los números uno por uno en líneas separadas.
*/
public class TiposDeBucles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        bucleFor(scan);
        scan.close();
    }

    private static void bucleFor(Scanner scan){
        System.out.println("Introduce un numero positivo");
        int numLoop = scan.nextInt();
        for(int i = 1; i <= numLoop; i++){
            System.out.println("El numero es "+i);
        }
    }
}
