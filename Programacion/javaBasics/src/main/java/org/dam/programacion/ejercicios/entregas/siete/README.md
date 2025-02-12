# 📸 Ejercicio: Clase Webcam

## Objetivo
Crear una clase `Webcam` que represente una cámara web con diversas propiedades y comportamientos.

## 📄 Requisitos

### Atributos
La clase debe incluir los siguientes atributos:
1. 👉 **Resolución** (en píxeles, representada como una cadena en el formato "ancho x alto", por ejemplo, "1920x1080").
2. 👉 **Frecuencia de cuadros por segundo (FPS)** (número entero).
3. 👉 **Estado de encendido/apagado** (booleano).
4. 👉 **Tamaño estimado del archivo de imagen generado (en MB, tipo `double`).**

### Métodos
1. Implementa un **constructor** que inicialice la resolución, FPS y establezca la cámara como apagada por defecto.
2. Implementa los **métodos getters y setters** necesarios.
3. Implementa un método `encender()` que active la cámara.
4. Implementa un método `apagar()` que la desactive.
5. Implementa un método `tomarFoto()` que:
    - Solo funcione si la cámara está encendida.
    - Devuelva un mensaje indicando que la foto fue tomada con la resolución y el tamaño estimado del archivo.
    - Calcule el tamaño estimado del archivo de imagen usando la siguiente fórmula:

      ```
      tamaño = (ancho * alto * FPS) / 1000000.0
      ```

      Donde `ancho` y `alto` se obtienen de la resolución proporcionada en el formato "ancho x alto".

### 📚 Prueba en el `main`
1. Crea una instancia de `Webcam` con una resolución de "1920x1080" y 30 FPS.
2. Intenta tomar una foto con la cámara apagada.
3. Enciende la cámara y toma una foto.
4. Apaga la cámara.

---
### ✨ Extras (Opcionales)
Si quieres practicar aún más, podrías agregar (aunque no cuente para nota):
- Un método para cambiar la resolución en tiempo de ejecución y recalcular el tamaño de la foto.
- Un método para calcular el consumo de datos en una videollamada según la resolución, tiempo en segundos y FPS.

¡Mucho ánimo! 🚀