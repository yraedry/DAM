package org.dam.programacion.basics;
import java.util.Scanner;

public class columnaMatrices {
    public static void main(String[] args) {
        /*
         * Matriz cuadrada 
         * rellena la matriz con los numeros desde el 1 hasta su tamaño 
         * calculas las sumas por filas de la matriz y muestralas por pantalla
         * calcula las sumas por columnas de la matriz y muestralas por pantalla
         */

         Scanner scanner = new Scanner(System.in);
         System.out.println("Introduce el numero de filas y columnas que quieres que tenga la matriz");
         int tamannio = scanner.nextInt();
         int[][] matriz = new int[tamannio][tamannio];
         int contador = 1;
        for(int x = 0; x < tamannio ;x++){
            for(int i = 0; i < tamannio ;i++){
                matriz[x][i]=contador++;
            }
        }
        System.out.println("--------------SUMAS-------------");
         for(int filas = 0; filas < matriz.length; filas++){
            int valoresFilas = 0;
            int valoresColumnas = 0;
            for(int columnas =0; columnas < matriz.length; columnas++){
                valoresFilas += matriz[filas][columnas];
                valoresColumnas += matriz[columnas][filas];
            }
             System.out.println("Fila " + filas + " -> Suma: " + valoresFilas);
             System.out.println("Columna " + filas + " -> Suma: " + valoresColumnas);
         }

    }
}
