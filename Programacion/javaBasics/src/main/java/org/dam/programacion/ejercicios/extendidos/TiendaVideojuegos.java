package org.dam.programacion.ejercicios.extendidos;

import java.util.Scanner;


/*
 * Desarrolla un programa que administre el inventario de una tienda de videojuegos. El inventario está organizado en una matriz de 3 filas por 3 columnas,
 * donde cada fila representa una categoría de videojuegos y cada columna representa un videojuego disponible en esa categoría.
 * El programa debe ofrecer al usuario un menú interactivo para gestionar el inventario:
 * Funcionalidades:
 * Mostrar el inventario:
 * El programa debe recorrer la matriz e imprimir el inventario en un formato tabular, utilizando colores:

 * Encabezado: Fondo azul y texto blanco.
 * Columnas: Cada columna debe tener un color diferente para el texto (rojo, verde, amarillo).
 * Todos los videojuegos deben mostrarse en minúsculas.
 * Añadir o actualizar un videojuego:
 * El programa permite al usuario elegir una categoría (fila) y un espacio (columna) en el inventario para asignar o reemplazar un videojuego.
 * El nombre del videojuego se debe convertir automáticamente a minúsculas y eliminar los espacios iniciales y finales.

 * Salir del programa:
 * Finaliza el programa.
 */



public class TiendaVideojuegos {

    static final String RESET = "\u001B[0m";
    static final String FONDO_AZUL = "\u001B[44m";
    static final String LETRA_BLANCA = "\u001B[97m";
    static final String LETRA_ROJA = "\u001B[31m";
    static final String LETRA_VERDE = "\u001B[32m";
    static final String LETRA_AMARILLA = "\u001B[33m";

    public static void main(String[] args) {
        String[] categorias = {"Accion", "Deporte", "RPG"};
        String[][] juegos = {{"Call of Duty", "Halo","Battlefield"}, //Accion
                            {"FIFA", "NBA 2K","Madden NFL"}, //Deportes
                            {"Final Fantasy", "Zelda","Skyrim"}}; //RPG
        crearMenu(categorias, juegos);
    }

    public static void crearMenu(String[] categorias, String [][] juegos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(LETRA_BLANCA +"Bienvenido a la tienda de videojuegos");
        while (true) {
            System.out.println(LETRA_BLANCA+"\nSi desea mostrar el inventario pulse 1");
            System.out.println("Si desea añadir o modificar un producto pulse 2");
            System.out.println("Si desea salir de la tienda pulse 3");
            int respuestaUsuario = scanner.nextInt();
            if (respuestaUsuario != 3) {
                switch (respuestaUsuario) {
                    case 1:
                        System.out.println("Has elegido ver el inventario");
                        mostrarInventario(categorias, juegos);
                        break;
                    case 2:
                        System.out.println("Vas a modificar o añadir un videojuego");
                        System.out.println("Si desea añadir un juego pulse 1");
                        System.out.println("Si desea modificar un juego pulse 2");
                        int cambioStock = scanner.nextInt();
                        switch (cambioStock){
                            case 1:

                                break;
                            case 2:
                                modificarJuego(categorias, juegos);
                                break;
                            default:
                                System.out.println("No has elegido ninguna opcion valida, intentalo de nuevo");
                                break;
                        }

                        break;
                    default:
                        System.out.println("No has elegido ninguna opcion valida, intentalo de nuevo");
                        break;
                }
            } else {
                System.out.println("Te echaremos de menos");
                break;
            }
        }
    }
    /*
     * Mostrar el inventario:
     * El programa debe recorrer la matriz e imprimir el inventario en un formato tabular, utilizando colores:
     * Encabezado: Fondo azul y texto blanco.
     * Columnas: Cada columna debe tener un color diferente para el texto (rojo, verde, amarillo).
     * Todos los videojuegos deben mostrarse en minúsculas.
    */
    /*
     * El inventario de la tienda comienza con los siguientes videojuegos:
     *  | Categoría | Videojuego 1 | Videojuego 2 | Videojuego 3 |
     *  |--------------------|--------------------|-----------------|-------------------|
     *  | Acción | Call of Duty | Halo | Battlefield |
     *  | Deportes | FIFA | NBA 2K | Madden NFL |
     *   | RPG | Final Fantasy | Zelda | Skyrim |
     */
    public static void mostrarInventario(String[] categorias, String [][] juegos){
     System.out.printf(FONDO_AZUL+"| %-10s | %-10s | %-10s | %-10s | %n"+RESET, "Categoria", "Videojuego", "Videojuego 2", "Videojuego 3");
     System.out.printf(FONDO_AZUL+"| %-10s | %-10s | %-10s | %-10s | %n"+RESET,"------------","------------","------------","------------");
     for(int i = 0; i < juegos.length; i++){
         switch (categorias[i]){
             case "Accion":
                 System.out.printf(LETRA_ROJA + "| %-10s |", categorias[i]);
                 break;
             case "Deporte":
                 System.out.printf(LETRA_VERDE + "%n| %-10s |", categorias[i]);
                 break;
             case "RPG":
                 System.out.printf(LETRA_AMARILLA + "%n| %-10s |", categorias[i]);
                 break;
         }
         for(int x =0; x < juegos.length; x++){
             System.out.printf(" %-10s |",juegos[i][x].toLowerCase());
         }
     }
    }

    /*
    * El programa permite al usuario elegir una categoría (fila) y un espacio (columna) en el inventario para asignar o reemplazar un videojuego.
    * El nombre del videojuego se debe convertir automáticamente a minúsculas y eliminar los espacios iniciales y finales.
    */
    public static void modificarJuego(String[]categorias, String [][] juegos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nElige una categoría:");
        for (int i = 0; i < categorias.length; i++) {
            System.out.printf("%d. %s%n", i + 1, categorias[i]);
        }
        int categoriaSeleccionada = scanner.nextInt() - 1;
        System.out.printf("Elige un espacio (1-%d): ", juegos[categoriaSeleccionada].length);
        int espacioSeleccionado = scanner.nextInt() - 1;

        System.out.println("Introduce el nombre del videojuego:");
        scanner.nextLine(); // Limpiar el buffer
        String videojuego = scanner.nextLine().trim().toLowerCase();

        juegos[categoriaSeleccionada][espacioSeleccionado] = videojuego;

        System.out.println("¡Videojuego asignado con éxito!");
    }
}
