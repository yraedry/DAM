package concesionario.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni", unique = true, nullable = false)
    private String dni;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Override
    public String toString() {
        return nombre + " (DNI: " + dni + ")";
    }
}