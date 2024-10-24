package org.dam.programacion.basics;

public class CasteoDatos {
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
