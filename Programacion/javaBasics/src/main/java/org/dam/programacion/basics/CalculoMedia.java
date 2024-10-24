package org.dam.programacion.basics;

public class CalculoMedia {
    /*
    *Ejercicio 10: Cálculo de la media de tres números
    * Objetivo: Practicar operaciones matemáticas básicas.
    * Instrucciones:
    * 1. Declara tres variables double llamadas num1, num2, y num3 con los valores 8.5, 6.7, y 9.3 respectivamente.
    * 2. Calcula la media de estos tres números.
    * 3. Imprime el resultado.
    */
    public static void main(String[] args) {
        double num1 = 8.5;
        double num2 = 6.7;
        double num3 = 9.3;

        double media = calculoMedia(num1, num2, num3);
        System.out.println(media);
    }
    /**
     * metodo para obtener la media de tres numeros
     * @param num1 primer numero
     * @param num2 segundo numero
     * @param num3 tercer numero
     * @return retorna la media
     */
    private static double calculoMedia(double num1, double num2, double num3){
        return (num1 + num2 + num3) /3;
    }
}
