package org.dam.programacion.basics;

public class OperadoresLogicos {
    public static void main(String[] args) {
        boolean esAdulto = true;
        boolean esEmpleado = false;
        operacionAnd(esAdulto, esEmpleado);
        operacionOr(esAdulto, esEmpleado);
        operacionNot(esAdulto);
    }

    private static void operacionAnd(boolean esAdulto, boolean esEmpleado){
        if(esAdulto && esEmpleado){
            System.out.println("Se cumple la condicion AND");
        }
    }

    private static void operacionOr(boolean esAdulto, boolean esEmpleado){
        if(esAdulto || esEmpleado){
            System.out.println("Se cumple la condicion OR");
        }
    }

    private static void operacionNot(boolean esAdulto){
        if(!esAdulto){
            System.out.println("Se cumple la condicion NOT");
        }
    }
}
