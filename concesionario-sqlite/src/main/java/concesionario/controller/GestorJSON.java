package concesionario.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import concesionario.dto.Coche;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestorJSON {
    private static final String RUTA_FICHERO = "src/main/resources/coches.json";
    private final Gson gson = new Gson();

    public List<Coche> leerCoches() {
        try (Reader reader = new FileReader(RUTA_FICHERO)) {
            Type listType = new TypeToken<ArrayList<Coche>>() {
            }.getType();
            List<Coche> coches = gson.fromJson(reader, listType);
            if (coches == null) return new ArrayList<>();
            return coches;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void guardarCoches(List<Coche> coches) {
        try (Writer writer = new FileWriter(RUTA_FICHERO)) {
            gson.toJson(coches, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarCoche(Coche nuevoCoche) {
        List<Coche> coches = leerCoches();
        coches.add(nuevoCoche);
        guardarCoches(coches);
    }
}
