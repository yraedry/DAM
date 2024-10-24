package org.dam.programacion.basics;

public class CalculosGeometria {
    /*
    * Ejercicio 8: Cálculo de área y perímetro de un rectángulo
    * Objetivo: Practicar la declaración de variables y realizar operaciones matemáticas simples.
    * Instrucciones:
    * 1. Declara dos variables double llamadas ancho y alto con los valores 4.5 y 3.2 respectivamente.
    * 2. Calcula el área (ancho * alto) y el perímetro (2 * (ancho + alto)) del rectángulo.
    * 3. Imprime los resultados.
    */
    public static void main(String[] args) {
        double ancho = 4.5;
        double alto = 3.2;
        System.out.println("El area del rectangulo es  "+ areaRectangulo(ancho,alto));
        System.out.println("El perimetro del rectangulo es  "+ perimetroRectangulo(ancho,alto));
    }
    /**
     * metodo para obtener el area de un rectangulo
     * @param ancho ancho del rectangulo
     * @param alto alto del rectangulo
     * @return retorna el area de un rectangulo
     */
    private static double areaRectangulo(double ancho, double alto){
        return ancho * alto;
    }
    /**
     * metodo para obtener el perimetro de un rectangulo
     * @param ancho ancho del rectangulo
     * @param alto alto del rectangulo
     * @return retorna el perimetro de un rectangulo
     */
    private static double perimetroRectangulo(double ancho, double alto){
        return 2 * (ancho + alto);
    }
}
