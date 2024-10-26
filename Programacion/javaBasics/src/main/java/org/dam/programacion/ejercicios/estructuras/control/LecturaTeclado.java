package org.dam.programacion.ejercicios.estructuras.control;

import java.util.Scanner;

public class LecturaTeclado {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in) ;
        numAlumnos(entrada);
        //limpiamos el buffer
        entrada.nextLine();
        nombreCompleto(entrada);
        notaMedia(entrada);
        //cerramos el objeto scanner
        entrada.close();
    }

    private static void numAlumnos(Scanner entrada){
        System.out.println("Cuantos alumnos sois en clase?");
        int alumnos = entrada.nextInt();
        System.out.println("Somos " + alumnos + " en clase");
    }

    private static void nombreCompleto(Scanner entrada){
        System.out.println("Cual es tu nombre completo?");
        String nombreCompleto = entrada.nextLine();
        System.out.println("Mi nombre es " + nombreCompleto);
    }

    private static void notaMedia(Scanner entrada){
        System.out.println("Cual fue la nota media que obtuviste en la ESO?");
        double notaMedia = entrada.nextDouble();
        System.out.println("La nota media es la eso fue " + notaMedia);
    }
}
