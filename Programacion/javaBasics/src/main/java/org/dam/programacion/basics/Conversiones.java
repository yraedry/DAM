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

    /**
     * metodo para transformar un  numero entero en una cadena
     * @param numero numero
     * @return retorna el numero como cadena
     */
    private static String transformarCadena(int numero){
        return String.valueOf(numero);
    }
    /**
     * metodo para transformar una cadena en un numero entero
     * @param texto numero
     * @return retorna la cadena como un numero entero
     */
    private static int transformarEntero(String texto){
        return Integer.parseInt(texto);
    }
}
