package Controlador;

import MODELO.DefinicionAtributo;
import Vista.VistaDefinicionAtributos;
import Vista.VistaEntidadFormulario;
import Singleton.AtributosSingleton;
import Controlador.ControladorEntidadFormulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControladorDefinicionAtributos {
    private VistaDefinicionAtributos vista;
    private Set<String> nombresUsados;

    public ControladorDefinicionAtributos(VistaDefinicionAtributos vista) {
        this.vista = vista;
        this.nombresUsados = new HashSet<>();
        inicializarEventos();
    }

    private void inicializarEventos() {
        vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = vista.getNombreAtributo();
                DefinicionAtributo.TipoDato tipo = vista.getTipoDatoSeleccionado();

                if (nombre.isEmpty()) {
                    vista.mostrarMensaje("El nombre del atributo no puede estar vacío.");
                    return;
                }

                if (nombresUsados.contains(nombre.toLowerCase())) {
                    vista.mostrarMensaje("Ya existe un atributo con ese nombre.");
                    return;
                }

                DefinicionAtributo nuevo = new DefinicionAtributo(nombre, tipo);
                vista.agregarAtributoLista(nuevo);
                nombresUsados.add(nombre.toLowerCase());
                vista.limpiarCampos();
            }
        });

        vista.getBtnContinuar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<DefinicionAtributo> atributos = vista.getAtributosDefinidos();
                if (atributos.size() < 3) {
                    vista.mostrarMensaje("Debes definir al menos 3 atributos.");
                    return;
                }

                // ✅ Guardar atributos en el Singleton
                AtributosSingleton.getInstancia().setAtributos(atributos);

                // ✅ Cerrar esta ventana
                vista.setVisible(false);

                // ✅ Mostrar la ventana para registrar entidades
                VistaEntidadFormulario vistaFormulario = new VistaEntidadFormulario();
                new ControladorEntidadFormulario(vistaFormulario);
                vistaFormulario.setVisible(true);
            }
        });
    }
}
