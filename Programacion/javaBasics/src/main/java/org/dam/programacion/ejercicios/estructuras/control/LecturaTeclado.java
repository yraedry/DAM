package org.dam.programacion.ejercicios.estructuras.control;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class LecturaTeclado {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in) ;
        try {
            numAlumnos(entrada);
            //limpiamos el buffer
            entrada.nextLine();
            nombreCompleto(entrada);
            notaMedia(entrada);
        }catch(NoSuchElementException e){
            System.out.println("No se proporcionó la entrada esperada.");
        }
        //cerramos el objeto scanner
        entrada.close();

    }

    private static void numAlumnos(Scanner entrada){
        try {
            System.out.println("Cuantos alumnos sois en clase?");
            int alumnos = entrada.nextInt();
            System.out.println("Somos " + alumnos + " en clase");
        } catch (NoSuchElementException e) {
            System.out.println("No se proporcionó la entrada esperada.");
        }
    }

    private static void nombreCompleto(Scanner entrada){
        try {
            System.out.println("Cual es tu nombre completo?");
            String nombreCompleto = entrada.nextLine();
            System.out.println("Mi nombre es " + nombreCompleto);
        } catch (NoSuchElementException e) {
            System.out.println("No se proporcionó la entrada esperada.");
        }

    }

    private static void notaMedia(Scanner entrada){
        try {
            System.out.println("Cual fue la nota media que obtuviste en la ESO?");
            double notaMedia = entrada.nextDouble();
            System.out.println("La nota media es la ESO fue " + notaMedia);
        } catch (NoSuchElementException e) {
            System.out.println("No se proporcionó la entrada esperada.");
        }
    }
}
