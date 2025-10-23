package org.accesodatos.dam;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

import com.accesodatos.dam.service.AlumnoOperationService;
import jakarta.xml.bind.JAXBException;

public class App {
    public static void main(String[] args) throws JAXBException {
        AlumnoOperationService service = new AlumnoOperationService();
        service.altaAlumno();
    }
