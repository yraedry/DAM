package org.accesodatos.dam.services;

import jakarta.xml.bind.Unmarshaller;
import org.accesodatos.dam.dto.Alumno;
import org.accesodatos.dam.dto.Alumnos;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AlumnoOperationService {

    private static final String PATH_FILE = "gestion-alumnos/src/main/resources/alumnos.xml";

    public void altaAlumno(String nombre, String apellido, int expediente) throws JAXBException {
        Alumnos alumnos = (Alumnos) helperUnmarshall();
        List<Alumno> alumnosXml = alumnos.getAlumno();
        if(alumnosXml == null){
            alumnosXml = new ArrayList<>();
            Alumno nuevoAlumno = new Alumno();
            nuevoAlumno.setNombre(nombre);
            nuevoAlumno.setApellido(apellido);
            nuevoAlumno.setExpediente(expediente);
            alumnosXml.add(nuevoAlumno);
        }else {
            List<Alumno> finalAlumnosXml = alumnosXml;
            IntStream.range(0, alumnosXml.size())
                    .forEach(i -> {
                        Alumno alumno = finalAlumnosXml.get(i);
                        if (alumno.getExpediente() != expediente) {
                            Alumno nuevoAlumno = new Alumno();
                            nuevoAlumno.setNombre(nombre);
                            nuevoAlumno.setApellido(apellido);
                            nuevoAlumno.setExpediente(expediente);
                            finalAlumnosXml.add(nuevoAlumno);

                        } else {
                            System.out.println("ese alumno ya esta dado de alta con ese expediente");
                        }
                    });
        }
        alumnos.setAlumno(alumnosXml);
        helperMarshall(alumnos);
        System.out.println("El alumno se dio de alta correctamente");
    }

    public void insertarNota(int expediente, double nota) throws JAXBException {
        Alumnos alumnos = (Alumnos) helperUnmarshall();
        List<Alumno> alumnosXml = alumnos.getAlumno();
        for (Alumno alumno : alumnosXml) {
            if (alumno.getExpediente() == expediente && alumno.getNota() == null) {
                alumno.setNota(nota);
                helperMarshall(alumnos);
            }
        }
        System.out.println(alumnosXml);
    }

    public void actualizarNota(int expediente, double nota) throws JAXBException {
        Alumnos alumnos = (Alumnos) helperUnmarshall();
        List<Alumno> alumnosXml = alumnos.getAlumno();
        for (Alumno alumno : alumnosXml) {
            if (alumno.getExpediente() == expediente) {
                alumno.setNota(nota);
                helperMarshall(alumnos);
            }
        }
        System.out.println(alumnosXml);
    }

    public void consultarNota(int expediente) throws JAXBException {
        Alumnos alumnos = (Alumnos) helperUnmarshall();
        List<Alumno> alumnosXml = alumnos.getAlumno();
        for (Alumno alumno : alumnosXml) {
            if (alumno.getExpediente() == expediente) {
                System.out.println("la nota del alumno con el expediente " +
                        alumno.getExpediente() + " es " + alumno.getNota());

            }
        }
    }

    public void eliminarAlumno(int expediente) throws JAXBException {
        Alumnos alumnos = (Alumnos) helperUnmarshall();
        List<Alumno> alumnosActualizada = alumnos.getAlumno();
        alumnos.setAlumno(alumnosActualizada);
        IntStream.range(0, alumnosActualizada.size())
                .forEach(i -> {
                    Alumno alumno = alumnosActualizada.get(i);
                    if (alumno.getExpediente() == expediente) {
                        alumnosActualizada.remove(i);
                        try {
                            helperMarshall(alumnos);
                        } catch (JAXBException e) {
                            System.err.println("Hubo un error al eliminar el alumno " + e);
                        }

                        System.out.println("El alumno con expediente " +
                                alumno.getExpediente() + " fue eliminado correctamente");
                    }
                });
    }

    public void consultarNotas() throws JAXBException {
        Alumnos alumnos = (Alumnos) helperUnmarshall();
        List<Alumno> alumnosXml = alumnos.getAlumno();
        for(var alumno : alumnosXml){
            System.out.println("la nota del alumno " + alumno.getNombre() + " " + alumno.getApellido() +
                    " con expediente " + alumno.getExpediente() + " es de un: " + alumno.getNota());
        }
    }

    private void helperMarshall(Alumnos alumnos) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Alumnos.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(alumnos, new File(PATH_FILE));
    }

    private Object helperUnmarshall() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Alumnos.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(new File(PATH_FILE));
    }
}

