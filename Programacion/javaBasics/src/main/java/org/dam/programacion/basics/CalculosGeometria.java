package org.dam.programacion.basics;

public class CalculosGeometria {
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
