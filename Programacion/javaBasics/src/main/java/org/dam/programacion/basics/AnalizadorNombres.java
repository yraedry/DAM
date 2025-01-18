package org.dam.programacion.basics;

import java.util.Scanner;

public class AnalizadorNombres {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final String ROJO = "\u001B[31m";
        final String AZUL = "\u001B[34m";
        final String RESET = "\u001B[0m";
        while (true) {
            System.out.println("Introduce un nombre, ya sea en mayusculas o minusculas");
            String nombre = scanner.nextLine();

            boolean esMinusculas = false;
            boolean tieneEspacios = false;
            if (nombre.equals(nombre.toUpperCase())) {
                System.out.println("El nombre esta en mayusculas");
            } else if (nombre.equals(nombre.toLowerCase())) {
                esMinusculas = true;
                System.out.println("El nombre esta en minusculas");
            } else {
                System.out.println("No has cumplido con los requerimientos");
            }
            if (!nombre.equals(nombre.trim())) {
                tieneEspacios = true;
                System.out.println("El nombre tiene espacios");
            }

            if (esMinusculas && !tieneEspacios) {
                System.out.println(AZUL + nombre.length());
                break;
            } else {
                System.out.println(ROJO + "no has cumplido los requisitos" + RESET);
            }
        }
    }
}