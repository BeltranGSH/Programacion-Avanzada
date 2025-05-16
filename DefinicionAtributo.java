package MODELO;

public class DefinicionAtributo {
    private String nombre;
    private TipoDato tipo;

    public enum TipoDato {
        STRING,
        INTEGER
    }

    public DefinicionAtributo(String nombre, TipoDato tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDato getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(TipoDato tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo.name() + ")";
    }
}
