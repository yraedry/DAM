package org.accesodatos.dam.services;

import com.accesodatos.dam.dto.Alumno;
import com.accesodatos.dam.dto.Alumnos;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AlumnoOperationService {

    private static final String PATH_FILE = "infraestructura/hello_world/src/main/resources/alumnos.xml";
    public void altaAlumno() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Alumnos.class);
        List<Alumno> alumnosList = new ArrayList<>();
        Alumno alumno = new Alumno();
        alumno.setNombre("Alumno");
        alumno.setApellido("Apellido");
        alumno.setExpediente(12345);
        alumnosList.add(alumno);
        Alumnos alumnos = new Alumnos();
        alumnos.setAlumno(alumnosList);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(alumnos, new File(PATH_FILE));

    }

}
