package org.dam.programacion.ejercicios.estructuras.seleccion;

public class TableroAjedrezVacio {
    //Tablero
    private static final int TAMANIO = 8;
    private static String[][] tablero;
    private static final String CASILLA_BLANCA = "□";
    private static final String CASILLA_NEGRA = "■";

    public static void main(String[] args) {
        tablero = new String[TAMANIO][TAMANIO];
        pintarTablero();
    }

    private static void pintarTablero(){
        for(int i = 0; i < TAMANIO; i ++){
            for(int j = 0; j < TAMANIO; j ++){
                if((i + j) % 2 == 0){
                   tablero[i][j] = CASILLA_NEGRA ;
                }else{
                    tablero[i][j] =CASILLA_BLANCA;
                }
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
