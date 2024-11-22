package org.dam.programacion.ejercicios.entregas;

import java.util.Random;
import java.util.Scanner;

public class BatallaNaval {
    /*
    * Generar el tablero:
    * Crea un array bidimensional de 5x5 que represente el tablero. [X]
    * Llena el tablero con ceros (0). [X]
    * Coloca aleatoriamente 3 barcos representados por el número 1. [X]
    * (OPCIONAL) Añade el nombre de cada fila y columna, usando para ello las opciones de formato que viste en clase el otro día.
    */
    private static int TAMANNIO = 5;
    private static int[][] tablero;
    public static void main(String[] args) {
        tablero = new int[TAMANNIO][TAMANNIO];
        inicializarTablero();
        mostrarTablero();
        crearMenu(tablero);
    }

    private static void inicializarTablero(){
        int numBarcos = 3;
        Random random = new Random();
        for(int j =0; j < numBarcos;j++){
          boolean colocado =false;
          while(!colocado){
              int fila = random.nextInt(5);
              int columna = random.nextInt(5);
              if(tablero[fila][columna] == 0){
                  tablero[fila][columna] = 1;
                  colocado = true;
              }
          }
        }
    }
    private static void mostrarTablero() {
        System.out.print("   A B C D E");
        System.out.println(" ");
        for (int i = 0; i < TAMANNIO; i++) {
            System.out.print((i + 1) + " |");
            for (int x = 0; x < TAMANNIO; x++) {
                System.out.print(tablero[i][x] + "|");
            }
            System.out.println(" ");
        }
    }
/*
   * Juego del usuario:
   * Pide al usuario que introduzca las coordenadas (fila y columna) para intentar "disparar" a un barco.
   * Si acierta, muestra un mensaje como "¡Tocado!" y marca la posición con una X roja.
   * Si falla, muestra "Agua" y marca la posición con un ~  (alt gr + 4) azul.
   * (OPCIONAL) Por supuesto, si quieres adornarlo aún más, eres bienvenido de hacerlo. Lo valoraré positivamente para compensar posibles errores.
  */
    public static void crearMenu(int [][] tablero) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Introduce la coordenadas para disparar");
            System.out.println("Dinos una fila");
            int fila = scanner.nextInt();
            System.out.println("Dinos una columna");
            int columna = scanner.nextInt();
            if (tablero[fila][columna] == 0) {
                System.out.println("Agua");
            } else {
                System.out.println("Tocado");
                tablero[fila][columna] = 2;
                mostrarTablero();
            }
        }

    }

}
