package org.dam.programacion.basics;

public class OperadoresLogicos {
    /*
    * Ejercicio 6: Operadores lógicos
    * Objetivo: Practicar el uso de operadores lógicos.
    * Instrucciones:
    * 1. Declara dos variables booleanas esAdulto con el valor true y esEmpleado con el valor false.
    * 2. Realiza las siguientes operaciones lógicas e imprime los resultados:
    * - esAdulto && esEmpleado (AND lógico)
    * - esAdulto || esEmpleado (OR lógico)
    * - !esAdulto (NOT lógico)
    */
    public static void main(String[] args) {
        boolean esAdulto = true;
        boolean esEmpleado = false;
        operacionAnd(esAdulto, esEmpleado);
        operacionOr(esAdulto, esEmpleado);
        operacionNot(esAdulto);
    }
    /**
     * metodo para comprobar el and de un if
     * @param esAdulto primer valor a comprobar
     * @param esEmpleado segundo valor a comprobar
     */
    private static void operacionAnd(boolean esAdulto, boolean esEmpleado){
        if(esAdulto && esEmpleado){
            System.out.println("Se cumple la condicion AND");
        }
    }
    /**
     * metodo para comprobar el or de un if
     * @param esAdulto primer valor a comprobar
     * @param esEmpleado segundo valor a comprobar
     */
    private static void operacionOr(boolean esAdulto, boolean esEmpleado){
        if(esAdulto || esEmpleado){
            System.out.println("Se cumple la condicion OR");
        }
    }
    /**
     * metodo para comprobar el not de un if
     * @param esAdulto primer valor a comprobar
     */
    private static void operacionNot(boolean esAdulto){
        if(!esAdulto){
            System.out.println("Se cumple la condicion NOT");
        }
    }
}
