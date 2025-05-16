package Controlador;

import Vista.VistaDefinicionAtributos;
import Controlador.ControladorDefinicionAtributos;

public class Main {
    public static void main(String[] args) {
        VistaDefinicionAtributos vista = new VistaDefinicionAtributos();
        new ControladorDefinicionAtributos(vista);
        vista.setVisible(true);
    }
}

