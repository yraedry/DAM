import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ColeccionesDinamicas {
    public static void main(String[] args) {
        ColeccionesDinamicas app = new ColeccionesDinamicas();
        app.crearMenu();
    }

    private void crearMenu(){
        System.out.println("Bienvenido a la gestion de ciudades");
        Scanner sc = new Scanner(System.in);
        var salidaBucle  = true;
        ArrayList<String> ciudades = new ArrayList<>();
        while(salidaBucle){
            pintarMenu();
            var opcion = 0;
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingresa un numero valido");
                sc.nextLine();
                continue;
            }
            switch(opcion) {
                case 1 -> agregarCiudad(sc, ciudades);
                case 2 -> eliminarCiudad(sc, ciudades);
                case 3 -> mostrarCiudades(ciudades);
                case 4 -> buscarCiudad(sc, ciudades);
                case 5 -> salidaBucle = false;
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    private void pintarMenu(){
        System.out.println("Que deseas hacer?");
        System.out.println("1. Agregar una ciudad");
        System.out.println("2. Eliminar una ciudad");
        System.out.println("3. Mostrar todas las ciudades");
        System.out.println("4. Buscar una ciudad");
        System.out.println("5. Salir");
    }

    private void agregarCiudad(Scanner sc, ArrayList<String> ciudades){
        System.out.println("Ingresa el nombre de la ciudad");
        var nombre = sc.next().toLowerCase();
        if(ciudades.contains(nombre)){
            System.out.println("La ciudad ya existe, no se permiten ciudades duplicadas");
        }else{
            ciudades.add(nombre);
        };
    }

    private void mostrarCiudades(ArrayList<String> ciudades){
        if(!ciudades.isEmpty()) {
            System.out.println("Las ciudades son:");
            for (String ciudad : ciudades) {
                System.out.println(ciudad);
            }
        }else{
            System.out.println("No hay ciudades que mostrar");
        }
    }

    private void buscarCiudad(Scanner sc, ArrayList<String> ciudades){
        System.out.println("Ingresa el nombre de la ciudad");
        var nombre = sc.next().toLowerCase();
        if(ciudades.contains(nombre)){
            System.out.println("La ciudad " + nombre  + " ya existe en la lista");
        }else{
            System.out.println("La ciudad " + nombre  + " no existe en la lista");
        }
    }

    private void eliminarCiudad(Scanner sc, ArrayList<String> ciudades){
        System.out.println("Ingresa el nombre de la ciudad");
        var nombre = sc.next().toLowerCase();
        if(ciudades.contains(nombre)){
            ciudades.remove(nombre);
            System.out.println("La ciudad " + nombre  + " se ha eliminado correctamente");
        }else{
            System.out.println("La ciudad " + nombre  + " no existe en la lista y no se puede eliminar");
        }
    }
}
