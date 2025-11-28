package concesionario;

import concesionario.dto.Coche;
import concesionario.service.ConcesionarioService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConcesionarioService service = new ConcesionarioService();
        boolean salir = false;

        System.out.println("--- CONCESIONARIO UAX (Hibernate) ---");

        while (!salir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Dar de alta un coche nuevo.");
            System.out.println("2. Vender un coche a un cliente.");
            System.out.println("3. Ver coches disponibles.");
            System.out.println("4. Ver coches vendidos.");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            if (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Inténtalo de nuevo.");
                sc.nextLine();
                continue;
            }
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Marca: "); String marca = sc.nextLine();
                    System.out.print("Modelo: "); String modelo = sc.nextLine();
                    System.out.print("Año: "); int anio = sc.nextInt();
                    System.out.print("Precio: "); double precio = sc.nextDouble();
                    sc.nextLine();

                    Coche nuevo = new Coche(marca, modelo, anio, precio);
                    service.altaCoche(nuevo);
                    System.out.println("Coche '" + marca + " " + modelo + "' dado de alta (DISPONIBLE).");
                    break;

                case 2:
                    List<Coche> disponibles = service.getCochesDisponibles();
                    if (disponibles.isEmpty()) {
                        System.out.println("No hay coches disponibles para la venta.");
                        break;
                    }

                    System.out.println("\n--- COCHES DISPONIBLES ---");
                    disponibles.forEach(c -> System.out.println(c.getId() + ". " + c.getMarca() + " " + c.getModelo() + " - " + c.getPrecio() + "€"));
                    System.out.print("Introduce el ID del coche a vender: ");

                    Long cocheId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Nombre del Cliente: "); String nombreCliente = sc.nextLine();
                    System.out.print("DNI del Cliente: "); String dniCliente = sc.nextLine();

                    if (service.venderCoche(cocheId, dniCliente, nombreCliente)) {
                        System.out.println("¡Venta realizada con éxito! El coche ha sido asignado al cliente " + nombreCliente + ".");
                    } else {
                        System.out.println("ERROR: El ID del coche no es válido o ya ha sido vendido.");
                    }
                    break;

                case 3:
                    List<Coche> listaDisp = service.getCochesDisponibles();
                    System.out.println("\n--- STOCK DISPONIBLE (" + listaDisp.size() + " unidades) ---");
                    if(listaDisp.isEmpty()) System.out.println("Stock vacío.");
                    else listaDisp.forEach(System.out::println);
                    break;

                case 4:
                    List<Coche> listaVend = service.getCochesVendidos();
                    System.out.println("\n--- COCHES VENDIDOS (" + listaVend.size() + " unidades) ---");
                    if(listaVend.isEmpty()) System.out.println("No hay ventas registradas.");
                    else listaVend.forEach(System.out::println);
                    break;

                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
        System.out.println("Aplicación cerrada. ¡Hasta pronto!");
    }
}