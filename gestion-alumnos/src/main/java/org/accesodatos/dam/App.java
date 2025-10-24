package org.accesodatos.dam;

import org.accesodatos.dam.services.AlumnoOperationService;
import jakarta.xml.bind.JAXBException;

import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws JAXBException {
        AlumnoOperationService alumnoOperationService = new AlumnoOperationService();
        int opcion;
        do {
            System.out.println("\n===== MENÚ DE GESTIÓN DE ALUMNOS =====");
            System.out.println("1. Dar de alta un alumn@ (expediente, nombre y apellidos)");
            System.out.println("2. Dar de baja un alumn@ (por expediente)");
            System.out.println("3. Insertar una nota a un alumn@ (por expediente)");
            System.out.println("4. Modificar la nota de un alumn@");
            System.out.println("5. Consultar la nota de un alumn@ (por expediente)");
            System.out.println("6. Consultar todas las notas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> darAlta(alumnoOperationService);
                case 2 -> darBaja(alumnoOperationService);
                case 3 -> insertarNota(alumnoOperationService);
                case 4 -> modificarNota(alumnoOperationService);
                case 5 -> consultarNota(alumnoOperationService);
                case 6 -> consultarTodas(alumnoOperationService);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }


    private static void darAlta(AlumnoOperationService alumnoOperationService) throws JAXBException {
        System.out.print("Expediente: ");
        int expediente = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellidos: ");
        String apellido = sc.nextLine();
        alumnoOperationService.altaAlumno(nombre, apellido, expediente);
    }

    private static void darBaja(AlumnoOperationService alumnoOperationService) throws JAXBException {
        System.out.print("Expediente: ");
        int expediente = sc.nextInt();
        sc.nextLine();
        alumnoOperationService.eliminarAlumno(expediente);
    }

    private static void insertarNota(AlumnoOperationService alumnoOperationService) throws JAXBException {
        System.out.print("Expediente: ");
        int expediente = sc.nextInt();
        System.out.print("Nota: ");
        double nota = sc.nextDouble();
        sc.nextLine();
        alumnoOperationService.insertarNota(expediente, nota);
    }

    private static void modificarNota(AlumnoOperationService alumnoOperationService) throws JAXBException {
        System.out.print("Expediente: ");
        int expediente = sc.nextInt();
        System.out.print("Nota: ");
        double nota = sc.nextDouble();
        sc.nextLine();
        alumnoOperationService.actualizarNota(expediente, nota);
    }

    private static void consultarNota(AlumnoOperationService alumnoOperationService) throws JAXBException {
        System.out.print("Expediente: ");
        int expediente = sc.nextInt();
        sc.nextLine();
        alumnoOperationService.consultarNota(expediente);
    }

    private static void consultarTodas(AlumnoOperationService alumnoOperationService) throws JAXBException {
        alumnoOperationService.consultarNotas();
    }
}