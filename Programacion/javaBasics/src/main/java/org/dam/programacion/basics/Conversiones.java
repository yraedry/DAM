package org.dam.programacion.basics;

public class Conversiones {
    /*
    * Ejercicio 7: Conversión entre String y tipos numéricos
    * Objetivo: Practicar la conversión entre tipos de datos numéricos y cadenas (String).
    * Instrucciones:
    * 1. Declara una variable int llamada numero con el valor 42.
    * 2. Convierte numero a una cadena y almacénalo en una variable numeroCadena.
    * 3. Declara una variable String llamada texto con el valor "123".
    * 4. Convierte texto a un número entero y almacénalo en una variable textoEntero.
    * 5. Imprime ambos resultados.
    */
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
