package MODELO;



import java.util.HashMap;
import java.util.Map;

public class Entidad {
    private Map<String, Object> atributos;

    public Entidad() {
        this.atributos = new HashMap<>();
    }

    public void setAtributo(String nombre, Object valor) {
        atributos.put(nombre, valor);
    }

    public Object getAtributo(String nombre) {
        return atributos.get(nombre);
    }

    public Map<String, Object> getAtributos() {
        return atributos;
    }

    public void setAtributos(Map<String, Object> atributos) {
        this.atributos = atributos;
    }

    @Override
    public String toString() {
        return atributos.toString();
    }
}
