package org.dam.programacion.ejercicios;

import org.dam.programacion.ejercicios.entregas.Fracciones;

public class Application {
    public static void main(String[] args) {
        Fracciones fracciones = new Fracciones();
        Fracciones fraccionesParametros = new Fracciones(5, 10);
        Fracciones fraccionesParametro = new Fracciones(6);


        System.out.println("Fracción 1: " + fracciones);
        System.out.println("Fracción 2: " + fraccionesParametros);
        System.out.println("Fracción 3: " + fraccionesParametro);

        // Modificar y mostrar valores
        fracciones.setNumerador(2);
        fracciones.setDenominador(3);
        System.out.println("Fracción 1 modificada: " + fracciones);

        try {
            fracciones.setDenominador(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al establecer denominador: " + e.getMessage());
        }
    }
}
