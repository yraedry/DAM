package org.dam.programacion.basics;

import java.util.Random;
import java.util.Scanner;

public class BuscaMazapanes {
    public static void main(String[] args) {
        /*
        * Crea un programa que permita al usuario encontrar 3 mazapanes escondidos
        en un tablero de 4x4. Las posiciones las decides tú, estudiante. El usuario
        tiene hasta 8 intentos, si para entonces no lo consigue, deséale unas felices
        fiestas. Asegúrate de avisar al usuario de lo que pasa con sus tiradas y
        presentarle el programa. ¡EXTRA!: Si eres capaz de hacer que las posiciones
        sean completamente aleatorias (sin repetirse), tendrás hasta medio punto
        extra en tu examen (sin superar nunca el 10).*/

        int[][] tablero = new int[4][4];

        int mazapanes = 0;
        int intentos = 0;
        Random random = new Random();
        while(mazapanes < 3) {
            int columna = random.nextInt(4);
            int fila = random.nextInt(4);
            if (tablero[columna][fila] == 0) {
                tablero[columna][fila] = 1;
                mazapanes++;
            }
        }
        Scanner scanner = new Scanner(System.in);
        while(intentos < 8){
            if(mazapanes == 0){
                System.out.println("Enhorabuena, Has encontrado todos los mazapanes");
            }
            System.out.println("Introduce la columna");
            int columna = scanner.nextInt();

            System.out.println("Introduce la fila");
            int fila = scanner.nextInt();

            if(fila<0||columna<0||fila>3||columna>3){
                System.out.println("tirada fuera del tablero");
                continue;
            }
            if(tablero[columna][fila] == 1){
                System.out.println("Has encontrado el mazapan");
                tablero[columna][fila] = 0;
                mazapanes--;
                intentos++;
            }else{
                System.out.println("No has encontrado el mazapan");
                intentos++;
            }
            if(intentos == 8){
                System.out.println("Lo siento, tus intentos han terminado, no has encontrado los mazapanes");

            }
        }
    }
}
