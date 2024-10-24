package org.dam.programacion.basics;

public class OperadoresLogicos {
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
