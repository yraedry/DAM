package concesionario.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "coches")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coche {

    public enum Estado {
        DISPONIBLE,
        VENDIDO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private int anio;
    private double precio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Coche(String marca, String modelo, int anio, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.estado = Estado.DISPONIBLE;
    }

    @Override
    public String toString() {
        String info = id + ". " + marca + " " + modelo + " (" + anio + ") - " + precio + "€";
        if (estado == Estado.VENDIDO && cliente != null) {
            info += " [VENDIDO a: " + cliente.getNombre() + "]";
        } else {
            info += " [DISPONIBLE]";
        }
        return info;
    }
}