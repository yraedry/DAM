package org.dam.programacion.ejercicios.extendidos;

public class TableroAjedrez {

    /*
     * Para resolver el ejercicio, deberás seguir los siguientes pasos:
     * • Paso 1. Definir constantes de las piezas.
     * • Paso 2. Poner las piezas negras de la octava fila.
     * • Paso 3. Añadir al dibujo la línea inferior.
     * • Paso 4. Dibujar la fila intermedia con la casilla blanca y la casilla negra.
     * • Paso 5. Repetir la la sos edia de unta competare alero mixto.
     */
     //Tablero
    private static final int TAMANIO = 8;
    private static String[][] tablero;
    private static final String CASILLA_BLANCA = "□";
    private static final String CASILLA_NEGRA = "■";
    // Piezas Blancas
    final static String PEON_BLANCAS = "♙";
    final static String TORRE_BLANCAS = "♖";
    final static String CABALLO_BLANCAS = "♘";
    final static String ALFIL_BLANCAS = "♗";
    final static String DAMA_BLANCAS = "♕";
    final static String REY_BLANCAS = "♔";
    // Piezas Negras
    final static String PEON_NEGRAS = "♟";
    final static String TORRE_NEGRAS = "♜";
    final static String CABALLO_NEGRAS = "♞";
    final static String ALFIL_NEGRAS = "♝";
    final static String DAMA_NEGRAS = "♛";
    final static String REY_NEGRAS = "♚";

    public static void main(String[] args) {
        tablero = new String[TAMANIO][TAMANIO];
        inicilizarTablero();
        mostrarTablero();
    }

    private static  void inicilizarTablero(){
        //piezas blancas
        tablero[0][0] = TORRE_BLANCAS;
        tablero[0][1] = CABALLO_BLANCAS;
        tablero[0][2] = ALFIL_BLANCAS;
        tablero[0][3] = DAMA_BLANCAS;
        tablero[0][4] = REY_BLANCAS;
        tablero[0][5] = ALFIL_BLANCAS;
        tablero[0][6] = CABALLO_BLANCAS;
        tablero[0][7] = TORRE_BLANCAS;

        //piezas negras
        tablero[7][0] = TORRE_NEGRAS;
        tablero[7][1] = CABALLO_NEGRAS;
        tablero[7][2] = ALFIL_NEGRAS;
        tablero[7][3] = DAMA_NEGRAS;
        tablero[7][4] = REY_NEGRAS;
        tablero[7][5] = ALFIL_NEGRAS;
        tablero[7][6] = CABALLO_NEGRAS;
        tablero[7][7] = TORRE_NEGRAS;

        //peones
        for(int i =0; i < TAMANIO; i++){
            tablero[1][i] = PEON_BLANCAS;
            tablero[6][i] = PEON_NEGRAS;
        }

        //casillas vacias
        for(int i =2;i <6; i++){
            for(int j = 0; j< TAMANIO; j++){
                if ((i + j) % 2 == 0) {
                    tablero[i][j] = CASILLA_BLANCA;
                } else {
                    tablero[i][j] = CASILLA_NEGRA;
                }
            }
        }
    }
    private static void mostrarTablero() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
