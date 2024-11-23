package org.dam.programacion.ejercicios.entregas;

import java.util.Random;
import java.util.Scanner;

public class BatallaNaval {
    /*
    * @author adrian nunez sanchez
    * Generar el tablero:
    * Crea un array bidimensional de 5x5 que represente el tablero. [X]
    * Llena el tablero con ceros (0). [X]
    * Coloca aleatoriamente 3 barcos representados por el número 1. [X]
    * (OPCIONAL) Añade el nombre de cada fila y columna, usando para ello las opciones de formato que viste en clase el otro día.
    */
    private final static int TAMANNIO = 5;
    private static int[][] tableroOculto;
    private static char[][] tableroJugador;
    // Códigos de color ANSI
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        tableroOculto = new int[TAMANNIO][TAMANNIO];
        tableroJugador = new char[TAMANNIO][TAMANNIO];
        inicializarTablero();
        inicializarTableroUsuario();
        iniciarBatalla();
    }

    private static void inicializarTablero(){
        int numBarcos = 3;
        Random random = new Random();
        for(int j =0; j < numBarcos;j++){
          boolean colocado =false;
          while(!colocado){
              int fila = random.nextInt(5);
              int columna = random.nextInt(5);
              if(tableroOculto[fila][columna] == 0){
                  tableroOculto[fila][columna] = 1;
                  colocado = true;
              }
          }
        }
    }

    private static void inicializarTableroUsuario(){
        for(int i =0; i < tableroJugador.length;i++){
            for(int x=0; x < tableroJugador[i].length;x++){
                tableroJugador[i][x] = 'ˆ';
            }
        }
    }

    private static void mostrarEncabezado(){
        System.out.print("  "); // Espacio inicial para alinear los índices de las filas
        for (char col = 'A'; col < 'A' + TAMANNIO; col++) {
            System.out.printf(" %c", col);
        }
        System.out.println();
    }
    private static void mostrarTablero() {
        mostrarEncabezado();
        for (int i = 0; i < TAMANNIO; i++) {
            System.out.print(i+ " |");
            for (int x = 0; x < TAMANNIO; x++) {
                if(tableroJugador[i][x] == 'X'){
                    System.out.printf(RED + tableroJugador[i][x] + RESET + "|");
                } else if (tableroJugador[i][x] == '~') {
                    System.out.print(BLUE + tableroJugador[i][x] + RESET + "|");
                }else{
                    System.out.printf(tableroJugador[i][x] + "|");
                }
            }
            System.out.println(" ");
        }
        System.out.println("-----------------------------------");
    }

    private static void mostrarTableroReal() {
        mostrarEncabezado();
        for (int i = 0; i < TAMANNIO; i++) {
            System.out.print(i + " |");
            for (int x = 0; x < TAMANNIO; x++) {
                System.out.print(tableroOculto[i][x] + "|");
            }
            System.out.println(" ");
        }
        System.out.println("-----------------------------------");
    }
/*
   * Juego del usuario:
   * Pide al usuario que introduzca las coordenadas (fila y columna) para intentar "disparar" a un barco.
   * Si acierta, muestra un mensaje como "¡Tocado!" y marca la posición con una X roja.
   * Si falla, muestra "Agua" y marca la posición con un ~  (alt gr + 4) azul.
   * (OPCIONAL) Por supuesto, si quieres adornarlo aún más, eres bienvenido de hacerlo. Lo valoraré positivamente para compensar posibles errores.
   * Condiciones:
   * El usuario tiene un máximo de 10 intentos.
   * Si encuentra los 3 barcos antes de que se acaben los intentos, el juego termina y se muestra "¡Victoria!".
   * Si se agotan los intentos sin encontrar todos los barcos, muestra "Derrota. Los barcos estaban en estas posiciones:" seguido del tablero con las posiciones reveladas.
   *
   * Salida del tablero:
   * Después de cada turno, muestra el tablero actualizado. Solo las posiciones que el usuario ha adivinado deben revelarse.
 */
    public static void iniciarBatalla() {
        iniciarTitulo();
        System.out.println("pulsa enter para comenzar el juego!");
        Scanner scanner = new Scanner(System.in);
        int intentos = 0;
        int barcosAcertados =0;
        boolean esGanador = false;

        while (intentos <= 10 && !esGanador) {
            if(barcosAcertados == 3){
                esGanador =true;
                tituloVictoria();
            }else {
                scanner.nextLine();
                System.out.println(intentos+ " intentos, te quedan " + (10 - intentos) + " intentos");
                System.out.println("-----------------------------------");
                System.out.println("Introduce la coordenadas para disparar");
                int columna = traductorCoordenadas(scanner);
                System.out.println("Elige una fila del 0 al 4");
                int fila = scanner.nextInt();

                //Controlamos que no pueda disparar fuera del tablero
                if (fila < 0 || fila >= TAMANNIO) {
                    System.out.println("Coordenadas fuera de rango. Intenta de nuevo.");
                    continue;
                }

                // Controlar si la celda ya fue disparada
                if (tableroJugador[fila][columna] == 'X' || tableroJugador[fila][columna] == '~') {
                    System.out.println("Ya disparaste en esta posición. Intenta con otra.");
                    continue;
                }

                if (tableroOculto[fila][columna] == 0) {
                    tituloAgua();
                    tableroJugador[fila][columna] = '~';
                    mostrarTablero();
                } else {
                    tituloTocado();
                    tableroJugador[fila][columna] = 'X';
                    barcosAcertados++;
                    mostrarTablero();
                }
                intentos++;
                if(intentos > 10){
                    tituloDerrota();
                    mostrarTableroReal();
                }
            }
        }
        scanner.close();
    }

    private static int traductorCoordenadas(Scanner scanner){
        int columnna=-1;
        boolean filaValida = false;
        while(!filaValida) {
            System.out.println("Elige una columna (A-B-C-D-E)");
            String nombrefila = scanner.nextLine();
            switch (nombrefila.toUpperCase()) {
                case "A":
                    columnna = 0;
                    filaValida = true;
                    break;
                case "B":
                    columnna = 1;
                    filaValida = true;
                    break;
                case "C":
                    columnna = 2;
                    filaValida = true;
                    break;
                case "D":
                    columnna = 3;
                    filaValida = true;
                    break;
                case "E":
                    columnna = 4;
                    filaValida = true;
                    break;
                default:
                    System.out.println("Introduce una columna valida");
                    break;
            }
        }
        return columnna;
    }

    private static void iniciarTitulo(){
        System.out.println("██████╗  █████╗ ████████╗ █████╗ ██╗     ██╗      █████╗     ███╗   ██╗ █████╗ ██╗   ██╗ █████╗ ██╗     ");
        System.out.println("██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██║     ██║     ██╔══██╗    ████╗  ██║██╔══██╗██║   ██║██╔══██╗██║     ");
        System.out.println("██████╔╝███████║   ██║   ███████║██║     ██║     ███████║    ██╔██╗ ██║███████║██║   ██║███████║██║     ");
        System.out.println("██╔══██╗██╔══██║   ██║   ██╔══██║██║     ██║     ██╔══██║    ██║╚██╗██║██╔══██║██║   ██║██╔══██║██║     ");
        System.out.println("██████╔╝██║  ██║   ██║   ██║  ██║███████╗███████╗██║  ██║    ██║ ╚████║██║  ██║╚██████╔╝██║  ██║███████╗");
        System.out.println("╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═╝    ╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝");
    }

    private static void tituloVictoria(){
        System.out.println("██╗   ██╗██╗ ██████╗████████╗ ██████╗ ██████╗ ██╗ █████╗ ");
        System.out.println("██║   ██║██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗██║██╔══██╗");
        System.out.println("██║   ██║██║██║        ██║   ██║   ██║██████╔╝██║███████║");
        System.out.println("╚██╗ ██╔╝██║██║        ██║   ██║   ██║██╔══██╗██║██╔══██║");
        System.out.println(" ╚████╔╝ ██║╚██████╗   ██║   ╚██████╔╝██║  ██║██║██║  ██║");
        System.out.println("  ╚═══╝  ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝╚═╝  ╚═╝");
    }
    private static void tituloDerrota(){
        System.out.println("██████╗ ███████╗██████╗ ██████╗  ██████╗ ████████╗ █████╗");
        System.out.println("██╔══██╗██╔════╝██╔══██╗██╔══██╗██╔═══██╗╚══██╔══╝██╔══██╗");
        System.out.println("██║  ██║█████╗  ██████╔╝██████╔╝██║   ██║   ██║   ███████║");
        System.out.println("██║  ██║██╔══╝  ██╔══██╗██╔══██╗██║   ██║   ██║   ██╔══██║");
        System.out.println("██████╔╝███████╗██║  ██║██║  ██║╚██████╔╝   ██║   ██║  ██║");
        System.out.println("╚═════╝ ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚═╝  ╚═╝");
    }
    private static void tituloAgua(){
        System.out.println(" █████╗  ██████╗ ██╗   ██╗ █████╗ ");
        System.out.println("██╔══██╗██╔════╝ ██║   ██║██╔══██╗");
        System.out.println("███████║██║  ███╗██║   ██║███████║");
        System.out.println("██╔══██║██║   ██║██║   ██║██╔══██║");
        System.out.println("██║  ██║╚██████╔╝╚██████╔╝██║  ██║");
        System.out.println("╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝");
    }

    private static void tituloTocado(){
        System.out.println("████████╗ ██████╗  ██████╗ █████╗ ██████╗  ██████╗");
        System.out.println("╚══██╔══╝██╔═══██╗██╔════╝██╔══██╗██╔══██╗██╔═══██╗");
        System.out.println("   ██║   ██║   ██║██║     ███████║██║  ██║██║   ██║");
        System.out.println("   ██║   ██║   ██║██║     ██╔══██║██║  ██║██║   ██║");
        System.out.println("   ██║   ╚██████╔╝╚██████╗██║  ██║██████╔╝╚██████╔╝");
        System.out.println("   ╚═╝    ╚═════╝  ╚═════╝╚═╝  ╚═╝╚═════╝  ╚═════╝");
    }

}
