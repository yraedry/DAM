package org.dam.programacion.ejercicios.entregas.dos;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Sumador de numeros
* @author adrian nuñez sanchez
*
* Escribe un programa que permita al usuario ingresar una serie de números enteros. El programa debe seguir pidiendo números hasta que el usuario ingrese "0".
* Una vez que se ingresa "0", el programa debe mostrar la suma total de todos los números ingresados (sin contar el 0 final).
*/
public class SumadorNumeros {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        sumatorio(scan);
        scan.close();
    }
    /**
     * metodo para realizar la suma de los numeros que vaya introduciendo el usuario
     * @param scan inicalizacion del objeto Scanner
     */
    private static void sumatorio(Scanner scan){
        int entradaUsuario, numSuma = 0;
        while(true){
            System.out.println("Debes ingresar una serie de numeros enteros, en el momento que quieras parar, introduce 0");
            try {
                entradaUsuario = scan.nextInt();
                if(entradaUsuario != 0) {
                    numSuma += entradaUsuario;
                }else{
                    System.out.println("La suma total de los numeros es igual "+numSuma);
                    break;
                }
            }catch (InputMismatchException ex) {
                System.out.println("No has introducido un numero entero, porfavor introduce un numero entero para continuar.");
                scan.nextLine();
            }
        }
    }
}
