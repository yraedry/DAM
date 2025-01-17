package org.dam.programacion.ejercicios.entregas;

import java.util.Arrays;

public class CalculosEstadistica {
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
        for (int x =0; x < moda.length; x++){
            int repeticiones = 0;
            for (int y =0; y < moda.length; y++){
                if(moda[x] == moda[y]){
                    repeticiones++;
                }
                if(repeticiones>numeroMaximoCalculado){
                    modaCalculada = moda[x];
                    numeroMaximoCalculado=repeticiones;
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
