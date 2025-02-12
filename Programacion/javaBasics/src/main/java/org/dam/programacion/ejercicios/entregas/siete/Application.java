package org.dam.programacion.ejercicios.entregas.siete;

public class Application {
    public static void main(String[] args) {
        Webcam webcam = new Webcam("1920x1080", 30);
        webcam.tomarFoto();
        webcam.encender();
        webcam.tomarFoto();
        webcam.apagar();

    }
}
