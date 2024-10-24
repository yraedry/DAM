package org.dam.programacion.basics;


public class NumerosAleatorios {

    public static void main(String[] args) {
        
        System.out.println("El valor de la variable byte es: " + generarByte());
        System.out.println("El valor de la variable short es: " + generarShort());
        System.out.println("El valor de la variable int es: " + generarInt());
        System.out.println("El valor de la variable long es: " + generarLong());
        System.out.println("El valor de la variable float es: " + generarFloat());
        System.out.println("El valor de la variable double es: " + generarDouble());

    }

    /**
     * metodo para generar un numero de tipo byte entre el 0 y 100
     * @return retorna un numero en byte
     */
    private static byte generarByte(){
        return (byte) (Math.random() * 100);
    }

    /**
     * metodo para generar un numero de tipo short entre el 0 y 100
     * @return retorna un numero en short
     */
    private static short generarShort(){
        return (short) (Math.random() * 100);
    }

    /**
     * metodo para generar un numero de tipo int entre el 0 y 100
     * @return retorna un numero en int
     */
    private static int generarInt(){
        return (int) (Math.random() * 100);
    }

    /**
     * metodo para generar un numero de tipo long entre el 0 y 100
     * @return retorna un numero en long
     */
    private static long generarLong(){
        return (long) (Math.random() * 100);
    }

    /**
     * metodo para generar un numero de tipo float entre el 0 y 100
     * @return retorna un numero en float
     */
    private static float generarFloat(){
        return (float) (Math.random() * 100);
    }

    /**
     * metodo para generar un numero de tipo double entre el 0 y 100
     * @return retorna un numero en double
     */
    private static double generarDouble(){
        return (Math.random() * 100);
    }
}