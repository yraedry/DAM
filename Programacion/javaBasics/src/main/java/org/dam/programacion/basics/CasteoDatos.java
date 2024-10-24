package org.dam.programacion.basics;

public class CasteoDatos {
    /*
     * Ejercicio 3: Conversión de tipos de datos
     * Objetivo: Practicar la conversión de tipos de datos (casting).
     * Instrucciones:
     * 1. Declara una variable double llamada precio con el valor 19.99.
     * 2. Convierte precio a un entero (int) y almacena el resultado en una variable precioEntero.
     * 3. Imprime ambos valores (el original y el convertido).
     */
    public static void main(String[] args) {
        double precio = 19.99;
        System.out.println("El valor de la variable int es: " + generarInt(precio));
        System.out.println("El valor de la variable double es: " + precio);
    }

    /**
     * metodo para generar un numero de tipo int entre el 0 y 100
     * @param precio variable a castear
     * @return retorna un numero en int
     */
    private static int generarInt(double precio){
        return (int) precio;
    }

}
