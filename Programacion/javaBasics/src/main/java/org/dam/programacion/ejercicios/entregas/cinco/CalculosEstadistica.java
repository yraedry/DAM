package org.dam.programacion.ejercicios.entregas.cinco;

import java.util.Arrays;

public class CalculosEstadistica {
    /*
    Diferencias entre commit, push y pull
    El commit se sube los cambios a tu rama local pero aun no han subido a la rama remota
    El push te sube todos los cambios que tengas en tu rama local a la rama remota
    El pull te trae todos los cambios que se han producido en la rama remota a tu rama local y hace un merge o rebase implicito en tu rama local
    */
    public static void main(String[] args) {
        int[] media = {1,2,3,4,5,6,7,8,9};
        double[] moda = {1,1,2,2,2,2,2,5,5,5,6,7,7,7,7};
        String[] mediana = {"9","4","6","3","2","7","5","1"};
        CalculosEstadistica app = new CalculosEstadistica();
        app.calcular(media);
        app.calcular(moda);
        app.calcular(mediana);

    }   

    private void calcular(int[] media){
        int sumatorio = 0;
        for(int numero : media){
           sumatorio += numero; 
        }
        System.out.println("La media de los numeros es "+ sumatorio / media.length);
    }
    private void calcular(double[] moda){
        double modaCalculada = 0;
        double numeroMaximoCalculado = 0;
        for (double valorModa : moda) {
            int repeticiones = 0;
            for (double valor : moda) {
                if (valorModa == valor) {
                    repeticiones++;
                }
                if (repeticiones > numeroMaximoCalculado) {
                    modaCalculada = valorModa;
                    numeroMaximoCalculado = repeticiones;
                }
            }
        }
        System.out.println("La moda de los numeros es "+modaCalculada);
    }
    private void calcular(String[] mediana){
        Arrays.sort(mediana);
        if (mediana.length % 2 == 1) {
            System.out.println("La mediana es "+mediana[mediana.length / 2]);
        } else {
            int mid1 = Integer.parseInt(mediana[(mediana.length / 2) - 1]);
            int mid2 = Integer.parseInt(mediana[mediana.length / 2]);
            System.out.println("La mediana es "+ (mid1 + mid2) / 2);
        }
    }
}
