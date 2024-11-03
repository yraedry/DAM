package org.dam.programacion.ejercicios.entregas.optimizadas;

public class ComparadorEdadesDescuentosOptimizada {
    /**
     * @author adrian nunez sanchez
     * Declara cuatro variables de tipo int para representar las edades de cuatro personas.
     * Declara una variable double para representar el precio original de un producto, y una variable int para representar el descuento en porcentaje.
     * Usa operadores booleanos para comparar las edades de las personas y establecer quién es la más joven y quién es la mayor. (Asume que no hay edades iguales para simplificarlo.)
     * Aplica el descuento solo si al menos dos personas son mayores de 18 años. En caso contrario, el precio del producto queda sin descuento.
     * Realiza un casting explícito para convertir el descuento de int a double y luego aplica el descuento en el precio original.
     * Imprime el precio final del producto y menciona si el descuento fue aplicado o no.
     *
     */
    public static void main(String[] args) {
        int persona = (int) (Math.random() * 31);
        int personaDos = (int) (Math.random() * 21);
        int personaTres = (int) (Math.random() * 21);
        int personaCuatro = (int) (Math.random() * 51);
        //creamos un array con las edades de las personas
        int[] edades = {persona, personaDos, personaTres, personaCuatro};
        double precioOriginal = Math.random() * 1000;
        int descuento = 15;

        //comprobamos cual es la persona mas mayor y mas pequenna
        comprobarEdades(edades);

        //asignamos a una variable cuantos mayores de edad hay
        int mayoresEdad = contadorMayoresEdad(edades);

        //comprobamos si hay dos o mas mayores de edad
        if(mayoresEdad >= 2){
            // aplicamos el descuento y lo casteamos a double
            double precioFinal = precioOriginal * (1- ((double)descuento /100));
            System.out.println("Se aplico el descuento");
            System.out.println("El precio original seria " + precioOriginal +" pero con el descuento se queda en " +  precioFinal);
        }else{
            System.out.println("No se aplico el descuento");
            System.out.println("El precio sin descuento seria " + precioOriginal);
        }
    }
    /**
     * Metodo para comprobar quien es la persona con mayor y menor edad
     * @param edades array con las edades de las personas
     */
    private static void comprobarEdades(int[] edades){
        //asignamos el primer valor del array para tener un valor por el que poder comparar
        int mayor = edades[0];
        int menor = edades[0];
        //recorremos el array para ir comprobando
        for(int edad : edades){
            mayor = edad > mayor ? edad : mayor;
            menor = edad < menor ? edad : menor;
        }
        System.out.println("la persona con mayor edad tiene " + mayor);
        System.out.println("la persona con menos edad tiene " + menor);
    }

    /**
     * Metodo para comprobar cuantos mayores de edad existen en un grupo de personas
     * @param edades array con las edades de las personas
     * @return retorna el numero de personas mayores de edad
     */
    private static int contadorMayoresEdad(int[] edades){
        int contMayoresEdad = 0;
        //recorremos el array y si la persona tiene mas o igual a 18 annos sumamos uno al contador
        for(int edad : edades){
            contMayoresEdad = edad >= 18 ? contMayoresEdad+1 : contMayoresEdad;
        }
        System.out.println("Hay un total de " + contMayoresEdad + " personas que son mayores de edad");
        return contMayoresEdad;
    }
}
