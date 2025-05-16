package Controlador;

import MODELO.Entidad;
import MODELO.PersistenciaService;
import Vista.VistaEditarEntidad;
import Vista.VistaTablaEntidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class ControladorVistaTablaEntidades {
    private VistaTablaEntidades vista;
    private List<Entidad> listaEntidades;
    private PersistenciaService servicio;

    public ControladorVistaTablaEntidades(VistaTablaEntidades vista, List<Entidad> entidades) {
        this.vista = vista;
        this.listaEntidades = entidades;
        this.servicio = new PersistenciaService();

        inicializarEventos();
    }

    private void inicializarEventos() {
        vista.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = vista.getTabla().getSelectedRow();
                if (filaSeleccionada == -1) {
                    vista.mostrarMensaje("Debes seleccionar una fila para eliminar.");
                    return;
                }

                listaEntidades.remove(filaSeleccionada);
                servicio.guardarEntidades(listaEntidades);
                vista.getModeloTabla().removeRow(filaSeleccionada);
                vista.mostrarMensaje("Entidad eliminada correctamente.");
            }
        });

        vista.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = vista.getTabla().getSelectedRow();
                if (fila == -1) {
                    vista.mostrarMensaje("Selecciona una entidad para editar.");
                    return;
                }

                Entidad entidadSeleccionada = listaEntidades.get(fila);
                VistaEditarEntidad editor = new VistaEditarEntidad(entidadSeleccionada);

                editor.getBtnGuardar().addActionListener(ev -> {
                    Map<String, String> nuevosValores = editor.getValoresEditados();

                    for (Map.Entry<String, String> entry : nuevosValores.entrySet()) {
                        String clave = entry.getKey();
                        String nuevoValor = entry.getValue();
                        Object valorConvertido;

                        Object valorOriginal = entidadSeleccionada.getAtributo(clave);
                        try {
                            if (valorOriginal instanceof Integer) {
                                valorConvertido = Integer.valueOf(nuevoValor);
                            } else if (valorOriginal instanceof Double) {
                                valorConvertido = Double.valueOf(nuevoValor);
                            } else {
                                valorConvertido = nuevoValor;
                            }
                        } catch (NumberFormatException ex) {
                            editor.mostrarMensaje("Formato inválido para '" + clave + "'. Debe ser un número.");
                            return;
                        }

                        entidadSeleccionada.setAtributo(clave, valorConvertido);
                    }

                    servicio.guardarEntidades(listaEntidades);

                    for (int i = 0; i < vista.getModeloTabla().getColumnCount(); i++) {
                        String columna = vista.getModeloTabla().getColumnName(i);
                        vista.getModeloTabla().setValueAt(
                                entidadSeleccionada.getAtributo(columna),
                                fila,
                                i
                        );
                    }

                    editor.dispose();
                    vista.mostrarMensaje("Entidad actualizada correctamente.");
                });

                editor.setVisible(true);
            }
        });
    }
}
