package MODELO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaService {
    private static final String RUTA_ARCHIVO = "entidades.json";
    private Gson gson;

    public PersistenciaService() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void guardarEntidades(List<Entidad> entidades) {
        try (FileWriter writer = new FileWriter(RUTA_ARCHIVO)) {
            gson.toJson(entidades, writer);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public List<Entidad> cargarEntidades() {
        try (Reader reader = new FileReader(RUTA_ARCHIVO)) {
            Type tipoLista = new TypeToken<List<Entidad>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (Exception e) {
            return new ArrayList<>(); // Si no existe o hay error, devuelve lista vacía
        }
    }
}
