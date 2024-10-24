package org.dam.programacion.basics;

public class Conversiones {
    public static void main(String[] args) {
        int numero = 42;
        String numeroCadena = transformarCadena(numero);
        String texto = "123";
        int textoEntero = transformarEntero(texto);
        System.out.println("El numero transformado a String es " + numeroCadena);
        System.out.println("La cadena transformado a numero es " + textoEntero);
    }

    private static String transformarCadena(int numero){
        return String.valueOf(numero);
    }

    private static int transformarEntero(String texto){
        return Integer.parseInt(texto);
    }
}
