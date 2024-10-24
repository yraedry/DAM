package org.dam.programacion.basics;

public class Conversiones {
    public static void main(String[] args) {
        int numero = 42;
        String numeroCadena = String.valueOf(numero);
        String texto = "123";
        int textoEntero = Integer.parseInt(texto);
        System.out.println("El numero transformado a String es " + numeroCadena);
        System.out.println("La cadena transformado a numero es " + textoEntero);
    }
}
