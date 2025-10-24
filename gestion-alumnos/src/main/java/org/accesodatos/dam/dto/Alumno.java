package org.accesodatos.dam.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@Data
public class Alumno implements Serializable {
    private int expediente;
    private String nombre;
    private String apellido;
    private Double nota;
}
