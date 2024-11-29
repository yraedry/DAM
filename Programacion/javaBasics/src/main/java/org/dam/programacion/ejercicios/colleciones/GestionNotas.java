package org.dam.programacion.ejercicios.colleciones;

import java.util.Scanner;

public class GestionNotas {
    public static void main(String[] args) {
        String[] estudiante = {"Andres Mateu", "Mar Beamud", "Luis Miguel Richard"};
        double[][] notasProgramacion = {{4.00, 4.50, 3.80, 4.20, 3.50}, {8.00, 7.50, 9.00, 8.30, 8.00}, {7.00, 6.50, 7.50, 6.80, 7.50}};
        double[][] notasEntornosDesarrollo = {{4.5, 3.0, 4.8, 4.0}, {7.5, 8.2, 7.8, 8.5}, {6.5, 7.0, 7.5, 6.8}};
        final String ROJO = "\u001B[31m";
        final String RESET = "\u001B[0m";

        Scanner scanner = new Scanner(System.in);
        int opciones;
        do {
            System.out.println("Menú principal");
            System.out.println("1. Ver notas de Programación\n" +
                    "2. Ver notas de Entornos de Desarrollo\n" +
                    "3. Salir");
            opciones = scanner.nextInt();
            if (opciones == 3) {
                System.out.println("Saliendo del programa");
                break;
            } else {
                while (true) {
                    String asignatura = null;
                    double[][] notas = null;
                    if (opciones == 1) {
                        asignatura = "programacion";
                        System.out.println("Has entrado a ver las notas de programacion");
                        notas = notasProgramacion;
                    } else if(opciones == 2){
                        asignatura = "entornosDesarrollo";
                        System.out.println("Has entrado a ver las notas de Entornos de Desarrollo");
                        notas = notasEntornosDesarrollo;
                    }
                    System.out.println("Que desea hacer");
                    System.out.println("1. Ver notas\n" +
                            "2. Cambiar nota\n" +
                            "3. Mostrar nota final\n" +
                            "4. Salir al menu principal");
                    int opcionesAsignatura = scanner.nextInt();
                    if (opcionesAsignatura == 1) {
                        System.out.println("Has elegido ver notas");

                        //Para mostrar el encabezado
                        for (int x = 0; x < estudiante.length; x++) {
                            System.out.printf("%-20s", estudiante[x]);
                        }
                        System.out.println();

                        //para obtener el maximo de notas y mostrarlas todas
                        int maxNotas = 0;
                        for (double[] estudianteNotas : notas) {
                            if (estudianteNotas.length > maxNotas) {
                                maxNotas = estudianteNotas.length;
                            }
                        }

                        //mostramos las notas en formator tabular
                        for (int fila = 0; fila < maxNotas; fila++) {
                            for (int columna = 0; columna < notas.length; columna++) {
                                if (fila < notas[columna].length) {
                                    if(notas[columna][fila]  < 5){
                                        System.out.printf(ROJO + "%-20.2f"+ RESET, notas[columna][fila]);
                                    }else {
                                        System.out.printf("%-20.2f", notas[columna][fila]);
                                    }
                                }else{
                                    System.out.printf("%-20s", "");
                                }
                            }
                            System.out.println();
                        }
                    } else if (opcionesAsignatura == 2) {
                        System.out.println("Has elegido cambiar la nota");
                        System.out.println("Elige el indice del estudiante (1-3)");
                        int indiceEstudiante = scanner.nextInt();
                        System.out.println("Elige el indice de la nota (1-5)");
                        int indiceNota = scanner.nextInt() + 1;
                        System.out.println("Introduce la nueva nota");
                        double nuevaNota = scanner.nextDouble();
                        notas[indiceEstudiante][indiceNota] = nuevaNota;
                        System.out.println("¡Nota actualizada correctamente!");
                    } else if (opcionesAsignatura == 3) {
                        System.out.println("Has elegido mostrar la nota final");
                        for (int x = 0; x < notas.length; x++) {
                            System.out.print(estudiante[x] + ": ");
                            double notaFinal=0;
                            double mediaEntregas;
                            if(asignatura.equalsIgnoreCase("programacion")){
                                mediaEntregas = (notas[x][0] + notas[x][1] + notas[x][2] + notas[x][3]) / 4;
                                notaFinal = (mediaEntregas * 0.6) + (notas[x][4] * 0.4);

                            }else if(asignatura.equalsIgnoreCase("entornosDesarrollo")){
                                mediaEntregas = (notas[x][0] + notas[x][1] + notas[x][2]) / 3;
                                notaFinal = (mediaEntregas * 0.6) + (notas[x][3] * 0.4);

                            }
                            System.out.print(notaFinal);
                            System.out.println();
                        }
                    } else if (opcionesAsignatura == 4) {
                        System.out.println("Salir al menu principal");
                        break;
                    } else {
                        System.out.println("Porfavor, elige una opcion valida");
                    }
                }
            }
        } while (opciones != 3);
    }
}
