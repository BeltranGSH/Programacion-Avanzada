package Singleton;

import MODELO.DefinicionAtributo;

import java.util.ArrayList;
import java.util.List;

public class AtributosSingleton {
    private static AtributosSingleton instancia;
    private List<DefinicionAtributo> atributosDefinidos;

    private AtributosSingleton() {
        atributosDefinidos = new ArrayList<>();
    }

    public static AtributosSingleton getInstancia() {
        if (instancia == null) {
            instancia = new AtributosSingleton();
        }
        return instancia;
    }

    public void setAtributos(List<DefinicionAtributo> atributos) {
        this.atributosDefinidos = atributos;
    }

    public List<DefinicionAtributo> getAtributos() {
        return atributosDefinidos;
    }
}

