package Controlador;

import MODELO.DefinicionAtributo;
import MODELO.Entidad;
import MODELO.PersistenciaService;
import Vista.VistaEntidadFormulario;
import Vista.VistaTablaEntidades;
import Singleton.AtributosSingleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class ControladorEntidadFormulario {
    private VistaEntidadFormulario vista;

    public ControladorEntidadFormulario(VistaEntidadFormulario vista) {
        this.vista = vista;
        inicializarEventos();
    }

    private void inicializarEventos() {
        vista.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, String> valores = vista.obtenerValores();
                Entidad nueva = new Entidad();

                List<DefinicionAtributo> atributos = AtributosSingleton.getInstancia().getAtributos();

                for (DefinicionAtributo atributo : atributos) {
                    String nombre = atributo.getNombre();
                    String valorTexto = valores.get(nombre);

                    if (valorTexto == null || valorTexto.isEmpty()) {
                        vista.mostrarMensaje("El campo '" + nombre + "' no puede estar vacío.");
                        return;
                    }

                    try {
                        Object valor;
                        switch (atributo.getTipo()) {
                            case INTEGER:
                                valor = Integer.parseInt(valorTexto);
                                break;
                            case STRING:
                                valor = valorTexto;
                                break;
                            default:
                                throw new IllegalArgumentException("Tipo de dato no soportado.");
                        }
                        nueva.setAtributo(nombre, valor);
                    } catch (NumberFormatException ex) {
                        vista.mostrarMensaje("El campo '" + nombre + "' debe ser un número entero.");
                        return;
                    }
                }

                // ✅ Validación: impedir guardar si hay campos vacíos o incompletos
                if (nueva.getAtributos().size() < atributos.size() ||
                    nueva.getAtributos().values().stream().anyMatch(v -> v == null || v.toString().isBlank())) {
                    vista.mostrarMensaje("Todos los campos deben estar llenos y válidos.");
                    return;
                }

                // ✅ Guardar en archivo JSON
                PersistenciaService servicio = new PersistenciaService();
                List<Entidad> existentes = servicio.cargarEntidades();
                existentes.add(nueva);
                servicio.guardarEntidades(existentes);

                vista.mostrarMensaje("Entidad guardada correctamente.");
                vista.limpiarCampos();
            }
        });

        vista.getBtnVerEntidades().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersistenciaService servicio = new PersistenciaService();
                List<Entidad> entidades = servicio.cargarEntidades();

                if (entidades.isEmpty()) {
                    vista.mostrarMensaje("No hay entidades guardadas.");
                } else {
                    VistaTablaEntidades vistaTabla = new VistaTablaEntidades(entidades);
                    new ControladorVistaTablaEntidades(vistaTabla, entidades);
                    vistaTabla.setVisible(true);
                }
            }
        });
    }
}
