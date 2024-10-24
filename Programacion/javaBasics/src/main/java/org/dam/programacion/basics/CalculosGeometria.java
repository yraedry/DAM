package org.dam.programacion.basics;

public class CalculosGeometria {
    public static void main(String[] args) {
        double ancho = 4.5;
        double alto = 3.2;
        System.out.println("El area del rectangulo es  "+ areaRectangulo(ancho,alto));
        System.out.println("El perimetro del rectangulo es  "+ perimetroRectangulo(ancho,alto));
    }

    private static double areaRectangulo(double ancho, double alto){
        return ancho * alto;
    }

    private static double perimetroRectangulo(double ancho, double alto){
        return 2 * (ancho + alto);
    }
}
