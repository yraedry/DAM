package org.dam.programacion.ejercicios.estructuras.repeticion;

public class TableroAjedrezAlgebraico {
    //Tablero
    private static final int TAMANIO = 8;
    private static int[][] tablero;

    public static void main(String[] args) {
        tablero = new int[TAMANIO][TAMANIO];
        pintarTablero();
    }

    private static void pintarTablero(){
        for(int i = 0; i < TAMANIO; i++){
            for(int j = 0; j < TAMANIO; j++){
                tablero[i][j] = (TAMANIO * 10 + 1) - (i * 10) + j;
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
