package org.dam.programacion.ejercicios.estructuras.salto;

public class BuclesInfinitos {
    public static void main(String[] args) {
        int cont = 0;
        while(true){
            System.out.println("el contador va por "+cont);
            if (cont == 30){
                break;
            }else{
                cont++;
            }
        }
    }
}
