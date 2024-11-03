package org.dam.programacion.ejercicios.entregas;

public class ComparadorEdadesDescuentos {

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
        double precioOriginal = Math.random() * 1000;
        int descuento = 15;

        //comprobamos cual es la persona mas mayor
        comprobarMayor(persona, personaDos, personaTres, personaCuatro);
        //comprobamos cual es la persona mas pequenna
        comprobarMenor(persona, personaDos, personaTres, personaCuatro);

        //asignamos a una variable cuantos mayores de edad hay
        int mayoresEdad = contadorMayoresEdad(persona, personaDos, personaTres, personaCuatro);

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
    * Metodo para comprobar quien es la persona con mayor edad
    * @param mayor cogemos la edad de una persona como referencia
    * @param personaDos edad de la segunda persona
    * @param personaTres edad de la tercera persona
    * @param personaCuatro edad de la cuarta persona
    */
    private static void comprobarMayor(int mayor, int personaDos, int personaTres, int personaCuatro){
        if(personaDos > mayor){
            mayor = personaDos;
        }
        if(personaTres > mayor){
            mayor = personaTres;
        }
        if(personaCuatro > mayor){
            mayor = personaCuatro;
        }
        System.out.println("la persona con mas edad tiene " + mayor);
    }
    /**
     * Metodo para comprobar quien es la persona con menor edad
     * @param menor cogemos la edad de una persona como referencia
     * @param personaDos edad de la segunda persona
     * @param personaTres edad de la tercera persona
     * @param personaCuatro edad de la cuarta persona
     */
    private static void comprobarMenor(int menor, int personaDos, int personaTres, int personaCuatro){
        if(personaDos < menor){
            menor = personaDos;
        }
        if(personaTres < menor){
            menor = personaTres;
        }
        if(personaCuatro < menor){
            menor = personaCuatro;
        }
        System.out.println("la persona con menos edad tiene " + menor);
    }
    /**
     * Metodo para comprobar cuantos mayores de edad existen en un grupo de personas
     * @param persona cogemos la edad de una persona como referencia
     * @param personaDos edad de la segunda persona
     * @param personaTres edad de la tercera persona
     * @param personaCuatro edad de la cuarta persona
     * @return retorna el numero de personas mayores de edad
     */
    private static int contadorMayoresEdad(int persona, int personaDos, int personaTres, int personaCuatro){
        int contMayoresEdad = 0;
        contMayoresEdad = persona >= 18 ? contMayoresEdad+1 : contMayoresEdad;
        contMayoresEdad = personaDos >= 18 ? contMayoresEdad+1 : contMayoresEdad;
        contMayoresEdad = personaTres >= 18 ? contMayoresEdad+1 : contMayoresEdad;
        contMayoresEdad = personaCuatro >= 18 ? contMayoresEdad+1: contMayoresEdad;
        System.out.println("Hay un total de " + contMayoresEdad + " personas que son mayores de edad");
        return contMayoresEdad;
    }
}
