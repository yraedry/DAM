package org.accesodatos.dam.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
@XmlRootElement(name = "alumnos")
public class Alumnos implements Serializable {
    private List<Alumno> alumno;
}
