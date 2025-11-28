package concesionario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coche {
    private String marca;
    private String modelo;
    private int anio;
    private double precio;

}