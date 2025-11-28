import concesionario.controller.GestorJSON;
import concesionario.dto.Coche;
import concesionario.service.GestorBD;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorJSON gestorJSON = new GestorJSON();
        GestorBD gestorBD = new GestorBD();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- CONCESIONARIO UAX S.L. ---");
            System.out.println("1. Dar de alta un coche nuevo (JSON)");
            System.out.println("2. Vender un coche (Mover de JSON a BD)");
            System.out.println("3. Ver coches disponibles (JSON)");
            System.out.println("4. Ver coches vendidos (BD)");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Marca: "); String marca = sc.nextLine();
                    System.out.print("Modelo: "); String modelo = sc.nextLine();
                    System.out.print("Año: "); int anio = sc.nextInt();
                    System.out.print("Precio: "); double precio = sc.nextDouble();

                    // Creamos el objeto usando el constructor generado por Lombok
                    Coche nuevo = new Coche(marca, modelo, anio, precio);
                    gestorJSON.agregarCoche(nuevo);
                    System.out.println("Coche guardado en disponibles.");
                    break;

                case 2:
                    List<Coche> disponibles = gestorJSON.leerCoches();
                    if (disponibles.isEmpty()) {
                        System.out.println("No hay coches para vender.");
                        break;
                    }

                    System.out.println("Selecciona el número del coche a vender:");
                    for (int i = 0; i < disponibles.size(); i++) {
                        // Usamos el toString() generado por Lombok
                        System.out.println(i + ". " + disponibles.get(i));
                    }

                    int index = sc.nextInt();
                    sc.nextLine();

                    if (index >= 0 && index < disponibles.size()) {
                        Coche cocheVendido = disponibles.get(index);

                        System.out.print("Nombre del Cliente: "); String cliente = sc.nextLine();
                        System.out.print("DNI del Cliente: "); String dni = sc.nextLine();

                        gestorBD.registrarVenta(cocheVendido, cliente, dni);

                        disponibles.remove(index);
                        gestorJSON.guardarCoches(disponibles);

                        System.out.println("Operación de venta finalizada.");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 3:
                    List<Coche> lista = gestorJSON.leerCoches();
                    if(lista.isEmpty()) System.out.println("No hay stock.");
                    else lista.forEach(System.out::println);
                    break;

                case 4:
                    gestorBD.verVentas();
                    break;

                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}