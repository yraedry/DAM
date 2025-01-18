package org.dam.programacion.basics;
import java.util.Scanner;

public class ListaCompra {
    public static void main(String[] args) {

        final String ROJO = "\u001B[31m";
        final String AZUL = "\u001B[34m";
        final String RESET = "\u001B[0m";

        String[] listaInventario = new String[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la tienda tiene que introducir 5 elementos en la lista");
        int totalInventario = 0;
        while(totalInventario < 5){
            System.out.println("Introduce los valores valor");
            String elemento = scanner.nextLine();
            listaInventario[totalInventario] = elemento;
            totalInventario++;
            System.out.println("valor introducido correctamente");
        }

        for(int x = 0; x < listaInventario.length; x++){
            if(x < 4){
                System.out.println(AZUL + listaInventario[x]);
            }else{
                System.out.println(ROJO + listaInventario[x] + RESET);
            }
        }

        System.out.println("Feliz compra!!!");

    }
}
