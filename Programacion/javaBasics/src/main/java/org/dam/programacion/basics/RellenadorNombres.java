package org.dam.programacion.basics;

import java.util.Scanner;

public class RellenadorNombres {
//    Crea un programa que permita trabajar con una matriz de tamaño 2x2 de tipo String. El programa debe realizar los siguientes pasos:
//    Crear una matriz de tamaño 2x2 para almacenar cadenas de texto.
//    Pedir al usuario que introduzca 4 palabras, una para cada posición de la matriz.
//    Mostrar la matriz completa en formato de tabla.
//    Mostrar por pantalla los elementos de la diagonal principal (de la esquina superior izquierda a la esquina inferior derecha), concatenando un espacio entre ellos.
//    Terminar el programa agradeciendo al usuario.

    public static void main(String[] args) {
        String[][] nombres = new String[2][2];
        var scanner = new Scanner(System.in);
        for(int x = 0; x < nombres.length; x++){
            for(int i = 0; i < nombres[x].length; i++){
                System.out.println("Introduce una palabra");
                var palabra = scanner.nextLine();
                nombres[x][i] = palabra;
            }
        }

        for(int x=0;x < nombres.length; x++){
            for(int i = 0; i < nombres.length; i++){
                System.out.print(nombres[x][i] + " ");
            }
            System.out.println();
        }

        for(int x=0;x < nombres.length; x++){
            for(int i = 0; i < nombres.length; i++){
                if(x == i){
                    System.out.print(nombres[x][i] + " ");
                }
            }
        }
        System.out.println();
        System.out.println("Que pases un buen dia");
    }
}
