package org.dam.programacion;

import java.util.Scanner;

public class ComprobarParesImpares {
    public static void main(String[] args) {
        System.out.println(comprobarNumeros());
    }

    /**
     * metodo para introducir un numero hasta el 999999999 y comprobar si es par o impar
     * @return retorna una cadena indicando si el numero es par o impar
     */
    private static String comprobarNumeros(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        String resultado;
        int numero = entrada.nextInt();
        if (comprobarPar(numero)) {
           resultado = "El numero " + numero + " es par";
        } else {
            resultado = "El numero " + numero + " es impar";
        }
        return resultado;
    }

    /**
     * Metodo para comprobar si el numero es par o impar
     * @param numero numero entero a comprobar
     * @return devuelve si el numero es par o impar con true o false
     */
    private static boolean comprobarPar(int numero){
        return numero % 2 == 0;
    }
}