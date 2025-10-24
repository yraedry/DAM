package org.accesodatos.dam;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Supermercado {
    private static final String PATH = "supermercado/src/main/resources/";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Supermercado app = new Supermercado();
        Path path = app.crearFichero();
        File file = new File(path.toString());
        try {
            if (file.createNewFile()) {
                System.out.println("El fichero se creo correctamente por lo que no hay datos para leer");
                app.addDatos(path);
                System.out.println("Se han creado los datos correctamente el contenido del fichero es ");
                app.leerFichero(path);
            } else {
                System.out.println("Fichero ya esta creado y su contenido es ");
                app.leerFichero(path);
            }

        } catch (IOException e) {
            System.err.println("Error en el procedimiento " + e);
        }

    }
    private void addDatos(Path path) {
        try {
            boolean continuar = Boolean.TRUE;
            int cont  = 1;
            do {
                Files.writeString(path, "Usuario " + cont +  System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                Files.writeString(path, "-------  " + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Introduzca un nombre");
                var nombre = sc.nextLine();
                Files.writeString(path, "nombre: "+ nombre + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Introduzca un precio");
                var precio = sc.nextLine();
                Files.writeString(path, "precio: " + precio + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Introduzca una cantidad");
                var cantidad = sc.nextLine();
                Files.writeString(path, "cantidad: " + cantidad + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                System.out.println("Desea añadir mas productos? Escribe si o no");
                var respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("no")) {
                    continuar = Boolean.FALSE;
                }
                cont++;
            } while (continuar);
        } catch (IOException e) {
            System.err.println("Error al añadir datos " + e);
        }
    }

    private Path crearFichero() {
        System.out.println("Introduce el nombre del fichero que quieras crear o al que quieras acceder");
        String nombreFichero = sc.nextLine();
        System.out.println("Introduce la extension del fichero");
        String extensionFichero = sc.nextLine();
        System.out.println("el fichero es " + nombreFichero + "." + extensionFichero);
        File file = new File(PATH + nombreFichero + "." + extensionFichero);
        return file.toPath();
    }

    private void leerFichero(Path path) {
        try {
            List<String> lineas = Files.readAllLines(path, StandardCharsets.UTF_8);
            lineas.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error al leer el fichero "  +e);
        }
    }
}
