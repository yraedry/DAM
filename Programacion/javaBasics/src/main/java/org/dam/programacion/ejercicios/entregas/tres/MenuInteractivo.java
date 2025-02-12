package org.dam.programacion.ejercicios.entregas.tres;

import java.util.InputMismatchException;
import java.util.Scanner;

/* Menu Interactivo
 * @author adrian nuñez sanchez
 *
 * Diseña un programa que muestre un menú interactivo con tres opciones:
 * Saludar
 * Despedirse
 * Salir
 * El programa debe permitir al usuario elegir una opción y responder en consecuencia (por ejemplo, “¡Hola!” o “Adiós”).
 * Este menú debe seguir apareciendo hasta que el usuario seleccione la opción “Salir”.
 * Si el usuario selecciona una opción inválida, el programa debe mostrar un mensaje de error e invitar a elegir nuevamente.
 */
public class MenuInteractivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        incializarMenu(scanner);
        scanner.close();
    }
    /**
     * metodo para realizar un menu interactivo
     * @param scanner inicalizacion del objeto Scanner
     */
    private static void incializarMenu(Scanner scanner){
        int entradaUsuario;
        System.out.println("Bienvenido al menu interactivo!!!!");

        while(true){
            System.out.println("Tienes tres opciones para elegir:");
            System.out.println("Puedes saludar pulsando 1");
            System.out.println("Puedes despedirte pulsando 2");
            System.out.println("Puedes salir de este menu pulsando 3");
            System.out.println("Que deseas hacer?");
            try {
                entradaUsuario = scanner.nextInt();
                if(entradaUsuario == 3) {
                    System.out.println("Te echaremos de menos, saliendo del menu....");
                    break;
                }else if(entradaUsuario != 1 && entradaUsuario != 2){
                    System.out.println("No has elegido una opcion valida, intentalo de nuevo!!");
                }else{
                    switch (entradaUsuario) {
                        case 1:
                            System.out.println("Hola jugador!!!!\n");
                            break;
                        case 2:
                            System.out.println("Adios jugador!!!!\n");
                            break;
                    }
                }
            }catch (InputMismatchException ex) {
                System.out.println("No has introducido una opcion valida, porfavor introduce una opcion valida para continuar.");
                scanner.nextLine();
            }
        }
    }
}
